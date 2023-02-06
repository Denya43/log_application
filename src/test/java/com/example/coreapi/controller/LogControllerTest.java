package com.example.coreapi.controller;

import com.example.coreapi.controller.impl.LogControllerImpl;
import com.example.coreapi.dto.LogEntityDto;
import com.example.coreapi.service.LogEntityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class LogControllerTest {

    @Mock
    private LogEntityService logService;

    @Mock
    private LogControllerImpl logController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(logController).build();
    }

    @Test
    public void addLog_ShouldReturn200AndSavedMessage_WhenValidInput() throws Exception {
        LogEntityDto log = new LogEntityDto("message", "type", "level", LocalDate.now());

        mockMvc.perform(post("/core-api/logs")
                        .content(asJsonString(log))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void addLog_ShouldReturn400_WhenInvalidInput() throws Exception {
        LogEntityDto log = new LogEntityDto("", "", "", null);

        mockMvc.perform(post("/core-api/logs")
                        .content(asJsonString(log))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}