package com.example.coreapi.dto;

import java.time.LocalDate;

public class LogEntityDto {

    private String message;
    private String type;
    private String level;
    private LocalDate time;

    public LogEntityDto() {
    }

    public LogEntityDto(String message, String type, String level, LocalDate time) {
        this.message = message;
        this.type = type;
        this.level = level;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
}
