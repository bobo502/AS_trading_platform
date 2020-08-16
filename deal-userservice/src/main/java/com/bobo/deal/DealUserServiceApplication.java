package com.bobo.deal;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.bobo.deal.serviceImpl")
public class DealUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DealUserServiceApplication.class, args);
    }

}
