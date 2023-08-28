package com.xuecheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@EnableFeignClients(basePackages={"com.xuecheng.learning.feignclient"})
@SpringBootApplication

public class LearningApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(LearningApiApplication.class, args);
    }


}
