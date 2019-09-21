package com.example.tlnguyen_ridebook;

import java.io.Serializable;

public class Ride implements Serializable {
	/*Ride class bundles with all its need attributes*/
	
    private String date;
    private String time;
    private String distance;
    private String speed;
    private String cadence;
    private String comment;

    public Ride(String date, String time, String distance, String speed, String cadence, String comment) {
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.speed = speed;
        this.cadence = cadence;
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getCadence() {
        return cadence;
    }

    public void setCadence(String cadence) {
        this.cadence = cadence;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}