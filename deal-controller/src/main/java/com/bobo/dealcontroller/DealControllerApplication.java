package com.bobo.dealcontroller;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.bobo.dealcontroller")
public class DealControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DealControllerApplication.class, args);
    }

}
