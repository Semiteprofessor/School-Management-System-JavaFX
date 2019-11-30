/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Inventory.healthCentre;

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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class addDrugController implements Initializable {

    @FXML
    private ImageView imageViewStudentImage;
    @FXML
    private Button selectImage;
    @FXML
    private JFXTextField clmStudentName;
    @FXML
    private JFXTextField clmDisability;
    @FXML
    private JFXTextField clmID;
    @FXML
    private JFXTextField clmID1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/healthCentre/hospital.fxml"));
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

    @FXML
    private void selectStudentImageOnAction(ActionEvent event) {
    }
    
}
