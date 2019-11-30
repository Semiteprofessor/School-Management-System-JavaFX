/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Portal;

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
public class mainPortalController implements Initializable {

    @FXML
    private Button btnBack;

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
        stage.setScene(new Scene (home));

        new Pulse (home).play ();
    }

    @FXML
    private void btnAdmin(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Portal/adminPortal/UserAccount.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));
    }

    @FXML
    private void btnAssessement(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Portal/assessmentPortal/assessment.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));
    }
    
}
