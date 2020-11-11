package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import com.example.demo.controllers.RouteHandlerController;
import com.example.demo.service.impl.LocalFileReaderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RouteHandlerControllerTest {
    @Autowired
    RouteHandlerController routeHandlerController;
    @Autowired
    LocalFileReaderService localFileReaderService;

    @Test
    public void correctWorkUploadController() {
        routeHandlerController.uploadGraph();
        routeHandlerController.loadRoutes();
        routeHandlerController.writeShortestRoutes("src\\test\\java\\com\\example\\demo\\resources\\recorded");
        List<String> expected = List.of("TRUE;35", "FALSE;", "TRUE;20");
        List<String> actual = localFileReaderService.read("src\\test\\java\\com\\example\\demo\\resources\\recorded");
        assertEquals(expected, actual);
    }
}
