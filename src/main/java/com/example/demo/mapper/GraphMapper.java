package com.example.demo.mapper;

import com.example.demo.exeption.InvalidGraphContentException;
import com.example.demo.model.Graph;
import org.springframework.stereotype.Component;

@Component
public class GraphMapper {
    private static final int GRAPH_FROM = 0;
    private static final int GRAPH_TO = 1;
    private static final int GRAPH_LENGTH = 2;


    public Graph graphMapper (String[] graphContent){
        if (graphContent.length != 3){
            throw new InvalidGraphContentException("Data cannot be read like a graph");
        }
        Graph graph = new Graph();
        graph.setFrom(Long.valueOf(graphContent[GRAPH_FROM]));
        graph.setTo(Long.valueOf(graphContent[GRAPH_TO]));
        graph.setLength(Long.valueOf(graphContent[GRAPH_LENGTH]));
        return graph;
    }

}
