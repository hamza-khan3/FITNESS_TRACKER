package com.example.cpscm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import com.example.classes.*;

public class HelloController {
    @FXML
    private TextField age;

    @FXML
    private TextField cardio;

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
    private TextField weight;

    Alert alert = new Alert(Alert.AlertType.NONE);

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

            User user = new User(name_value, age_value, weight_value, pace_value, height_value, cardio_value, duration_value);

        } catch (Exception e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Enter correct values for the user information!");
            alert.show();
        }
    }
}
