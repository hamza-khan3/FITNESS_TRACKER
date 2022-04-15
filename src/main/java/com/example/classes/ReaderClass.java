/**
 * Names: Ravale Khan and Hamza Khan
 * Tutorial: Ravale Khan: T06 and Hamza Khan: T04
 * Date: Friday, April 15th, 2022
 */
package com.example.classes;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

/**
 * This is a simple Reader class which will scan an input file and extract
 * the information/attributes of a person into an array.
 */
public class ReaderClass {
    /**
     * A string array is initialized with length 7, the length will be 7 as our csv input file has
     * 7 different values separated by commas. While there is no empty line we will scan the whole line
     * as a string and then split it by ','.
     * Finally, we will return the data.
     * @param myData
     * @return
     * @throws FileNotFoundException
     */


    public static String[] loadData(File myData) throws FileNotFoundException {

        String [] data = new String[7];
        Scanner scanner = new Scanner(myData);
        while (scanner.hasNextLine()) {
            String lines = scanner.nextLine();
            data = lines.split(",");

        }
        return data;

    }

}
