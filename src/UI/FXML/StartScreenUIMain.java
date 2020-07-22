package UI.FXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenUIMain extends Application {
    public static Stage mainStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        mainStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/UI/FXML/StartScreenUI.fxml"));
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }
    public static Stage getStage(){
        return mainStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}

