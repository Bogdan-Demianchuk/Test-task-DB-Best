package com.example.demo;

import com.example.demo.controllers.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TestTaskDbBestApplication {
    private static Console console;

    public TestTaskDbBestApplication(Console console) {
        this.console = console;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestTaskDbBestApplication.class, args);
        console.run();
    }
}

