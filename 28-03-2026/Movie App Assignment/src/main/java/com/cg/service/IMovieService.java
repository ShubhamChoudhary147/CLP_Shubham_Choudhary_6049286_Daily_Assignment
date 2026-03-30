package com.cg.service;

import com.cg.entities.Movie;
import java.util.List;
import java.util.Optional;

public interface IMovieService {

    Movie addMovie(Movie movie);

    List<Movie> getAllMovies();

    List<Movie> getMoviesByGenre(String genre);

    void deleteMovie(Long id);

    Optional<Movie> getMovieById(Long id);

    Movie updateMovie(Long id, Movie movie);
}