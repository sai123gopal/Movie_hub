package com.saigopl.movie_hub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.saigopl.movie_hub.R;
import com.saigopl.movie_hub.databinding.MovieReviewsItemsBinding;
import com.saigopl.movie_hub.models.MoviesReviews;

import java.util.ArrayList;

public class MovieReviewsRecyclerAdapter extends RecyclerView.Adapter<MovieReviewsRecyclerAdapter.ViewHolder> {

    ArrayList<MoviesReviews> moviesReviewsArrayList;
    Context context;

    public MovieReviewsRecyclerAdapter(ArrayList<MoviesReviews> moviesReviewsArrayList, Context context) {
        this.moviesReviewsArrayList = moviesReviewsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieReviewsItemsBinding reviewsItemsBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.movie_reviews_items,parent,false);
        return new ViewHolder(reviewsItemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setModel(moviesReviewsArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return moviesReviewsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        MovieReviewsItemsBinding binding;
        public ViewHolder(@NonNull MovieReviewsItemsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
