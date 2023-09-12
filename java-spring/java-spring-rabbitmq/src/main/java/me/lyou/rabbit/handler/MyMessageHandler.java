package me.lyou.rabbit.handler;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyMessageHandler {

    private final RabbitTemplate rabbitTemplate;

    public MyMessageHandler(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "main_queue")
    public void handle(String message) {
        System.out.println("consume message: " + message);
        if (message.equals("bad")) {
            throw new RuntimeException("bad message");
        }
    }

    @RabbitListener(queues = "dead_letter_queue")
    public void handleDelay(String message) {
        System.out.println("get dead letter message: " + message);

        message = "dead letter message: " + message;

        // do something
        // report message to another queue
        rabbitTemplate.convertAndSend("main", "main_queue", message);


    }
}
