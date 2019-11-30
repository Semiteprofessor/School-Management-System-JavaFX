/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Management;

import animatefx.animation.Pulse;
import api.*;
import com.jfoenix.controls.JFXDatePicker;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ResourceBundle;
import api.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class eventController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private Button viewInfo;
    @FXML
    private Button viewInfo1;
    @FXML
    private Button viewInfo11;
    @FXML
    private Button viewInfo111;
    @FXML
    private Button viewInfo2;
    @FXML
    private Button viewInfo12;
    @FXML
    private Button viewInfo112;
    @FXML
    private Button viewInfo1111;


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
    }

    @FXML
    private void btnViewInfo(ActionEvent event) {
    }


    
}
