package com.example.tlnguyen_ridebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddRideFragment.OnFragmentInteractionListener, EditRideFragment.OnFragmentInteractionListener {
    //Variable declaration
    ListView rideListView;
    ArrayAdapter<Ride> rideAdapter;
    ArrayList<Ride> rideDataList;
    int tempPosition;
    float totalDistance;
    TextView totalDistanceView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //main screen is the ride list
        rideListView = findViewById(R.id.ride_list);
        rideDataList = new ArrayList<>();
        rideAdapter = new CustomList(this, rideDataList);
        rideListView.setAdapter(rideAdapter);
        totalDistanceView = findViewById(R.id.total_distance_textView);
        updateTotalDistance();

        //total distance

        //add button
        final FloatingActionButton addRideButton = findViewById(R.id.add_ride_button);
        addRideButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateTotalDistance();
                new AddRideFragment().show(getSupportFragmentManager(), "ADD_RIDE");


            }
        });

        //edit ride view
        rideListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ride selectedRide = (Ride) parent.getItemAtPosition(position);
                tempPosition = position;
                new EditRideFragment(selectedRide).show(getSupportFragmentManager(), "EDIT_RIDE");
                updateTotalDistance();

            }
        });
    }


    public void updateTotalDistance() {
        totalDistance = 0;
        for (int i = 0; i < rideDataList.size(); i++) {
            totalDistance += Float.parseFloat(rideDataList.get(i).getDistance());
        }

        totalDistanceView.setText("Total: " + totalDistance + " km");
    }

    // Add A Ride
    @Override
    public void onOkPressed(Ride newRide) {
        rideDataList.add(newRide);
        rideAdapter.notifyDataSetChanged();
        updateTotalDistance();

    }

    // Edit A Ride
    @Override
    public void onItemClicked(Ride newRide) {
		// Delete a ride
        if (newRide.getDate() == "*") {
            rideDataList.remove(tempPosition);
        } else {
            rideDataList.set(tempPosition, newRide);
        }

        rideAdapter.notifyDataSetChanged();
        updateTotalDistance();


    }
}
