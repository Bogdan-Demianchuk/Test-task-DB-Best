package com.example.demo.controllers;

import java.util.List;
import com.example.demo.model.Route;
import com.example.demo.service.FileEditorService;
import com.example.demo.service.GraphUploader;
import com.example.demo.service.impl.RouteCsvParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class RouteHandlerController {
    private final GraphUploader graphUploader;
    private final RouteCsvParser routeCsvParser;
    private final FileEditorService fileEditorService;
    List<Route> routes;
    @Value("${path.to.routes.file}")
    private String path;

    public RouteHandlerController(GraphUploader graphUploader, RouteCsvParser routeCsvParser, FileEditorService fileEditorService) {
        this.graphUploader = graphUploader;
        this.routeCsvParser = routeCsvParser;
        this.fileEditorService = fileEditorService;
    }

    public void uploadGraph() {
        graphUploader.uploadGraph();
        log.info("Graph have been uploaded!");
    }

    public List<Route> loadRoutes() {
        routes = routeCsvParser.parseCsvFile(path);
        log.info("Routes have been uploaded!");
        return routes;
    }

    public String writeShortestRoutes(String path) {
        StringBuilder result = new StringBuilder("");
        for (Route route : routes) {
            Long shortestRoute = graphUploader.findShortestRoute(route);
            if (shortestRoute == Long.MAX_VALUE) {
                result.append("FALSE;").append("\n");
            } else {
                result.append("TRUE;").append(shortestRoute.toString()).append("\n");
            }
        }
        fileEditorService.createFile(path);
        fileEditorService.write(path, result.toString());
        log.info("The shortest routes were found and recorded in a file " + path);
        return path;
    }

}
