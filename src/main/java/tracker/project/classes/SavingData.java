/**
 * Names: Ravale Khan and Hamza Khan
 * Tutorial: Ravale Khan: T06 and Hamza Khan: T04
 * Date: Friday, April 15th, 2022
 */
package tracker.project.classes;

import tracker.project.app.MainController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class will make use of the exercise functions and save that data to
 * a file.
 */

public class SavingData {
    /**
     * Takes the output file and writes the information of the user to it.
     * @param output
     */
    public static void saveData(File output) {

        try {
            FileWriter myWriter = new FileWriter(output, true);
            Double calories = Exercise.caloriesBurned(MainController.user);
            Double BMI = Exercise.BMICalculator(MainController.user);
            Double distanceCovered = Exercise.distance_Covered(MainController.user);
            myWriter.write("Name:"+MainController.user.getName()+","+" Calories burned: "+calories+","+" BMI: "+BMI+","+" Distance covered in Kilometers: "+distanceCovered+"\n");
            myWriter.flush();
            myWriter.close();
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}