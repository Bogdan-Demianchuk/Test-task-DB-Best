package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.mapper.RouteMapper;
import com.example.demo.model.Route;
import com.example.demo.service.CsvParserService;
import com.example.demo.service.FileReaderService;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RouteCsvParser implements CsvParserService<Route> {
    private final FileReaderService fileRiderService;
    private final RouteMapper routeMapper;

    public RouteCsvParser(@Qualifier("localFileReaderService") FileReaderService fileRiderService, RouteMapper routeMapper) {
        this.fileRiderService = fileRiderService;
        this.routeMapper = routeMapper;
    }

    @Override
    public List<Route> parseCsvFile(String path) {
        List<Route> routes = new ArrayList<>();
        CsvParserSettings csvParserSettings = new CsvParserSettings();
        csvParserSettings.setMaxCharsPerColumn(-1);
        CsvParser csvParser = new CsvParser(csvParserSettings);
        List<String> lines = fileRiderService.read(path);
        lines.remove(0);
        for (String line : lines) {
            String[] nodeContent = csvParser.parseLine(line);
            routes.add(routeMapper.routeMapper(nodeContent));
        }
        return routes;
    }
}
