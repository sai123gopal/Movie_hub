package com.saigopl.movie_hub.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Credits {

    @SerializedName("id")
    @Expose
    private int id ;

    @SerializedName("cast")
    @Expose
    private ArrayList<Cast> casts = new ArrayList<>();

    public ArrayList<Cast> getCasts() {
        return casts;
    }

    public void setCasts(ArrayList<Cast> casts) {
        this.casts = casts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
