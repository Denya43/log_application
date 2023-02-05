package com.example.coreapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coreapi.entity.LogEntity;

@Repository
public interface LogEntityRepository extends JpaRepository<LogEntity, Long> {

}
