package me.lyou.aop.service.impl;

import me.lyou.aop.service.AnimalService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AnimalServiceTest {

    @Resource
    private AnimalService animalService;
    @Test
    void walk() {
        animalService.walk();
    }

    @Test
    void eat() {
        animalService.eat();
    }
}