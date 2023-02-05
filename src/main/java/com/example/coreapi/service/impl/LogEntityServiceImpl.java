package com.example.coreapi.service.impl;

import com.example.coreapi.dao.LogEntityRepository;
import com.example.coreapi.dto.LogEntityDto;
import com.example.coreapi.entity.LogEntity;
import com.example.coreapi.service.LogEntityService;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

@Service
public class LogEntityServiceImpl implements LogEntityService {
    private final static String LOG_FILE_PATH = "/logs/logfile.txt";
    private final LogEntityRepository logEntityRepository;

    public LogEntityServiceImpl(LogEntityRepository logEntityRepository) {
        this.logEntityRepository = logEntityRepository;
    }

    @Override
    public void saveLogToDatabase(LogEntityDto logEntityDto) {
        LogEntity logEntity = new LogEntity(logEntityDto);

        logEntityRepository.save(logEntity);
    }

    @Override
    public void writeLogToFile(LogEntityDto logEntityDto) {
        Path path = Paths.get(LOG_FILE_PATH);
        try (FileWriter fileWriter = new FileWriter(path.toString(), true)) {
            fileWriter.write(String.format("%s %s\n",
                    logEntityDto.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    logEntityDto.getMessage()));
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
