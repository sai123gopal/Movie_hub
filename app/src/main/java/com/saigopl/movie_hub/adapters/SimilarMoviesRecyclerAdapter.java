package com.saigopl.movie_hub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.saigopl.movie_hub.R;
import com.saigopl.movie_hub.databinding.SimilarMoviesItemsBinding;
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
        SimilarMoviesItemsBinding similarMoviesItemsBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.similar_movies_items,parent,false);
        return new ViewHolder(similarMoviesItemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setModel(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        SimilarMoviesItemsBinding binding;
        public ViewHolder(@NonNull SimilarMoviesItemsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

            binding.setClick(new OnGoingMoviesRecyclerAdapter.Click());

        }
    }




}
