package com.cg.service;

import com.cg.entities.Movie;
import com.cg.repo.IMovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private IMovie movieRepository;

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie updateMovie(Long id, Movie updatedMovie) {

        Optional<Movie> existingMovie = movieRepository.findById(id);

        if (existingMovie.isPresent()) {
            Movie movie = existingMovie.get();
            movie.setMovieName(updatedMovie.getMovieName());
            movie.setRating(updatedMovie.getRating());
            movie.setGenre(updatedMovie.getGenre());
            return movieRepository.save(movie);
        } else {
            return null; 
        }
    }
}