package com.example.glupalab.models;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import org.jetbrains.annotations.NotNull;


@Entity(tableName = "movie")
public class Movie {

    @PrimaryKey
    @NotNull
    public String imdbID;

    @ColumnInfo(name = "custom_title")
    public String Title;
    public String Year;
    public String Type;
    public String Poster;




}
