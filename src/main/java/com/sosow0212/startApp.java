package com.sosow0212;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링부트라는 걸 알려주는 어노테이션
public class startApp {

    public static void main(String[] args) {
        SpringApplication.run(startApp.class, args); // 스프링 어플리케이션 실행하겠다는 뜻

    }
}
