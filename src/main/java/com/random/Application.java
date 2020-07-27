package com.random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//bower - Сборщик проекта для фронта
@SpringBootApplication//@ComponentScan входит в @SpringBootApplication и будет автоматический пойск в корне com.random
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
