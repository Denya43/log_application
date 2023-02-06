package com.example.coreapi.dao;

import com.example.coreapi.entity.LogEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LogEntityRepositoryTest {

    @Autowired
    private LogEntityRepository logEntityRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        LogEntity testMessage = new LogEntity("testMessage");
        logEntityRepository.save(testMessage);

        LogEntity found = logEntityRepository.findByMessage(testMessage.getMessage());

        assertEquals(found.getMessage(), testMessage.getMessage());
    }
}