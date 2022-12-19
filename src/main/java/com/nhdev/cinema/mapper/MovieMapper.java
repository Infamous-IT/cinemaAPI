package com.nhdev.cinema.mapper;

import com.nhdev.cinema.dto.MovieDTO;
import com.nhdev.cinema.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MovieMapper {

    MovieDTO movieToMovieDTO(Optional<Movie> movie);

    List<MovieDTO> movieToMovieDTOList(List<Movie> movieList);

    Movie movieDTOToMovie(MovieDTO movieDTO);
}
