package com.example.glupalab.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.glupalab.R;
import com.example.glupalab.holders.CustomListViewHolder;
import com.example.glupalab.models.Movie;


import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends RecyclerView.Adapter {
    List<Movie> dataset;
    View.OnClickListener listener;

    public CustomListAdapter(View.OnClickListener listener) {
        this.dataset = new ArrayList<>();
        this.listener=listener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_element_layout, viewGroup, false);
        return new CustomListViewHolder(view,viewGroup.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((CustomListViewHolder)viewHolder).setText(dataset.get(i).Title,dataset.get(i).Year,dataset.get(i).Poster,listener);

    }
    public String getClickedItemId(CustomListViewHolder holder) {
        int adapterPosition = holder.getAdapterPosition();
        return dataset.get(adapterPosition).imdbID;
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void updateDataset(List<Movie> newDataset) {
        this.dataset = newDataset;
        notifyDataSetChanged();
    }
}
