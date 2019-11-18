package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Forget_password {


    static String RID = "";
    static StringBuilder output = new StringBuilder();
    @FXML
    private javafx.scene.control.TextArea INPUT;
    @FXML
    private javafx.scene.control.TextField NUMBER;


    @FXML
    private javafx.scene.control.Button Signup;
    @FXML
    private javafx.scene.control.Button closeButton;

    private void closelastButtonAction() {

        Stage stage = (Stage) closeButton.getScene().getWindow();

        stage.close();

    }

    public void back() throws IOException {

        //Main.launch();
       /* Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog with Custom Actions");
        alert.setHeaderText("It Looks you want to get back , you want to save your Output ?");
        alert.setContentText("Choose your option.");

        ButtonType buttonTypeOne = new ButtonType("Save");
        ButtonType buttonTypeTwo = new ButtonType("Without Save");
        //ButtonType buttonTypeThree = new ButtonType("Three");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            alert.close();
        } else if (result.get() == buttonTypeTwo) {*/
        closelastButtonAction();
        Home.Connect();
        //}
        // ... user chose "Two"

       /* else {
            alert.close();

            //System.out.println("test");
        }*/
    }

    public void about() throws IOException {
        closelastButtonAction();
        About.About();
    }

    public static void forget_password() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Home.class.getResource("Forget_password.fxml"));
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

    public void connect() throws IOException {
        closelastButtonAction();
        Home.Connect();
    }


   /* public void SendEmail() throws IOException, NexmoClientException {

        String Number = NUMBER.getText();
        System.out.println(Number);
        NexmoClient client = new NexmoClient.Builder()
                .apiKey("a653fa93")
                .apiSecret("TYeGnseEOoWh1TFK")
                .build();
        VerifyClient verifyClient = client.getVerifyClient();

        VerifyRequest request = new VerifyRequest("212617611074", "");
        request.setLength(6);
        System.out.println(request);

        VerifyResponse response = verifyClient.verify(request);

        if (response.getStatus() == VerifyStatus.OK) {
            System.out.printf("RequestID: %s", response.getRequestId());
            RID=response.getRequestId();
            closelastButtonAction();
            VERIFY.verify();

        } else {
            System.out.printf("ERROR! %s: %s",
                    response.getStatus(),
                    response.getErrorText()
            );
        }
        }*/
    }








