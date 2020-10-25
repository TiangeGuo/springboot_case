package com.atguigu.dao;


import com.atguigu.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
//@Repository
public interface UserMapper extends Mapper<User> {
}
