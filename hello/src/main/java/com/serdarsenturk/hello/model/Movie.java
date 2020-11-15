package com.serdarsenturk.hello.model;

public class Movie {

    private int movieId;
    private String movieName;
    public String comment;

    public Movie() {
    }

    public Movie(String movieName, String comment){
        this.movieName = movieName;
        this.comment = comment;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
