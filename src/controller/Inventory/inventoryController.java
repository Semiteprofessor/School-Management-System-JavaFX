/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Inventory;

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
public class inventoryController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private Button laboratory;
    @FXML
    private Button healtheCentre;
    @FXML
    private Button library;
    @FXML
    private Button computer;
    @FXML
    private Button drawing;
    @FXML
    private Button homeEcons;
    @FXML
    private Button musical;
    @FXML
    private Button sport;

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
    private void btnLaboratory(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Laboratory/laboratory.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnHealtheCentre(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/HealthCentre/hospital.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnLibrary(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Library/LibraryManagement.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnComputer(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Computer/computer.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnDrawing(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Drawing/td.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnHomeEcons(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Econs/econs.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnMusical(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Music/music.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnSport(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Sport/sport.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

  
}
