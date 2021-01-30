package com.ptv.livebox.contoller;

import com.ptv.livebox.dto.Movie;
import com.ptv.livebox.service.MovieService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return movieService.create(movie);
    }

    @PutMapping("/{id}")
    public Movie create(@PathVariable("id") Integer id, @RequestBody Movie movie) {
        return movieService.update(id, movie);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return movieService.delete(id);
    }
}
