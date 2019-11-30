/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.staff;

import Model.Staff;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import dbController.StaffController;
import db.DBConnection;
import dbController.MoveController;
import dbController.StudentController;
import dbController.TransferController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static dbController.StaffController.searchStaffByName;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class MoveStaffController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton Back;
    @FXML
    private JFXTextField clmStaffName;
    @FXML
    private JFXTextField clmClasses;
    @FXML
    private JFXTextField clmSalary;
    @FXML
    private JFXTextField clmContact;
    @FXML
    private JFXTextField clmAddress;
    @FXML
    private JFXTextField clmState;
    @FXML
    private JFXTextField clmID;
    @FXML
    private JFXTextField clmEmail;
    @FXML
    private JFXComboBox<String> clmGender;
    @FXML
    private JFXTextField clmDegree;
    @FXML
    private JFXDatePicker clmDOB;
    @FXML
    private JFXDatePicker clmHired;
    @FXML
    private JFXTextField clmDepartment;
    @FXML
    private JFXTextField clmPosition;
    @FXML
    private Button move;
    @FXML
    private TextField EmpNo;
    @FXML
    private TextField empName;
    @FXML
    private Button searchStaff;
    @FXML
    private Button searchByName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load (getClass ().getResource ("/View/Staff/StaffManagement.fxml"));
        Node node = (Node) event.getSource ();
        Stage stage = (Stage) node.getScene ().getWindow ();
        stage.setScene (new Scene (home));
    }

    @FXML
    private void btnUpdate(ActionEvent event) {
    }

    @FXML
    private void Back(ActionEvent event) {
    }


    @FXML
    private void btnMoveStaff(ActionEvent event) {


        String id = clmID.getText ();
        String name = clmStaffName.getText ();
        String classes = clmClasses.getText ();
        String gender = clmGender.getValue ();
        String dob = String.valueOf ((clmDOB.getValue ()));
        String hired = String.valueOf ((clmHired.getValue ()));
        String department = clmDepartment.getText ();
        String position = clmPosition.getText ();
        String degree = clmDegree.getText ();
        String salary = clmSalary.getText ();
        String contact = clmContact.getText ();
        String email = clmContact.getText ();
        String address = clmAddress.getText ();
        String state = clmState.getText ();


        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection ().getConnection ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }


        int moveStaff = 0;
        try {

            String sql = "INSERT INTO oldstaff (id, name, classes, gender, dob, hired, department, position, degree, salary, contact, email, address, state)" +
                    "SELECT * FROM staffs";

            PreparedStatement stm = null;
            try {
                stm = conn.prepareStatement (sql);

                stm.executeUpdate ();


            } catch (SQLException e) {
                e.printStackTrace ();
            }

            int a = MoveController.deleteStaff (name);
            int b = MoveController.updateStaff (name);

            if (a > 0) {

                if (b > 0) {


                    if (moveStaff > 0) {
                        Alert alert = new Alert (Alert.AlertType.INFORMATION);
                        alert.setTitle ("Information Dialog");
                        alert.setHeaderText (null);
                        alert.setContentText ("Staff moved successfully");
                        alert.show ();

                    } else {

                        Alert alert = new Alert (Alert.AlertType.ERROR);
                        alert.setTitle ("Transfer Students");
                        alert.setHeaderText (null);
                        alert.setContentText ("Oops..! There is an Error in Transferring Staff..!");
                        alert.showAndWait ();
                    }
                }
            }


        } catch (SQLException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    private void searchStaff(ActionEvent event) {

        try {

            int id = Integer.parseInt (EmpNo.getText ());
            Staff s = StaffController.searchStaff (id);
            if (s != null) {
                clmID.setText (String.valueOf (s.getId ()));
                clmStaffName.setText (s.getName ());
                clmClasses.setText (s.getClasses ());
                clmGender.setValue (s.getGender ());
                clmDOB.setValue (LocalDate.parse (s.getDob ()));
                clmHired.setValue (LocalDate.parse (s.getHired ()));
                clmDepartment.setText (s.getDepartment ());
                clmPosition.setText (s.getPosition ());
                clmDegree.setText (s.getDegree ());
                clmSalary.setText (s.getSalary ());
                clmContact.setText (s.getContact ());
                clmEmail.setText (s.getEmail ());
                clmAddress.setText (s.getAddress ());
                clmState.setText (s.getState ());


            } else {
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle ("Staff Search");
                alert.setHeaderText (null);
                alert.setContentText ("Staff Not Found");
                alert.showAndWait ();

                clmID.setText (null);
                clmStaffName.setText (null);
                clmClasses.setText (null);
                clmGender.setValue (null);
                clmDepartment.setText (null);
                clmPosition.setText (null);
                clmDOB.setValue (null);
                clmHired.setValue (null);
                clmDegree.setText (null);
                clmSalary.setText (null);
                clmContact.setText (null);
                clmEmail.setText (null);
                clmAddress.setText (null);
                clmState.setText (null);
                empName.setText (null);
                EmpNo.setText (null);
            }
        } catch (SQLException ex) {
            Logger.getLogger (StaffController.class.getName ()).log (Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    private void searchByName(ActionEvent event) {

        try {

            String name = empName.getText ();
            Staff s = searchStaffByName (name);
            if (s != null) {
                clmID.setText (String.valueOf (s.getId ()));
                clmStaffName.setText (s.getName ());
                clmClasses.setText (s.getClasses ());
                clmGender.setValue (s.getGender ());
                clmDepartment.setText (s.getDepartment ());
                clmPosition.setText (s.getPosition ());
                clmDOB.setValue (LocalDate.parse (s.getDob ()));
                clmHired.setValue (LocalDate.parse (s.getHired ()));
                clmDegree.setText (s.getDegree ());
                clmSalary.setText (s.getSalary ());
                clmContact.setText (s.getContact ());
                clmEmail.setText (s.getEmail ());
                clmAddress.setText (s.getAddress ());
                clmState.setText (s.getState ());


            } else {
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle ("Staff Search");
                alert.setHeaderText (null);
                alert.setContentText ("Staff Not Found");
                alert.showAndWait ();

                clmID.setText (null);
                clmStaffName.setText (null);
                clmClasses.setText (null);
                clmGender.setValue (null);
                clmDepartment.setText (null);
                clmPosition.setText (null);
                clmDOB.setValue (null);
                clmHired.setValue (null);
                clmContact.setText (null);
                clmEmail.setText (null);
                clmAddress.setText (null);
                clmState.setText (null);
                empName.setText (null);
                EmpNo.setText (null);
            }
        } catch (SQLException ex) {
            Logger.getLogger (StaffController.class.getName ()).log (Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

}