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
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

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

    private String name_value;
    private int age_value;
    private double weight_value;
    private double pace_value;
    private double height_value;
    private int cardio_value;
    private double duration_value;
    User user = new User(name_value, age_value, weight_value, pace_value, height_value, cardio_value, duration_value);

    @FXML
    private TextArea view;

    @FXML
    private TextField weight;

    Alert alert = new Alert(Alert.AlertType.NONE);
    HashMap<String, String> personsAttributes;

    //Do we need this??
    public HelloController() {
    }

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
            String personsAttributes = String.valueOf(Organizer.organizeData(user));
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
            FileChooser file_chooser = new FileChooser();
            File person_file = file_chooser.showOpenDialog(new Stage());

            if (person_file == null) {
                throw new Exception();
            }

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

        } catch (Exception e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("You have entered an invalid file!");
            alert.show();
        }
    }

    @FXML
    void editPerson(ActionEvent event) {
    }

    @FXML
    void loadSavedUsers(ActionEvent event) {
        try {
            FileChooser file_chooser = new FileChooser();
            File saved_users_file = file_chooser.showOpenDialog(new Stage());

            if (saved_users_file == null) {
                throw new Exception();
            }

            FileReader fr = new FileReader(saved_users_file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            if (String.valueOf(line.charAt(0)).equals("N")) {
                String past_users = "";
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
    void saveEdit(ActionEvent event) {
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
                writeToFile(file);
                Sorting comparing = new Sorting(user.getName(), Exercise.caloriesBurned(user), Exercise.BMICalculator(user), Exercise.distance_Covered(user));
                String[] args = new String[1];
                args[0] = String.valueOf(file);
                comparing.BR(args);
            }else {
                throw new Exception();
            }
        } catch (Exception e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("An error occurred.");
            alert.show();
        }

    }

    public void writeToFile(File file){
        try {
            FileWriter myWriter = new FileWriter(file, true);
            Double calories = Exercise.caloriesBurned(user);
            Double BMI = Exercise.BMICalculator(user);
            Double distanceCovered = Exercise.distance_Covered(user);
            myWriter.write("Name:"+user.getName()+","+" Calories burned: "+calories+","+" BMI: "+BMI+","+" Distance covered in Kilometers: "+distanceCovered+"\n");
            myWriter.flush();
            myWriter.close();
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText("Data saved successfully!");
            alert.show();
        } catch (IOException e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("An error occurred.");
            alert.show();
        }
    }
}
