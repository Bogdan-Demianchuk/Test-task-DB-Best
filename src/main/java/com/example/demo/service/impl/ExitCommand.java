package com.example.demo.service.impl;

import com.example.demo.service.CommandsHandler;
import org.springframework.stereotype.Service;

@Service
public class ExitCommand implements CommandsHandler {
    @Override
    public void execute() {
        System.exit(0);
    }
}
