package com.saigopl.movie_hub.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OngoingMovieDetails {

    @SerializedName("adult")
    @Expose
    private boolean adult;

    @SerializedName("backdrop_path")
    @Expose
    private String backdrop_path;

    @SerializedName("id")
    @Expose
    private float id;

    @SerializedName("original_language")
    @Expose
    private String original_language;

    @SerializedName("original_title")
    @Expose
    private String original_title;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("popularity")
    @Expose
    private float popularity;

    @SerializedName("poster_path")
    @Expose
    private String poster_path;

    @SerializedName("release_date")
    @Expose
    private String release_date;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("video")
    @Expose
    private boolean video;

    @SerializedName("vote_average")
    @Expose
    private float vote_average;

    @SerializedName("vote_count")
    @Expose
    private float vote_count;

    public boolean getAdult() {
        return adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public float getId() {
        return id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getTitle() {
        return title;
    }

    public boolean getVideo() {
        return video;
    }

    public float getVote_average() {
        return vote_average;
    }

    public float getVote_count() {
        return vote_count;
    }

    // Setter Methods

    public void setAdult( boolean adult ) {
        this.adult = adult;
    }

    public void setBackdrop_path( String backdrop_path ) {
        this.backdrop_path = backdrop_path;
    }

    public void setId( float id ) {
        this.id = id;
    }

    public void setOriginal_language( String original_language ) {
        this.original_language = original_language;
    }

    public void setOriginal_title( String original_title ) {
        this.original_title = original_title;
    }

    public void setOverview( String overview ) {
        this.overview = overview;
    }

    public void setPopularity( float popularity ) {
        this.popularity = popularity;
    }

    public void setPoster_path( String poster_path ) {
        this.poster_path = poster_path;
    }

    public void setRelease_date( String release_date ) {
        this.release_date = release_date;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public void setVideo( boolean video ) {
        this.video = video;
    }

    public void setVote_average( float vote_average ) {
        this.vote_average = vote_average;
    }

    public void setVote_count( float vote_count ) {
        this.vote_count = vote_count;
    }


}
