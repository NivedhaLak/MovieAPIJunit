package com.api.service;

import java.util.List;

import com.api.entity.Movie;
import com.api.vo.MovieVO;

public interface MovieService {

	Boolean createMovies(MovieVO movieVO);

	Boolean updateMovies(MovieVO movieVO);

	List<MovieVO> fetchAllMovies();

	List<MovieVO> fetchMoviesbyId(String id, String value);
}
