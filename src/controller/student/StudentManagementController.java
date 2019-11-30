/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import Model.Student;
import animatefx.animation.BounceInDown;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import controller.common.Actions;
import controller.staff.StaffManagementController;
import db.DBConnection;
import dbController.StudentController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import animatefx.animation.FadeIn;
import javafx.scene.image.Image;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;


public class StudentManagementController implements Initializable {


    @FXML
    private TextField tfSearch;
    @FXML
    private Button btnManageStudent;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private Button btnBack;
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
    private Button btnAddStudent;
    @FXML
    private Button btnPrintStudent;
    @FXML
    private Button btnTransferStudent;
    @FXML
    private TableColumn<?, ?> clmID1;
    private TableColumn<Student, ImageView> clmImage;
    @FXML
    private AnchorPane studPane;



    @Override
    public void initialize(URL url, ResourceBundle rb) {





        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }


        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        ResultSet resultSet = null;
        try {
            resultSet = conn.createStatement ().executeQuery ("SELECT * FROM students");
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


                clmID.setCellValueFactory (new PropertyValueFactory<> ("id"));
                clmStudentName.setCellValueFactory (new PropertyValueFactory<> ("name"));
                clmClasses.setCellValueFactory (new PropertyValueFactory<> ("classes"));
                clmGender.setCellValueFactory (new PropertyValueFactory<> ("gender"));
                clmDOB.setCellValueFactory (new PropertyValueFactory<> ("dob"));
                clmAdmitted.setCellValueFactory (new PropertyValueFactory<> ("admitted"));
                clmDepartment.setCellValueFactory (new PropertyValueFactory<> ("department"));
                clmDisability.setCellValueFactory (new PropertyValueFactory<> ("disability"));
                clmDesignation.setCellValueFactory (new PropertyValueFactory<> ("designation"));
                clmContact.setCellValueFactory (new PropertyValueFactory<> ("contact"));
                clmAddress.setCellValueFactory (new PropertyValueFactory<> ("address"));
                clmState.setCellValueFactory (new PropertyValueFactory<> ("state"));
                clmYear.setCellValueFactory (new PropertyValueFactory<> ("year"));
                tableView.setItems (oblist);



                FilteredList<Student> filteredData = new FilteredList<>(oblist, e -> true);
                tfSearch.setOnKeyReleased (e -> {
                    tfSearch.textProperty ().addListener ((observable, oldValue, newValue) -> {
                        filteredData.setPredicate ((Predicate<? super Student>) student-> {
                            if (newValue == null || newValue.isEmpty ()) {
                                return true;
                            }

                            String lowerCaseFilter = newValue.toLowerCase ();
                            if (student.getName ().toLowerCase ().contains (lowerCaseFilter)){
                                return  true;
                            }else if (student.getClasses ().toLowerCase ().contains (lowerCaseFilter)){
                                return  true;
                            }else if (student.getGender ().toLowerCase ().contains (lowerCaseFilter)) {
                                return  true;
                            }else  if (student.getDepartment ().toLowerCase ().contains (lowerCaseFilter)){

                            }return false;


                        });
                    });

                    SortedList<Student> sortedData = new SortedList<> (filteredData);

                    sortedData.comparatorProperty ().bind (tableView.comparatorProperty ());

                    tableView.setItems (sortedData);
                });




            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }








    }


        @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void addStudentOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/student/addStudent.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void manageStudentOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/student/ManageStudents.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }



    @FXML
    private void printStudentOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/student/PrintStudents.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

    }


    @FXML
    private void transferStudentOnAction(ActionEvent event)  throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/student/TransferStudents.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void tfSearchOnAction(ActionEvent event) {
    }



    //Search Method
    @FXML
    private void handleSearchButton(ActionEvent event) {


    }


}





