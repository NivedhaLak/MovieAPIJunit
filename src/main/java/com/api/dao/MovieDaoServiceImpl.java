package com.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.Movie;
import com.api.repository.MovieRepository;

@Service
public class MovieDaoServiceImpl implements MovieDaoService {

	@Autowired
	MovieRepository repository;

	@Override
	public Movie save(Movie movie) {
		return repository.save(movie);
	}

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Movie> findByColumn(String id, String value) {
		if ("year".equalsIgnoreCase(id)) {
			return repository.findByYear(Integer.parseInt(value));
		} else if ("rating".equalsIgnoreCase(id)) {
			return repository.findByRating(Double.parseDouble(value));
		}
		return null;
	}

}
