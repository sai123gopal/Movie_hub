package com.saigopl.movie_hub.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimilarMovieDetails {
    @SerializedName("adult")
    @Expose
    private boolean adult;
    @SerializedName("id")
    @Expose
    private float id;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("release_date")
    @Expose
    private String release_date;
    @SerializedName("poster_path")
    @Expose
    private String poster_path;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("video")
    @Expose
    private boolean video;


    // Getter Methods

    public boolean getAdult() {
        return adult;
    }

    public float getId() {
        return id;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getTitle() {
        return title;
    }

    public boolean getVideo() {
        return video;
    }

    // Setter Methods

    public void setAdult( boolean adult ) {
        this.adult = adult;
    }

    public void setId( float id ) {
        this.id = id;
    }

    public void setOverview( String overview ) {
        this.overview = overview;
    }

    public void setRelease_date( String release_date ) {
        this.release_date = release_date;
    }

    public void setPoster_path( String poster_path ) {
        this.poster_path = poster_path;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public void setVideo( boolean video ) {
        this.video = video;
    }

}
