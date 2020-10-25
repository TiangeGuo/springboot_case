package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication()
@MapperScan("com.atguigu.dao")
@EnableTransactionManagement//开启声明式事务
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
