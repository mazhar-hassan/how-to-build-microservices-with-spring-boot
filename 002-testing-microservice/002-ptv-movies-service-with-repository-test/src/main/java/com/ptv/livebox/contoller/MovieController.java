package com.ptv.livebox.contoller;

import com.ptv.livebox.dto.Movie;
import com.ptv.livebox.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> list() {
        return movieService.list();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable("id") Integer id) {
            return movieService.findById(id);
    }
}
