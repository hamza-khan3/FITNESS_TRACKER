package com.example.cpscm;

import com.example.classes.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class HelloApplicationTest {

    static String testName;
    static int testAge;
    static double testWeight;
    static double testPace;
    static double testHeight;
    static int testCardio;
    static double testDuration;
    static User jack = new User(testName,testAge,testWeight,testPace,testHeight,testCardio,testDuration);
    /**
     * All the variables that were initialized earlier
     * will be assigned to certain attributes for testing.
     * These same test variables will then be used for our User object
     * and we will assign them to our "jack" object by using setters.
     * The test variables will be used for our expected/unexpected values
     * while our jack object will be inserted into functions that we test.
     */
    @BeforeAll
    static void setUp() {
        testName = "Jack";
        testAge = 25;
        testWeight = 90.5;
        testPace = 8.5;
        testHeight = 1.7;
        testCardio = 1;
        testDuration = 15.0;
        jack.Name(testName);
        jack.Age(testAge);
        jack.Weight(testWeight);
        jack.Pace(testPace);
        jack.Height(testHeight);
        jack.Cardio(testCardio);
        jack.Duration(testDuration);

    }
    /**
     * In this method we test the returned hashmap
     * we use assertNotEquals,therefore an incorrect value for weight is slipped in when
     * making our test hashmap. That test hashmap is our unexpected outcome which is why
     * assertNotEquals is used as it will be different to our organize data function.
     */
    @org.junit.jupiter.api.Test
    void organizeData1() {
        HashMap<String, String> set = new HashMap<String, String>();
        set.put("Name", testName);
        set.put("Age", Integer.toString(testAge));
        set.put("Weight", Double.toString(6.2));
        set.put("Pace", Double.toString(testPace));
        set.put("Height", Double.toString(testHeight));
        set.put("Cardio", "Running/Jogging");
        assertNotEquals(set, Organizer.organizeData(jack));
    }
    /**
     * We test the returned hashmap again but this time by using assertEquals which means
     * we will have to use the correct hashmap as our expected, therefore our test hashmap is equal
     * to the returned value from our organizeData function.
     * After creating the hashmap with the correct value we will test it with assertEquals.
     */
    @org.junit.jupiter.api.Test
    void organizeData2() {
        HashMap<String, String> set = new HashMap<String, String>();
        set.put("Name", testName);
        set.put("Age", Integer.toString(testAge));
        set.put("Weight", Double.toString(testWeight));
        set.put("Pace", Double.toString(testPace));
        set.put("Height", Double.toString(testHeight));
        set.put("Duration", Double.toString(testDuration));
        set.put("Cardio", "Running/Jogging");
        assertEquals(set,Organizer.organizeData(jack));
    }

    /**
     * In this method we test the returned calories burned by using
     * assertEquals which means we will have to use the correct test calories burned
     * as our expected, therefore our test calories are equal to our caloriesBurned function.
     */
    @org.junit.jupiter.api.Test
    void caloriesBurned1() {
        double metabolicValue = 10.0;
        double calories = testDuration * ((metabolicValue * 3.5 * testWeight / 200));
        double formattedCalories = Math.round(calories * 100.0) / 100.0;

        assertEquals(formattedCalories, Exercise.caloriesBurned(jack));
    }
    /**
     * In this method we test the returned calories burned by using
     * assertNotEquals, in this test, the correct value of calories burned is calculated
     * in our test calories variable. However we do not round it to two decimal places which makes
     * it an unexpected and incorrect outcome hence why we use assertNotEquals.
     */
    @org.junit.jupiter.api.Test
    void caloriesBurned2() {
        double metabolicValue = 10.0;
        double calories = testDuration * ((metabolicValue * 3.5 * testWeight / 200));


        assertNotEquals(calories, Exercise.caloriesBurned(jack));
    }
    /**
     * In this method we test the returned distance covered by using
     * assertNotEquals, in this test a random incorrect value is calculated as our test
     * distance variable which makes it an unexpected and incorrect outcome hence why we
     * use assertNotEquals.
     */
    @org.junit.jupiter.api.Test
    void distance_Covered1() {
        double distanceCovered = testPace / testDuration;
        assertNotEquals(distanceCovered,Exercise.distance_Covered(jack));

    }
    /**
     * In this method we test the returned distance covered by using
     * assertEquals which means we will have to calculate the correct test distance
     * as our expected, therefore our test distance variable is equal to our distanceCovered function
     * hence why we use assertEquals
     */
    @org.junit.jupiter.api.Test
    void distance_Covered2() {
        double newDurationInHours = testDuration / 60;
        double distanceCovered = testPace * newDurationInHours;
        double formattedDistance = Math.round(distanceCovered * 100.0) / 100.0;
        assertEquals(formattedDistance,Exercise.distance_Covered(jack));

    }
    /**
     * In this method we test the returned BMI by using
     * assertNotEquals. In this test, a random incorrect value is calculated as our test
     * BMI variable which makes it an unexpected and incorrect outcome hence why we use assertNotEquals.
     */
    @org.junit.jupiter.api.Test
    void BMICalculator1() {
        double BMI = testWeight/testHeight;
        assertNotEquals(BMI,Exercise.BMICalculator(jack));
    }
    /**
     * In this method we test the returned BMI by using
     * assertEquals which means we will have to calculate the correct test BMI
     * as our expected, therefore our test BMI variable is equal to our BMICalculator function
     * hence why we use assertEquals.
     */
    @org.junit.jupiter.api.Test
    void BMICalculator2() {
        double bmi = testWeight / (testHeight * testHeight);
        double newBMI = Math.round(bmi * 100.0) / 100.0;
        assertEquals(newBMI,Exercise.BMICalculator(jack));

    }
    /**
     * If we look at our twohundredcalories function in Exercise.java, we can see that the
     * metabolic value is determined by the pace, if it is more than 6.0, the metabolicValue
     * is 10.0, otherwise it is 2.75. In this test, we use assertEquals which means our expected
     * should be equal to our twohundredcalories(jack.getPace(),jack.getWeight()) function. Since we already know Jack's pace
     * is more than 6.0 we can set our metabolicValue to 10.0 to get the correct expected test variable
     * of time.
     *
     */

    @org.junit.jupiter.api.Test
    void twohundredcalories1() {
        double metabolicValue = 10.0;
        double time = 0.0;
        double calories = 0.0;
        while (calories <= 200.0){
            calories = time * ((metabolicValue * 3.5 * testWeight) / 200);
            time ++;}
        assertEquals(time,Exercise.twohundredcalories(jack));
    }
    @org.junit.jupiter.api.Test
    void twohundredcalories2() {
        /**
         *This time we test this method by using assertNotEquals, the metabolic value is supposed to be 10.0
         * as we stated in the last test. But this time we will use 2.75 as our metabolic value to get our
         * unexpected test variable of time. This means our test variable will not be equal to our twohundredcalories function.
         *
         */
        double metabolicValue = 2.75;
        double time = 0.0;
        double calories = 0.0;
        while (calories <= 200.0){
            calories = time * ((metabolicValue * 3.5 * testWeight) / 200);
            time ++;}
        assertNotEquals(time,Exercise.twohundredcalories(jack));

    }
    /**
     * In this test, our loadData function from our Reader class will be tested using
     * assertArrayEquals. We will look at the input file that will be read from by our function
     * and make a correct test array which we expect from our loadData function.
     * After the test array is made, we pass our file through our loadData function and both
     * arrays should be equal.
     */
    @org.junit.jupiter.api.Test
    void ReaderClass1() throws FileNotFoundException {
        File testFile = new File("Arthur Morgan.txt");
        String [] expectedArray = new String[7];
        Scanner scanner = new Scanner(testFile);
        while (scanner.hasNextLine()) {
            String lines = scanner.nextLine();
            expectedArray = lines.split(",");
        }
        assertArrayEquals(expectedArray, ReaderClass.loadData(testFile));
    }
    /**
     * In this test, our loadData function from our Reader class will be tested using
     * assertNotEquals. We will create a testarray with the correct values BUT
     * will put them in the wrong order. This array will be unexpected from our loadData function.
     * Hence, they will not be equal.
     * @throws FileNotFoundException
     */
    @org.junit.jupiter.api.Test
    void ReaderClass2() throws FileNotFoundException {
        File testFile = new File("Arthur Morgan.txt");
        String [] unexpectedArray = {"John","100","20","6.0","1.85","15","1"};
        assertNotEquals(Arrays.toString(unexpectedArray),Arrays.toString(ReaderClass.loadData(testFile)));
    }


}