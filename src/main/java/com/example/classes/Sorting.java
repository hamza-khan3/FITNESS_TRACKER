package com.example.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorting implements Comparable<Sorting> {
    String name;
    double calories;
    double BMI;
    double distance_covered;

    public Sorting(String name, double calories, double BMI, double distance_covered){
        this.name = name;
        this.calories = calories;
        this.BMI = BMI;
        this.distance_covered = distance_covered;
    }

    /**
     * Takes the output.txt file and sorts it from greatest to lowest amount of
     * calories burned.
     * @param args
     * @return entries
     */

    public ArrayList BR(String[] args){
        ArrayList<Sorting> entries = new ArrayList<>();
            File file = new File("output.txt");
            if (file.isFile() && file.canRead() && file.canWrite() && file.exists()){
                try{
                    FileReader file_reader = new FileReader(file);
                    BufferedReader buffered_reader = new BufferedReader(file_reader);
                    String line = buffered_reader.readLine();
                    while (line != null){
                        //Further breaking down the line to get the values for name,
                        //calories, BMI, and distance covered.
                        String[] entry = line.split(":", 4);

                        String[] name_val = entry[1].split(",");
                        this.name = name_val[0];

                        String[] calories_val = entry[2].split(",");
                        this.calories = Double.parseDouble(calories_val[0]);

                        String[] BMI_val = entry[3].split(",");
                        this.BMI = Double.parseDouble(BMI_val[0]);

                        String[] distance_traveled_val = BMI_val[1].split(":");
                        this.distance_covered = Double.parseDouble(distance_traveled_val[1]);

                        Sorting entry_value = new Sorting(name, calories, BMI, distance_covered);
                        entries.add(entry_value);
                        line = buffered_reader.readLine();
                    }

                    //Sorting the entries array, which is storing the objects of the users/people who ran the program.
                    Collections.sort(entries);

                    //Writing to the file
                    FileWriter file_writer = new FileWriter(file);
                    BufferedWriter buffered_writer = new BufferedWriter(file_writer);
                    for (int i = 0; i < entries.size(); i++){
                        buffered_writer.write(entries.get(i).toString());
                    }

                    buffered_writer.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        return entries;
    }

    /**
     * If a value for calories burned is greater than another
     * value for calories burned, then the smaller value will
     * come before the larger one.(Going from greatest to least)
     * @param other
     * @return result
     */
    @Override
    public int compareTo(Sorting other){
        int result = 0;
        if (this.calories < other.calories){
            result = 1;
            return result;
        }else if (other.calories < this.calories){
            result = -1;
            return result;
        }
        return result;
    }

    /**
     * Overriding a toString function to return the correct String/line that should be written to the file.
     * Prevents from unreadable data being stored in the output.txt file.
     * @return
     */
    public String toString(){
        return "Name:"+name+","+" Calories burned: "+calories+","+" BMI: "+BMI+","+" Distance covered in Kilometers: "+distance_covered+"\n";
    }
}
