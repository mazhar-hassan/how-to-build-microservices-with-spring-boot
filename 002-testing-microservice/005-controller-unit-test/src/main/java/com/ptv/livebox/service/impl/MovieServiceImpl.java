package com.ptv.livebox.service.impl;

import com.ptv.livebox.common.exceptions.RecordNotFoundException;
import com.ptv.livebox.dao.MovieRepository;
import com.ptv.livebox.dto.Movie;
import com.ptv.livebox.mapper.MovieMapper;
import com.ptv.livebox.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<Movie> list() {
        return movieMapper.map(movieRepository.findAll());
    }

    @Override
    public Movie findById(Integer id) {
        return movieRepository.findById(id)
                .map(movieMapper::map)
                .orElseThrow(() -> new RecordNotFoundException(1, "Movie not found"));
    }
}
