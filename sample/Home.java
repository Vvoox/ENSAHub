package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Home implements Initializable {

    static StringBuilder output=new StringBuilder();

    @FXML
    private javafx.scene.control.TextField Password;

    @FXML
    private javafx.scene.control.TextField Email;
    @FXML
    private javafx.scene.control.TextField test;
    @FXML
    private javafx.scene.control.Label valide;
    @FXML
    private javafx.scene.control.Label Label1;
    @FXML
    private javafx.scene.control.Label iconLabel;
    @FXML
    private javafx.scene.control.Hyperlink signupLabel;
    @FXML
    private javafx.scene.control.Label Label2;
    @FXML private javafx.scene.control.Button Connect;
    @FXML private javafx.scene.control.Button cnt;
    @FXML private javafx.scene.control.Button closeButton;
    @FXML private javafx.scene.control.ProgressIndicator loading;
    static String email;
    static String password;
    private void closelastButtonAction(){ //hadi pour button cancel

        Stage stage = (Stage) closeButton.getScene().getWindow();

        stage.close();

    }
    public void signup() throws IOException {
        closelastButtonAction();
        SIGNUP.Sp();
    }
    public void isConnected() throws IOException {

        email = Email.getText();
        password = Password.getText();
        //Connect.setVisible(false);
//        loading.setVisible(true);
        //sleep(30000);
        if (DBConnection.isConnected(email, password)) {

            /*loading.setVisible(false);
            closeButton.setVisible(false);
            Email.setVisible(false);
            Password.setVisible(false);
            Connect.setVisible(false);
            Label1.setVisible(false);
            Label2.setVisible(false);
            iconLabel.setVisible(false);
            signupLabel.setVisible(false);
            //sleep(30000);

            valide.setVisible(true);
            //sleep(10000);*/

            closelastButtonAction();
            //Label2.setText(email);
            Continue();
                /*final String fromEmail = "khalilomogiwara@gmail.com"; //requires valid gmail id
                final String password = "mypassword"; // correct password for gmail id
                final String toEmail = "myemail@yahoo.com"; // can be any email id

                System.out.println("TLSEmail Start");
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
                props.put("mail.smtp.port", "587"); //TLS Port
                props.put("mail.smtp.auth", "true"); //enable authentication
                props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

                //create Authenticator object to pass in Session.getInstance argument
                Authenticator auth = new Authenticator() {
                    //override the getPasswordAuthentication method
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, password);
                    }
                };
                Session session = Session.getInstance(props, auth);

                EmailUtil.sendEmail(session, toEmail,"TLSEmail Testing Subject", "TLSEmail Testing Body");*/

        }


        else{
            //loading.setVisible(false);
            /*Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("DATA Information");
            alert.setHeaderText("You insert wrong Name or Password ! Try again ");
            alert.setContentText("Pres OK to continue");
            alert.showAndWait();*/
            closelastButtonAction();
            No_Continue();
        }

    }

    public void cnt() throws IOException {
        closelastButtonAction();
        Controller.start();

    }
    public void no_cnt() throws IOException {
        closelastButtonAction();
        Home.Connect();

    }
    public void loading(){
        Connect.setVisible(false);
        loading.setVisible(true);
    }
    public void forget_password() throws IOException {

        closelastButtonAction();
        Forget_password.forget_password();
    }
    public void back() throws IOException {

        //Main.launch();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
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
        } else if (result.get() == buttonTypeTwo) {
            closelastButtonAction();
            Home.Connect();
        }
        // ... user chose "Two"

        else {
            alert.close();

            //System.out.println("test");
        }
    }
    public void about() throws IOException {
        closelastButtonAction();
        About.About();
    }
    public static void Connect() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Home.class.getResource("HOME.fxml"));
        Image icon = new Image(Home.class.getResourceAsStream("Images/ensa1.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("ENSAHub");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.show();
    }
    public static void Continue() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Home.class.getResource("Continue.fxml"));
        Image icon = new Image(Home.class.getResourceAsStream("Images/ensa1.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("ENSAHub");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.show();
    }
    public static void No_Continue() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Home.class.getResource("Errordata.fxml"));
        Image icon = new Image(Home.class.getResourceAsStream("Images/ensa1.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("ENSAHub");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.show();
    }
    public static void saveddata() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Home.class.getResource("saveddata.fxml"));
        Image icon = new Image(Home.class.getResourceAsStream("Images/ensa1.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("ENSAHub");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.show();
    }
    public void closeButtonAction(){

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

    public void connect() throws IOException, InterruptedException {
        closelastButtonAction();
        Controller.start();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //valide.setVisible(false);
        //loading.setVisible(false);
        //init();

    }
}
