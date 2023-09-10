package me.lyou.aop;

import me.lyou.aop.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AopApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AopApp.class, args);
        run.getBean(UserService.class).save();
    }
}
