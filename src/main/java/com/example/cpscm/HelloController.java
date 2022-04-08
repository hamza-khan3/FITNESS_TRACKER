package com.example.cpscm;
//aa
import com.example.classes.*;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

import static javafx.application.Platform.exit;
import static javafx.scene.paint.Color.*;

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
    private static String name_value;
    private static int age_value;
    private static double weight_value;
    private static double pace_value;
    private static double height_value;
    private static int cardio_value;
    private static double duration_value;


    public static User user = new User(name_value, age_value, weight_value, pace_value, height_value, cardio_value, duration_value);


    Alert alert = new Alert(Alert.AlertType.NONE);
    HashMap<String, String> personsAttributes;


    @FXML
    void savePerson(ActionEvent event) {
        try {
            String name_value = name.getText();
            int age_value = Integer.parseInt(age.getText());
            double weight_value = Double.parseDouble(weight.getText());
            double pace_value = Double.parseDouble(pace.getText());
            double height_value = Double.parseDouble(height.getText());
            int cardio_value = Integer.parseInt(cardio.getText());
            double duration_value = Double.parseDouble(duration.getText());
            user.Name(name_value);
            user.Age(age_value);
            user.Weight(weight_value);
            user.Pace(pace_value);
            user.Height(height_value);
            user.Cardio(cardio_value);
            user.Duration(duration_value);
            personsAttributes = Organizer.organizeData(user);
            view.setText("Current User: " + "\n" + "Name: " + personsAttributes.get("Name") + "\n" + "Age in Years: " + personsAttributes.get("Age") + "\n" + "Weight in Kilograms: " + personsAttributes.get("Weight") +
                    "\n" + "Steady State Pace: " + personsAttributes.get("Pace") + "\n" + "Height in Meters: " + personsAttributes.get("Height") + "\n" + "Cardio Selection: " + personsAttributes.get("Cardio") + "\n" + "Duration of Exercise in minutes: " + personsAttributes.get("Duration"));

        } catch (Exception e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("You have entered invalid or incomplete information!");
            alert.show();
        }
    }

    public void displayData() {
        try {
            if (bmitoggle.isSelected()) {
                String bmivalue = String.valueOf(Exercise.BMICalculator(user));
                view.setText("User Name: " + this.personsAttributes.get("Name") + "\n" + "BMI: " + bmivalue);
            } else if (caloriestoggle.isSelected()) {
                String caloriesvalue = String.valueOf(Exercise.caloriesBurned(user));
                view.setText("User Name: " + this.personsAttributes.get("Name") + "\n" + "Calories burned: " + caloriesvalue);
            } else if (timetoggle.isSelected()) {
                String timevalue = String.valueOf(Exercise.twohundredcalories(user));
                view.setText("User Name: " + this.personsAttributes.get("Name") + "\n" + "Time to burn 200 calories: " + timevalue + "minutes");
            } else if (distancetoggle.isSelected()) {
                String distancevalue = String.valueOf(Exercise.distance_Covered(user));
                view.setText("User Name: " + this.personsAttributes.get("Name") + "\n" + "Distance covered: " + distancevalue + "km");
            } else if (alltoggle.isSelected()) {
                String caloriesvalue = String.valueOf(Exercise.caloriesBurned(user));
                String timevalue = String.valueOf(Exercise.twohundredcalories(user));
                String distancevalue = String.valueOf(Exercise.distance_Covered(user));
                String bmivalue = String.valueOf(Exercise.BMICalculator(user));
                view.setText("User Name: " + this.personsAttributes.get("Name") + "\n" + "Calories burned: " + caloriesvalue + "\n" + "Distance to burn 200 calories: " + timevalue + " minutes" + "\n" + "Distance covered: " + distancevalue + "km" + "\n" + "BMI: " + bmivalue);
            }
        } catch (Exception e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("You have entered invalid information!");
            alert.show();
        }
    }

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

    @FXML
    void loadPerson(ActionEvent event) {
        try {
            FileChooser.ExtensionFilter fileExtensions =
                    new FileChooser.ExtensionFilter(
                            "text file", "*.txt");


            FileChooser file_chooser = new FileChooser();
            file_chooser.getExtensionFilters().add(fileExtensions);
            File person_file = file_chooser.showOpenDialog(new Stage());

            if (person_file == null) {
                throw new Exception();
            }
            if (ReaderClass.loadData(person_file).length !=7){

                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("You have entered an invalid/incorrectly formatted file!");
                alert.show();

            }
            else if(ReaderClass.loadData(person_file).length == 7) {

                String[] data = ReaderClass.loadData(person_file);
                user.Name(data[0]);
                user.Age(Integer.valueOf(data[1]));
                user.Weight(Double.valueOf(data[2]));
                user.Pace(Double.valueOf(data[3]));
                user.Height(Double.valueOf(data[4]));
                user.Cardio(Integer.valueOf(data[5]));
                user.Duration(Double.valueOf(data[6]));

                personsAttributes = Organizer.organizeData(user);
                view.setText("Current User: " + "\n" + "Name: " + personsAttributes.get("Name") + "\n" + "Age in Years: " + personsAttributes.get("Age") + "\n" + "Weight in Kilograms: " + personsAttributes.get("Weight") +
                        "\n" + "Steady State Pace: " + personsAttributes.get("Pace") + "\n" + "Height in Meters: " + personsAttributes.get("Height") + "\n" + "Cardio Selection: " + personsAttributes.get("Cardio") + "\n" + "Duration of Exercise in minutes: " + personsAttributes.get("Duration"));
            }
        } catch (Exception e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("You have entered an invalid file!");
            alert.show();
        }
    }
    @FXML
    void loadSavedUsers(ActionEvent event) {
        try {
            FileChooser file_chooser = new FileChooser();
            File saved_users_file = file_chooser.showOpenDialog(new Stage());

            if (saved_users_file == null) {
                throw new Exception();
            }

            Sorting comparing = new Sorting(user.getName(), Exercise.caloriesBurned(user), Exercise.BMICalculator(user), Exercise.distance_Covered(user));
            comparing.BR(saved_users_file);
            String past_users = "";
            FileReader fr = new FileReader(saved_users_file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            if (String.valueOf(line.charAt(0)).equals("N")) {
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


        @FXML
        void saveAction(ActionEvent event) {
            try {
                FileChooser file_chooser = new FileChooser();
                file_chooser.setTitle("Save file");
                file_chooser.setInitialDirectory(new File("."));
                file_chooser.setInitialFileName("output.txt");
                File file = file_chooser.showSaveDialog(new Stage());
                if (file != null) {
                    //Need to fix sorting
                    SavingData.saveData(file);
                }else {
                    throw new Exception();
                }

                Sorting comparing = new Sorting(user.getName(), Exercise.caloriesBurned(user), Exercise.BMICalculator(user), Exercise.distance_Covered(user));
                comparing.BR(file);
            } catch (Exception e) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("An error occurred.");
                alert.show();
            }

        }





        @FXML
    void closeAction(ActionEvent event) {

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmation");
        confirmation.setContentText("Are you sure you want to exit this program?");
        ((Button) confirmation.getDialogPane().lookupButton(ButtonType.OK)).setText("Yes I'm sure!");
        ((Button) confirmation.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("No take me back!");
        confirmation.setHeaderText("Confirm Exit");
        Optional<ButtonType> choice = confirmation.showAndWait();
        if (choice.get() == ButtonType.OK) {
            System.exit(0);;

        }

    }
    public void saveUserInfo() {
        try {
            File file = fileChooser.showSaveDialog(new Stage());
            if (file != null) {//if statement to check if null as user may close file explorer window
                PrintWriter printWriter = new PrintWriter(file);
                if (user == null) {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Please add a person before trying to save!");
                    alert.show();
                } else if (user != null) {

                    printWriter.write(user.getName()+","+user.getAge()+","+user.getWeight()+","+user.getPace()+","+user.getHeight()+","+user.getCardio()+","+user.getDuration());
                    printWriter.close();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Success!");
                    alert.setContentText("File saved successfully!");
                }
            }
        } catch (FileNotFoundException e) {
        }
    }
}
