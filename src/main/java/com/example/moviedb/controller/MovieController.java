package com.example.moviedb.controller;

import com.example.moviedb.model.Movie;
import com.example.moviedb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeMovie(@PathVariable Long id) {
        boolean deleted = movieService.removeMovie(id);
        return deleted ? ResponseEntity.ok("Movie deleted successfully") :
                ResponseEntity.badRequest().body("Movie not found");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        Movie movie = movieService.getMovie(id);
        return movie != null ? ResponseEntity.ok(movie) : ResponseEntity.notFound().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }

    @GetMapping("/director/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirector(@PathVariable String director) {
        return ResponseEntity.ok(movieService.getMoviesByDirector(director));
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Movie>> getMoviesByReleaseYear(@PathVariable int year) {
        return ResponseEntity.ok(movieService.getMoviesByReleaseYear(year));
    }

    @GetMapping("/top/{n}")
    public ResponseEntity<List<Movie>> getTopRatedMovies(@PathVariable int n) {
        return ResponseEntity.ok(movieService.getTopRatedMovies(n));
    }
}
