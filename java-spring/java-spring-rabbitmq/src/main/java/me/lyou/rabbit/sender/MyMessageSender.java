package me.lyou.rabbit.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

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
        this.rabbitTemplate.convertAndSend("main_exchange", "main_queue", message);
    }
}
