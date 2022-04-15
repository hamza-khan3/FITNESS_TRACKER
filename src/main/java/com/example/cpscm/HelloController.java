/**
 * Names: Ravale Khan and Hamza Khan
 * Tutorial: Ravale Khan: T06 and Hamza Khan: T04
 * Date: Friday, April 8th, 2022
 */
package com.example.cpscm;

import com.example.classes.*;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.util.HashMap;
import java.util.Optional;
import java.util.jar.Attributes;

/**
 * Controller class for GUI
 */

/**
 * This class is the controller class where all the GUI's functions and action commands will be processed.
 * Names: Ravale Khan and Hamza Khan
 * Tutorial: Ravale Khan: T06 and Hamza Khan: T04
 * Date: Friday, April 15th, 2022
 */

public class HelloController {

    @FXML
    private TextField age;

    @FXML
    private RadioButton alltoggle;

    @FXML
    private RadioButton bmitoggle;

    @FXML
    private RadioButton caloriestoggle;

    @FXML
    private TextField cardio;

    @FXML
    private RadioButton distancetoggle;

    @FXML
    private TextField duration;

    @FXML
    private ToggleGroup ex;

    @FXML
    private TextField height;

    @FXML
    private TextField name;

    @FXML
    private TextField pace;

    @FXML
    private RadioButton timetoggle;

    @FXML
    private TextArea pastusers;

    @FXML
    FileChooser fileChooser = new FileChooser();

    @FXML
    private TextArea view;

    @FXML
    private TextField weight;

    //Creating general user variables where the user's information will be stored.
    private static String name_value;
    private static int age_value;
    private static double weight_value;
    private static double pace_value;
    private static double height_value;
    private static int cardio_value;
    private static double duration_value;


    //Making user object
    public static User user = new User(name_value, age_value, weight_value, pace_value, height_value, cardio_value, duration_value);

    //Creating alert and a hashmap where the users attributes will be stored.
    Alert alert = new Alert(Alert.AlertType.NONE);
    HashMap<String, String> personsAttributes;

    /**
     * This function checks if the user has entered the correct values
     * @param age
     * @param weight
     * @param pace
     * @param height
     * @param cardio
     * @param duration
     * @return
     */
    public static boolean correctValues(int age, double weight, double pace, double height, int cardio, double duration){
        //Checking if the values entered are illogical(less than 0.)
        //Your age, weight, pace, height, cardio, and duration of cardio have to all be certain logical
        //values.
        if (age < 0){
            return false;
        }

        if (weight < 0.0){
            return false;
        }

        if (pace < 0.0){
            return false;
        }

        if (height < 0.0){
            return false;
        }

        if (cardio != 1 && cardio != 2){
            return false;
        }

        if (duration < 0.0){
            return false;
        }

        return true;
    }

    /**
     * Checking if the user has been entered or if the values are still null.
     * @return
     */
    public static boolean userExists(){
        if (user.getAge()  == 0 || user.getWeight() == 0 || user.getPace() == 0 || user.getHeight() == 0 || user.getDuration() == 0){
            return false;
        }else {
            return true;
        }
    }


    /**
     * Saving the User information and displaying it
     * in the view section of the GUI for the
     * user to see and confirm.
     * @param event
     */
    @FXML
    void savePerson(ActionEvent event) {
        //Try/catch used to check for invalid inputs.
        try {
            //Getting all the user's information from the textFields and storing them
            //in the correct area.
            String name_value = name.getText();
            int age_value = Integer.parseInt(age.getText());
            double weight_value = Double.parseDouble(weight.getText());
            double pace_value = Double.parseDouble(pace.getText());
            double height_value = Double.parseDouble(height.getText());
            int cardio_value = Integer.parseInt(cardio.getText());
            double duration_value = Double.parseDouble(duration.getText());

            //checking if the user entered correct values
            if (correctValues(age_value, weight_value, pace_value, height_value, cardio_value, duration_value) == false){
                throw new Exception();
            }

            //Using setters to set the user's information.
            user.Name(name_value);
            user.Age(age_value);
            user.Weight(weight_value);
            user.Pace(pace_value);
            user.Height(height_value);
            user.Cardio(cardio_value);
            user.Duration(duration_value);
            personsAttributes = Organizer.organizeData(user);
            //Formatting the view output to be outputted in a certain way, so it looks decent for the user.
            view.setText("Current User: " + "\n" + "Name: " + personsAttributes.get("Name") + "\n" + "Age in Years: " + personsAttributes.get("Age") + "\n" + "Weight in Kilograms: " + personsAttributes.get("Weight") +
                    "\n" + "Steady State Pace: " + personsAttributes.get("Pace") + "\n" + "Height in Meters: " + personsAttributes.get("Height") + "\n" + "Cardio Selection: " + personsAttributes.get("Cardio") + "\n" + "Duration of Exercise in minutes: " + personsAttributes.get("Duration"));

        } catch (Exception e) {
            //This error is if the user enters invalid data into any of the text fields.
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("You have entered invalid or incomplete information!");
            alert.show();
        }
    }

