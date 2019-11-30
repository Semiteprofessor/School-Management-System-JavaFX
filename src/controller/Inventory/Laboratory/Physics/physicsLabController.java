/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Inventory.Laboratory.Physics;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Inventory.Computer;
import Model.Inventory.Physics;
import be.quodlibet.boxable.image.Image;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class physicsLabController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TextField tfSearch;
    @FXML
    private TableView<Physics> tableView;
    @FXML
    private TableColumn<Physics, String> clmID1;
    @FXML
    private TableColumn<Physics, String> clmID;
    @FXML
    private TableColumn<Physics, String> clmQty;
    @FXML
    private TableColumn<Physics, String> clmNote;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private TableColumn<Physics, Image> clmImage;
    @FXML
    private TableColumn<Physics, String> clmName;


    ObservableList<Physics> oblist = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();

            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM physicslab");

            while (resultSet.next()) {
                oblist.addAll(new Physics (
                        resultSet.getInt("id"),
                        resultSet.getByte ("image"),
                        resultSet.getString ("name"),
                        resultSet.getString ("quantity"),
                        resultSet.getString ("note")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }


        clmID.setCellValueFactory(new PropertyValueFactory<> ("id"));
        clmImage.setCellValueFactory(new PropertyValueFactory<>("image"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        clmNote.setCellValueFactory(new PropertyValueFactory<>("note"));

        tableView.setItems(oblist);
    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event)  throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Laboratory/laboratory.fxml"));
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
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Laboratory/Physics/addPhysics.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

    }

    @FXML
    private void btnEdit(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Laboratory/Physics/managePhysics.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }
    
}
