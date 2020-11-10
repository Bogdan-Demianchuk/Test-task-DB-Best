package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Node;
import com.example.demo.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    final NodeRepository nodeRepository;
    final CsvParserService csvParserService;

    @Autowired
    public DataLoader(NodeRepository nodeRepository, CsvParserService csvParserService) {
        this.nodeRepository = nodeRepository;
        this.csvParserService = csvParserService;
    }

    @Override
    public void run(ApplicationArguments args) {
        List<Node> list = csvParserService.parseCsvFile("src/main/resources/testFile");
        for(Node node :list){
            nodeRepository.save(node);
        }
    }
}
