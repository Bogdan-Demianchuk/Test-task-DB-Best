package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import com.example.demo.service.impl.UrlFileReaderService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UrlFileReaderServiceTest {
    @Autowired
    UrlFileReaderService urlFileReaderService;

    @Test
    public void localFileReaderServiceCorrectRead() {
        List<String> actual = urlFileReaderService
                .read("https://srv-store5.gofile.io/download/dHYyqy/testFile");
        List<String> expected = List.of("IDX,IDY,LENGTH", "1,2,10", "2,3,20", "3,4,30", "3,5,15", "6,7,20");
        assertEquals(expected, actual);
    }

    @Test
    public void localFileReaderServiceUnCorrectPath() {
        try {
            urlFileReaderService.read("12/45");
            Assert.fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Can't read file", e.getMessage());
        }
    }
}
