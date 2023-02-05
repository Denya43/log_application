package com.example.coreapi.entity;

import com.example.coreapi.dto.LogEntityDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "type")
    private String type;

    @Column(name = "level")
    private String level;

    @Column(name = "time")
    private LocalDate time;

    public LogEntity(String message, String type, String level, LocalDate time) {
    }

    public LogEntity(LogEntityDto logEntityDto) {
        this.message = logEntityDto.getMessage();
        this.type = logEntityDto.getType();
        this.level = logEntityDto.getLevel();
        this.time = logEntityDto.getTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LogEntity logs = (LogEntity) o;
        return id != null && Objects.equals(id, logs.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
