package com.saigopl.movie_hub.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SimilarMovies {

    @SerializedName("results")
    @Expose
    ArrayList<SimilarMovieDetails> details = new ArrayList<>();


    public ArrayList<SimilarMovieDetails> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<SimilarMovieDetails> details) {
        this.details = details;
    }
}
