package com.example.moviedb.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieRequestDto {

    @NotBlank(message = "Movie title is required")
    private String title;

    @NotBlank(message = "Genre is required")
    private String genre;

    @NotBlank(message = "Director is required")
    private String director;

    @Min(value = 1900, message = "Release year must be after 1900")
    private int releaseYear;

    @DecimalMin(value = "0.0", inclusive = true, message = "Rating must be at least 0.0")
    @DecimalMax(value = "10.0", inclusive = true, message = "Rating must be at most 10.0")
    private double rating;
}