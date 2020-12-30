package com.ptv.livebox.integration.service;

import com.ptv.livebox.dto.Movie;
import com.ptv.livebox.service.impl.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MovieServiceIntegrationTest {

    @Autowired
    MovieServiceImpl movieService;

    @Test
    void testFindById() {

        //Arrange
        Integer movieId = 1;

        //Action
        Movie found = movieService.findById(movieId);

        //Assert
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Titanic - Test Movie");
        assertThat(found.getDescription()).isEqualTo("The ship movie");
    }
}
