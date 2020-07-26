package UI.Controllers;

import UI.FXML.StartScreenUIMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class SignUpUIController {
   @FXML public Button Back;
   @FXML public GridPane rootPane;
   @FXML public TextField firstNameField;
   @FXML public TextField lastNameField;
   @FXML public TextField yearField;
    @FXML public TextField monthField;
    @FXML public TextField dayField;
    @FXML public TextField ageField;
    @FXML public TextField addressField;
    @FXML public TextField emailField;
    @FXML public TextField phoneNumberField;
    @FXML public Button submit;

    @FXML
   public void backToStartScreenUI(ActionEvent actionEvent) throws IOException {
        Stage primary = new Stage();
       BorderPane root = FXMLLoader.load(getClass().getResource("/UI/FXML/StartScreenUI.fxml"));
       rootPane.getChildren().setAll(root);
    }
    @FXML public boolean textFieldIsEmpty(){
        if (firstNameField.getText().trim().isEmpty()
        || lastNameField.getText().trim().isEmpty()
        || yearField.getText().trim().isEmpty()
        || monthField.getText().trim().isEmpty()
        || dayField.getText().trim().isEmpty()
        || ageField.getText().trim().isEmpty()
        || addressField.getText().trim().isEmpty()
        || emailField.getText().trim().isEmpty()
        || phoneNumberField.getText().trim().isEmpty()){
            return true;
        }
        return false;
    }

    @FXML public void submitCustomerInfo() throws IOException{
        textFieldErrorCheck();

    }
    @FXML public boolean textFieldErrorCheck(){
        boolean value = true;
        if (firstNameField.getText().trim().isEmpty()){
            value = false;
            Stage currentStage = StartScreenUIMain.getStage();
            Scene currentScene = currentStage.getScene();
            currentScene.getStylesheets().add(getClass().getResource("/UI/Controllers/error.css").toString());
            firstNameField.getStyleClass().add("error");
            Label error = new Label();
            error.setText("Error, this is a required field!");
            error.setStyle("-fx-text-fill: red");
            rootPane.add(error,4,0);

        }
        if (lastNameField.getText().trim().isEmpty()){
            value = false;
            Stage currentStage = StartScreenUIMain.getStage();
            Scene currentScene = currentStage.getScene();
            currentScene.getStylesheets().add(getClass().getResource("/UI/Controllers/error.css").toString());
            lastNameField.getStyleClass().add("error");
            Label error = new Label();
            error.setText("Error, this is a required field!");
            error.setStyle("-fx-text-fill: red");
            rootPane.add(error,4,1);

        }
        if (yearField.getText().trim().isEmpty()){
            value = false;
            Stage currentStage = StartScreenUIMain.getStage();
            Scene currentScene = currentStage.getScene();
            currentScene.getStylesheets().add(getClass().getResource("/UI/Controllers/error.css").toString());
            yearField.getStyleClass().add("error");
            Label error = new Label();
            error.setText("Error, this is a required field!");
            error.setStyle("-fx-text-fill: red");
            rootPane.add(error,4,2);
        }
        if (monthField.getText().trim().isEmpty()){
            value = false;
            Stage currentStage = StartScreenUIMain.getStage();
            Scene currentScene = currentStage.getScene();
            currentScene.getStylesheets().add(getClass().getResource("/UI/Controllers/error.css").toString());
            monthField.getStyleClass().add("error");
            Label error = new Label();
            error.setText("Error, this is a required field!");
            error.setStyle("-fx-text-fill: red");
            rootPane.add(error,4,3);
        }
        if (dayField.getText().trim().isEmpty()){
            value = false;
            Stage currentStage = StartScreenUIMain.getStage();
            Scene currentScene = currentStage.getScene();
            currentScene.getStylesheets().add(getClass().getResource("/UI/Controllers/error.css").toString());
            dayField.getStyleClass().add("error");
            Label error = new Label();
            error.setText("Error, this is a required field!");
            error.setStyle("-fx-text-fill: red");
            rootPane.add(error,4,4);
        }
        if (ageField.getText().trim().isEmpty()){
            value = false;
            Stage currentStage = StartScreenUIMain.getStage();
            Scene currentScene = currentStage.getScene();
            currentScene.getStylesheets().add(getClass().getResource("/UI/Controllers/error.css").toString());
            ageField.getStyleClass().add("error");
            Label error = new Label();
            error.setText("Error, this is a required field!");
            error.setStyle("-fx-text-fill: red");
            rootPane.add(error,4,5);
        }
        if (addressField.getText().trim().isEmpty()){
            value = false;
            Stage currentStage = StartScreenUIMain.getStage();
            Scene currentScene = currentStage.getScene();
            currentScene.getStylesheets().add(getClass().getResource("/UI/Controllers/error.css").toString());
            addressField.getStyleClass().add("error");
            Label error = new Label();
            error.setText("Error, this is a required field!");
            error.setStyle("-fx-text-fill: red");
            rootPane.add(error,4,6);
        }
        if (emailField.getText().trim().isEmpty()){
            value = false;
            Stage currentStage = StartScreenUIMain.getStage();
            Scene currentScene = currentStage.getScene();
            currentScene.getStylesheets().add(getClass().getResource("/UI/Controllers/error.css").toString());
            emailField.getStyleClass().add("error");
            Label error = new Label();
            error.setText("Error, this is a required field!");
            error.setStyle("-fx-text-fill: red");
            rootPane.add(error,4,7);
        }
        if (phoneNumberField.getText().trim().isEmpty()){
            value = false;
            Stage currentStage = StartScreenUIMain.getStage();
            Scene currentScene = currentStage.getScene();
            currentScene.getStylesheets().add(getClass().getResource("/UI/Controllers/error.css").toString());
            phoneNumberField.getStyleClass().add("error");
            Label error = new Label();
            error.setText("Error, this is a required field!");
            error.setStyle("-fx-text-fill: red");
            rootPane.add(error,4,8);
        }






        return value;
    }
}
