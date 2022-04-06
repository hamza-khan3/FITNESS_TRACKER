package com.example.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Organizer extends User{
    public Organizer(String name, int age, double weight, double pace, double height, int cardio, double duration){
        super(name, age, weight, pace, height, cardio, duration);
    }

    /**
     * Storing the values that the user gives us into a hashmap, so that
     * if the user wants to view these values, it can be displayed in an
     * organized manner.
     * @param name
     * @param age
     * @param weight
     * @param pace
     * @param height
     * @param cardio
     * @param duration
     * @return data
     */

    public static HashMap<String, String> organizeData(String name, int age, double weight, double pace, double height, double cardio, double duration){
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("Name", name);
        data.put("Age", Integer.toString(age));
        data.put("Weight", Double.toString(weight));
        data.put("Pace", Double.toString(pace));
        data.put("Height", Double.toString(height));
        //Checking if the user chose jogging/running or walking
        final int running_or_jogging = 1;
        final int walking = 2;
        if (cardio == running_or_jogging){
            data.put("Cardio", "Running/Jogging");
        }else if (cardio == walking){
            data.put("Cardio", "Walking");
        }
        data.put("Duration", Double.toString(duration));
        return data;
    }
}
