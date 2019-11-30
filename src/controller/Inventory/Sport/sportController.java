/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Inventory.Sport;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class sportController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TextField tfSearch;
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> clmID1;
    @FXML
    private TableColumn<?, ?> clmID;
    @FXML
    private TableColumn<?, ?> clmID3;
    @FXML
    private TableColumn<?, ?> clmAparatus;
    @FXML
    private TableColumn<?, ?> clmQty;
    @FXML
    private TableColumn<?, ?> clmNote;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event)  throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/inventory.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));
    }

    @FXML
    private void tfSearchOnAction(ActionEvent event) {
    }

    @FXML
    private void handleSearchButton(ActionEvent event) {
    }

    @FXML
    private void btnAdd(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Sport/addSport.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

    }

    @FXML
    private void btnEdit(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Sport/manageSport.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }
    
}
