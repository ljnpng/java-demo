package me.lyou.rabbit.sender;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyMessageSenderTest {

    @Resource
    private MyMessageSender myMessageSender;


    @Test
    void send() {
        myMessageSender.send("hello");
    }
}