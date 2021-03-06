package application;


import application.views.Home;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        BorderPane root = new BorderPane();

        Parent root = FXMLLoader.load(getClass().getResource("views/HOME.fxml"));
        Image icon = new Image(getClass().getResourceAsStream("Images/ensa1.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("ENSAHub");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
