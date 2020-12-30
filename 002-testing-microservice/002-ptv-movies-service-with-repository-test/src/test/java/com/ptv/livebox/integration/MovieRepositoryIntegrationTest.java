package com.ptv.livebox.integration;

import com.ptv.livebox.dao.MovieRepository;
import com.ptv.livebox.dao.entity.MovieEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MovieRepositoryIntegrationTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    MovieRepository movieRepository;

    @Test
    void test() {

        //given - Arrange
        MovieEntity movie = new MovieEntity();
        movie.setName("Test Movie Integration");
        movie.setDescription("Some testing description");
        entityManager.persist(movie);

        //when - Action
        boolean result = movieRepository.existsById(movie.getId());

        //then - Assert
        assertThat(result).isEqualTo(true);
    }

    @Test
    void testFindById() {

        //given - Arrange
        Integer movieId = 3;

        //when - Action
        MovieEntity movie = movieRepository.findById(movieId).orElse(null);

        //then - Assert
        assertThat(movie).isNotNull();
        assertThat(movie.getName()).isEqualTo("The Last Samurai - Test Movie");
        assertThat(movie.getDescription()).isEqualTo("Code and Honour");
    }

}
