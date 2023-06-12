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
//    乐观锁测试
    @Test
    public void test3(){
        User user=new User();
        user.setId(3);
        user.setName("王五");
        user.setVersion(1);
        int i = userDao.update(user, null);
        if (i>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }
}
