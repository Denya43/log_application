package com.example.coreapi.entity;

import com.example.coreapi.dto.LogEntityDto;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
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
