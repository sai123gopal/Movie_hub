package com.saigopl.movie_hub.models;

import android.icu.text.DecimalFormat;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieDetails {

    @SerializedName("adult")
    @Expose
    private boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    private String backdrop_path;

//    @SerializedName("belongs_to_collection")
//    @Expose
//    private String belongs_to_collection = null;

    @SerializedName("budget")
    @Expose
    private float budget;

    @SerializedName("genres")
    @Expose
    ArrayList<Genres> genres = new ArrayList<>();

    @SerializedName("homepage")
    @Expose
    private String homepage;

    @SerializedName("id")
    @Expose
    private float id;

    private String imdb_id;
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
    private String poster_path = null;
    ArrayList<Object> production_companies = new ArrayList<Object>();
    ArrayList<Object> production_countries = new ArrayList<Object>();

    @SerializedName("release_date")
    @Expose
    private String release_date;

    @SerializedName("revenue")
    @Expose
    private float revenue;

    @SerializedName("runtime")
    @Expose
    private float runtime;
    ArrayList<Object> spoken_languages = new ArrayList<Object>();

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tagline")
    @Expose
    private String tagline;

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

    private String  genresString = "";


    public boolean isAdult() {
        return adult;
    }

    public ArrayList<Genres> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genres> genres) {
        this.genres = genres;
    }

    public boolean isVideo() {
        return video;
    }

    public String getGenresString() {
        return genresString;
    }

    public void setGenresString(String genresString) {
        this.genresString = genresString;
    }

    public boolean getAdult() {
        return adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

//    public String getBelongs_to_collection() {
//        return belongs_to_collection;
//    }

    public float getBudget() {
        return budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public float getId() {
        return id;
    }

    public String getImdb_id() {
        return imdb_id;
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

    public float getRevenue() {
        return revenue;
    }

    public float getRuntime() {
        return runtime;
    }

    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public String getTitle() {
        return title;
    }

    public boolean getVideo() {
        return video;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public float getVote_average() {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return Float.parseFloat(decimalFormat.format(vote_average));
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

//    public void setBelongs_to_collection( String belongs_to_collection ) {
//        this.belongs_to_collection = belongs_to_collection;
//    }

    public void setBudget( float budget ) {
        this.budget = budget;
    }

    public void setHomepage( String homepage ) {
        this.homepage = homepage;
    }

    public void setId( float id ) {
        this.id = id;
    }

    public void setImdb_id( String imdb_id ) {
        this.imdb_id = imdb_id;
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

    public void setRevenue( float revenue ) {
        this.revenue = revenue;
    }

    public void setRuntime( float runtime ) {
        this.runtime = runtime;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public void setTagline( String tagline ) {
        this.tagline = tagline;
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

    public class Genres{

        @SerializedName("id")
        @Expose
        private Integer id;

        @SerializedName("name")
        @Expose
        private String name;
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }

}
