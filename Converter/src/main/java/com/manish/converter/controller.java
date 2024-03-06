package com.manish.converter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class controller implements Initializable
{
    @FXML

    public Label welcomeLabel;
    @FXML
    public ChoiceBox <String>choiceBox;
    @FXML
    public TextField userInputField;
    @FXML

    public Button convertButton;
    private static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
    private static final String F_TO_C_TEXT = "Fahrenheit to Celsius";

    private  boolean isC_TO_F = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
       // choiceBox.getItems().add("Celsius to Fahrenheit");
        //choiceBox.getItems().add("Fahrenheit to Celsius");
        //choiceBox.setValue("Celsius to Fahrenheit");
         choiceBox.getItems().add(C_TO_F_TEXT);
         choiceBox.getItems().add(F_TO_C_TEXT);

         choiceBox.setValue(C_TO_F_TEXT);
      choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
          @Override
          public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue)
          {
              System.out.println(newValue);
              if (newValue.equals(C_TO_F_TEXT)) { // If user has selected "Celsius to Fahrenheit"
                  isC_TO_F = true;
              } else {                // Else user has selected "Fahrenheit to Celsius"
                  isC_TO_F = false;
              }
          }

      });

        convertButton.setOnAction(actionEvent ->
        {
            convert();
        });

    }

    private void convert()
    {
        String input = userInputField.getText(); // 23.4   ==> "23.4"

        float enteredTemperature = 0.0f;
        try {
            enteredTemperature = Float.parseFloat(input);    // 23.4f
        } catch (Exception exception) {
            warnUser();
            return;
            // no code executed...
        }

        float newTemperature = 0.0f;
        if (isC_TO_F) {     // If user has selected "Celsius to Fahrenheit"
            newTemperature = (enteredTemperature * 9 / 5) + 32;
        } else {            // Else user has selected "Fahrenheit to Celsius"
            newTemperature = (enteredTemperature - 32) * 5 / 9;
        }

        display(newTemperature);
    }

    private void warnUser() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setHeaderText("Invalid Temperature Entered");
        alert.setContentText("Please enter a valid temperature");
        alert.show();
    }

    private void display(float newTemperature) {

        String unit = isC_TO_F? " F" : " C";

        System.out.println("The new temperature is: " + newTemperature + unit);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The new temperature is: " + newTemperature + unit);
        alert.show();
    }
}

