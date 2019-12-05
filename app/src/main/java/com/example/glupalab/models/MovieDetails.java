package com.example.glupalab.models;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@Entity(tableName = "movieDet")
public class MovieDetails {

    @SerializedName("Title")
    @Expose
    public String title;
    @SerializedName("Year")
    @Expose
    public String year;
    @SerializedName("Rated")
    @Expose
    public String rated;
    @SerializedName("Released")
    @Expose
    public String released;
    @SerializedName("Runtime")
    @Expose
    public String runtime;
    @SerializedName("Genre")
    @Expose
    public String genre;
    @SerializedName("Director")
    @Expose
    public String director;
    @SerializedName("Writer")
    @Expose
    public String writer;
    @SerializedName("Actors")
    @Expose
    public String actors;
    @SerializedName("Plot")
    @Expose
    public String plot;
    @SerializedName("Language")
    @Expose
    public String language;
    @SerializedName("Country")
    @Expose
    public String country;
    @SerializedName("Awards")
    @Expose
    public String awards;
    @SerializedName("Poster")
    @Expose
    public String poster;
    @SerializedName("Metascore")
    @Expose
    public String metascore;
    @SerializedName("imdbRating")
    @Expose
    @PrimaryKey
    @NotNull
    public String imdbRating;
    @SerializedName("imdbVotes")
    @Expose
    public String imdbVotes;
    @SerializedName("imdbID")
    @Expose
    public String imdbID;
    @SerializedName("Type")
    @Expose
    public String type;
    @SerializedName("DVD")
    @Expose
    public String dVD;
    @SerializedName("BoxOffice")
    @Expose
    public String boxOffice;
    @SerializedName("Production")
    @Expose
    public String production;
    @SerializedName("Website")
    @Expose
    public String website;
    @SerializedName("Response")
    @Expose
    public String response;
}


