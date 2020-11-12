package com.example.demo.controllers;

import java.util.List;
import com.example.demo.model.Node;
import com.example.demo.repository.NodeRepository;
import com.example.demo.service.CsvParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class NodesLoaderController implements ApplicationRunner {
    final NodeRepository nodeRepository;
    final CsvParserService<Node> csvParserService;
    @Value("${path.to.pipeline.file}")
    private String path;

    @Autowired
    public NodesLoaderController(NodeRepository nodeRepository, CsvParserService<Node> csvParserService) {
        this.nodeRepository = nodeRepository;
        this.csvParserService = csvParserService;
    }

    @Override
    public void run(ApplicationArguments args) {
        updateNodesInDB();
    }

    public void updateNodesInDB() {
        String[] paths = path.split(",");
        List<Node> list;
        for (String path : paths) {
            list = csvParserService.parseCsvFile(path.trim());
            for (Node node : list) {
                nodeRepository.save(node);
            }
        }
    }
}
