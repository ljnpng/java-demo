package me.lyou.mysql.dao;

import me.lyou.mysql.po.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserDaoTest {

    @Test
    void test() {
        UserDao userDao = new UserDao();

        User u1 = new User();
        u1.setName("张三");
        u1.setAge(18);
        u1.setGender(false);
        userDao.insert(u1);

        User u2 = new User();
        u2.setName("李四");
        u2.setAge(19);
        u2.setGender(true);
        userDao.insert(u2);

        User u3 = new User();
        u3.setName("王五");
        u3.setAge(20);
        u3.setGender(false);
        userDao.insert(u3);
        List<User> users = userDao.select();

        Assertions.assertEquals(3, users.size());

        Assertions.assertEquals("王五", users.get(2).getName());

        for (User user : users) {
            userDao.remove(user);
        }

    }

}