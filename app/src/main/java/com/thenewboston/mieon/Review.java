package com.thenewboston.mieon;

/**
 * Created by rahul on 05/11/15.
 */

class Review
{
    String reviewerName;
    String reviewedDate;
    float ratingBar;
    String reviewText;
    Review(String name, String date, float rating,String review)
    {
        this.reviewerName=name;
        this.reviewedDate=date;
        this.ratingBar=rating;
        this.reviewText=review;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public float getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(float ratingBar) {
        this.ratingBar = ratingBar;
    }

    public String getReviewedDate() {
        return reviewedDate;
    }

    public void setReviewedDate(String reviewedDate) {
        this.reviewedDate = reviewedDate;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }
}

