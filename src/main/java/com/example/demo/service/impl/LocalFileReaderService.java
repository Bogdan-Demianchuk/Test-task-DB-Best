package com.example.demo.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.example.demo.service.FileReaderService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class LocalFileReaderService implements FileReaderService {
    @Override
    public List<String> read(String path) {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            result = lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return result;
    }
}
