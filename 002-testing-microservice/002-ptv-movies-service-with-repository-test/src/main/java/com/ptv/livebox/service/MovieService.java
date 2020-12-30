package com.ptv.livebox.service;

import com.ptv.livebox.dto.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> list();

    Movie findById(Integer id);
}
