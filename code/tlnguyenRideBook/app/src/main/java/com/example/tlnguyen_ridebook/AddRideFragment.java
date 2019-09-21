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


public class AddRideFragment extends DialogFragment {
/*---------------------------------------------
This class is for adding a ride
Will return a Dialog, MainActivity
will trigger onOkPressed and create a new ride
----------------------------------------------*/

    /*------------------------
    Variables declared here
     -------------------------*/

    private EditText rideDate;
    private EditText rideTime;
    private EditText rideDistance;
    private EditText rideSpeed;
    private EditText rideCadence;
    private EditText rideComment;
    private OnFragmentInteractionListener listener;

    // booleans for input validation
    private boolean boolDate;
    private boolean boolTime;
    private boolean boolDistance;
    private boolean boolSpeed;
    private boolean boolCadence;


    public interface OnFragmentInteractionListener {
        void onOkPressed(Ride newRide);
    }

    /*------------------------------------
    ALL INPUT CHECKING FUNCTION START HERE
     -------------------------------------*/

    // check date formatting of input. Return true/false

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

    // check if a string can be converted into a non negative float. Return true/false

    public boolean float_check(String s) {
        try {
            Float.parseFloat(s);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        if (Float.parseFloat(s)<0) {return false;}else{
        return true;}
    }

    // check if a string can be converted into a non negative int. Return true/false

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

        // set all the booleans for input validation to false

        boolDate = false;
        boolTime = false;
        boolDistance = false;
        boolCadence = false;
        boolSpeed = false;

        /*---------------------------------------------
        SHOW THE EDIT_TEXT VIEW FOR INPUTS:
        - Set Error for empty field when start up
        - Validate input for exact format
        - If pass, Error set to null, validation booleans
        set to true.
         ----------------------------------------------*/

        // Instantiate TextWatcher for every EditText, monitor user input

        rideDate = view.findViewById(R.id.ride_date_editText_fragment);
        rideDate.setError("Field can't be empty");
        rideDate.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (rideDate.getText().toString().isEmpty()) {
                    rideDate.setError("Field can't be empty");
                }
                else if (!date_check(rideDate.getText().toString())) {
                    rideDate.setError("Please enter a valid date");
                } else {
                    rideDate.setError(null);
                    boolDate = true;
                }


            }
        });

        rideTime = view.findViewById(R.id.ride_time_editText_fragment);
        rideTime.setError("Field can't be empty");
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
                }
                else if (!rideTime.getText().toString().matches("^(([0-1][0-9]|2[0-3])[:]([0-5][0-9]))$")) {
                    rideTime.setError("Please enter a valid time");
                } else {
                    rideTime.setError(null);
                    boolTime = true;
                }


            }
        });


        rideDistance = view.findViewById(R.id.ride_distance_editText_fragment);
        rideDistance.setError("Field can't be empty");
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
                }
                else if (!float_check(rideDistance.getText().toString())) {
                    rideDistance.setError("Please enter a valid distance");
                } else {
                    rideDistance.setError(null);
                    boolDistance = true;
                }


            }
        });


        rideSpeed = view.findViewById(R.id.ride_speed_editText_fragment);
        rideSpeed.setError("Field can't be empty");
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
                }
                else if (!float_check(rideSpeed.getText().toString())) {
                    rideSpeed.setError("Please enter a valid date");
                } else {
                    rideSpeed.setError(null);
                    boolSpeed = true;
                }


            }
        });

        rideCadence = view.findViewById(R.id.ride_cadence_editText_fragment);
        rideCadence.setError("Field can't be empty");
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
                }
                else if (!int_check(rideCadence.getText().toString())) {
                    rideCadence.setError("Please enter a valid date");
                } else {
                    rideCadence.setError(null);
                    boolCadence = true;
                }


            }
        });

        rideComment = view.findViewById(R.id.ride_comment_editText_fragment);

        /*---------------------------------
        Build Alert Dialog, return new Ride
        for the main activity
         ----------------------------------*/

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        return builder
                .setView(view)
                .setCustomTitle(LayoutInflater.from(getActivity()).inflate(R.layout.add_fragment_title,null))
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String date = rideDate.getText().toString();
                        String time = rideTime.getText().toString();
                        String distance = rideDistance.getText().toString();
                        String speed = rideSpeed.getText().toString();
                        String cadence = rideCadence.getText().toString();
                        String comment = rideComment.getText().toString();

                        // Return newRide for the listener. Else if any input validation failed, show an error for the user

                        if (boolDate == true && boolTime == true && boolDistance == true && boolSpeed == true && boolCadence == true) {
                            listener.onOkPressed(new Ride(date, time, distance, speed, cadence, comment));
                        } else {
                            Toast toast = Toast.makeText(getContext(), " (~__~) Oops, some of your inputs are wrong! Please try again!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0,0);
                            toast.show();
                        }
                    }
                }).create();
    }
}
