package com.ptv.livebox.mapper;


import com.ptv.livebox.dao.entity.MovieEntity;
import com.ptv.livebox.dto.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    Movie map(MovieEntity entity);

    MovieEntity map(Movie movie);

    List<Movie> map(List<MovieEntity> entities);
}
