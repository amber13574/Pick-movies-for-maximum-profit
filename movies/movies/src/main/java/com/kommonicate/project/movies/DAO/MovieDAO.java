package com.kommonicate.project.movies.DAO;

import Resource.MovieDetails;
import Resource.MovieResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MovieDAO {

    private static final Long FIXED_AMOUNT = 10000000L;

    public MovieResponse getMoviesList(List<MovieDetails> movieDetails) {
        int idx = 0;
        MovieDetails[] movieDetailsArray = new MovieDetails[movieDetails.size()];
        for (MovieDetails md : movieDetails) {
            movieDetailsArray[idx] = new MovieDetails(md.getMovieName(), md.getStartDate(), md.getEndDate());
            idx++;
        }
        return getFinalListOfMovies(movieDetailsArray);
    }

    public static MovieResponse getFinalListOfMovies(MovieDetails[] movieDetailsArray) {

        Arrays.sort(movieDetailsArray);
        List<String> moviesList = new ArrayList<>();
        long countOfMovies = 1L;
        int currentMovieIdx = 0;
        moviesList.add(movieDetailsArray[0].getMovieName());
        for (int idx = 1; idx < movieDetailsArray.length; idx++) {
            if (movieDetailsArray[idx].getStartDate().after(movieDetailsArray[currentMovieIdx].getEndDate())) {
                moviesList.add(movieDetailsArray[idx].getMovieName());
                currentMovieIdx = idx;
                countOfMovies++;
            }
        }
        displayMovieResponse(countOfMovies, moviesList);
        return new MovieResponse(countOfMovies * FIXED_AMOUNT, moviesList);
    }

    private static void displayMovieResponse(long countOfMovies, List<String> moviesList) {
        System.out.println("Total amount actor can make : " + countOfMovies * FIXED_AMOUNT);
        System.out.print("The final list of movies to select :" + " ");
        System.out.print("[");
        for (String movie : moviesList) {
            System.out.print(" " + movie + " ");
        }
        System.out.print("]");
    }

}

