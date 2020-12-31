package com.ptv.livebox;

import com.ptv.livebox.dao.entity.MovieEntity;
import com.ptv.livebox.dto.Movie;

public class MovieDataUtils {
    public static Movie createMovieDTO() {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setName("Mock Movie");
        movie.setDescription("Mocked description");
        return movie;
    }

    public static MovieEntity createMovieEntity() {
        MovieEntity movie = new MovieEntity();
        movie.setId(1);
        movie.setName("Mock Movie");
        movie.setDescription("Mocked description");
        return movie;
    }
}
