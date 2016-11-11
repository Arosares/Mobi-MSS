package com.example.aro.cowcounter;

import android.text.Editable;

/**
 * Created by aro on 04.11.16.
 */

public class Cow {
    private String breed;
    private String cowID;

    public Cow(String breed, String cowID){
        this.breed = breed;
        this.cowID = cowID;
    }

    public String getBreed() {
        return breed;
    }

    public String getCowID() {
        return cowID;
    }

    @Override
    public String toString(){
        return "Cow [breed: " + breed + ", id: " + cowID + "]";
    }
}
