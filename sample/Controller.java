package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private javafx.scene.control.Button closeButton;



    @FXML private javafx.scene.control.Button applyButton;
    @FXML private javafx.scene.control.Label home;
    @FXML private javafx.scene.control.Label explore;
    @FXML private javafx.scene.control.Label events;

    @FXML private ComboBox<String> methods;
    ObservableList<String> list1 = FXCollections.observableArrayList("testbox");

    public static void start() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Home.class.getResource("chooses.fxml"));
        Image icon = new Image(Home.class.getResourceAsStream("Images/1.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("ENSAHub");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.show();
    }
    public void Logout() throws IOException {
        closelastButtonAction();
        Home.Connect();
    }
    public void closeButtonAction() {

        Stage stage = (Stage) closeButton.getScene().getWindow();


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warnning");
        alert.setHeaderText("Looks you want to close the program !");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            stage.close();
        } else {
            alert.close();

        }

    }
    @FXML
    private void closelastButtonAction(){

        Stage stage = (Stage) closeButton.getScene().getWindow();

        stage.close();

    }
    public void APPLY() throws IOException {
        if (methods.getValue().equals("ENIGMA")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("The methods is not ready yet");
            alert.setHeaderText("SOON...");
            alert.setContentText("Pres OK to continue");
            alert.showAndWait();
            //start();

        } else {
            closelastButtonAction();

            if (methods.getValue().equals("")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Looks you don't any methods");
                alert.setContentText("Click Ok and choose a method ");

                alert.showAndWait();


            }
          /*  if (methods.getValue().equals("AFFINE CIPHER")) {
                start1();
            }*/

        }
    }
        public void about () throws IOException {
            closelastButtonAction();
            About.About();
        }


        @Override
        public void initialize (URL location, ResourceBundle resources){

            //language.setItems(list);
            //methods.setItems(list1);


        }



}

