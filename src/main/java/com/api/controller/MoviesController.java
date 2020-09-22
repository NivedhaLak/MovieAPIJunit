package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.Movie;
import com.api.service.MovieService;
import com.api.vo.MovieVO;

@RestController
public class MoviesController {

	@Autowired
	MovieService service;

	@GetMapping("/")
	public String welcome() {
		return "Welcome to movies api.";
	}

	@PostMapping("/movie")
	public Boolean createMovies(@RequestBody MovieVO movieVO) {
		return service.createMovies(movieVO);
	}

	@PutMapping("/movie")
	public Boolean updateMovies(@RequestBody MovieVO movieVO) {
		return service.updateMovies(movieVO);
	}

	@GetMapping("/movie")
	public List<MovieVO> fetchAllMovies() {
		return service.fetchAllMovies();

	}

	@GetMapping("/movie/{id}/{value}")
	public List<MovieVO> fetchMoviesbyId(@PathVariable String id, @PathVariable String value) {
		return service.fetchMoviesbyId(id, value);
	}
}
