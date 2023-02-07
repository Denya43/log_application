package com.example.coreapi.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String message;

    @Column()
    private String type;

    @Column()
    private String level;

    @Column()
    private LocalDateTime time;

    public LogEntity() {

    }

    public LogEntity(String message, String type, String level, LocalDateTime time) {
        this.message = message;
        this.level = level;
        this.type = type;
        this.time = time;
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
