package com.example.demo.service.impl;

import com.example.demo.service.CommandsHandler;
import org.springframework.stereotype.Service;

@Service
public class HelpCommand implements CommandsHandler {
    @Override
    public void execute() {
        System.out.println("u -Enter this command to update pipeline, after typing " +
                "you need to enter the path to pipeline");
        System.out.println("c -Enter this command to calculate the shortest routes");
        System.out.println("r -Enter this command to display results in terminal " +
                "(available after the command \"c\")");
        System.out.println("h -Enter this command to get the entire list of commands " +
                "and descriptions for them");
        System.out.println("exit -Enter this command to close application" +
                "and descriptions for them");
    }
}
