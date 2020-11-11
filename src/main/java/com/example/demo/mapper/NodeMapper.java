package com.example.demo.mapper;

import com.example.demo.exeption.InvalidContentForMappingException;
import com.example.demo.model.Node;
import org.springframework.stereotype.Component;

@Component
public class NodeMapper {
    private static final int NODE_FROM = 0;
    private static final int NODE_TO = 1;
    private static final int NODE_LENGTH = 2;


    public Node nodeMapper(String[] nodeContent) {
        if (nodeContent.length != 3) {
            throw new InvalidContentForMappingException("Data cannot be read like a node");
        }
        Node node = new Node();
        node.setPointFrom(Long.valueOf(nodeContent[NODE_FROM]));
        node.setPointTo(Long.valueOf(nodeContent[NODE_TO]));
        node.setLength(Long.valueOf(nodeContent[NODE_LENGTH]));
        return node;
    }

}
