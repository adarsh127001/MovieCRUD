package com.example.moviedb.repository;

import com.example.moviedb.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenre(String genre);
    List<Movie> findByDirector(String director);
    List<Movie> findByReleaseYear(int releaseYear);
}
