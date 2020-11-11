package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import com.example.demo.service.impl.LocalFileReaderService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LocalFileReaderServiceTest {
    @Autowired
    LocalFileReaderService localFileReaderService;

    @Test
    public void localFileReaderServiceCorrectRead() {
        List<String> actual = localFileReaderService
                .read("src/test/java/com/example/demo/resources/testFile");
        List<String> expected = List.of("IDX,IDY,LENGTH", "1,2,10", "2,3,20", "3,4,30", "3,5,15", "6,7,20");
        assertEquals(actual, expected);
    }

    @Test
    public void localFileReaderServiceUnCorrectPath() {
        try {
            localFileReaderService.read("12/45");
            Assert.fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Can't read the file", e.getMessage());
        }
    }
}
