package com.example;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BootApplicationTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @Test
    public void test01(){
        User user = userDao.selectById(1);
        System.out.println(user);
    }

    @Test
    public void test02(){
        List<User> users = userService.list();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
