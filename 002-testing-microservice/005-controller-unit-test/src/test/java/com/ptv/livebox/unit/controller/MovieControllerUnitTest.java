package com.ptv.livebox.unit.controller;

import com.ptv.livebox.contoller.MovieController;
import com.ptv.livebox.dto.Movie;
import com.ptv.livebox.service.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.ptv.livebox.MovieDataUtils.createMovieDTO;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(MovieController.class)
public class MovieControllerUnitTest {
    @Autowired
    public MockMvc mockMvc;

    @MockBean
    MovieService service;

    @Test
    void testFindById() throws Exception {
        Movie dto = createMovieDTO();
        when(service.findById(1)).thenReturn(dto);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/movies/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Mock Movie"))
                .andExpect(jsonPath("$.description").value("Mocked description"));
    }
}
