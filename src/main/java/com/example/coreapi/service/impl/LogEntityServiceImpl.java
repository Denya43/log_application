package com.example.coreapi.service.impl;

import com.example.coreapi.dao.LogEntityRepository;
import com.example.coreapi.dto.LogEntityDto;
import com.example.coreapi.entity.LogEntity;
import com.example.coreapi.service.LogEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service
@Slf4j
@RequiredArgsConstructor
public class LogEntityServiceImpl implements LogEntityService {
    private final static String LOG_FILE_PATH = "/logs/logfile.txt";
    private final LogEntityRepository logEntityRepository;

    @Override
    public void saveLogToDatabase(LogEntityDto logEntityDto) {
        LogEntity logEntity = new LogEntity(logEntityDto);

        logEntityRepository.save(logEntity);
    }

    @Override
    public void writeLogToFile(String fileName, LogEntityDto logEntityDto) {
        log.trace("ENTRY writeLogToFile");

        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                log.error("Can't create file");
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            writer.write(logEntityDto.toString());
            writer.newLine();
        } catch (IOException e) {
            log.error("Can't write into file");;
        }
        log.trace("EXIT writeLogToFile");
    }
}
