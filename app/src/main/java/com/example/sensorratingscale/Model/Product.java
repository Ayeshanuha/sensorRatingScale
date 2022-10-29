package com.example.sensorratingscale.Model;


public class Product {
    private float rating;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public float getSumRating() {
        return sumRating;
    }

    public void setSumRating(float sumRating) {
        this.sumRating = sumRating;
    }

    private int ratingCount;
    private float sumRating;
}


