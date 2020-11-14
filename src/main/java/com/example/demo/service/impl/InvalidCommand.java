package com.example.demo.service.impl;

import com.example.demo.service.CommandsHandler;
import org.springframework.stereotype.Service;

@Service
public class InvalidCommand implements CommandsHandler {
    @Override
    public void execute() {
        System.out.println("Invalid command entered, try again");
    }
}
