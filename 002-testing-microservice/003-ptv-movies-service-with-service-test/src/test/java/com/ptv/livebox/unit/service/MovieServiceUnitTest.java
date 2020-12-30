package com.ptv.livebox.unit.service;

import com.ptv.livebox.dao.MovieRepository;
import com.ptv.livebox.dao.entity.MovieEntity;
import com.ptv.livebox.dto.Movie;
import com.ptv.livebox.mapper.MovieMapper;
import com.ptv.livebox.service.impl.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieServiceUnitTest {
    @Mock
    MovieRepository movieRepository;

    @Mock
    MovieMapper movieMapper;

    @InjectMocks
    MovieServiceImpl movieService;

    @Test
    void testFindById() {

        //Arrange
        Integer movieId = 1;
        MovieEntity entity = createMovieEntity();
        Movie dto = createMovieDTO();
        doReturn(Optional.of(entity)).when(movieRepository).findById(movieId);
        when(movieMapper.map(entity)).thenReturn(dto);

        //Action
        Movie found = movieService.findById(movieId);

        //Assert
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo(dto.getName());
        assertThat(found.getDescription()).isEqualTo(dto.getDescription());

        verify(movieRepository).findById(movieId);
        verify(movieMapper, times(1)).map(entity);
    }
    
    private MovieEntity createMovieEntity() {
        MovieEntity movie = new MovieEntity();
        movie.setId(1);
        movie.setName("Mock Movie");
        return movie;
    }

    private Movie createMovieDTO() {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setName("Mock Movie");
        return movie;
    }
}
