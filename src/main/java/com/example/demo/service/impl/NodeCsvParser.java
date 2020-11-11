package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.mapper.NodeMapper;
import com.example.demo.model.Node;
import com.example.demo.service.CsvParserService;
import com.example.demo.service.FileReaderService;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeCsvParser implements CsvParserService<Node> {
    private final FileReaderService fileRiderService;
    private final NodeMapper nodeMapper;

    @Autowired
    public NodeCsvParser(FileReaderService fileRiderService, NodeMapper nodeMapper) {
        this.fileRiderService = fileRiderService;
        this.nodeMapper = nodeMapper;
    }

    @Override
    public List<Node> parseCsvFile(String path) {
        List<Node> nodes = new ArrayList<>();
        CsvParserSettings csvParserSettings = new CsvParserSettings();
        csvParserSettings.setMaxCharsPerColumn(-1);
        CsvParser csvParser = new CsvParser(csvParserSettings);
        List<String> lines = fileRiderService.read(path);
        lines.remove(0);
        for (String line : lines) {
            String[] nodeContent = csvParser.parseLine(line);
            nodes.add(nodeMapper.nodeMapper(nodeContent));
        }
        return nodes;
    }
}
