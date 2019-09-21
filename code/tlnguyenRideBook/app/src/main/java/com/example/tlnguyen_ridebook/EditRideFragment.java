package com.example.tlnguyen_ridebook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class EditRideFragment extends DialogFragment {
/*---------------------------------------
This class is used to Edit/View/Delte
when the ride being selected in ListView
----------------------------------------*/


    /*------------------------
    Variables declared here
     -------------------------*/

    private EditText rideDate;
    private EditText rideTime;
    private EditText rideDistance;
    private EditText rideSpeed;
    private EditText rideCadence;
    private EditText rideComment;
    private Ride ride;
    private OnFragmentInteractionListener listener;

    // booleans for input validation


    private boolean boolDate;
    private boolean boolTime;
    private boolean boolDistance;
    private boolean boolSpeed;
    private boolean boolCadence;


    // Default construct pass in a ride for edit
    public EditRideFragment(Ride ride) {
        this.ride = ride;
    }

    public Ride getRide() {
        return ride;
    }

    public interface OnFragmentInteractionListener {
        void onItemClicked(Ride newRide);
    }

    /*------------------------------------
    ALL INPUT CHECKING FUNCTION START HERE
     -------------------------------------*/

    public boolean date_check(String s) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        formatDate.setLenient(false);
        try {
            formatDate.parse(s);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public boolean float_check(String s) {
        try {
            Float.parseFloat(s);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        if (Float.parseFloat(s)<0) {return false;}else{
            return true;}
    }

    public boolean int_check(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        if (Integer.parseInt(s)<0) {return false;};
        return true;
    }

    /*---------------------------
    INPUT CHECKING FUNCTIONS END
     ----------------------------*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentInteractionListener");

        }
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.ride_fragment_layout, null);

        boolDate = true;
        boolTime = true;
        boolDistance = true;
        boolCadence = true;
        boolSpeed = true;

        rideDate = view.findViewById(R.id.ride_date_editText_fragment);
        rideTime = view.findViewById(R.id.ride_time_editText_fragment);
        rideDistance = view.findViewById(R.id.ride_distance_editText_fragment);
        rideSpeed = view.findViewById(R.id.ride_speed_editText_fragment);
        rideCadence = view.findViewById(R.id.ride_cadence_editText_fragment);
        rideComment = view.findViewById(R.id.ride_comment_editText_fragment);


        rideDate.setText(ride.getDate());
        rideTime.setText(ride.getTime());
        rideDistance.setText(ride.getDistance());
        rideSpeed.setText(ride.getSpeed());
        rideCadence.setText(ride.getCadence());
        rideComment.setText(ride.getComment());

        /*---------------------------------------------
        SHOW THE EDIT_TEXT VIEW FOR INPUTS:
        - Set Error for empty field when start up
        - Validate input for exact format
        - If pass, Error set to null, validation booleans
        set to true.
         ----------------------------------------------*/

        // Instantiate TextWatcher for every EditText, monitor user input

        rideDate.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (rideDate.getEditableText().toString().isEmpty()) {
                    rideDate.setError("Field can't be empty");
                    boolDate = false;
                }
                else if (!date_check(rideDate.getEditableText().toString())) {
                    rideDate.setError("Please enter a valid date");
                    boolDate = false;

                } else {
                    rideDate.setError(null);
                    boolDate = true;
                }


            }
        });

        rideTime.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (rideTime.getText().toString().isEmpty()) {
                    rideTime.setError("Field can't be empty");
                    boolTime = false;
                }
                else if (!rideTime.getText().toString().matches("^(([0-1][0-9]|2[0-3])[:]([0-5][0-9]))$")) {
                    rideTime.setError("Please enter a valid time");
                    boolTime = false;
                } else {
                    rideTime.setError(null);
                    boolTime = true;
                }


            }
        });

        rideDistance.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (rideDistance.getText().toString().isEmpty()) {
                    rideDistance.setError("Field can't be empty");
                    boolDistance = false;
                }
                else if (!float_check(rideDistance.getText().toString())) {
                    rideDistance.setError("Please enter a valid distance");
                    boolDistance = false;
                } else {
                    rideDistance.setError(null);
                    boolDistance = true;
                }


            }
        });

        rideSpeed.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (rideSpeed.getText().toString().isEmpty()) {
                    rideSpeed.setError("Field can't be empty");
                    boolSpeed = false;
                }
                else if (!float_check(rideSpeed.getText().toString())) {
                    rideSpeed.setError("Please enter a valid date");
                    boolSpeed = false;
                } else {
                    rideSpeed.setError(null);
                    boolSpeed = true;
                }


            }
        });

        rideCadence.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (rideCadence.getText().toString().isEmpty()) {
                    rideCadence.setError("Field can't be empty");
                    boolCadence = false;
                }
                else if (!int_check(rideCadence.getText().toString())) {
                    rideCadence.setError("Please enter a valid date");
                    boolCadence = false;
                } else {
                    rideCadence.setError(null);
                    boolCadence = true;
                }


            }
        });


        // Alert dialog builder


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
                .setView(view)
                .setCustomTitle(LayoutInflater.from(getActivity()).inflate(R.layout.edit_fragment_title,null))

                // Delete button. If selected, instantiate a special type of Ride. The listener can detect this special ride as an alert,
                // hence deleting the current selected ride

                .setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onItemClicked(new Ride("*", "*", "*","*", "*", "*"));
                    }
                })
                .setNegativeButton("Cancel", null)

                // Pressing ok will create a newRide being edited replacing former selected ride

                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String date = rideDate.getText().toString();
                        String time = rideTime.getText().toString();
                        String distance = rideDistance.getText().toString();
                        String speed = rideSpeed.getText().toString();
                        String cadence = rideCadence.getText().toString();
                        String comment = rideComment.getText().toString();
                        if (boolDate == true && boolTime == true && boolDistance == true && boolSpeed == true && boolCadence == true) {
                            listener.onItemClicked(new Ride(date, time, distance, speed, cadence, comment));
                        } else {
                            Toast toast = Toast.makeText(getContext(), " (~__~) Oops, some of your inputs are wrong! Please try again!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0,0);
                            toast.show();
                        }
                    }
                }).create();
    }
}
