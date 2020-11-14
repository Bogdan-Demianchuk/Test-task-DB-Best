package com.example.demo.service.impl;

import java.io.File;
import java.util.List;
import com.example.demo.service.CommandsHandler;
import com.example.demo.service.FileReaderService;
import org.springframework.stereotype.Service;

@Service
public class PrintResultCommand implements CommandsHandler {
    private final FileReaderService fileReaderService;
    private String resultPath = "src" + File.separator + "main" + File.separator +
            "resources" + File.separator + "result";

    public PrintResultCommand(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    @Override
    public void execute() {
        List<String> read = fileReaderService.read(resultPath);
        for (String line : read) {
            System.out.println(line);
        }
    }
}
