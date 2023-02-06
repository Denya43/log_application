package com.example.coreapi.service.impl;

import com.example.coreapi.dao.LogEntityRepository;
import com.example.coreapi.dto.LogEntityDto;
import com.example.coreapi.entity.LogEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LogEntityServiceImplTest {
    private static final String FILE_NAME = "src/test/resources/logfile.txt";
    private static final LogEntityDto LOG_ENTITY_DTO = new LogEntityDto("messageTest", "testType", "testLevel",  LocalDate.now());

    @Mock
    private LogEntityRepository logEntityRepository;

    @Mock
    private LogEntityServiceImpl logEntityService;

    @Test
    public void testSaveLogToDatabase() {
        logEntityService.saveLogToDatabase(LOG_ENTITY_DTO);

        verify(logEntityRepository, times(1)).save(new LogEntity(LOG_ENTITY_DTO));
    }

    @Test
    public void testWriteLogToFile() throws IOException {
        logEntityService.writeLogToFile(FILE_NAME, LOG_ENTITY_DTO);

        File file = new File(FILE_NAME);
        assertTrue(file.exists());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            assertTrue(line.contains(LOG_ENTITY_DTO.toString()));
        }
    }
}