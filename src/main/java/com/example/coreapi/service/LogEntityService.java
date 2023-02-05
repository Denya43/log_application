package com.example.coreapi.service;

import com.example.coreapi.dto.LogEntityDto;

public interface LogEntityService {
    void saveLogToDatabase(LogEntityDto logEntityDto);
    void writeLogToFile(String fileName, LogEntityDto logEntityDto);
}
