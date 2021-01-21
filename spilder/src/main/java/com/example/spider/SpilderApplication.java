package com.example.spider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.example.spider.spider.dao")
@EnableScheduling
@EnableCaching
public class SpilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpilderApplication.class, args);
    }

}
