package com.ptv.livebox.mapper;


import com.ptv.livebox.dao.entity.MovieEntity;
import com.ptv.livebox.dto.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    Movie map(MovieEntity entity);

    MovieEntity map(Movie movie);

    List<Movie> map(List<MovieEntity> entities);

    @Mapping(ignore = true, target = "id")
    void mapTo(@MappingTarget MovieEntity entity, Movie movie);
}
