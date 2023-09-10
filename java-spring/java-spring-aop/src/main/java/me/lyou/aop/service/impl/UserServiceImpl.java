package me.lyou.aop.service.impl;

import me.lyou.aop.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public void save() {
        System.out.println("save");
    }

    public void update() {
        System.out.println("update");
    }
}
