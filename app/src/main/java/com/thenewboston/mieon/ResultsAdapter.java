package com.thenewboston.mieon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rahul on 05/11/15.
 */
public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ResultViewHolder> {
    List<ResultObject> results;

    public ResultsAdapter(List<ResultObject> results) {
        this.results = results;
    }

    @Override
    public ResultsAdapter.ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.results_listrow, parent, false);
        ResultsAdapter.ResultViewHolder pvh = new ResultsAdapter.ResultViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ResultsAdapter.ResultViewHolder resultViewHolder, int i) {
        ResultViewHolder.resultname.setText(results.get(i).name);
        ResultViewHolder.address.setText(results.get(i).address);
        ResultViewHolder.rating.setText(results.get(i).ratings);
        ResultViewHolder.storeavailable.setVisibility(results.get(i).storeavailable ? View.VISIBLE : View.INVISIBLE);
        ResultViewHolder.homeavailable.setVisibility(results.get(i).homeavaialable?View.VISIBLE:View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
    public static class ResultViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rv;
        static TextView resultname;
        static TextView address;
        static TextView rating;
        static  ImageView storeavailable;
        static ImageView homeavailable;

        ResultViewHolder(View itemView) {
            super(itemView);
            rv = (RecyclerView)itemView.findViewById(R.id.recyclerView_resultsListRow);
            resultname = (TextView)itemView.findViewById(R.id.ProfileName);
            address = (TextView)itemView.findViewById(R.id.address);
            rating = (TextView)itemView.findViewById(R.id.rating);
            storeavailable=(ImageView)itemView.findViewById(R.id.storeavailable);
            homeavailable=(ImageView)itemView.findViewById(R.id.homeavailable);
        }
    }
}
