package me.lyou.aop.service;

import me.lyou.aop.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void save() {
        userService.save();

    }

    @Test
    void update() {
        userService.update();
    }
}