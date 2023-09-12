package me.lyou.ioc;

import me.lyou.ioc.service.CustomService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CustomServiceTest {

    @Resource
    private CustomService customService;
    @Test
    void sayHello() {
        customService.sayHello();
    }
}