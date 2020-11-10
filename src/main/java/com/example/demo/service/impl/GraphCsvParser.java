package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.mapper.GraphMapper;
import com.example.demo.model.Graph;
import com.example.demo.service.CsvParserService;
import com.example.demo.service.FileReaderService;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraphCsvParser implements CsvParserService<Graph> {
    private final FileReaderService fileRiderService;
    private final GraphMapper graphMapper;

    @Autowired
    public GraphCsvParser(FileReaderService fileRiderService, GraphMapper graphMapper) {
        this.fileRiderService = fileRiderService;
        this.graphMapper = graphMapper;
    }

    @Override
    public List<Graph> parseCsvFile(String path) {
        List<Graph> graphs = new ArrayList<>();
        CsvParserSettings csvParserSettings = new CsvParserSettings();
        csvParserSettings.setMaxCharsPerColumn(-1);
        CsvParser csvParser = new CsvParser(csvParserSettings);
        List<String> lines = fileRiderService.read(path);
        lines.remove(0);
        for (String line : lines) {
            String[] graphContent = csvParser.parseLine(line);
            graphs.add(graphMapper.graphMapper(graphContent));
        }
        return graphs;
    }
}
