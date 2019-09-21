package com.example.tlnguyen_ridebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<Ride> {
/*-----------------------------------------
CustomList contains Rides, publish it to a
custom ListView
------------------------------------------*/

    private ArrayList<Ride> rides;
    private Context context;

    public CustomList(Context context, ArrayList<Ride> rides) {
        super(context, 0, rides);
        this.rides = rides;
        this.context = context;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        Ride ride = rides.get(position);

        TextView rideDate = view.findViewById(R.id.ride_date);
        TextView rideTime = view.findViewById(R.id.ride_time);
        TextView rideDistance = view.findViewById(R.id.ride_distance);

        rideDate.setText(ride.getDate());
        rideTime.setText(ride.getTime()+" hr");
        rideDistance.setText(ride.getDistance()+" km");

        return view;
    }
}
