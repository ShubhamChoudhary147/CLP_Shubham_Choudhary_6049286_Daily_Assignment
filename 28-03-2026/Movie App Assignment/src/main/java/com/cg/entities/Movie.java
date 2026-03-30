package com.cg.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Movie Name is required !!")
	@Pattern(regexp = "[a-zA-Z0-9 ]+", message = "Movie Name should be only alphanumeric")
	private String movieName;

	@Min(value = 1, message = "Rating needs to be a number: eg: 8.5. Rating is on Scale 1-10")
	@Max(value = 10, message = "Rating needs to be a number: eg: 8.5. Rating is on Scale 1-10")
	private double rating;

	@NotBlank(message = "Select Genre!!!")
	private String genre;

	public Movie() {
	}

	public Movie(Long id, String movieName, double rating, String genre) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.rating = rating;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}