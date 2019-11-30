/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import db.DBConnection;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class SignUpController implements Initializable {

    @FXML
    private AnchorPane LogIn;
    @FXML
    private TextField tfUserName;

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField pfPassword;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    double x = 0, y = 0;

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();

    }


    @FXML
    private void dragged(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setX(event.getSceneX() - x);
        stage.setY(event.getSceneY() - y);

    }


    @FXML
    private void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void login(MouseEvent event) throws IOException {
        Parent logIn = FXMLLoader.load(getClass().getResource("/View/LoginPage.fxml"));

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(logIn));

    }


    @FXML
    private void max(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setFullScreenExitHint(" ");
        stage.setFullScreen(true);

    }

    @FXML
    private void min(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setIconified(true);


    }

    @FXML
    void signup(ActionEvent event) {



            try {
                Connection conn = DBConnection.getDBConnection().getConnection();



                String user_name = tfUserName.getText();
                String email = tfEmail.getText();
                String password = pfPassword.getText();


                Statement statement = conn.createStatement();



             int   signUp = statement.executeUpdate("insert  into  user (user_name, email, password) " +
                        "values ('" + user_name + "', '" + email + "', '" + password + "')");


                if (tfUserName.getText().isEmpty() || tfEmail.getText().isEmpty() || pfPassword.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("All field required");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter your username, email and password to signup");
                    alert.show();


                }if (signUp > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("SignUp Successful");
                    alert.show();

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid Username or Password");
                    alert.show();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace ();
            }

    }
}