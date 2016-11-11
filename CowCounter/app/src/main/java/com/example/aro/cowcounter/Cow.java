package com.example.aro.cowcounter;

import android.text.Editable;

import java.util.Comparator;

/**
 * Created by aro on 04.11.16.
 */

public class Cow implements Comparable<Cow> {
    private int breed;
    private int cowID;

    public Cow(int breed, int cowID){
        this.breed = breed;
        this.cowID = cowID;
    }

    public int getBreed() {
        return breed;
    }

    public int getCowID() {
        return cowID;
    }

    @Override
    public String toString(){
        return "Cow [breed: " + breed + ", id: " + cowID + "]";
    }

    @Override
    public int compareTo(Cow t1) {
        int sizeComparison = Integer.compare(breed, t1.getBreed());

        if (sizeComparison == 0) {
            sizeComparison = Integer.compare(cowID, t1.getCowID());
        }
        return sizeComparison;
    }
}
