package com.example.coreapi.controller.impl;

import com.example.coreapi.controller.LogController;
import com.example.coreapi.dto.LogEntityDto;
import com.example.coreapi.service.LogEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping()
@RequiredArgsConstructor
@Slf4j
public class LogControllerImpl implements LogController {
    private final LogEntityService logService;
    private static final String FILE_NAME = "logs.txt";


    @PostMapping(value = "/logs")
    public ResponseEntity<String> addLog(@Valid @RequestBody LogEntityDto logEntityDto) {
        log.trace("ENTRY addLog");

        logService.saveLogToDatabase(logEntityDto);
        logService.writeLogToFile(FILE_NAME, logEntityDto);

        log.trace("EXIT addLog");

        return new ResponseEntity<>("Log written successfully", HttpStatus.OK);
    }
}