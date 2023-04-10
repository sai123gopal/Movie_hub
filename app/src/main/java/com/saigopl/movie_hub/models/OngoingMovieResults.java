package com.saigopl.movie_hub.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OngoingMovieResults {

    @SerializedName("results")
    ArrayList<OngoingMovieDetails> details = new ArrayList<>();


    public ArrayList<OngoingMovieDetails> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<OngoingMovieDetails> details) {
        this.details = details;
    }
}
