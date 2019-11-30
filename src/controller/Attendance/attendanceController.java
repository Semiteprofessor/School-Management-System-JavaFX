/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Attendance;

import Model.Attendance;
import animatefx.animation.Pulse;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
import javafx.scene.control.ComboBox;
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
public class attendanceController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TextField tfSearch;
    @FXML
    private ComboBox<String> loadClasses;
    @FXML
    private Button checkAttendance;
    @FXML
    private TableView<Attendance> tableView;
    @FXML
    private TableColumn<Attendance, String> clmID1;
    @FXML
    private TableColumn<Attendance, String> clmID;
    @FXML
    private TableColumn<Attendance, String> clmName;
    @FXML
    private TableColumn<Attendance, String> clmTerm;
    @FXML
    private TableColumn<Attendance, String> clmDate;
    @FXML
    private TableColumn<Attendance, String> clmAttendance;
    @FXML
    private TableColumn<Attendance, String> clmExcuse;
    @FXML
    private TableColumn<Attendance, Integer> clmTotalPresent;
    @FXML
    private TableColumn<Attendance, Integer> clmTotalAbsent;
    @FXML
    private ComboBox<String> loadTerm;
    @FXML
    private ComboBox<String> selectClasses;
    @FXML
    private TextField EmpNo;
    @FXML
    private Button searchStaff;
    @FXML
    private Button update;
    @FXML
    private Button update1;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXTextField studNo;
    @FXML
    private JFXTextField studName;
    @FXML
    private ComboBox<String> selectTerm;
    @FXML
    private JFXTextField totPresent;
    @FXML
    private JFXTextArea excuse;
    @FXML
    private TextField enterStudNo;
    @FXML
    private Button searchStudent;
    @FXML
    private TableColumn<Attendance, String> clmClass;


    ObservableList<Attendance> oblist = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> loadAttendance;
    @FXML
    private JFXTextField totDays;
    @FXML
    private TableColumn<Attendance, Integer> clmTotalDays;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTerm.getItems().addAll("First", "Second", "Third", "None");
        loadClasses.getItems().addAll("JS1", "JS2", "JS3", "SS1", "SS2", "SS3", "All Classes", "None");
        loadAttendance.getItems().addAll ("Present", "Absent");
        selectClasses.getItems ().addAll ("JS1", "JS2", "JS3", "SS1", "SS2", "SS3", "All Classes", "None");
        selectTerm.getItems ().addAll ("First", "Second", "Third", "None");



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
            resultSet = conn.createStatement ().executeQuery ("SELECT * FROM attendance");
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        try {
            while (resultSet.next ()) {
                oblist.addAll (new Attendance (
                        resultSet.getInt ("id"),
                        resultSet.getString ("name"),
                        resultSet.getString ("classes"),
                        resultSet.getString ("term"),
                        resultSet.getString ("date"),
                        resultSet.getString ("attendance"),
                        resultSet.getString ("excuse"),
                        resultSet.getInt ("totaldays"),
                        resultSet.getInt ("totalpresent"),
                        resultSet.getInt ("totalabsent")
                ));


                clmID.setCellValueFactory (new PropertyValueFactory<> ("id"));
                clmName.setCellValueFactory (new PropertyValueFactory<> ("name"));
                clmClass.setCellValueFactory (new PropertyValueFactory<> ("classes"));
                clmTerm.setCellValueFactory (new PropertyValueFactory<> ("term"));
                clmDate.setCellValueFactory (new PropertyValueFactory<> ("date"));
                clmAttendance.setCellValueFactory (new PropertyValueFactory<> ("attendance"));
                clmExcuse.setCellValueFactory (new PropertyValueFactory<> ("excuse"));
                clmTotalDays.setCellValueFactory (new PropertyValueFactory<> ("totaldays"));
                clmTotalPresent.setCellValueFactory (new PropertyValueFactory<> ("totalpresent"));
                clmTotalAbsent.setCellValueFactory (new PropertyValueFactory<> ("totalabsent"));

                tableView.setItems (oblist);

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
        stage.setScene(new Scene (home));

        new Pulse (home).play ();
    }

    @FXML
    private void tfSearchOnAction(ActionEvent event) {
    }

    @FXML
    private void handleSearchButton(ActionEvent event) {
    }


    @FXML
    private void btnCheckPayment(ActionEvent event) {
    }

    @FXML
    private void searchStaff(ActionEvent event) {
    }

    @FXML
    private void update(ActionEvent event) {
    }

    @FXML
    private void btnSearchStudent(ActionEvent event) {
    }
    
}
