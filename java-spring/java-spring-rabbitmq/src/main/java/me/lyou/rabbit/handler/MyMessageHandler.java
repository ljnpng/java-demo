package me.lyou.rabbit.handler;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyMessageHandler {

    private final RabbitTemplate rabbitTemplate;

    private static final int MAX_RETRIES = 4;

    public MyMessageHandler(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "main_queue")
    public void handle(Message message) {
        String msg = new String(message.getBody());
        int retry = message.getMessageProperties().getHeader("retry");
        try {
            System.out.println("consume message: " + msg);
            if (msg.equals("bad")) {
                throw new RuntimeException("bad message");
            }
        } catch (Exception e) {
            if (retry < MAX_RETRIES) {
                System.out.println("add to retry queue retry = " + retry);
                rabbitTemplate.convertAndSend("delay_exchange", "delay", message, m -> {
                    m.getMessageProperties().setHeader("retry", retry + 1);
                    m.getMessageProperties().setExpiration(String.valueOf(10000 * (retry + 1)));
                    return m;
                });
            } else {
                System.out.println("Oh no! Game over!");
            }
        }

    }

}
