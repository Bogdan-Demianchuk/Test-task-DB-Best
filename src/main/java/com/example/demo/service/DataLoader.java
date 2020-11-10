package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Graph;
import com.example.demo.repository.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    final GraphRepository graphRepository;
    final CsvParserService csvParserService;

    @Autowired
    public DataLoader(GraphRepository graphRepository, CsvParserService csvParserService) {
        this.graphRepository = graphRepository;
        this.csvParserService = csvParserService;
    }

    @Override
    public void run(ApplicationArguments args) {
        List<Graph> list = csvParserService.parseCsvFile("src/main/resources/testFile");
        for(Graph graph:list){
            graphRepository.save(graph);
        }
    }
}
