package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.exeption.InvalidContentForMappingException;
import com.example.demo.mapper.NodeMapper;
import com.example.demo.model.Node;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NodeMapperTest {
    List<Node> expected = new ArrayList<>();
    List<String[]> lines = new ArrayList<>();
    @Autowired
    NodeMapper nodeMapper;

    @BeforeEach
    void init() {
        expected.add(new Node(1L, 2L, 10L));
        expected.add(new Node(2L, 3L, 20L));
        expected.add(new Node(3L, 4L, 30L));
        expected.add(new Node(3L, 5L, 15L));
        expected.add(new Node(6L, 7L, 20L));
        lines.add(new String[]{"1", "2", "10"});
        lines.add(new String[]{"2", "3", "20"});
        lines.add(new String[]{"3", "4", "30"});
        lines.add(new String[]{"3", "5", "15"});
        lines.add(new String[]{"6", "7", "20"});
    }

    @Test
    public void getGraphFromLineTest() {
        List<Node> actual = new ArrayList<>();
        for (String[] contentGraph : lines) {
            Node node = nodeMapper.nodeMapper(contentGraph);
            actual.add(node);
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void invalidDataInLineThenExceptionThrownTest() {
        String[] contentGraph = new String[]{"2", "1", "2", "1"};
        try {
            nodeMapper.nodeMapper(contentGraph);
            Assert.fail("Expected InvalidContentForMappingException");
        } catch (InvalidContentForMappingException thrown) {
            Assert.assertEquals("Data cannot be read like a node", thrown.getMessage());
        }
    }
}
