/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.classes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import animatefx.animation.Pulse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class enterClassesController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private Button enterJS1;
    @FXML
    private Button enterJS2;
    @FXML
    private Button enterJS3;
    @FXML
    private Button enterSS1;
    @FXML
    private Button enterSS2;
    @FXML
    private Button enterSS3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new Pulse (home).play ();
    }

    @FXML
    private void enterJS1(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/JS1/JS1.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void enterJS2(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/JS2/JS2.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void enterJS3(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/JS3/JS3.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void enterSS1(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/SS1/SS1.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void enterSS2(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/SS2/SS2.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void enterSS3(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/SS3/SS3.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    
}
