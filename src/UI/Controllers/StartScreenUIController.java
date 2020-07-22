package UI.Controllers;



import UI.FXML.StartScreenUIMain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenUIController {
    @FXML public Button signUp;
    @FXML public Button signIn;
    @FXML public Button help;
    @FXML public Button exit;
    @FXML public BorderPane rootPane;

    @FXML public void signUpEventHandler() throws IOException {
        /*
        This method is used to navigate to the Sign Up UI from the Start Screen UI when the UI.SignUp button is pressed
         */

        Parent rootPane = FXMLLoader.load(getClass().getResource("/UI/FXML/SignUpUI.fxml"));
        Scene test = new Scene(rootPane, 500, 500);
        Stage mainStage = StartScreenUIMain.getStage();
        mainStage.setScene(test);
    }

    @FXML public void signInEventHandler() throws IOException{
        /*
        This method is used to navigate to the Sign In Scene from the Start Screen UI
         */
        BorderPane rootPane = FXMLLoader.load(getClass().getResource("/UI/FXML/SignInUI.fxml"));
        Scene test = new Scene(rootPane, 500, 500);
        Stage mainStage = StartScreenUIMain.getStage();
        mainStage.setScene(test);
    }
}
