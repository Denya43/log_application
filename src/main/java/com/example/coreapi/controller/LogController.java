package com.example.coreapi.controller;

import com.example.coreapi.dto.LogEntityDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface LogController {

    ResponseEntity<String> addLog(@Valid @RequestBody LogEntityDto logEntityDto);
}
