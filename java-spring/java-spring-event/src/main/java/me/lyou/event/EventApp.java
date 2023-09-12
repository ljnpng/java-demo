package me.lyou.event;

import me.lyou.event.service.FeedbackService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EventApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(EventApp.class, args);
        run.getBean(FeedbackService.class).feedback("1", "2");
    }
}
