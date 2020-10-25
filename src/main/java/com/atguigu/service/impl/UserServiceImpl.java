package com.atguigu.service.impl;

import com.atguigu.dao.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    RedisTemplate redisTemplate;
    //@Autowired
    @Resource
    private  UserMapper userMapper;
    @Override
    @Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ,rollbackFor = Exception.class,noRollbackFor =FileNotFoundException.class)
    public List<User> findAll() throws FileNotFoundException {
        //int i=10/0;
        //FileInputStream inputStream = new FileInputStream("xxx");
        List<User> userList = (List<User>) redisTemplate.boundValueOps("userKey").get();
        if(userList==null){
           userList = userMapper.selectAll();
            redisTemplate.boundValueOps("userKey").set(userList);
            System.out.println("从数据库中查询...");
        }else {
            System.out.println("从缓存中查询.....");
        }
        //如果缓存中有数据, 直接返回
        return userList;
    }
}
