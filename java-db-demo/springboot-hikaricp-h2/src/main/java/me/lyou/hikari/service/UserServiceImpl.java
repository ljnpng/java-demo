package me.lyou.hikari.service;

import me.lyou.hikari.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Primary
public class UserServiceImpl {

    @Autowired(required = false)
    @Qualifier("jdbcTemplate")
    private UserDao userDao;

    private JdbcTemplate jdbcTemplate;
}
