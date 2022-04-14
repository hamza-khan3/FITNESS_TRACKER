/**
 * Names: Ravale Khan and Hamza Khan
 * Tutorial: Ravale Khan: T06 and Hamza Khan: T04
 * Date: Friday, April 8th, 2022
 */
package com.example.classes;


/**
 * The exercise class extends the User class by inheriting the attributes of
 * the user/person of the program. The class is composed of functions that are mainly
 * used for calculations. These calculations aid us in displaying the "output special".
 */

public class Exercise extends User {

    public Exercise(String name, int age, double weight, double pace, double height, int cardio, double duration) {
        super(name, age, weight, pace, height, cardio, duration);
    }

    /**
     * Function that calculates calories burned using a formula.
     * Judges the metabolic value based on pace of cardio.
     *
     * @param user
     * @return
     */

    public static double caloriesBurned(User user) {

        //Metabolicvalue is a fixed value, depending on the type of cardio.
        double metabolicValue = 0.0;
        double threshold = 6.0;
        if (user.getPace() < threshold) {
            metabolicValue = 2.75;
        } else if (user.getPace() >= threshold) {
            metabolicValue = 10;
        }
        double calories = user.getDuration() * ((metabolicValue * 3.5 * user.getWeight()) / 200);
        double formattedCalories = Math.round(calories * 100.0) / 100.0;
        return formattedCalories;
    }

    /**
     * Function that calculates distance covered while doing cardio.
     *
     * @param user
     * @return formattedDistance
     */
    public static double distance_Covered(User user) {
        double newDurationInHours = user.getDuration() / 60;
        double distanceCovered = user.getPace() * newDurationInHours;
        double formattedDistance = Math.round(distanceCovered * 100.0) / 100.0;
        return formattedDistance;
    }

    /**
     * Function that calculates BMI. Divides weight by height squared.
     *
     * @param user
     * @return newBMI
     */
    public static double BMICalculator(User user) {
        double bmi = user.getWeight() / (user.getHeight() * user.getHeight());
        double newBMI = Math.round(bmi * 100.0) / 100.0;
        return newBMI;
    }

    /**
     * Calculates the time you would have to move at a certain pace to burn 200 calories.
     *
     * @param user
     * @return time
     */
    public static double twohundredcalories(User user) {

        double time = 0.0;
        double calories = 0.0;
        if (user.getPace() > 6.0) {
            double metabolicValue = 10.0;
            //Until 200 calories are not burned, this loop will continue. 
            while (calories <= 200.0) {
                calories = time * ((metabolicValue * 3.5 * user.getWeight()) / 200);
                time++;
            }
        } else {
            double metabolicValue = 2.75;
            while (calories <= 200.0) {
                calories = time * ((metabolicValue * 3.5 * user.getWeight()) / 200);
                time++;
            }
        }
        return time;
    }
}
