/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.classes.JS1;

import com.jfoenix.controls.JFXTextField;

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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class addBroadSheetController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private JFXTextField clmID;
    @FXML
    private JFXTextField clmID47;
    @FXML
    private JFXTextField clmID48;
    @FXML
    private JFXTextField clmID49;
    @FXML
    private JFXTextField clmID5;
    @FXML
    private JFXTextField clmID8;
    @FXML
    private JFXTextField clmID494;
    @FXML
    private JFXTextField clmID498;
    @FXML
    private JFXTextField clmID484;
    @FXML
    private JFXTextField clmID488;
    @FXML
    private JFXTextField clmID477;
    @FXML
    private JFXTextField clmID4711;
    @FXML
    private JFXTextField clmID14;
    @FXML
    private JFXTextField clmID10;
    @FXML
    private JFXTextField clmID3;
    @FXML
    private JFXTextField clmID4911;
    @FXML
    private JFXTextField clmID497;
    @FXML
    private JFXTextField clmID493;
    @FXML
    private JFXTextField clmID4811;
    @FXML
    private JFXTextField clmID487;
    @FXML
    private JFXTextField clmID483;
    @FXML
    private JFXTextField clmID4714;
    @FXML
    private JFXTextField clmID4710;
    @FXML
    private JFXTextField clmID476;
    @FXML
    private JFXTextField clmID4;
    @FXML
    private JFXTextField clmID41;
    @FXML
    private JFXTextField clmID411;
    @FXML
    private JFXTextField clmID13;
    @FXML
    private JFXTextField clmID7;
    @FXML
    private JFXTextField clmID2;
    @FXML
    private JFXTextField clmID4910;
    @FXML
    private JFXTextField clmID496;
    @FXML
    private JFXTextField clmID492;
    @FXML
    private JFXTextField clmID4810;
    @FXML
    private JFXTextField clmID486;
    @FXML
    private JFXTextField clmID482;
    @FXML
    private JFXTextField clmID4713;
    @FXML
    private JFXTextField clmID479;
    @FXML
    private JFXTextField clmID475;
    @FXML
    private JFXTextField clmID9;
    @FXML
    private JFXTextField clmID6;
    @FXML
    private JFXTextField clmID1;
    @FXML
    private JFXTextField clmID499;
    @FXML
    private JFXTextField clmID495;
    @FXML
    private JFXTextField clmID491;
    @FXML
    private JFXTextField clmID489;
    @FXML
    private JFXTextField clmID485;
    @FXML
    private JFXTextField clmID481;
    @FXML
    private JFXTextField clmID4712;
    @FXML
    private JFXTextField clmID478;
    @FXML
    private JFXTextField clmID474;
    @FXML
    private JFXTextField clmID42;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/JS1/broadSheet.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));
    }

    @FXML
    private void addStud(ActionEvent event) {
    }

    @FXML
    private void Reset(ActionEvent event) {
    }
    
}
