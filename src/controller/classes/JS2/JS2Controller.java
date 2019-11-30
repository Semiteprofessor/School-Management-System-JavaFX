/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.classes.JS2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Student;
import db.DBConnection;
import dbController.ClassesController;
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
import tableModel.StudentTableModel;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class JS2Controller implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TextField tfSearch;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, Integer> clmID;
    @FXML
    private TableColumn<Student, String> clmStudentName;
    @FXML
    private TableColumn<Student, String> clmClasses;
    @FXML
    private TableColumn<Student, String> clmDOB;
    @FXML
    private TableColumn<Student, String> clmAdmitted;
    @FXML
    private TableColumn<Student, String> clmGender;
    @FXML
    private TableColumn<Student, String> clmDepartment;
    @FXML
    private TableColumn<Student, String> clmDisability;
    @FXML
    private TableColumn<Student, String> clmDesignation;
    @FXML
    private TableColumn<Student, String> clmContact;
    @FXML
    private TableColumn<Student, String> clmAddress;
    @FXML
    private TableColumn<Student, String> clmState;

    ObservableList<Student> oblist = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Student, String> clmYear;
    @FXML
    private TableColumn<?, ?> clmID1;
    @FXML
    private Button btnSubject;
    @FXML
    private Button timeTable;
    @FXML
    private Button broadSheet;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        try {
            Connection conn = DBConnection.getDBConnection ().getConnection ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }


        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection ().getConnection ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        ResultSet resultSet = null;
        try {
            resultSet = conn.createStatement ().executeQuery ("SELECT * FROM students WHERE classes = 'JS2'");
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        try {
            while (resultSet.next ()) {
                oblist.addAll (new Student (
                        resultSet.getInt ("id"),
                        resultSet.getString ("name"),
                        resultSet.getString ("classes"),
                        resultSet.getString ("gender"),
                        resultSet.getString ("dob"),
                        resultSet.getString ("admitted"),
                        resultSet.getString ("department"),
                        resultSet.getString ("disability"),
                        resultSet.getString ("designation"),
                        resultSet.getString ("contact"),
                        resultSet.getString ("address"),
                        resultSet.getString ("state"),
                        resultSet.getString ("year")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        clmID.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmClasses.setCellValueFactory(new PropertyValueFactory<>("classes"));
        clmGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        clmDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        clmAdmitted.setCellValueFactory(new PropertyValueFactory<>("admitted"));
        clmDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        clmYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        clmDisability.setCellValueFactory(new PropertyValueFactory<>("disability"));
        clmDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        clmContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        clmState.setCellValueFactory(new PropertyValueFactory<>("state"));

        tableView.setItems(oblist);
    }



    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/enterClasses.fxml"));
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
    private void btnSubject(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/JS2/subject.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnTimeTable(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/JS2/timeTable.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnBroadSheet(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/JS2/broadSheet.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }
    
}
