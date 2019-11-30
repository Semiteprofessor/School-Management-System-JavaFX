/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Inventory.Drawing;

import Model.Inventory.Computer;
import Model.Inventory.TD;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import db.TableSchema;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
public class tdController implements Initializable {


    ObservableList<TD> oblist = FXCollections.observableArrayList();
    @FXML
    private Button btnBack;
    @FXML
    private TextField tfSearch;
    @FXML
    private TableView<TD> tableView;
    @FXML
    private TableColumn<TD, String> clmID1;
    @FXML
    private TableColumn<TD, String> clmID;
    @FXML
    private TableColumn<TD, Byte> clmImage;
    @FXML
    private TableColumn<TD, String> clmQty;
    @FXML
    private TableColumn<TD, String> clmNote;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private TableColumn<?, ?> clmName;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();

            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM td");

            while (resultSet.next()) {
                oblist.addAll(new TD (
                        resultSet.getInt("id"),
                        resultSet.getBytes ("image"),
                        resultSet.getString ("name"),
                        resultSet.getString ("qty"),
                        resultSet.getString ("note")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }


        clmID.setCellValueFactory(new PropertyValueFactory<> ("id"));
        clmImage.setPrefWidth (80);
        clmImage.setCellValueFactory(new PropertyValueFactory<>("image"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        clmNote.setCellValueFactory(new PropertyValueFactory<>("note"));

        tableView.setItems(oblist);
    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/inventory.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void tfSearchOnAction(ActionEvent event) {
    }

    @FXML
    private void handleSearchButton(ActionEvent event) {
    }

    @FXML
    private void btnAdd(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Drawing/addDrawing.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnEdit(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Drawing/manageDrawing.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }
    
}
