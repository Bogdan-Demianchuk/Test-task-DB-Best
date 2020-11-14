package com.example.demo.service.impl;

import java.io.File;
import com.example.demo.controllers.RouteHandlerController;
import com.example.demo.service.CommandsHandler;
import org.springframework.stereotype.Service;

@Service
public class CalculateShortestRouteCommand implements CommandsHandler {
    private final RouteHandlerController routeHandlerController;
    private String resultPath = "src" + File.separator + "main" + File.separator +
            "resources" + File.separator + "result";

    public CalculateShortestRouteCommand(RouteHandlerController routeHandlerController) {
        this.routeHandlerController = routeHandlerController;
    }

    @Override
    public void execute() {
        routeHandlerController.uploadGraph();
        routeHandlerController.loadRoutes();
        routeHandlerController.writeShortestRoutes(resultPath);
    }
}
