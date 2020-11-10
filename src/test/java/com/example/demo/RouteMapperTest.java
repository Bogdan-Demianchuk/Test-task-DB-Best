package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.exeption.InvalidContentForMappingException;
import com.example.demo.mapper.RouteMapper;
import com.example.demo.model.Route;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RouteMapperTest {
    List<Route> expected = new ArrayList<>();
    List<String[]> lines = new ArrayList<>();
    @Autowired
    RouteMapper routeMapper;
    @BeforeEach
    void init() {
        expected.add(new Route(1L, 2L));
        expected.add(new Route(2L, 3L));
        expected.add(new Route(3L, 4L));
        expected.add(new Route(3L, 5L));
        expected.add(new Route(6L, 7L));
        lines.add(new String[]{"1", "2"});
        lines.add(new String[]{"2", "3"});
        lines.add(new String[]{"3", "4"});
        lines.add(new String[]{"3", "5"});
        lines.add(new String[]{"6", "7"});
    }

    @Test
    public void getRouteFromLineTest() {
        List<Route> actual = new ArrayList<>();
        for (String[] contentGraph : lines) {
            Route route = routeMapper.routeMapper(contentGraph);
            actual.add(route);
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void invalidDataInLineThenExceptionThrownTest() {
        String[] contentGraph = new String[]{"2", "1", "2", "1"};
        try {
            routeMapper.routeMapper(contentGraph);
            Assert.fail("Expected InvalidContentForMappingException");
        } catch (InvalidContentForMappingException thrown) {
            Assert.assertEquals("Data cannot be read like a route", thrown.getMessage());
        }
    }
}
