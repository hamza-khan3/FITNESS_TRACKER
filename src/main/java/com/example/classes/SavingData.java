package com.example.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class SavingData {
    /**
     * Takes the output file and writes the information of the user to it.
     * @param output
     */
    public static void saveData(File output) {

        try {
            FileWriter myWriter = new FileWriter(output, true);
            Double calories = Exercise.caloriesBurned(Main.user.getPace(),Main.user.getDuration(),Main.user.getWeight());
            Double BMI = Exercise.BMICalculator(Main.user.getWeight(),Main.user.getHeight());
            Double distanceCovered = Exercise.distance_Covered(Main.user.getDuration(),Main.user.getPace());
            myWriter.write("Name:"+Main.user.getName()+","+" Calories burned: "+calories+","+" BMI: "+BMI+","+" Distance covered in Kilometers: "+distanceCovered+"\n");
            myWriter.flush();
            myWriter.close();
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}