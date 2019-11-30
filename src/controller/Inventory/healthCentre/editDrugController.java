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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class editDrugController implements Initializable {

    @FXML
    private AnchorPane manageStudents;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnPrint;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private ImageView imageViewStudentImage;
    @FXML
    private Button selectImage;
    @FXML
    private JFXTextField clmGeneric;
    @FXML
    private JFXTextField clmQuantity;
    @FXML
    private JFXTextField clmID;
    @FXML
    private JFXTextField clmName;
    @FXML
    private TextField AdNo;
    @FXML
    private Button searchStudent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBackHomeOnAction(ActionEvent event)  throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/healthCentre/hospital.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));
    }

    @FXML
    private void btnPrint(ActionEvent event) {
    }

    @FXML
    private void btnDelete(ActionEvent event) {
    }

    @FXML
    private void btnUpdate(ActionEvent event) {
    }

    @FXML
    private void searchStudent(ActionEvent event) {
    }
    
}
