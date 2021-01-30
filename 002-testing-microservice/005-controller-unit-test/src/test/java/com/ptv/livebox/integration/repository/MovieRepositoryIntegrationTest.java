package com.ptv.livebox.integration.repository;

import com.ptv.livebox.dao.MovieRepository;
import com.ptv.livebox.dao.entity.MovieEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MovieRepositoryIntegrationTest {
    @Autowired
    MovieRepository movieRepository;

    @Test
    void testFindById() {
        //give - Arrange
        Integer movieId = 3;

        //when - Action
        MovieEntity movie = movieRepository.findById(movieId).orElse(null);

        //then - Assert
        assertThat(movie).isNotNull();
        assertThat(movie.getName()).isEqualTo("The Last Samurai - Test Movie");
        assertThat(movie.getDescription()).isEqualTo("Code and Honour");
    }
}
