package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import com.example.demo.service.FileEditorService;
import com.example.demo.service.impl.LocalFileReaderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FileEditorServiceTest {
    @Autowired
    FileEditorService fileEditorService;
    @Autowired
    LocalFileReaderService localFileReaderService;

    @Test
    public void correctWorkFileEditorService() {
        String pathToFile = fileEditorService.createFile("src/test/java/com/example/demo/resources/writeFile");
        fileEditorService.write(pathToFile, "Hello file" + "\n" + "Hello");
        List<String> actual = localFileReaderService.read(pathToFile);
        List<String> expected = List.of("Hello file", "Hello");
        assertEquals(actual, expected);
    }
}
