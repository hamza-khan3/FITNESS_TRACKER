package com.example.cpscm;
//aa
import com.example.classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.HashMap;

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
                    "\n" + "Steady State Pace:" + personsAttributes.get("Pace") + "\n" + "Height in Meters" + personsAttributes.get("Height") + "\n" + "Cardio Selection: " + personsAttributes.get("Cardio") + "\n" + "Duration of Exercise: " + personsAttributes.get("Duration"));

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
                view.setText(personsAttributes + "\n" + "BMI: " + bmivalue);
            } else if (caloriestoggle.isSelected()) {
                String caloriesvalue = String.valueOf(Exercise.caloriesBurned(user));
                view.setText(personsAttributes + "\n" + "Calories burned: " + caloriesvalue);
            } else if (timetoggle.isSelected()) {
                String timevalue = String.valueOf(Exercise.twohundredcalories(user));
                view.setText(personsAttributes + "\n" + "Time to burn 200 calories: " + timevalue + "minutes");
            } else if (distancetoggle.isSelected()) {
                String distancevalue = String.valueOf(Exercise.distance_Covered(user));
                view.setText(personsAttributes + "\n" + "Distance covered: " + distancevalue + "km");
            } else if (alltoggle.isSelected()) {
                String caloriesvalue = String.valueOf(Exercise.caloriesBurned(user));
                String timevalue = String.valueOf(Exercise.twohundredcalories(user));
                String distancevalue = String.valueOf(Exercise.distance_Covered(user));
                String bmivalue = String.valueOf(Exercise.BMICalculator(user));
                view.setText(personsAttributes + "\n" + "Calories burned: " + caloriesvalue + "\n" + "Distance to burn 200 calories: " + timevalue + "minutes" + "\n" + "Distance covered: " + distancevalue + "km" + "\n" + "BMI: " + bmivalue);
            }
        } catch (Exception e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("You have entered invalid information!");
            alert.show();
        }
    }
}
