package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void test(){

        try {
            List<User> users= userService.findAll();
            System.out.println(users);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
