package com.thenewboston.mieon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rahul on 05/11/15.
 */
public class ServicesAdapter extends ArrayAdapter<Services> {
    public ServicesAdapter(Context context, int resource, List<Services> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Services service = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.profile_services_listrow, parent, false);
        }
        // Lookup view for data population
        TextView serviceName = (TextView) convertView.findViewById(R.id.serviceName);
        TextView serviceCharge = (TextView) convertView.findViewById(R.id.serviceCharge);
        // Populate the data into the template view using the data object
        serviceName.setText(service.service);
        serviceCharge.setText(service.amount);
        // Return the completed view to render on screen
        return convertView;
    }
}
