package UI.Controllers;



import UI.FXML.StartScreenUIMain;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StartScreenUIController extends StartScreenUIMain implements Initializable {
    @FXML
    public static Button signUp;
    @FXML
    public Button signIn;
    @FXML
    public Button help;
    @FXML
    public Button exit;
    @FXML
    public BorderPane rootPane;
    @FXML
    public ImageView imageTest;
    @FXML public  HBox hBox;
    @FXML public Label titleLabel;
    @FXML public  ImageView imageViewTest;
    public ArrayList<Image> imageList = new ArrayList<>();


    @FXML
    public void signUpEventHandler() throws IOException {
        /*
        This method is used to navigate to the Sign Up UI from the Start Screen UI when the UI.SignUp button is pressed
         */

        Parent rootPane = FXMLLoader.load(getClass().getResource("/UI/FXML/SignUpUI.fxml"));
        Scene test = new Scene(rootPane, 500, 500);
        Stage mainStage = StartScreenUIMain.getStage();
        mainStage.setScene(test);
    }

    @FXML
    public void signInEventHandler() throws IOException {
        /*
        This method is used to navigate to the Sign In Scene from the Start Screen UI
         */
        BorderPane rootPane = FXMLLoader.load(getClass().getResource("/UI/FXML/SignInUI.fxml"));
        Scene test = new Scene(rootPane, 500, 500);
        Stage mainStage = StartScreenUIMain.getStage();
        mainStage.setScene(test);
    }
    public static void test(){
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(5),signUp);
        translateTransition.setDuration(Duration.seconds(5));
        translateTransition.setToY(-200);
        translateTransition.play();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(10),titleLabel);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(2.0);
        fadeTransition.play();
        try {
            setImageSlide();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void setImageSlide() throws FileNotFoundException {
        File file = new File("C:\\Users\\ashch\\Documents\\Fall 2019 Classes\\CS 212 Java\\Java Problems\\Banking\\pictures");
        File[] files = file.listFiles();


    }

}
