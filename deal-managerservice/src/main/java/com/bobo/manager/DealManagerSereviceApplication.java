package com.bobo.manager;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.bobo.manager.service")
public class DealManagerSereviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DealManagerSereviceApplication.class, args);
    }

}
