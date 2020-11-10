package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.Graph;
import com.example.demo.service.impl.GraphCsvParser;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GraphCsvParserTest {
    List<Graph> expected = new ArrayList<>();
    @Autowired
    GraphCsvParser graphCsvParser;

    @BeforeEach
    void init() {
        System.out.println("before");
        expected.add(new Graph(1L, 2L, 10L));
        expected.add(new Graph(2L, 3L, 20L));
        expected.add(new Graph(3L, 4L, 30L));
        expected.add(new Graph(3L, 5L, 15L));
        expected.add(new Graph(6L, 7L, 20L));
    }

    @Test
    public void parseCsvFileToGraphCorrectTest() {

        List<Graph> actual = graphCsvParser.parseCsvFile("src/test/java/com/example/demo/resources/testFile");
        Assert.assertEquals(expected, actual);
    }
}
