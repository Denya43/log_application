package com.example.coreapi.controller;

import com.example.coreapi.dto.LogEntityDto;
import com.example.coreapi.service.LogEntityService;
import com.example.coreapi.service.impl.LogEntityServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping()
public class LogController {
    private final LogEntityService logService;


    public LogController(LogEntityServiceImpl logService) {
        this.logService = logService;
    }


    @PostMapping(value = "/logs", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addLog(@Valid @RequestBody LogEntityDto logEntityDto, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.BAD_REQUEST);
        }

        logService.saveLogToDatabase(logEntityDto);
        String fileName = "logs.txt";
        logService.writeLogToFile(fileName, logEntityDto);
        return new ResponseEntity<>("Log written successfully", HttpStatus.OK);
    }

    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthcheck() {
        return ResponseEntity.status(HttpStatus.OK).body("Healthcheck succeeded.");
    }
}