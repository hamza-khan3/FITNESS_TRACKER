package com.example.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String name = "person";
    static int age = 0;
    static double weight = 0.0;
    static double pace = 0.0;
    static double height = 0.0;
    static int cardio = 2;
    static double duration = 0.0;

    static User user = new User(name, age, weight, pace, height, cardio, duration);
    static Organizer organize = new Organizer(name, age, weight, pace, height, cardio, duration);
    static Exercise workout = new Exercise(name, age, weight, pace, height, cardio, duration);

    /**
     * Name: Ravale Khan and Hamza Khan
     * Date: Friday, March 4th 2022
     * Tutorial: Ravale Khan: T06, Hamza Khan:04
     */

    public static void addingPerson(int add_person) {

        /**
         * This while loop checks to make sure that if add_person is not 1, then the program
         * gives an error message and prompts the user to enter one to enter a person.
         */
        final int one = 1;
        while (add_person != one) {
            System.err.println("Please select 1 to add a person: ");
            add_person = scanner.nextInt();
        }
    }

    public static void outputGeneral(String name, int age, double weight, double pace, double height, int cardio, double duration) {
        String viewData = "";

        //Output general
        do {

            int[] correct_options2 = {1, 2, 3, 4, 5};

            System.out.println("View additional data about person by selecting the number: ");
            System.out.println("1. Calories burned: ");
            System.out.println("2. Distance covered: ");
            System.out.println("3. Calculate BMI: ");
            System.out.println("4. Recommended time to burn 200 calories at a given pace: ");
            System.out.println("5. Done viewing information");
            int selectOption2 = scanner.nextInt();
            boolean check2 = false;
            for (int element2 : correct_options2) {
                if (element2 == selectOption2) {
                    check2 = true;
                    break;

                }
            }
            while (check2 == false) {
                System.err.println("You have entered an invalid selection, please look at the options and try again.");
                selectOption2 = scanner.nextInt();
                for (int element : correct_options2) {
                    if (element == selectOption2) {
                        check2 = true;
                        break;

                    }
                }
            }
            //Shows calories burned while doing cardio
            if (selectOption2 == 1) {
                double calories = workout.caloriesBurned(pace, duration, weight);
                System.out.println(name + ", you burned " + calories + " calories doing cardio for " + duration + " minutes.");
            }
            //Shows distance covered during cardio
            if (selectOption2 == 2) {
                double distanceCovered = workout.distance_Covered(duration, pace);
                System.out.println(name + ", you have covered " + distanceCovered + " km in " + duration + " minutes.");
            }
            //Shows BMI
            if (selectOption2 == 3) {
                double bmi = workout.BMICalculator(weight, height);
                System.out.println(name + ", your BMI is: " + bmi);
            }
            //Shows what time you have to do cardio at a certain pace to burn how many calories.
            if (selectOption2 == 4) {
                double pace_to_burn = pace;
                double time_to_burn = workout.twohundredcalories(pace_to_burn, weight);
                System.out.println(name + ", at a pace of " + pace_to_burn + "km/h you would have to do your cardio for " + time_to_burn + " minutes to burn 200 calories. ");
            }
            //Quit option
            if (selectOption2 == 5) {
                break;
            }

            System.out.println("Please enter 'yes' if you would like to keep viewing data, otherwise enter 'no'.");
            viewData = scanner.next();

        }
        while (viewData.equals("yes"));
    }


    public static void inputGeneral(String name, int age, double weight, double pace, double height, int cardio, double duration) {
        String addData = "";

        //Input general
        //The do loop will print out the menu of options for the user to input.
        //Checks if the selected option is indeed correct.
        //Calls the functions responsible for getting the input the user wants to enter.


        do {
            int[] correct_options = {1, 2, 3, 4, 5, 6, 7};

            //Menu for entering inputs
            System.out.println("Add data about the person by selecting the number: ");
            System.out.println("1. Enter persons name: ");
            System.out.println("2. Enter persons age in years: ");
            System.out.println("3. Enter persons weight in kilograms: ");
            System.out.println("4. Enter persons pace in Kilometers: ");
            System.out.println("5. Enter persons height in meters: ");
            System.out.println("6. Enter persons duration of exercise in minutes: ");
            System.out.println("7. Done entering information");

            //checking if the options are correct
            int selectOption = scanner.nextInt();
            boolean check = false;
            for (int element : correct_options) {
                if (element == selectOption) {
                    check = true;
                    break;

                }
            }
            while (check == false) {
                System.err.println("You have entered an invalid selection, please look at the menu and try again");
                selectOption = scanner.nextInt();
                for (int element : correct_options) {
                    if (element == selectOption) {
                        check = true;
                        break;
                    }
                }
            }
            if (selectOption == 1) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("You have chosen to add the person's name, please enter this information now:");
                name = scanner.nextLine();
                user.Name(name);
            }
            if (selectOption == 2) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("You have chosen to add the person's age, please enter this information now:");
                age = scanner.nextInt();
                final int zero = 0;
                while (age < zero) {
                    System.err.println("Please enter a valid number: ");
                    age = scanner.nextInt();
                }
                user.Age(age);
            }
            if (selectOption == 3) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("You have chosen to add the person's weight, please enter this information now:");
                weight = scanner.nextDouble();
                user.Weight(weight);
            }
            if (selectOption == 4) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("You have chosen to add the person's pace, please enter this information now:");
                pace = scanner.nextDouble();
                user.Pace(pace);
                //We will have to call a function from the person class here.
                System.out.println("Select which form of cardio person wants to do: ");
                System.out.println("1. Running/Jogging");
                System.out.println("2. Walking");
                cardio = scanner.nextInt();
                user.Cardio(cardio);
            }
            if (selectOption == 5) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("You have chosen to add the person's height, please enter this information now:");
                height = scanner.nextDouble();
                user.Height(height);
            }
            if (selectOption == 6) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("You have chosen to add the person's duration of exercise, please enter this information now:");
                duration = scanner.nextInt();
                user.Duration(duration);
            }
            if (selectOption == 7) {
                break;
            }

            System.out.println("Please enter 'yes' if you would like to keep adding information, otherwise enter 'no'.");
            addData = scanner.next();

        }
        while (addData.equals("yes"));

        viewingGeneral(user.getName(), user.getAge(), user.getWeight(), user.getPace(), user.getHeight(), user.getCardio(), user.getDuration());
    }

    public static void viewingGeneral(String name, int age, double weight, double pace, double height, int cardio, double duration) {
        //Asking the user if they want to view the data they have just entered.
        //Uses Hashmaps to print the data stored depending on what the user enters.
        System.out.println("Do you want to view the data? Enter 'yes' if you do and 'no' if you do not: ");
        String view_stored_data = scanner.next();
        while (view_stored_data.equals("yes")) {
            System.out.println("Select which data entry you would like to view:");
            System.out.println("1. Name\n2. Age\n3. Weight\n4. Pace\n5. Height\n6. Duration\n7. Done viewing data");
            int view = scanner.nextInt();
            HashMap<String, String> data = organize.organizeData(name, age, weight, pace, height, cardio, duration);
            if (view == 1) {
                System.out.println("Name stored: " + data.get("Name"));
            }
            if (view == 2) {
                System.out.println("Age stored: " + data.get("Age"));
            }
            if (view == 3) {
                System.out.println("Weight stored: " + data.get("Weight"));
            }
            if (view == 4) {
                System.out.println("Pace stored: " + data.get("Pace") + "\nCardio stored: " + data.get("Cardio"));
            }
            if (view == 5) {
                System.out.println("Height stored: " + data.get("Height"));
            }
            if (view == 6) {
                System.out.println("Duration stored: " + data.get("Duration"));
            }
            if (view == 7) {
                break;
            }
            System.out.println("Please enter 'yes' if you would like to keep viewing information, otherwise 'no'.");
            view_stored_data = scanner.next();
        }

        editingGeneral(user.getName(), user.getAge(), user.getWeight(), user.getPace(), user.getHeight(), user.getCardio(), user.getDuration());
    }

    public static void editingGeneral(String name, int age, double weight, double pace, double height, int cardio, double duration) {
        //Asking the user if they want to edit the data.
        //Makes sure the options are correct, and updates the value
        //for the data entry the user wishes to edit.
        System.out.println("Do you want to edit the data? Enter 'yes' if you do and 'no' if you do not: ");
        String edit_stored_data = scanner.next();
        if (edit_stored_data.equals("yes")) {
            String editData = "";
            do {
                int[] correct_options = {1, 2, 3, 4, 5, 6, 7};

                System.out.println("Edit data about the person by selecting the number: ");
                System.out.println("1. Edit persons name: ");
                System.out.println("2. Edit persons age in years: ");
                System.out.println("3. Edit persons weight in kilograms: ");
                System.out.println("4. Edit persons pace in Kilometers: ");
                System.out.println("5. Edit persons height in meters: ");
                System.out.println("6. Edit persons duration of exercise in minutes: ");
                System.out.println("7. Done editing information");
                int selectOption = scanner.nextInt();
                boolean check = false;
                for (int element : correct_options) {
                    if (element == selectOption) {
                        check = true;
                        break;

                    }
                }
                while (check == false) {
                    System.err.println("You have entered an invalid selection, please look at the menu and try again");
                    selectOption = scanner.nextInt();
                    for (int element : correct_options) {
                        if (element == selectOption) {
                            check = true;
                            break;
                        }
                    }
                }
                if (selectOption == 1) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("You have chosen to add the person's name, please enter this information now:");
                    name = scanner.nextLine();
                    user.Name(name);
                }
                if (selectOption == 2) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("You have chosen to add the person's age, please enter this information now:");
                    age = scanner.nextInt();
                    final int zero = 0;
                    while (age < zero) {
                        System.err.println("Please enter a valid number: ");
                        age = scanner.nextInt();
                    }
                    user.Age(age);
                }
                if (selectOption == 3) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("You have chosen to add the person's weight, please enter this information now:");
                    weight = scanner.nextDouble();
                    user.Weight(weight);
                }
                if (selectOption == 4) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("You have chosen to add the person's pace, please enter this information now:");
                    pace = scanner.nextDouble();
                    user.Pace(pace);
                    //We will have to call a function from the person class here.
                    System.out.println("Select which form of cardio person wants to do: ");
                    System.out.println("1. Running/Jogging");
                    System.out.println("2. Walking");
                    cardio = scanner.nextInt();
                    user.Cardio(cardio);
                }
                if (selectOption == 5) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("You have chosen to add the person's height, please enter this information now:");
                    height = scanner.nextDouble();
                    user.Height(height);
                }
                if (selectOption == 6) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("You have chosen to add the person's duration of exercise, please enter this information now:");
                    duration = scanner.nextInt();
                    user.Duration(duration);
                }
                if (selectOption == 7) {
                    break;
                }
                System.out.println("Please enter 'yes' if you would like to keep editing information, otherwise enter 'no'.");
                editData = scanner.next();

            }
            while (editData.equals("yes"));
        }


        //Asking the user if they want to see the edited data.
        if (edit_stored_data.equals("yes")) {
            System.out.println("Do you want to view the edited data? Enter 'yes' if you do and 'no' if you do not: ");
            String view_edited_data = scanner.next();
            if (view_edited_data.equals("yes")) {
                System.out.println(organize.organizeData(user.Name(name), user.Age(age), user.Weight(weight), user.Pace(pace), user.Height(height), user.Cardio(cardio), user.Duration(duration)));
            }
        }

        outputGeneral(user.getName(), user.getAge(), user.getWeight(), user.getPace(), user.getHeight(), user.getCardio(), user.getDuration());
    }

    /**
     * Function that checks if any arguments have been added.
     * @param args
     * @return
     */

    private static boolean checkArgument(String[] args) {
        if (args.length == 1) {
            return true;
        } else {
            System.err.println("Invalid number of arguments for loading data!");
            System.exit(1);
        }
        return false;
    }

    /**
     * This function displays the output.txt files data to the user
     * in the format of a table. It shows how many calories previous users had burned, and where he/she stands in comparison
     * to them.
     * @param
     */

    public static void ShowingData(){
        System.out.println("Do you want to view the player logs? Enter 'yes' if you do and 'no' if you do not: ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("yes")){
            File file = new File("output.txt");
            if (file.isFile() && file.exists() && file.canRead()){
                try{
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String line = br.readLine();
                    while (line != null){
                        System.out.println(line);
                        line = br.readLine();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //Making the main class. Where the program starts from.
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Would you like to load data from a file?");
        Scanner loadData = new Scanner(System.in);
        if ((loadData.nextLine().equals("yes") && checkArgument(args) == true)) {
                //You can add the code here that will skip over the menu if the arguments are valid and entered from the terminal
                if (!(args[0].contains("data"))){
                    System.err.println("Cannot load file as the first argument is not a data file");
                    System.exit(1);
                }
                File myData = new File(args[0]);
                String[] data = ReaderClass.loadData(myData);
                user.Name(data[0]);
                user.Age(Integer.valueOf(data[1]));
                user.Weight(Double.valueOf(data[2]));
                user.Pace(Double.valueOf(data[3]));
                user.Height(Double.valueOf(data[4]));
                user.Cardio(Integer.valueOf(data[5]));
                user.Duration(Double.valueOf(data[6]));

                //This will be called at the end. Change the values of name, age, weight etc by assigning the correct args values to them.
                viewingGeneral(user.getName(), user.getAge(), user.getWeight(), user.getPace(), user.getHeight(), user.getCardio(), user.getDuration());
            }
        else {

            //Creating scanner object
            Scanner scanner = new Scanner(System.in);

            //Adding data. User is asked to press 1 to add a person
            //Once the user presses 1, the menu will drop down and other options
            //will be displayed for the user to add information/data about the user.
            //The input from the user will be stored in an int variable, add_person.

            System.out.println("Press 1 to add person");
            int add_person = scanner.nextInt();
            addingPerson(add_person);

            inputGeneral(user.getName(), user.getAge(), user.getWeight(), user.getPace(), user.getHeight(), user.getCardio(), user.getDuration());

        }

        System.out.println("Would you like to save data to file?");
        Scanner outputData = new Scanner(System.in);
        if (outputData.nextLine().equals("yes")) {
            File outputFile = new File("output.txt");
            if (checkArgument(args) == true) {
                SavingData.saveData(outputFile);
            }
        }

        Sorting comparing = new Sorting(user.getName(), workout.caloriesBurned(user.getPace(), workout.BMICalculator(user.getHeight(), user.getWeight()), user.getDuration()), user.getWeight(), workout.distance_Covered(user.getDuration(), user.getPace()));
        comparing.BR(args);

        ShowingData();
    }
}