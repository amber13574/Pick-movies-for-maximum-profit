package com.kommonicate.project.movies.Controller;

import Resource.MovieDetails;
import Resource.MovieResponse;
import com.kommonicate.project.movies.DAO.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    public MovieDAO movieDAO;

    @PostMapping("/movies")
    public @ResponseBody
    MovieResponse getMovieResponse(@RequestBody List<MovieDetails> movieDetails) {
        return movieDAO.getMoviesList(movieDetails);
    }
}

