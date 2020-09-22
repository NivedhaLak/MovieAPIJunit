package com.api.dao;

import java.util.List;

import com.api.entity.Movie;

public interface MovieDaoService{

	Movie save(Movie movie);
	
	List<Movie> findAll();
	
	List<Movie> findByColumn(String id, String value);
}
