package com.example.demo.mapper;

import com.example.demo.exeption.InvalidContentForMappingException;
import com.example.demo.model.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {
    private static final int NODE_FROM = 0;
    private static final int NODE_TO = 1;

    public Route routeMapper(String[] nodeContent) {
        if (nodeContent.length != 2) {
            throw new InvalidContentForMappingException("Data cannot be read like a route");
        }
        Route route = new Route();
        route.setPointFrom(Long.valueOf(nodeContent[NODE_FROM]));
        route.setPointTo(Long.valueOf(nodeContent[NODE_TO]));
        return route;
    }
}
