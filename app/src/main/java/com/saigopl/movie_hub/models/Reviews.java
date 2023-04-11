package com.saigopl.movie_hub.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Reviews {

    @SerializedName("results")
    @Expose
    ArrayList<MoviesReviews> moviesReviews = new ArrayList<>();

    public ArrayList<MoviesReviews> getMoviesReviews() {
        return moviesReviews;
    }

    public void setMoviesReviews(ArrayList<MoviesReviews> moviesReviews) {
        this.moviesReviews = moviesReviews;
    }
}
