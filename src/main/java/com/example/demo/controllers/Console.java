package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import com.example.demo.service.CommandsHandler;
import com.example.demo.service.impl.CalculateShortestRouteCommand;
import com.example.demo.service.impl.ExitCommand;
import com.example.demo.service.impl.HelpCommand;
import com.example.demo.service.impl.InvalidCommand;
import com.example.demo.service.impl.PrintResultCommand;
import com.example.demo.service.impl.UpdateNodesInDBCommand;
import org.springframework.stereotype.Controller;

@Controller
public class Console {
    private static HashMap<String, CommandsHandler> commandHandlers;
    private final ExitCommand exitCommand;
    private final UpdateNodesInDBCommand updateNodesInDBCommand;
    private final CalculateShortestRouteCommand calculateShortestRouteCommand;
    private final PrintResultCommand printResultCommand;
    private final HelpCommand helpCommand;
    private final InvalidCommand invalidCommand;

    public Console(ExitCommand exitCommand,
                   UpdateNodesInDBCommand updateNodesInDBCommand,
                   CalculateShortestRouteCommand calculateShortestRouteCommand,
                   PrintResultCommand printResultCommand,
                   HelpCommand helpCommand, InvalidCommand invalidCommand) {
        this.exitCommand = exitCommand;
        this.updateNodesInDBCommand = updateNodesInDBCommand;
        this.calculateShortestRouteCommand = calculateShortestRouteCommand;
        this.printResultCommand = printResultCommand;
        this.helpCommand = helpCommand;
        this.invalidCommand = invalidCommand;
    }

    @PostConstruct
    public HashMap<String, CommandsHandler> initCommands() {
        commandHandlers = new HashMap<>();
        commandHandlers.put("exit", exitCommand);
        commandHandlers.put("u", updateNodesInDBCommand);
        commandHandlers.put("c", calculateShortestRouteCommand);
        commandHandlers.put("r", printResultCommand);
        commandHandlers.put("h", helpCommand);
        return commandHandlers;
    }

    public void run() {
        System.out.println("h -Enter this command to get the entire list of commands and descriptions for them");
        System.out.println("Write command pleas");
        Scanner input = new Scanner(System.in);
        String userCommand;
        while (true) {
           userCommand = input.nextLine();
            commandHandlers.getOrDefault(userCommand, invalidCommand).execute();
        }
    }
}
