package com.example.glupalab;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.glupalab.client.ApiClient;
import com.example.glupalab.db.Repository;
import com.example.glupalab.models.MovieDetails;
import com.squareup.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieDetailsActivity extends AppCompatActivity {

    String movieId;
    Repository repository;
    Intent intent;
    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        intent = getIntent();
        repository = (Repository) intent.getSerializableExtra("repository");
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView2);
        movieId = intent.getStringExtra("movieId");
        loadData();
    }


    public void loadData() {
        Call<MovieDetails> call = ApiClient.getService().getMoviesDetails("e1cd9f9d", movieId);
        call.enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {
                System.out.println(response.body().imdbID);
                textView.setText("Title: " + response.body().title + " \n Year: " + response.body().year);
                Picasso.with(getApplicationContext()).load(response.body().poster).placeholder(android.R.drawable.sym_def_app_icon).error(android.R.drawable.sym_def_app_icon).into(imageView);
            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {

            }

        });
    }
}
