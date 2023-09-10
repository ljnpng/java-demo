package me.lyou.aop.service;

import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    public void walk() {
        System.out.println("walk");
    }

    public void eat() {
        System.out.println("eat");
    }

}
