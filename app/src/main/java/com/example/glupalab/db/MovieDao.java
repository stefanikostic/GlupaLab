package com.example.glupalab.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.glupalab.models.Movie;

import java.util.List;

@Dao
public interface MovieDao {

    @Query("SELECT * from movie")
    @Deprecated
    public List<Movie> getAll();

    @Query("SELECT * from movie")
    public LiveData<List<Movie>> getAllAsync();

    @Query("SELECT * from movie WHERE custom_title LIKE :title")
    public List<Movie> findByTitle(String title); // title == "abc"

    @Query("SELECT * from movie WHERE imdbID = :id")
    public Movie findById(Long id);

    @Insert
    public void insert(Movie... tracks);

    @Query("DELETE from movie WHERE imdbID= :id")
    public void delete(Long id);

    @Query("DELETE from movie")
    public void deleteAll();

}
