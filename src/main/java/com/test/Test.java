package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.api.entity.Movie;

public class Test {

	public static void main(String[] args) {
		List<Movie> itr = new ArrayList<Movie>();

		Movie movie = new Movie();
		movie.setName("TEst");
		movie.setYear(2020);
		movie.setRating(2.3);
		itr.add(movie);
		Iterable<Movie> i = itr;
		
		List<Movie> ll= StreamSupport.stream(i.spliterator(), false).collect(Collectors.toList());
		System.out.println(ll.isEmpty()+"---- "+ll.size());

	}

}
