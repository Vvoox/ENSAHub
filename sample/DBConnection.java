package sample;
import javafx.scene.control.Alert;

import java.sql.*;

import static sample.SIGNUP.MySQLConnection;

public class DBConnection {
    //static String url="jdbc:mysql://localhost:3306/ensaproject";
    static String url = "jdbc:mysql://remotemysql.com:3306/ZG94mCGaQ4";
    static String user="ZG94mCGaQ4";
    static String password="jc3FQRQnXn";
    public static void DBConnection() throws SQLException, ClassNotFoundException {
    /*String url="jdbc:mysql://localhost:3306/cryptosis";
    String user="root";
    String password="";*/
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection myConn = DriverManager.getConnection(url,user,password);



    }
    public static boolean issignup(String Name ,String Last_name,String Email , String Number ,String Password) throws ClassNotFoundException {
        boolean stat = false;
        /*String url="jdbc:mysql://localhost:3306/cryptosis";
        String user="root";
        String password="";
       // Class.forName("com.mysql.jdbc.Driver");*/
        Connection myConn = null;
        PreparedStatement pst = null;
        try {

            myConn = MySQLConnection.getConnection(url,user,password);
            pst = myConn.prepareStatement("insert into etudiant values(?,?,?,?,?)");
            pst.setString(1,Name);
            pst.setString(2,Last_name);
            pst.setString(3, Email);
            pst.setString(4, Number);
            pst.setString(5,Password);
            int i=pst.executeUpdate();
            if(i>0){
               /* Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("DATA Information");
                alert.setHeaderText("Your information is Saved");
                alert.setContentText("Pres OK to continue");
                alert.showAndWait();*/
                stat=true;

                //Signup.setVisible(false);
                //JOptionPane.showMessageDialog(frame , "Data is saved");



            }
            else {
                //JOptionPane.showMessageDialog(frame , "Data is not saved");

            }
        }catch (Exception e){
          /*  Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("DATA Information");
            alert.setHeaderText("Your error is : "+e);
            alert.setContentText("Pres OK to continue");
            alert.showAndWait();*/
            stat=false;

            // new Signup().setVisible(false);
            //JOptionPane.showMessageDialog(null, e);
        }

        return stat;

    }
    public static boolean isConnected(String Email , String Password){
        boolean etat=false;
            try{
                //String EMAIL="";
                //String PASSWORD="";
                Connection myConn = MySQLConnection.getConnection(url,user,password);
                String mySqlQuery =
                        "SELECT  Email,Password FROM etudiant WHERE Email = '"+
                                Email+
                                "' AND Password = '"+
                                Password+
                                "'";
                PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                    Home.email= resultSet.getString("Email");
                    Home.password= resultSet.getString("Password");
                    //LoginSession.Nickname = resultSet.getString("Nickname");

                    etat=true;
                }

            }catch (Exception exception){

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("DATA Information");
                alert.setHeaderText("Your error is : "+exception);
                alert.setContentText("Pres OK to continue");
                alert.showAndWait();
            }

            return etat;
        }
    }
