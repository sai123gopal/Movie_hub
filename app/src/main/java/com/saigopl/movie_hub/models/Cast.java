package com.saigopl.movie_hub.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cast {
    @SerializedName("adult")
    @Expose
    private boolean adult;
    @SerializedName("id")
    @Expose
    private float id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profile_path")
    @Expose
    private String profile_path;
    @SerializedName("character")
    @Expose
    private String character;


    public boolean getAdult() {
        return adult;
    }

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public String getCharacter() {
        return character;
    }


    public void setAdult( boolean adult ) {
        this.adult = adult;
    }

    public void setId( float id ) {
        this.id = id;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setProfile_path( String profile_path ) {
        this.profile_path = profile_path;
    }

    public void setCharacter( String character ) {
        this.character = character;
    }

}
