package com.example.demo.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import com.example.demo.service.FileReaderService;
import org.springframework.stereotype.Service;

@Service
public class UrlFileReaderService implements FileReaderService {
    @Override
    public List<String> read(String path) {
        List<String> result = new ArrayList<>();
        try (InputStream is = new URL(path).openConnection().getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(is));
             Stream<String> stream = reader.lines()) {
            stream.forEach(result::add);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        return result;
    }
}
