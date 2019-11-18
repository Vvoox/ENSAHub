package sample;


import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.verify.CheckResponse;
import com.nexmo.client.verify.VerifyClient;
import com.nexmo.client.verify.VerifyStatus;
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

import static java.lang.Thread.sleep;

public class VERIFY implements Initializable {


    static StringBuilder output = new StringBuilder();

    @FXML
    private javafx.scene.control.Label pin;
    @FXML
    private javafx.scene.control.TextField NUMBER;

    @FXML
    private javafx.scene.control.Label valide;
    @FXML
    private javafx.scene.control.Button Signup;
    @FXML
    private javafx.scene.control.Button closeButton;

    public void closelastButtonAction() {

        Stage stage = (Stage) closeButton.getScene().getWindow();

        stage.close();

    }
    public static void verify() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Home.class.getResource("Verification.fxml"));
        Image icon = new Image(Home.class.getResourceAsStream("Images/ensa1.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("ENSAHub");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.show();

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
        Image icon = new Image(Home.class.getResourceAsStream("Images/1.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("CRYPTOSIS");
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


    public boolean Verify() throws IOException, NexmoClientException, InterruptedException {
        String code = NUMBER.getText();
        boolean stat = false;
        NexmoClient client = new NexmoClient.Builder()
                .apiKey("a653fa93")
                .apiSecret("TYeGnseEOoWh1TFK")
                .build();
        VerifyClient verifyClient = client.getVerifyClient();
        String requestId = SIGNUP.RID;
        CheckResponse response = verifyClient.check(requestId, code);
        if (response.getStatus() == VerifyStatus.OK) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Correct PIN");
            alert.setHeaderText("Your Account is Verified , Welcome "+SIGNUP.name);
            alert.setContentText("Pres OK to continue");
            alert.showAndWait();
            closelastButtonAction();
            stat=true;
            pin.setVisible(false);
            NUMBER.setVisible(false);
            Signup.setVisible(false);
            closeButton.setVisible(false);
            valide.setVisible(true);
            sleep(20);
            Home.Connect();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("ERROR! %s: %s"+response.getStatus()+response.getErrorText());
            alert.setContentText("Pres OK to continue");
            alert.showAndWait();
            stat=false;
        }
        return stat;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        valide.setVisible(false);
    }
}
