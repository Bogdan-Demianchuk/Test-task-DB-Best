package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.exeption.InvalidGraphContentException;
import com.example.demo.mapper.GraphMapper;
import com.example.demo.model.Graph;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GraphMapperTest {
    List<Graph> expected = new ArrayList<>();
    List<String[]> lines = new ArrayList<>();
    @Autowired
    GraphMapper graphMapper;

    @BeforeEach
    void init() {
        expected.add(new Graph(1L, 2L, 10L));
        expected.add(new Graph(2L, 3L, 20L));
        expected.add(new Graph(3L, 4L, 30L));
        expected.add(new Graph(3L, 5L, 15L));
        expected.add(new Graph(6L, 7L, 20L));
        lines.add(new String[]{"1", "2", "10"});
        lines.add(new String[]{"2", "3", "20"});
        lines.add(new String[]{"3", "4", "30"});
        lines.add(new String[]{"3", "5", "15"});
        lines.add(new String[]{"6", "7", "20"});
    }

    @Test
    public void getGraphFromLineTest() {
        List<Graph> actual = new ArrayList<>();
        for (String[] contentGraph : lines) {
            Graph graph = graphMapper.graphMapper(contentGraph);
            actual.add(graph);
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void invalidDataInLineThenExceptionThrownTest() {
        String[] contentGraph = new String[]{"2", "1", "2", "1"};
        try {
            graphMapper.graphMapper(contentGraph);
            Assert.fail("Expected InvalidGraphContentException");
        } catch (InvalidGraphContentException thrown) {
            Assert.assertEquals("Data cannot be read like a graph", thrown.getMessage());
        }
    }
}
