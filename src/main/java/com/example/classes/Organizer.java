package com.example.classes;


import java.util.HashMap;
/**
 * The organizer class extends the User class by inheriting the attributes of
 * the user/person of the program. The class is composed of a function that stores the
 * users data in an organized hashmap.
 */
public class Organizer extends User{
    public Organizer(String name, int age, double weight, double pace, double height, int cardio, double duration){
        super(name, age, weight, pace, height, cardio, duration);
    }

    /**
     * Storing the values that the user gives us into a hashmap, so that
     * if the user wants to view these values, it can be displayed in an
     * organized manner.
     * @param user
     * @return data
     */

    public static HashMap<String, String> organizeData(User user){
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("Name", user.getName());
        data.put("Age", Integer.toString(user.getAge()));
        data.put("Weight", Double.toString(user.getWeight()));
        data.put("Pace", Double.toString(user.getPace()));
        data.put("Height", Double.toString(user.getHeight()));
        //Checking if the user chose jogging/running or walking
        final int running_or_jogging = 1;
        final int walking = 2;
        if (user.getCardio() == running_or_jogging){
            data.put("Cardio", "Running/Jogging");
        }else if (user.getCardio() == walking){
            data.put("Cardio", "Walking");
        }
        data.put("Duration", Double.toString(user.getDuration()));
        return data;
    }
}
