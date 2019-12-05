package com.example.glupalab;

import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.glupalab.adapters.CustomListAdapter;
import com.example.glupalab.client.ApiClient;
import com.example.glupalab.db.Repository;
import com.example.glupalab.holders.CustomListViewHolder;
import com.example.glupalab.models.Movie;
import com.example.glupalab.models.MovieList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Repository repository;
    CustomListAdapter adapter;
    SearchView searchView;
    private static String API_KEY = "e1ab6c5d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        repository = new Repository(getApplicationContext());
    }

    public void initRecycler()
    {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomListAdapter(getItemViewOnClickListener());
        recyclerView.setAdapter(adapter);
    }

    private View.OnClickListener getItemViewOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomListViewHolder holder = (CustomListViewHolder) v.getTag();
                String selectedMovieId= adapter.getClickedItemId(holder);
                Intent intent = new Intent(getApplicationContext(), MovieDetailsActivity.class);
                intent.putExtra("movieId", selectedMovieId);
                intent.putExtra("repository", repository);
                startActivity(intent);
            }
        };
    }

    public void initToolbar()
    {
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_menu, menu);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(getOnQueryTextListener());
        return true;
    }

    private SearchView.OnQueryTextListener getOnQueryTextListener() {
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                initRecycler();
                repository.deleteAll();
                loadData(query);
                initData();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        };
    }
    public void initData()
    {
        repository.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> data) {
                adapter.updateDataset(data);
            }
        });
    }

    public void loadData(String query)
    {
        Call<MovieList> call = ApiClient.getService().getMovies(API_KEY, query);
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                for(Movie m:response.body().Search)
                {
                    repository.insert(m);
                }
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {

            }
        });
    }
}
