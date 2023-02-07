package com.example.coreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
    private LocalDateTime time;

    public LogEntityDto() {
    }
}
