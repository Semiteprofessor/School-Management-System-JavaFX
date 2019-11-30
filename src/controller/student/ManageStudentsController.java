/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Staff;
import Model.Student;
import dbController.StaffController;
import dbController.StudentController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXTextField;
import db.TableSchema;
import controller.ReportViewController;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import db.DBConnection;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import static dbController.StaffController.searchStaffByName;
import static dbController.StudentController.*;
import static dbController.StudentController.updateLeftStudent;
import javafx.scene.image.ImageView;
import dbController.StudentController;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class ManageStudentsController implements Initializable {

    @FXML
    private AnchorPane manageStudents;
    @FXML
    private Button btnBack;
    @FXML
    private JFXTextField clmStudentName;
    @FXML
    private JFXTextField clmClasses;
    @FXML
    private JFXTextField clmDepartment;
    @FXML
    private JFXTextField clmDesignation;
    @FXML
    private JFXTextField clmDisability;
    @FXML
    private JFXTextField clmContact;
    @FXML
    private JFXTextField clmAddress;
    @FXML
    private JFXTextField clmState;
    @FXML
    private JFXDatePicker clmDOB;
    @FXML
    private JFXTextField clmID;
    @FXML
    private JFXDatePicker clmDateAdmitted;
    @FXML
    private Button btnPrint;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private TextField AdNo;
    @FXML
    private TextField AdNo1;
    @FXML
    private Button searchStudent;
    @FXML
    private Button searchPastStudent;
    @FXML
    private JFXComboBox<String> clmGender;

    ObservableList<String> list = FXCollections.observableArrayList("Male", "Female");
    @FXML
    private JFXTextField clmYear;
    @FXML
    private ImageView imageViewStudentImage;
    @FXML
    private Button selectImage;
    private TextField empName;
    @FXML
    private Button searchByName;
    @FXML
    private TextField StudName;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        clmGender.setItems(list);

    }


    @FXML
    void searchByName(ActionEvent event) {

        try {

            String name = StudName.getText();
            Student s = searchStudentByName (name);
            if (s != null) {
                clmID.setText(String.valueOf(s.getId()));
                clmStudentName.setText(s.getName());
                clmClasses.setText(s.getClasses());
                clmGender.setValue(s.getGender ());
                clmDOB.setValue (LocalDate.parse (s.getDob()));
                clmDateAdmitted.setValue (LocalDate.parse (s.getAdmitted ()));
                clmDepartment.setText(s.getDepartment ());
                clmDisability.setText (s.getDisability ());
                clmDesignation.setText(s.getDesignation ());
                clmContact.setText(s.getContact());
                clmAddress.setText(s.getAddress());
                clmState.setText(s.getState());
                clmYear.setText(s.getYear ());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Student Search");
                alert.setHeaderText(null);
                alert.setContentText("Student Not Found");
                alert.showAndWait();

                clmID.setText(null);
                clmStudentName.setText(null);
                clmClasses.setText(null);
                clmGender.setValue(null);
                clmDOB.setValue (null);
                clmDateAdmitted.setValue (null);
                clmDepartment.setText(null);
                clmDisability.setText (null);
                clmDesignation.setText(null);
                clmContact.setText(null);
                clmAddress.setText(null);
                clmState.setText(null);
                clmYear.setText(null);
                AdNo.setText(null);
                StudName.setText (null);
                AdNo1.setText(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }




    //Delete Method
    //Delete Method
    @FXML
    void btnDelete(ActionEvent event) {
        try {
            Integer id = Integer.valueOf(clmID.getText());
            Student s = new Student(Integer.parseInt(clmID.getText()),
                    clmStudentName.getText(),
                    clmClasses.getText(),
                    clmGender.getValue(),
                    clmDOB.getValue (),
                    clmDateAdmitted.getValue (),
                    clmDepartment.getText(),
                    clmDisability.getText(),
                    clmDesignation.getText(),
                    clmContact.getText(),
                    clmAddress.getText(),
                    clmState.getText(),
                    clmYear.getText());

            if(AdNo1.getText().isEmpty()) {

                int moveStudent = moveStudent(s);
                if (moveStudent > 0) {

                    int deleteStudent = deleteStudent(id);
                    if (deleteStudent > 0) {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Delete Student");
                        alert.setHeaderText(null);
                        alert.setContentText("Student " + id + " has been deleted successfully..!");
                        alert.showAndWait();

                        AdNo.setText(null);
                        StudName.setText (null);
                        AdNo1.setText (null);
                        clmID.setText(null);
                        clmStudentName.setText(null);
                        clmClasses.setText(null);
                        clmGender.setValue(null);
                        clmDOB.setValue (null);
                        clmDateAdmitted.setValue (null);
                        clmDepartment.setText(null);
                        clmDisability.setText(null);
                        clmDesignation.setText(null);
                        clmContact.setText(null);
                        clmAddress.setText(null);
                        clmState.setText(null);
                        clmYear.setText(null);


                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Delete Student");
                        alert.setHeaderText(null);
                        alert.setContentText("There is an error deleting Student");
                        alert.showAndWait();
                    }
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Delete Student");
                    alert.setHeaderText(null);
                    alert.setContentText("There is an error deleting Student");
                    alert.showAndWait();
                }
            }
            else{

                int forceDelete = deleteLeftStudent(id);
                if (forceDelete > 0) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Delete Student");
                    alert.setHeaderText(null);
                    alert.setContentText("Student " + id + " has been deleted successfully..!");
                    alert.showAndWait();


                    AdNo.setText(null);
                    AdNo1.setText(null);
                    clmStudentName.setText (null);
                    clmID.setText(null);
                    clmStudentName.setText(null);
                    clmClasses.setText(null);
                    clmGender.setValue(null);
                    clmDOB.setValue (null);
                    clmDateAdmitted.setValue (null);
                    clmDepartment.setText(null);
                    clmDisability.setText(null);
                    clmDesignation.setText(null);
                    clmContact.setText(null);
                    clmAddress.setText(null);
                    clmState.setText(null);
                    clmYear.setText(null);


                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Delete Student");
                    alert.setHeaderText(null);
                    alert.setContentText("There is an error deleting Student");
                    alert.showAndWait();
                }
            }
        } catch(SQLException ex){
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    void btnPrint(ActionEvent event) throws SQLException, ClassNotFoundException {

        String id = clmID.getText();

        Connection conn = DBConnection.getDBConnection().getConnection();
        try {
            InputStream report1 = getClass().getResourceAsStream("/Reports/StudentAdmission.jrxml");
            InputStream report2 = getClass().getResourceAsStream("/Reports/StudentInfo.jrxml");

            JRDesignQuery query = new JRDesignQuery();

            JasperDesign jd1 = JRXmlLoader.load(report1);
            query.setText("select * from students where id = '" + id + "'");
            jd1.setQuery(query);
            ReportViewController r = new ReportViewController();
            r.viewReport(jd1);

            JasperDesign jd2 = JRXmlLoader.load(report2);
            query.setText("select * from students where id = '" + id + "'");
            jd2.setQuery(query);
            ReportViewController r2 = new ReportViewController();
            r.viewReport(jd2);


        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    //Update Method
    @FXML
    void btnUpdate(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {


        int id = Integer.parseInt (clmID.getText ());
        String name = clmStudentName.getText ();
        String classes = clmClasses.getText ();
        String gender = String.valueOf (clmGender.getItems ());
        String dob = String.valueOf ((clmDOB.getValue ()));
        String admitted = String.valueOf ((clmDateAdmitted.getValue ()));
        String department = clmDesignation.getText ();
        String disability = clmDisability.getText ();
        String designation = clmDesignation.getText ();
        String contact = clmContact.getText ();
        String address = clmAddress.getText ();
        String state = clmState.getText ();
        String year = clmYear.getText ();

        Student s;
        s = new Student (id, name, classes, gender, dob, admitted, department, disability, designation, contact, address, state, year);


        int i = updateStudent (s);

        int d = updateOldStudent (s);

        if (d > 0) {
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle ("Student Management");
            alert.setHeaderText (null);
            alert.setContentText ("Student " + name + " Updated Successfully..!");
            alert.showAndWait ();

            AdNo1.setText (null);
            clmID.setText (null);
            clmStudentName.setText (null);
            clmStudentName.setText (null);
            clmClasses.setText (null);
            clmGender.setValue (null);
            clmDOB.setValue (null);
            clmDateAdmitted.setValue (null);
            clmDepartment.setText (null);
            clmDisability.setText (null);
            clmDesignation.setText (null);
            clmContact.setText (null);
            clmAddress.setText (null);
            clmState.setText (null);
            clmYear.setText (null);
        } else if (i > 0) {

            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle ("Student Management");
            alert.setHeaderText (null);
            alert.setContentText ("Student " + name + " Updated Successfully..!");
            alert.showAndWait ();

            AdNo.setText (null);
            AdNo1.setText (null);
            clmID.setText (null);
            clmStudentName.setText (null);
            clmClasses.setText (null);
            clmGender.setValue (null);
            clmDOB.setValue (null);
            clmDateAdmitted.setValue (null);
            clmDepartment.setText (null);
            clmDisability.setText (null);
            clmDesignation.setText (null);
            clmContact.setText (null);
            clmAddress.setText (null);
            clmState.setText (null);
            clmYear.setText (null);

        } else {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle ("Student Management");
            alert.setHeaderText (null);
            alert.setContentText ("OOPs there is an error updating Student..!");
            alert.showAndWait ();
        }


    }



    //Search Method
    @FXML
    void searchStudent(ActionEvent event) {

        try {
            int adNo = Integer.parseInt(AdNo.getText());
            Student s = StudentController.searchStudent(adNo);
            if (s != null) {
                clmID.setText(String.valueOf(s.getId ()));
                clmStudentName.setText(s.getName ());
                clmClasses.setText(s.getClasses ());
                clmGender.setValue (s.getGender ());
                clmDOB.setValue (LocalDate.parse (s.getDob ()));
                clmDateAdmitted.setValue (LocalDate.parse (s.getAdmitted ()));
                clmDepartment.setText(s.getDepartment ());
                clmDisability.setText(s.getDisability ());
                clmDesignation.setText(s.getDesignation ());
                clmContact.setText(s.getContact ());
                clmAddress.setText(s.getAddress());
                clmState.setText(s.getState ());
                clmYear.setText(s.getYear ());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Student Search");
                alert.setHeaderText(null);
                alert.setContentText("Student Not Found");
                alert.showAndWait();

                AdNo.setText(null);
                clmID.setText(null);
                clmStudentName.setText(null);
                clmClasses.setText(null);
                clmGender.setValue (null);
                clmDOB.setValue (null);
                clmDateAdmitted.setValue (null);
                clmDepartment.setText(null);
                clmDisability.setText(null);
                clmDesignation.setText(null);
                clmContact.setText(null);
                clmAddress.setText(null);
                clmState.setText(null);
                clmYear.setText(null);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void searchPastStudent(ActionEvent event) {
        try {
            int id = Integer.parseInt(AdNo1.getText());
            Student s = StudentController.searchPastStudent(id);
            if (s != null) {
                clmID.setText(String.valueOf(s.getId()));
                clmStudentName.setText(s.getName());
                clmClasses.setText(s.getClasses());
                clmGender.setValue(s.getGender());
                clmDOB.setValue (LocalDate.parse (s.getDob()));
                clmDateAdmitted.setValue (LocalDate.parse (s.getAdmitted()));
                clmDepartment.setText(s.getDepartment());
                clmDisability.setText(s.getDisability());
                clmDesignation.setText(s.getDesignation());
                clmContact.setText(s.getContact());
                clmAddress.setText(s.getAddress());
                clmState.setText(s.getState());
                clmYear.setText(s.getYear());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Student Search");
                alert.setHeaderText(null);
                alert.setContentText("Student Not Found");
                alert.showAndWait();

                AdNo.setText(null);
                clmID.setText(null);
                clmStudentName.setText(null);
                clmClasses.setText(null);
                clmGender.setValue(null);
                clmDOB.setValue (null);
                clmDateAdmitted.setValue (null);
                clmDepartment.setText(null);
                clmDisability.setText(null);
                clmDesignation.setText(null);
                clmContact.setText(null);
                clmAddress.setText(null);
                clmState.setText(null);
                clmYear.setText(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }



    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/student/StudentManagement.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }




}