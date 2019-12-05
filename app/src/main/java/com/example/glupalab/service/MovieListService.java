package com.example.glupalab.service;

import com.example.glupalab.models.MovieDetails;
import com.example.glupalab.models.MovieList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieListService {

    @GET("?type=movie")
    Call<MovieList> getMovies(
            @Query("apikey") String apiKey,
            @Query("s") String title
    );

    @GET("?type=movie&plot=short")
    Call<MovieDetails> getMoviesDetails(
            @Query("apikey") String apiKey,
            @Query("i") String id
    );


}
