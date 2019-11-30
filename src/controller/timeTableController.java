/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class timeTableController implements Initializable {



    @FXML
    private GridPane pnlHost;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/schoolmanagementsystem/Views/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }


    @FXML
    private void add_student(ActionEvent event) {
    }

    @FXML
    private void dragged(MouseEvent event) {
    }

    @FXML
    private void pressed(MouseEvent event) {
    }
    
}
