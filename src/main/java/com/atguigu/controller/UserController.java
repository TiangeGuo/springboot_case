package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/findAll")
    @ResponseBody
    public Result findAll(){
        System.out.println("123456");
        List<User> users = null;
        try {
            users = userService.findAll();
            System.out.println(users);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Result.ok(users);
    }
}
