package com.example.glupalab.holders;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.glupalab.R;
import com.squareup.picasso.Picasso;

public class CustomListViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView textView;
    private TextView textView2;
    Context context;

    public CustomListViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context=context;
        imageView = itemView.findViewById(R.id.imageItemView1);
        textView = itemView.findViewById(R.id.textView5);
        itemView.setTag(this);
    }

    public void setText(String text, String year, String image, View.OnClickListener listener) {
        textView.setText(text + " " + year);
        itemView.setOnClickListener(listener);
        Picasso.with(context)
                .load(image)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(imageView);

    }
}

