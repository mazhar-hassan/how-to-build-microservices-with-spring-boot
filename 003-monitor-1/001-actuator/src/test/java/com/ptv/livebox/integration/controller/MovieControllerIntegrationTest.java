package com.ptv.livebox.integration.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MovieControllerIntegrationTest {
    @Autowired
    public MockMvc mockMvc;

    @Test
    void testFindById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/movies/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Titanic - Test Movie"))
                .andExpect(jsonPath("$.description").value("The ship movie"));
    }

    @Test
    void testFindByIdNotFound() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/movies/101"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
