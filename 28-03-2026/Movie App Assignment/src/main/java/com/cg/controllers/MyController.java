package com.cg.controllers;

import com.cg.entities.Movie;
import com.cg.service.IMovieService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MyController {

	@Autowired
	private IMovieService movieService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/addMovie")
	public String showAddMoviePage(Model model) {
		model.addAttribute("movie", new Movie());
		return "addMovie";
	}

	@PostMapping("/addMovie")
	public String addMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "addMovie";
		}

		movieService.addMovie(movie);

		model.addAttribute("movie", new Movie());
		model.addAttribute("successMessage", "Movie '" + movie.getMovieName() + "' added successfully!");

		return "addMovie";
	}

	@GetMapping("/allMovies")
	public String getAllMovies(Model model) {
		List<Movie> movies = movieService.getAllMovies();
		model.addAttribute("movies", movies);
		return "allMovies";
	}

	@GetMapping("/searchMovie")
	public String showSearchPage(Model model) {
		model.addAttribute("searchMovie", new Movie());
		model.addAttribute("movies", null);
		return "searchMovie";
	}

	@PostMapping("/searchMovie")
	public String searchByCategory(@ModelAttribute("searchMovie") Movie movie, Model model) {
		List<Movie> movies = movieService.getMoviesByGenre(movie.getGenre());
		model.addAttribute("searchMovie", movie);
		model.addAttribute("movies", movies);
		return "searchMovie";
	}

	@GetMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable Long id, Model model) {

		Optional<Movie> movie = movieService.getMovieById(id);

		if (movie.isPresent()) {
			movieService.deleteMovie(id);
			model.addAttribute("successMessage", "Movie deleted successfully!");
		} else {
			model.addAttribute("errorMessage", "Movie not found with ID: " + id);
		}

		model.addAttribute("movies", movieService.getAllMovies());
		return "allMovies";
	}

	@GetMapping("/editMovie/{id}")
	public String showEditPage(@PathVariable Long id, Model model) {

		Optional<Movie> movie = movieService.getMovieById(id);

		if (movie.isPresent()) {
			model.addAttribute("movie", movie.get());
		} else {
			model.addAttribute("errorMessage", "Movie not found with ID: " + id);
			model.addAttribute("movie", new Movie());
		}

		return "editMovie";
	}

	@PostMapping("/editMovie/{id}")
	public String updateMovie(@PathVariable Long id, @Valid @ModelAttribute("movie") Movie updatedMovie,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "editMovie";
		}

		Movie updated = movieService.updateMovie(id, updatedMovie);

		if (updated != null) {
			model.addAttribute("successMessage", "Movie updated successfully!");
		} else {
			model.addAttribute("errorMessage", "Movie not found with ID: " + id);
		}

		return "editMovie";
	}
}