    /**
     * This function will display the data.
     */

    public void displayData() {
        //Try/catch used to catch any errors.
        try {
            //Checking if a user has been entered into the program first.
            //If the users information is not default, that means a user has been entered.
            if (user.getAge() == 0 || user.getName().equals("") || user.getWeight() == 0.0 || user.getPace() == 0.0 || user.getHeight() == 0.0 || user.getDuration() == 0.0){
                throw new RuntimeException();
            }

            //BMI displayed for the user.
            if (bmitoggle.isSelected()) {
                String bmivalue = String.valueOf(Exercise.BMICalculator(user));
                view.setText("User Name: " + this.personsAttributes.get("Name") + "\n" + "BMI: " + bmivalue);
              //Calories burned displayed for the user.
            } else if (caloriestoggle.isSelected()) {
                String caloriesvalue = String.valueOf(Exercise.caloriesBurned(user));
                view.setText("User Name: " + this.personsAttributes.get("Name") + "\n" + "Calories burned: " + caloriesvalue);
              //Time needed to burn 200 calories displayed for the user.
            } else if (timetoggle.isSelected()) {
                String timevalue = String.valueOf(Exercise.twohundredcalories(user));
                view.setText("User Name: " + this.personsAttributes.get("Name") + "\n" + "Time to burn 200 calories: " + timevalue + "minutes");
               //Distance traveled shown
            } else if (distancetoggle.isSelected()) {
                String distancevalue = String.valueOf(Exercise.distance_Covered(user));
                view.setText("User Name: " + this.personsAttributes.get("Name") + "\n" + "Distance covered: " + distancevalue + "km");
               //All values shown
            } else if (alltoggle.isSelected()) {
                String caloriesvalue = String.valueOf(Exercise.caloriesBurned(user));
                String timevalue = String.valueOf(Exercise.twohundredcalories(user));
                String distancevalue = String.valueOf(Exercise.distance_Covered(user));
                String bmivalue = String.valueOf(Exercise.BMICalculator(user));
                view.setText("User Name: " + this.personsAttributes.get("Name") + "\n" + "Calories burned: " + caloriesvalue + "\n" + "Time to burn 200 calories: " + timevalue + " minutes" + "\n" + "Distance covered: " + distancevalue + "km" + "\n" + "BMI: " + bmivalue);
            }
        } catch (RuntimeException g){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("You have not entered in a User yet!");
            alert.show();
        } catch (Exception e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("You have entered invalid information!");
            alert.show();
        }
    }

    /**
     * This function will display the "about" information
     * @param event
     */

