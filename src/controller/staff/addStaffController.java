/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.staff;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import db.TableSchema;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import controller.student.StudentManagementController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import db.DBConnection;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class addStaffController implements Initializable {




    ObservableList<String> list = FXCollections.observableArrayList("Male", "Female");
    @FXML
    private JFXTextField clmStaffName;
    @FXML
    private JFXTextField clmClasses;
    @FXML
    private JFXTextField clmDepartment;
    @FXML
    private JFXComboBox<String> clmGender;
    @FXML
    private JFXTextField clmDegree;
    @FXML
    private JFXTextField clmSalary;
    @FXML
    private JFXTextField clmContact;
    @FXML
    private JFXTextField clmAddress;
    @FXML
    private JFXTextField clmPosition;
    @FXML
    private JFXTextField clmID;
    @FXML
    private JFXTextField clmState;
    @FXML
    private JFXTextField clmEmail;
    @FXML
    private JFXDatePicker clmHired;
    @FXML
    private JFXDatePicker clmDOB;
    @FXML
    private ImageView imageViewPatientImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       clmGender.setItems(list);
    }





    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/staff/StaffManagement.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void addStaff(ActionEvent event) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        try {

            String id = clmID.getText();
            String name = clmStaffName.getText();
            String classes = clmClasses.getText();
            String gender = clmGender.getValue();
            String dob = String.valueOf ((clmDOB.getValue ()));
            String hired = String.valueOf ((clmHired.getValue ()));
            String department = clmDepartment.getText();
            String position = clmPosition.getText();
            String degree = clmDegree.getText();
            String salary = clmSalary.getText();
            String contact = clmContact.getText();
            String email = clmContact.getText();
            String address = clmAddress.getText();
            String state = clmState.getText();

            int addStaff;
            try (Statement statement = conn.createStatement ()) {

                addStaff = statement.executeUpdate ("INSERT INTO staffs (id, name, classes, gender, dob, hired, department, position, degree, salary, contact, email, address, state)" +
                        "VALUES('" + id + "','" + name + "', '" + classes + "', '" + gender + "', '" + dob + "', '" + hired + "', '" + department + "', '" + position + "', '" + degree + "', '" + salary + "', '" + contact + "','" + email + "', '" + address + "', '" + state + "') ");
            }


            if (addStaff > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Staff added successfully");
                alert.show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Reset(ActionEvent event) {
    }

    @FXML
    private void selectPatientImageOnAction(ActionEvent event) {    }



    
}
