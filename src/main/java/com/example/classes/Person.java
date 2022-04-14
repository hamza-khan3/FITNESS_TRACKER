package com.example.classes;

/**
 * The Person class is an abstract class that will be inherited by the User class
 * all of the functions and variables will be initialized here.
 */

public abstract class Person {

    /**
     * Storage variables for information about the person.
     */
    String name;
    int age;
    double weight;
    double pace;
    double height;
    int cardio;
    double duration;


    /**
     * Making the constructor/default values for the information about the person
     */
    public Person(String name, int age, double weight, double pace, double height, int cardio, double duration){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.pace = pace;
        this.height = height;
        this.cardio = cardio;
        this.duration = duration;
    }

    public abstract String Name(String name);

    public abstract int Age(int age);

    public abstract double Weight(double weight);

    public abstract double Pace(double pace);

    public abstract double Height(double height);

    public abstract int Cardio(int cardio);

    public abstract double Duration(double duration);

}

