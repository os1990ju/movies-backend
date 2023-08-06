package com.suothtroniks.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService moviesService;

    @GetMapping
    public ResponseEntity<List<Movie>> allMovies(){
        return new ResponseEntity<List<Movie>> ( moviesService.AllMovies(), HttpStatus.OK );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie( @PathVariable ObjectId id ){
        return new ResponseEntity<Optional<Movie>> (moviesService.singleMovie ( id ), HttpStatus.OK );
    }
    @GetMapping("/imdbId/{imdbId}")
    public ResponseEntity<Optional<Movie>> singleMovieByImdbId( @PathVariable String imdbId ){
        return new ResponseEntity<Optional<Movie>> (moviesService.singleMovieByImdbId ( imdbId ), HttpStatus.OK );
    }
}
