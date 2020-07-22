package UI.Controllers;

import UI.FXML.StartScreenUIMain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInUIController {


   @FXML public Button back;
   @FXML  public Button signIn;
    public BorderPane rootPane;

    @FXML public void backToStartScreenUIEventHandler() throws IOException {
       Stage mainStage = StartScreenUIMain.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("/UI/FXML/StartScreenUI.fxml"));
        Scene newScene = new Scene(root, 500, 500);
        mainStage.setScene(newScene);


   }
}
