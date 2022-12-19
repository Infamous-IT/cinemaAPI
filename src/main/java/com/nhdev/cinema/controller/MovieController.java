package com.nhdev.cinema.controller;

import com.nhdev.cinema.dto.MovieDTO;
import com.nhdev.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = MovieController.BASE_URL)
public class MovieController {

    public static final String BASE_URL = ServiceAPIUrl.VERSION_PATH + "/movie";

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDTO> get(){
        return movieService.get();
    }

    @GetMapping(value = "/{id}")
    public MovieDTO getById(@PathVariable UUID id) {
        return movieService.getById(id);
    }

    @PatchMapping(value = "/{id}")
    public MovieDTO update(@RequestBody MovieDTO movieDTO) {
        return movieService.update(movieDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDTO create(@RequestBody MovieDTO movieDTO) {
        return movieService.create(movieDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable UUID id) {
        movieService.delete(id);
    }
}
