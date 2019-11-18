package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class About implements Initializable {

    @FXML
    private javafx.scene.control.TextArea INPUT;
    @FXML
    private javafx.scene.control.TextArea OUTPUT;
    @FXML
    private javafx.scene.control.TextField ENCRYPTKEY1;

    @FXML
    private javafx.scene.control.Button closeButton;
    @FXML
    private javafx.scene.control.Label backButton;
    @FXML
    private javafx.scene.control.Button chooseButton;
    String inpt = "";

    private void closelastButtonAction() {

        Stage stage = (Stage) closeButton.getScene().getWindow();

        stage.close();

    }


    public static void About() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Home.class.getResource("About.fxml"));
        Image icon = new Image(Home.class.getResourceAsStream("Images/ensa1.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("ENSAHub");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.show();
    }

    public void closeButtonAction() {

        Stage stage = (Stage) closeButton.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warnning");
        alert.setHeaderText("Look you want to close the program !");
        alert.setContentText("Are you ok with this?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            stage.close();
        } else {
            alert.close();

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void back() throws IOException {

        closelastButtonAction();

        Home.Connect();


    }

}
