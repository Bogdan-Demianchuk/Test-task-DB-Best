package com.example.demo;

import com.example.demo.controllers.Console;
import com.example.demo.controllers.NodesLoaderController;
import com.example.demo.controllers.RouteHandlerController;
import com.example.demo.service.FileReaderService;
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

