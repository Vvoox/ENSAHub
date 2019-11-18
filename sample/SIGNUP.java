package sample;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.verify.VerifyClient;
import com.nexmo.client.verify.VerifyRequest;
import com.nexmo.client.verify.VerifyResponse;
import com.nexmo.client.verify.VerifyStatus;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.Optional;

public class SIGNUP {

    static StringBuilder output=new StringBuilder();

    public static DriverManager MySQLConnection;
    @FXML
    private javafx.scene.control.TextArea INPUT;
    @FXML
    private javafx.scene.control.TextArea OUTPUT;

    @FXML
    private javafx.scene.control.TextField Name;
    @FXML
    private javafx.scene.control.TextField Last_name;
    @FXML
    private javafx.scene.control.TextField Number;
    @FXML
    private javafx.scene.control.TextField Password;
    @FXML
    private javafx.scene.control.TextField R_Password;
    @FXML
    private javafx.scene.control.TextField Email;
    @FXML private javafx.scene.control.Button Signup;
    @FXML private javafx.scene.control.Button closeButton;
    static String name="";
    static String RID = "";
    private void closelastButtonAction(){ //hadi pour button cancel

        Stage stage = (Stage) closeButton.getScene().getWindow();

        stage.close();

    }
    public void back() throws IOException {

            closelastButtonAction();
            Home.Connect();

    }
    public void about() throws IOException {
        closelastButtonAction();
        About.About();
    }
    public static void Sp() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Home.class.getResource("Sign_up.fxml"));
        Image icon = new Image(Main.class.getResourceAsStream("Images/ensa1.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("ENSAHub");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.show();
    }
    public void closeButtonAction()
    {

        Stage stage = (Stage) closeButton.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warnning");
        alert.setHeaderText("Look you want to close the program !");
        alert.setContentText("Are you ok with this?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            stage.close();
        } else {
            alert.close();

        }

    }
    public void svdata() throws IOException {
        closelastButtonAction();
        Home.Connect();
    }
    public void connect() throws IOException {
        closelastButtonAction();
        Home.Connect();
    }
    public void signupclicked() throws ClassNotFoundException, IOException, NexmoClientException {

        name= Name.getText();
        String last_name = Last_name.getText();
        String email = Email.getText();
        String number = Number.getText();
        String password = Password.getText();
        if(DBConnection.issignup(name,last_name,email,number,password)){

            SendPin(number);
            closelastButtonAction();
            Home.saveddata();
            }
        }
    public String SendPin(String Number) throws IOException, NexmoClientException {

        System.out.println(Number);
        NexmoClient client = new NexmoClient.Builder()
                .apiKey("a653fa93")
                .apiSecret("TYeGnseEOoWh1TFK")
                .build();
        VerifyClient verifyClient = client.getVerifyClient();

        VerifyRequest request = new VerifyRequest(Number, "Cryptosis");
        request.setLength(6);
        System.out.println(request);

        VerifyResponse response = verifyClient.verify(request);

        if (response.getStatus() == VerifyStatus.OK) {
            System.out.printf("RequestID: %s", response.getRequestId());
            RID=response.getRequestId();

        } else {
            System.out.printf("ERROR! %s: %s",
                    response.getStatus(),
                    response.getErrorText()
            );
        }
        return RID;
    }
    }
    /*public static boolean issignup(String Name ,String Email , String Password){


        Connection myConn = null;
        PreparedStatement pst = null;
        try {

            myConn = MySQLConnection.getConnection();
            pst = myConn.prepareStatement("insert into login values(?,?,?)");
            pst.setString(1,Name);
            pst.setString(2, Email);
            pst.setString(3,Password);
            int i=pst.executeUpdate();
            if(i>0){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("DATA Information");
                alert.setHeaderText("Your information is Saved");
                alert.setContentText("Pres OK to continue");
                alert.showAndWait();
                Home.Connect();
                //Signup.setVisible(false);
                //JOptionPane.showMessageDialog(frame , "Data is saved");



            }
            else {
                //JOptionPane.showMessageDialog(frame , "Data is not saved");

            }
        }catch (Exception e){
            // new Signup().setVisible(false);
            //JOptionPane.showMessageDialog(null, e);
        }

        return true;

    }*/

