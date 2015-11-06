package com.thenewboston.mieon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rahul on 05/11/15.
 */
public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.PersonViewHolder>{

    List<Review> reviews;

    ReviewsAdapter(List<Review> reviews){
        this.reviews = reviews;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_reviews_listrow, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(reviews.get(i).reviewerName);
        personViewHolder.Date.setText(reviews.get(i).reviewedDate);
        personViewHolder.rbar.setRating(reviews.get(i).ratingBar);

    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv;
        TextView personName;
        TextView Date;
        RatingBar rbar;

        PersonViewHolder(View itemView) {
            super(itemView);
            rv = (RecyclerView)itemView.findViewById(R.id.recyclerView_reviewsListRow);
            personName = (TextView)itemView.findViewById(R.id.reviewerName);
            Date = (TextView)itemView.findViewById(R.id.reviewerDate);
            rbar = (RatingBar)itemView.findViewById(R.id.rating);
        }
    }

}
