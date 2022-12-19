package com.nhdev.cinema.service;

import com.nhdev.cinema.dto.MovieDTO;
import com.nhdev.cinema.mapper.MovieMapper;
import com.nhdev.cinema.model.Movie;
import com.nhdev.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDTO> get() {
        return movieMapper.movieToMovieDTOList(movieRepository.findAll());
    }

    @Override
    public MovieDTO update(MovieDTO movieDTO) {
        Movie movie = movieMapper.movieDTOToMovie(movieDTO);
        Movie updatedMovie = movieRepository.save(movie);
        return movieMapper.movieToMovieDTO(Optional.of(updatedMovie));
    }

    @Override
    public MovieDTO create(MovieDTO movieDTO) {
        Movie movie = movieMapper.movieDTOToMovie(movieDTO);
        Movie createdMovie = movieRepository.save(movie);
        return movieMapper.movieToMovieDTO(Optional.of(createdMovie));
    }

    @Override
    public MovieDTO getById(UUID id) {
        return movieMapper.movieToMovieDTO(movieRepository.findById(id));
    }

    @Override
    public void delete(UUID id) {
        movieRepository.deleteById(id);
    }
}
