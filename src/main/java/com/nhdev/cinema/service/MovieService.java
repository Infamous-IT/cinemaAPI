package com.nhdev.cinema.service;

import com.nhdev.cinema.dto.MovieDTO;

import java.util.List;
import java.util.UUID;

public interface MovieService {

    List<MovieDTO> get();

    MovieDTO update(MovieDTO movieDTO);

    MovieDTO create(MovieDTO movieDTO);

    MovieDTO getById(UUID id);

    void delete(UUID id);
}