    @FXML
    void aboutAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("About the Program");
        alert.setContentText("Names: Ravale Khan and Hamza Khan\nEmails: ravale.khan@ucalgary.ca and hamza.khan3@ucalgary.ca\n" +
                "This program is a fitness tracker very similar to the ones found in treadmills at gyms. This program will track a persons " +
                "basic information while they are exercising, such as how much distance the person covered during their workout, how many calories they burned, " +
                "what their BMI is, and it even gives a recommendation to the user for how much time they would have to do their workout to burn 200 calories. ");
        alert.show();
    }

    /**
     * This function will load a pre-existing
     * person into the world, therefore bypassing the section of
     * the GUI where the user has to enter the information manually.
     * @param event
     */

    @FXML
    void loadPerson(ActionEvent event) {
        try {

            //Creating a FileChooser which will allow the user to select a file from his computer.
            FileChooser.ExtensionFilter fileExtensions = new FileChooser.ExtensionFilter("text file", "*.txt");


            FileChooser file_chooser = new FileChooser();
            file_chooser.getExtensionFilters().add(fileExtensions);
            File person_file = file_chooser.showOpenDialog(new Stage());

            //Checking if the file is of the correct format.
            if (ReaderClass.loadData(person_file).length !=7){
                //Goes ito this if the file is of the wrong format.
                throw new RuntimeException();
            }
            else if(ReaderClass.loadData(person_file).length == 7) {


                //Storing the users information that we retrieved from the file loaded.
                String[] data = ReaderClass.loadData(person_file);

                //checking if the file has the correct values
                if (correctValues(Integer.valueOf(data[1]), Double.valueOf(data[2]), Double.valueOf(data[3]), Double.valueOf(data[4]), Integer.valueOf(data[5]), Double.valueOf(data[6])) == false){
                    throw new Exception();
                }

                user.Name(data[0]);
                user.Age(Integer.valueOf(data[1]));
                user.Weight(Double.valueOf(data[2]));
                user.Pace(Double.valueOf(data[3]));
                user.Height(Double.valueOf(data[4]));
                user.Cardio(Integer.valueOf(data[5]));
                user.Duration(Double.valueOf(data[6]));

                //Outputting the person's information in the view section of the GUI.
                personsAttributes = Organizer.organizeData(user);
                view.setText("Current User: " + "\n" + "Name: " + personsAttributes.get("Name") + "\n" + "Age in Years: " + personsAttributes.get("Age") + "\n" + "Weight in Kilograms: " + personsAttributes.get("Weight") +
                        "\n" + "Steady State Pace: " + personsAttributes.get("Pace") + "\n" + "Height in Meters: " + personsAttributes.get("Height") + "\n" + "Cardio Selection: " + personsAttributes.get("Cardio") + "\n" + "Duration of Exercise in minutes: " + personsAttributes.get("Duration"));
            }
        } catch (RuntimeException g){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("You have entered an invalid/incorrectly formatted file!");
            alert.show();
        } catch (Exception e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("You have entered an invalid file!");
            alert.show();
        }
    }
    @FXML
    void viewPerson(){
        try {
            view.setText("Current User: " + "\n" + "Name: " + personsAttributes.get("Name") + "\n" + "Age in Years: " + personsAttributes.get("Age") + "\n" + "Weight in Kilograms: " + personsAttributes.get("Weight") +
                    "\n" + "Steady State Pace: " + personsAttributes.get("Pace") + "\n" + "Height in Meters: " + personsAttributes.get("Height") + "\n" + "Cardio Selection: " + personsAttributes.get("Cardio") + "\n" + "Duration of Exercise in minutes: " + personsAttributes.get("Duration"));
        }
        catch(Exception e){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please add a person before trying to view!");
            alert.show();
        }
    }

    /**
     * This function loads all the past user's information.
     * @param event
     */
    @FXML
    void loadSavedUsers(ActionEvent event) {
        try {

            File saved_users_file = new File("output.txt");

            //Sorting all the users from greatest number of calories burned to the lowest.
            Sorting comparing = new Sorting(user.getName(), Exercise.caloriesBurned(user), Exercise.BMICalculator(user), Exercise.distance_Covered(user));
            comparing.BR(saved_users_file);

            //Creating a past users string which will be updated to output a table of users that will be displayed
            //in the view section of the GUI.
            String past_users = "";
            //Creating FileReader to read the past user's information from the text file.
            FileReader fr = new FileReader(saved_users_file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            //Making sure the document is of the correct format, checking if the first char value is "N"(Name).
            if (String.valueOf(line.charAt(0)).equals("N")) {
                //While the line is not null, the program will loop through the file.
                while (line != null) {
                    past_users = past_users + line + "\n";
                    line = br.readLine();
                }

                view.setText(past_users);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("You have entered an invalid file!");
            alert.show();
        }
    }

    /**
     * This function will save the users exercise information
     * @param event
     */
    @FXML
    void saveAction(ActionEvent event) {
        try {

            if (userExists() == false){
                throw new RuntimeException();
            }

            FileChooser file_chooser = new FileChooser();
            file_chooser.setTitle("Save file");
            file_chooser.setInitialDirectory(new File("."));
            file_chooser.setInitialFileName("output.txt");
            File file = file_chooser.showSaveDialog(new Stage());
            //If the file is not null
            if (file != null) {
                //Save the information of the user to the file.
                SavingData.saveData(file);
            }else {
                throw new Exception();
            }

            //Sorting the new file with the new user entry.
            Sorting comparing = new Sorting(user.getName(), Exercise.caloriesBurned(user), Exercise.BMICalculator(user), Exercise.distance_Covered(user));
            comparing.BR(file);
        } catch (RuntimeException f){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please add a person before saving!");
            alert.show();
        } catch (Exception e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("An error occurred.");
            alert.show();
        }

    }

    /**
     * Closes the window/program.
     * @param event
     */
    @FXML
    void closeAction(ActionEvent event) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmation");
        //Checks with the user if they are sure they want to quit the application.
        confirmation.setContentText("Are you sure you want to exit this program?");
        ((Button) confirmation.getDialogPane().lookupButton(ButtonType.OK)).setText("Yes I'm sure!");
        ((Button) confirmation.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("No take me back!");
        confirmation.setHeaderText("Confirm Exit");
        Optional<ButtonType> choice = confirmation.showAndWait();
        if (choice.get() == ButtonType.OK) {
            System.exit(0);
        }
    }

    /**
     * This function saves the users basic information, such as name, height, weigh, age etc.
     */
    public void saveUserInfo() {
        try {

            if (userExists() == false){
                throw new FileNotFoundException();
            }

            //Allows user to name and select a file to save to.
            fileChooser.setInitialFileName(user.getName() + ".txt");
            File file = fileChooser.showSaveDialog(new Stage());
            if (file != null) {//if statement to check if null as user may close file explorer window
                PrintWriter printWriter = new PrintWriter(file);
                //Checking if the user exists or not
                if (user == null) {
                    throw new FileNotFoundException();
                } else if (user != null) {
                    //Saving the user to their own text file.
                    printWriter.write(user.getName()+","+user.getAge()+","+user.getWeight()+","+user.getPace()+","+user.getHeight()+","+user.getCardio()+","+user.getDuration());
                    printWriter.close();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Success!");
                    alert.setContentText("File saved successfully!");
                }
            }
        } catch (FileNotFoundException e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please add a person before trying to save!");
            alert.show();
        }
    }
}
