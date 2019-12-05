package com.example.glupalab.db;

import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.room.Room;
import com.example.glupalab.models.Movie;

import java.io.Serializable;
import java.util.List;

public class Repository implements Serializable {
    private static MDatabase database = null;
    public Repository(Context context)
    {
        if(database == null)
        {
            database = Room
                    .databaseBuilder(context,MDatabase.class,"db-app")
                    .build();
        }
    }

    public LiveData<List<Movie>> getAllMovies()
    {
        return database.getMovieDao().getAllAsync();
    }

    public void insert(final Movie movie)
    {
        new AsyncTask<Void,Void,Void>() {
            @Override
            protected Void doInBackground(Void...voids) {
                database.getMovieDao().insert(movie);
                return null;
            }
        }.execute();

    }
    public void deleteAll() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                database.getMovieDao().deleteAll();
                return null;
            }
        }.execute();

    }

}
