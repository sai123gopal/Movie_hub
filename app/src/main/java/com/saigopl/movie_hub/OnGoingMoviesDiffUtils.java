package com.saigopl.movie_hub;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.saigopl.movie_hub.models.OngoingMovieDetails;

public class OnGoingMoviesDiffUtils extends DiffUtil.ItemCallback<OngoingMovieDetails> {
    @Override
    public boolean areItemsTheSame(@NonNull OngoingMovieDetails oldItem, @NonNull OngoingMovieDetails newItem) {
        return String.valueOf(oldItem.getId()).equals(String.valueOf(newItem.getId()));
    }

    @Override
    public boolean areContentsTheSame(@NonNull OngoingMovieDetails oldItem, @NonNull OngoingMovieDetails newItem) {
        return String.valueOf(oldItem.getId()).equals(String.valueOf(newItem.getId()));
    }
}
