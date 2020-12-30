package com.ptv.livebox.integration.controller;

import com.ptv.livebox.contoller.MovieController;
import com.ptv.livebox.dto.Movie;
import com.ptv.livebox.service.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestController {

    @Mock
    MovieService service;

    @InjectMocks
    MovieController controller;

    @Test
    void test() {
        Movie dto = createMovieDTO();

        when(service.findById(1)).thenReturn(dto);

        Movie result = controller.findById(1);

        assertThat(result).isNotNull();
    }

    private Movie createMovieDTO() {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setName("Mock Movie");
        return movie;
    }
}
