package com.example.coreapi.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class LogEntityDto {

    @NotNull
    private String message;
    @NotNull
    private String type;
    @NotNull
    private String level;
    @NotNull
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

    @Override
    public String toString() {
        return "LogEntityDto{" +
                "message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", time=" + time +
                '}';
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
}
