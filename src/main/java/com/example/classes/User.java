/**
 * Names: Ravale Khan and Hamza Khan
 * Tutorial: Ravale Khan: T06 and Hamza Khan: T04
 * Date: Friday, April 8th, 2022
 */
package com.example.classes;

/**
 * This class is essentially the core of the program and it extends the abstract
 * person class which contains getters and setters and helps with assigning text fields(GUI) to our
 * variables.
 */

public class User extends Person {
    private String name;
    private int age;
    private double weight;
    private double pace;
    private double height;
    private int cardio;
    private double duration;

    public User(String name, int age, double weight, double pace, double height, int cardio, double duration){
        super(name, age, weight, pace, height, cardio, duration);
    }

    //Making getter for name
    public String getName() {
        return this.name;
    }

    //Making getter for age
    public int getAge() {
        return this.age;
    }

    //Making getter for weight
    public double getWeight() {
        return this.weight;
    }

    //Making getter for pace
    public double getPace() {
        return this.pace;
    }

    //Making getter for height
    public double getHeight() {
        return this.height;
    }

    //Making getter for cardio
    public int getCardio() {
        return this.cardio;
    }

    //Making getter for duration
    public double getDuration() {
        return this.duration;
    }

    //Making setter for Name
    public String Name(String name) {
        this.name = name;
        return this.name;
    }

    /**
     * Function that sets the users age
     * @return age
     */
    @Override
    public int Age(int age) {
        this.age = age;
        return this.age;
    }

    /**
     * Function that sets the users weight
     * @return weight
     */
    @Override
    public double Weight(double weight) {
        this.weight = weight;
        return this.weight;
    }

    /**
     * Function that sets the users pace(speed at which the user will run/walk at)
     * @return pace
     */
    @Override
    public double Pace(double pace) {
        this.pace = pace;
        return this.pace;
    }

    /**
     * Function that sets the height of the user.
     * @return height
     */
    @Override
    public double Height(double height) {
        this.height = height;
        return this.height;
    }

    /**
     * Function that sets the type of cardio the user wants to do.
     * @return cardio
     */
    @Override
    public int Cardio(int cardio) {
        this.cardio = cardio;
        return this.cardio;
    }

    /**
     * Function that sets the workout time of the user(time the user will spend exercising).
     * @return duration
     */
    @Override
    public double Duration(double duration) {
        this.duration = duration;
        return this.duration;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", pace=" + pace +
                ", height=" + height +
                ", cardio=" + cardio +
                ", duration=" + duration +
                '}';
    }
}
