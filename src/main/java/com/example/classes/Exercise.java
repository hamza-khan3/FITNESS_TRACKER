package com.example.classes;

import java.util.Scanner;
//Ravales commit
public class Exercise extends User {
    Scanner scanner = new Scanner(System.in);

    public Exercise(String name, int age, double weight, double pace, double height, int cardio, double duration) {
        super(name, age, weight, pace, height, cardio, duration);
    }

    /**
     * Function that calculates calories burned using a formula.
     * Judges the metabolic value based on pace of cardio.
     *
     * @param pace
     * @param duration
     * @param weight
     * @return
     */

    public static double caloriesBurned(double pace, double duration, double weight) {

        //Metabolicvalue is a fixed value, depending on the type of cardio.
        double metabolicValue = 0.0;
        double threshold = 6.0;
        if (pace < threshold) {
            metabolicValue = 2.75;
        } else if (pace >= threshold) {
            metabolicValue = 10;
        }
        double calories = duration * ((metabolicValue * 3.5 * weight) / 200);
        double formattedCalories = Math.round(calories * 100.0) / 100.0;
        return formattedCalories;
    }

    /**
     * Function that calculates distance covered while doing cardio.
     *
     * @param duration
     * @param pace
     * @return formattedDistance
     */
    public static double distance_Covered(double duration, double pace) {
        double newDurationInHours = duration / 60;
        double distanceCovered = pace * newDurationInHours;
        double formattedDistance = Math.round(distanceCovered * 100.0) / 100.0;
        return formattedDistance;
    }

    /**
     * Function that calculates BMI. Divides weight by height squared.
     *
     * @param weight
     * @param height
     * @return newBMI
     */
    public static double BMICalculator(double weight, double height) {
        double bmi = weight / (height * height);
        double newBMI = Math.round(bmi * 100.0) / 100.0;
        return newBMI;
    }

    /**
     * Calculates the time you would have to move at a certain pace to burn 200 calories.
     *
     * @param pace_to_burn
     * @param weight
     * @return time
     */
    public static double twohundredcalories(double pace_to_burn, double weight) {

        double time = 0.0;
        double calories = 0.0;
        if (pace_to_burn > 6.0) {
            double metabolicValue = 10.0;
            //Until 200 calories are not burned, this loop will continue. 
            while (calories <= 200.0) {
                calories = time * ((metabolicValue * 3.5 * weight) / 200);
                time++;
            }
        } else {
            double metabolicValue = 2.75;
            while (calories <= 200.0) {
                calories = time * ((metabolicValue * 3.5 * weight) / 200);
                time++;
            }
        }
        return time;
    }
}
