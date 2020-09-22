package com.api.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.MovieDaoService;
import com.api.entity.Movie;
import com.api.vo.MovieVO;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDaoService daoService;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Boolean createMovies(MovieVO movieVO) {
		if (movieVO.getName() == null || movieVO.getYear() == null || movieVO.getYear() <= 0
				|| movieVO.getRating() == null)
			return Boolean.FALSE;
		daoService.save(modelMapper.map(movieVO, Movie.class));
		return Boolean.TRUE;
	}

	@Override
	public Boolean updateMovies(MovieVO movieVO) {
		if (movieVO == null || movieVO.getId() == null)
			return Boolean.FALSE;

		daoService.save(modelMapper.map(movieVO, Movie.class));

		return Boolean.TRUE;
	}

	@Override
	public List<MovieVO> fetchAllMovies() {
		return convertListMovieToVOList(daoService.findAll());
	}

	@Override
	public List<MovieVO> fetchMoviesbyId(String id, String value) {
		if ("year".equalsIgnoreCase(id) || "rating".equalsIgnoreCase(id))
			return convertListMovieToVOList(daoService.findByColumn(id, value));

		return null;
	}

	private List<MovieVO> convertListMovieToVOList(List<Movie> movie) {
		List<MovieVO> voList = new ArrayList<MovieVO>();
		movie.forEach(entity -> voList.add(modelMapper.map(entity, MovieVO.class)));
		return voList;
	}

}
