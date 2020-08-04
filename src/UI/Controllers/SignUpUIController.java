package UI.Controllers;

import Classes.Customer;
import Classes.Verification;
import UI.FXML.StartScreenUIMain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

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
        Stage mainStage = StartScreenUIMain.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("/UI/FXML/StartScreenUI.fxml"));
        Scene newScene = new Scene(root, 500, 500);
        mainStage.setScene(newScene);
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
        String firstName = firstNameFieldInputVerification();
        String lastName = lastNameFieldInputVerification();
        int year = yearFieldInputVerification();
        int month = monthFieldInputVerification();
        int day = dayFieldInputVerification();
        String address = "";
        addressInputVerification();
        String email = emailFieldInputVerification();
        String phoneNumber = phoneNumberFieldInputVerification();
        Customer newCustomer = new Customer(firstName, lastName, year, month, day, address, email, phoneNumber);
        if (textFieldErrorCheck()){
            submitEventHandler();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input", ButtonType.OK);
                alert.setContentText("Invalid Input, please try again!");
                alert.showAndWait();

            }




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
//        if (addressField.getText().trim().isEmpty()){
//            value = false;
//            Stage currentStage = StartScreenUIMain.getStage();
//            Scene currentScene = currentStage.getScene();
//            currentScene.getStylesheets().add(getClass().getResource("/UI/Controllers/error.css").toString());
//            addressField.getStyleClass().add("error");
//            Label error = new Label();
//            error.setText("Error, this is a required field!");
//            error.setStyle("-fx-text-fill: red");
//            rootPane.add(error,4,6);
//        }
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
    @FXML public void submitEventHandler() throws IOException {
        Stage stage = StartScreenUIMain.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("/UI/FXML/CustomerBankUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }
    public String firstNameFieldInputVerification(){
        String firstName;
        firstName = Verification.verifyName(firstNameField.getText().trim());
        return firstName;

    }
    public String lastNameFieldInputVerification(){
        String lastName = Verification.verifyName(lastNameField.getText().trim());
        return lastName;
    }
    public int yearFieldInputVerification(){
        int year = Verification.verifyYear(Integer.parseInt(yearField.getText().trim()));
        return year;
    }
    public int monthFieldInputVerification(){
        int month = Verification.verifyMonth(Integer.parseInt(monthField.getText().trim()));
        return month;
    }
    public int dayFieldInputVerification(){
        int day = Verification.verifyDay(yearFieldInputVerification(),monthFieldInputVerification(), Integer.parseInt(dayField.getText().trim()));
        return day;
    }
    public int ageFieldInputVerification(){
        int age = Verification.returnAge(Verification.localDateCreater(yearFieldInputVerification(), monthFieldInputVerification(), dayFieldInputVerification()));
        int ageFieldInput = Integer.parseInt(ageField.getText().trim());
        if (age != ageFieldInput)
            return Integer.MIN_VALUE;
        else
            return age;
    }
    public String addressFieldInputVerification(){
        String address = Verification.verifyAddress();
        return address;
    }
    public String emailFieldInputVerification(){
        String email = Verification.verifyEmail(emailField.getText().trim());
        return email;
    }
    public String phoneNumberFieldInputVerification(){
        String phoneNumber = Verification.verifyNumber(phoneNumberField.getText().trim());
        return phoneNumber;
    }
    public String addressInputVerification(){
        Alert addressDialog = new Alert(Alert.AlertType.INFORMATION);
        addressDialog.setTitle("Address Input");
        addressDialog.setContentText("Please enter your street, city, state and zipcode");
        addressDialog.getDialogPane().getButtonTypes().addAll(ButtonType.FINISH, ButtonType.CANCEL);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10.0);
        gridPane.setVgap(10.0);
        Label street = new Label("Street Address: ");
        TextField streetTextField = new TextField();
        Label city = new Label("City: ");
        TextField cityTextField = new TextField();
        Label state = new Label("State: ");
        TextField stateTextField = new TextField();
        Label zipcode = new Label("ZipCode: ");
        TextField zipCodeTextField = new TextField();
        gridPane.add(street, 0, 0);
        gridPane.add(streetTextField, 1, 0);
        gridPane.add(city, 0, 1);
        gridPane.add(cityTextField, 1, 1);
        gridPane.add(state, 0, 2);
        gridPane.add(stateTextField, 1, 2);
        gridPane.add(zipcode, 0, 3);
        gridPane.add(zipCodeTextField,1, 3);
        addressDialog.getDialogPane().setContent(gridPane);
        Optional<ButtonType> result = addressDialog.showAndWait();
        StringBuilder address = new StringBuilder();

        if (result.get() == ButtonType.FINISH){
            address.append(streetTextField.getText() + ", ");
            address.append(cityTextField.getText() + ", ");
            address.append(stateTextField.getText() + ", ");
            address.append(zipCodeTextField.getText());
            System.out.println(address);




        }
        return address.toString();

    }

}
