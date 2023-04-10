package com.saigopl.movie_hub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.saigopl.movie_hub.databinding.OngoingMovieItemBinding;
import com.saigopl.movie_hub.models.OngoingMovieDetails;

import kotlinx.coroutines.CoroutineDispatcher;

public class OnGoingMoviesRecyclerAdapter extends PagingDataAdapter<OngoingMovieDetails, OnGoingMoviesRecyclerAdapter.ViewModel> {

    Context context;

    public OnGoingMoviesRecyclerAdapter(@NonNull DiffUtil.ItemCallback<OngoingMovieDetails> diffCallback, Context context) {
        super(diffCallback);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OngoingMovieItemBinding movieItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.ongoing_movie_item,parent,false);
        return new ViewModel(movieItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {
        holder.movieItemBinding.setModel(getItem(position));
    }

    public class ViewModel extends RecyclerView.ViewHolder {

        OngoingMovieItemBinding movieItemBinding;
        public ViewModel(@NonNull OngoingMovieItemBinding itemView) {
            super(itemView.getRoot());
            movieItemBinding = itemView;
        }
    }
}
