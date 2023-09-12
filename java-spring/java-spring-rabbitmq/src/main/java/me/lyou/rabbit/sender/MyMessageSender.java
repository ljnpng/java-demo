package me.lyou.rabbit.sender;

import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class MyMessageSender {

    private final RabbitTemplate rabbitTemplate;

    public MyMessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/send/{message}")
    public void send(@PathVariable String message) {
        System.out.println("send message: " + message);
        this.rabbitTemplate.convertAndSend("main_exchange", "main_queue", message, msg -> {
            MessageProperties messageProperties = msg.getMessageProperties();
            messageProperties.setHeader("retry", 0);
            return msg;
        });
    }
}
