package UI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
        if (textFieldIsEmpty()){
            while (textFieldIsEmpty()){

            }
        }
    }
}
