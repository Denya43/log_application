package com.example.coreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
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

    @Override
    public String toString() {
        return "LogEntityDto{" +
                "message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", time=" + time +
                '}';
    }
}
