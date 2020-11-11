package com.example.demo.controllers;

import java.util.List;
import java.util.Scanner;
import com.example.demo.service.FileReaderService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class Console {
    final RouteHandlerController routeHandlerController;
    final NodesLoaderController nodesLoaderController;
    final FileReaderService fileReaderService;

    public Console(RouteHandlerController routeHandlerController, NodesLoaderController nodesLoaderController, FileReaderService fileReaderService) {
        this.routeHandlerController = routeHandlerController;
        this.nodesLoaderController = nodesLoaderController;
        this.fileReaderService = fileReaderService;
    }


    public void run() {
        System.out.println("h -Enter this command to get the entire list of commands and descriptions for them");
        System.out.println("Write command pleas");
        Scanner input = new Scanner(System.in);
        String inputFromConsole = input.nextLine();
        while (!inputFromConsole.equals("exit")) {
            if (inputFromConsole.equals("u")) {
                nodesLoaderController.updateNodesInDB();
            }
            if (inputFromConsole.equals("c")) {
                routeHandlerController.uploadGraph();
                routeHandlerController.loadRoutes();
                routeHandlerController.writeShortestRoutes("src/main/resources/result");
            }
            if (inputFromConsole.equals("r")) {
                List<String> read = fileReaderService.read("src/main/resources/result");
                for (String line : read) {
                    System.out.println(line);
                }
            }
            if (inputFromConsole.equals("h")) {
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
            System.out.println("Write command pleas");
            inputFromConsole = input.nextLine();
        }
        System.exit(0);
    }
}
