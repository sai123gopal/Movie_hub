package com.saigopl.movie_hub.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saigopl.movie_hub.models.SimilarMovieDetails;

import java.util.ArrayList;

public class SimilarMoviesRecyclerAdapter extends RecyclerView.Adapter<SimilarMoviesRecyclerAdapter.ViewHolder> {

    ArrayList<SimilarMovieDetails> list;
    Context context;

    public SimilarMoviesRecyclerAdapter(ArrayList<SimilarMovieDetails> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
