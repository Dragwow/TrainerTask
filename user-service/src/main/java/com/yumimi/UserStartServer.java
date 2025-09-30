package com.yumimi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.yumimi.client")
public class UserStartServer {
    public static void main(String[] args) {
        SpringApplication.run(UserStartServer.class, args);
    }
}
