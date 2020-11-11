package com.example.demo;

import com.example.demo.model.Route;
import com.example.demo.service.GraphUploader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GraphUploaderTest {
    @Autowired
    GraphUploader graphUploader;

    @Test
    public void correctWork(){
        graphUploader.uploadGraph();
        Long shortestRoute = graphUploader.findShortestRoute(new Route(2L, 5L));
    }
}
