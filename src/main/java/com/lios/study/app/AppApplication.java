package com.lios.study.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liaiguang
 */
@MapperScan("com.lios.study.app.mapper")
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
