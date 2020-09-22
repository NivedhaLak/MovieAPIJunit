package com.test.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.api.dao.MovieDaoService;
import com.api.dao.MovieDaoServiceImpl;
import com.api.entity.Movie;
import com.api.repository.MovieRepository;
import com.api.service.MovieService;
import com.api.service.MovieServiceImpl;
import com.api.vo.MovieVO;

public class MovieTestServiceImpl {

	@InjectMocks
	private MovieService movieService = new MovieServiceImpl();

	@Mock
	private ModelMapper modelMapper;

	@Mock
	private MovieRepository repository;

	@Mock
	private MovieDaoService daoService = new MovieDaoServiceImpl();

	@Before
	public void init_mocks() {
		MockitoAnnotations.initMocks(this);
	}

	static List<Movie> itr;
	static MovieVO movieVO;

	@BeforeClass
	public static void testObject() {
		itr = new ArrayList<Movie>();
		Movie movie = new Movie();
		movie.setName("TEst");
		movie.setYear(2020);
		movie.setRating(2.3);
		itr.add(movie);
	}

	@Before
	public void testObjectVO() {
		movieVO = new MovieVO();
		movieVO.setName("TEst");
		movieVO.setYear(2020);
		movieVO.setRating(2.3);
	}

	@Test
	public void fetchAllMovies() throws Exception {
		when(daoService.findAll()).thenReturn(itr);
		List<MovieVO> list = movieService.fetchAllMovies();
		assertTrue(!list.isEmpty());
	}

	@Test
	public void createMovies() throws Exception {
		when(daoService.save(Mockito.any(Movie.class))).thenReturn(new Movie());
		Boolean result = movieService.createMovies(movieVO);
		assertTrue(result);
	}

	@Test
	public void createMoviesWithEmptyName() throws Exception {
		MovieVO movie = movieVO;
		movie.setName(null);
		when(daoService.save(Mockito.any(Movie.class))).thenReturn(new Movie());
		Boolean result = movieService.createMovies(movie);
		assertFalse(result);
	}

	@Test
	public void createMoviesWithEmptyYear() throws Exception {
		MovieVO movie = movieVO;
		movie.setYear(null);
		when(daoService.save(Mockito.any(Movie.class))).thenReturn(new Movie());
		Boolean result = movieService.createMovies(movie);
		assertFalse(result);
	}

	@Test
	public void updateMovies() throws Exception {
		MovieVO movie = movieVO;
		movie.setId(3l);
		when(daoService.save(Mockito.any(Movie.class))).thenReturn(new Movie());
		Boolean result = movieService.updateMovies(movie);
		assertTrue(result);
	}

	@Test
	public void updateMoviesWithEmptyId() throws Exception {
		when(daoService.save(Mockito.any(Movie.class))).thenReturn(new Movie());
		Boolean result = movieService.updateMovies(movieVO);
		assertFalse(result);
	}

	@Test
	public void fetchMoviesbyYear() throws Exception {
		when(daoService.findByColumn(Mockito.anyString(), Mockito.anyString())).thenReturn(itr);
		List<MovieVO> result = movieService.fetchMoviesbyId("year", "2020");
		assertTrue(!result.isEmpty());
	}

	@Test
	public void fetchMoviesbyRating() throws Exception {

		when(daoService.findByColumn(Mockito.anyString(), Mockito.anyString())).thenReturn(itr);
		List<MovieVO> result = movieService.fetchMoviesbyId("rating", "2.3");
		assertTrue(!result.isEmpty());
	}

}
