package me.lyou.rabbit;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RabbitApp {
    public static void main(String[] args) {
        SpringApplication.run(RabbitApp.class, args);
    }

    @Bean
    public Queue deadLetterQueue() {
        return new Queue("dead_letter_queue");
    }

    @Bean
    public Queue mainQueue() {
        Queue mainQueue = new Queue("main_queue", true);
        mainQueue.addArgument("x-dead-letter-exchange", "dead_letter_exchange");
        mainQueue.addArgument("x-message-ttl", 10000);
        mainQueue.addArgument("x-dead-letter-routing-key", "dlk");
        return mainQueue;
    }

    @Bean
    public DirectExchange mainExchange() {
        return new DirectExchange("main_exchange");
    }

    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange("dead_letter_exchange");
    }
}
