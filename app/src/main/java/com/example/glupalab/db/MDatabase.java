package com.example.glupalab.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.glupalab.models.Movie;

@Database(entities = {Movie.class},version = 1)
public abstract class MDatabase extends RoomDatabase {
    public abstract MovieDao getMovieDao();
}
