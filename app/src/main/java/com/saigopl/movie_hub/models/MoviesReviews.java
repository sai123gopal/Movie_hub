package com.saigopl.movie_hub.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoviesReviews {

    @SerializedName("author")
    @Expose
    private String author;

    @SerializedName("author_details")
    @Expose
    Author_details Author_detailsObject;
    @SerializedName("content")
    @Expose
    private String content;
    private String created_at;
    private String id;
    private String updated_at;
    private String url;


    // Getter Methods

    public String getAuthor() {
        return author;
    }

    public Author_details getAuthor_details() {
        return Author_detailsObject;
    }

    public String getContent() {
        return content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getId() {
        return id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getUrl() {
        return url;
    }

    // Setter Methods

    public void setAuthor( String author ) {
        this.author = author;
    }

    public void setAuthor_details( Author_details author_detailsObject ) {
        this.Author_detailsObject = author_detailsObject;
    }

    public void setContent( String content ) {
        this.content = content;
    }

    public void setCreated_at( String created_at ) {
        this.created_at = created_at;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public void setUpdated_at( String updated_at ) {
        this.updated_at = updated_at;
    }

    public void setUrl( String url ) {
        this.url = url;
    }


    public class Author_details {
        private String name;
        private String username;

        @SerializedName("avatar_path")
        @Expose
        private String avatar_path;
        private String rating = null;


        // Getter Methods

        public String getName() {
            return name;
        }

        public String getUsername() {
            return username;
        }

        public String getAvatar_path() {
            return avatar_path;
        }

        public String getRating() {
            return rating;
        }

        // Setter Methods

        public void setName(String name) {
            this.name = name;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setAvatar_path(String avatar_path) {
            this.avatar_path = avatar_path;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }
    }

}



