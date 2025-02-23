package com.example.moviedb.controller;

import com.example.moviedb.dto.MovieRequestDto;
import com.example.moviedb.model.Movie;
import com.example.moviedb.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Movie> addMovie(@RequestBody @Valid MovieRequestDto movieDto) {
        Movie movie = convertToEntity(movieDto);
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> removeMovie(@PathVariable Long id) {
        boolean deleted = movieService.removeMovie(id);
        return deleted
                ? ResponseEntity.ok("Movie deleted successfully")
                : ResponseEntity.badRequest().body("Movie not found");
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

    // Helper method to convert MovieRequestDto to Movie entity
    private Movie convertToEntity(MovieRequestDto dto) {
        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setGenre(dto.getGenre());
        movie.setDirector(dto.getDirector());
        movie.setReleaseYear(dto.getReleaseYear());
        movie.setRating(dto.getRating());
        return movie;
    }
}