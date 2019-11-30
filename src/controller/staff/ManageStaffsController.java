package controller.staff;

import com.jfoenix.controls.JFXButton;
import controller.student.StudentManagementController;
import controller.student.addStudentController;
import dbController.StaffController;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import db.TableSchema;
import static dbController.StaffController.*;
import static dbController.StaffController.updateStaff;
import Model.Staff;
import Model.Student;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import controller.ReportViewController;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;


public class ManageStaffsController implements Initializable {

    @FXML
    private AnchorPane manageStudents;
    @FXML
    private Button btnBack;
    @FXML
    private JFXTextField clmStaffName;
    @FXML
    private JFXTextField clmClasses;
    @FXML
    private JFXTextField clmPosition;
    @FXML
    private JFXTextField clmDegree;
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
    private JFXDatePicker clmHired;
    @FXML
    private JFXTextField clmEmail;
    @FXML
    private JFXTextField clmDepartment;
    @FXML
    private JFXTextField clmSalary;
    @FXML
    private JFXComboBox<String> clmGender;

    ObservableList<String> list = FXCollections.observableArrayList("Male", "Female");
    @FXML
    private Button printStaff;
    @FXML
    private Button deleteStaff;
    @FXML
    private Button update;
    @FXML
    private TextField EmpNo;
    @FXML
    private TextField empName;
    @FXML
    private TextField empNoOld;
    @FXML
    private Button searchStaff;
    @FXML
    private Button searchByName;
    @FXML
    private Button searchOldStaff;
    @FXML
    private ImageView imageViewStudentImage;
    @FXML
    private Button selectImage;

    public ManageStaffsController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        clmGender.setItems(list);

    }



    @FXML
    void searchByName(ActionEvent event) {

        try {

            String name = empName.getText();
            Staff s = searchStaffByName(name);
            if (s != null) {
                clmID.setText(String.valueOf(s.getId()));
                clmStaffName.setText(s.getName());
                clmClasses.setText(s.getClasses());
                clmGender.setValue(s.getGender ());
                clmDepartment.setText(s.getDepartment());
                clmPosition.setText(s.getPosition());
                clmDOB.setValue(LocalDate.parse (s.getDob()));
                clmHired.setValue(LocalDate.parse (s.getHired()));
                clmDegree.setText(s.getDegree());
                clmSalary.setText(s.getSalary());
                clmContact.setText(s.getContact());
                clmEmail.setText(s.getEmail());
                clmAddress.setText(s.getAddress());
                clmState.setText(s.getState());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Staff Search");
                alert.setHeaderText(null);
                alert.setContentText("Staff Not Found");
                alert.showAndWait();

                clmID.setText(null);
                clmStaffName.setText(null);
                clmClasses.setText(null);
                clmGender.setValue(null);
                clmDepartment.setText(null);
                clmPosition.setText(null);
                clmDOB.setValue(null);
                clmHired.setValue(null);
                clmContact.setText(null);
                clmEmail.setText(null);
                clmAddress.setText(null);
                clmState.setText(null);
                empName.setText(null);
                empNoOld.setText(null);
                EmpNo.setText(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    void searchOldStaff(ActionEvent event) {

        try {


            int id = Integer.parseInt(empNoOld.getText());
            Staff s = StaffController.searchOldStaff(id);
            if (s != null) {
                clmID.setText(String.valueOf(s.getId()));
                clmStaffName.setText(s.getName());
                clmClasses.setText(s.getClasses());
                clmGender.setValue(s.getDepartment());
                clmDepartment.setText(s.getDepartment());
                clmPosition.setText(s.getPosition());
                clmDOB.setValue (LocalDate.parse (s.getDob()));
                clmHired.setValue (LocalDate.parse (s.getHired()));
                clmDegree.setText(s.getDegree());
                clmSalary.setText(s.getSalary());
                clmContact.setText(s.getContact());
                clmEmail.setText(s.getEmail());
                clmAddress.setText(s.getAddress());
                clmState.setText(s.getState());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Staff Search");
                alert.setHeaderText(null);
                alert.setContentText("Staff Not Found");
                alert.showAndWait();

                clmID.setText(null);
                clmStaffName.setText(null);
                clmClasses.setText(null);
                clmGender.setValue(null);
                clmDepartment.setText(null);
                clmPosition.setText(null);
                clmDOB.setValue (null);
                clmHired.setValue (null);
                clmContact.setText(null);
                clmEmail.setText(null);
                clmAddress.setText(null);
                clmState.setText(null);
                empName.setText(null);
                empNoOld.setText(null);
                EmpNo.setText(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    void searchStaff(ActionEvent event) {

        try {

            int id = Integer.parseInt(EmpNo.getText());
            Staff s = StaffController.searchStaff(id);
            if (s != null) {
                clmID.setText(String.valueOf(s.getId()));
                clmStaffName.setText(s.getName());
                clmClasses.setText(s.getClasses());
                clmGender.setValue(s.getGender());
                clmDOB.setValue (LocalDate.parse (s.getDob()));
                clmHired.setValue (LocalDate.parse (s.getHired()));
                clmDepartment.setText(s.getDepartment());
                clmPosition.setText(s.getPosition());
                clmDegree.setText(s.getDegree());
                clmSalary.setText(s.getSalary());
                clmContact.setText(s.getContact());
                clmEmail.setText(s.getEmail());
                clmAddress.setText(s.getAddress());
                clmState.setText(s.getState());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Staff Search");
                alert.setHeaderText(null);
                alert.setContentText("Staff Not Found");
                alert.showAndWait();

                clmID.setText(null);
                clmStaffName.setText(null);
                clmClasses.setText(null);
                clmGender.setValue(null);
                clmDepartment.setText(null);
                clmPosition.setText(null);
                clmDOB.setValue (null);
                clmHired.setValue (null);
                clmDegree.setText(null);
                clmSalary.setText(null);
                clmContact.setText(null);
                clmEmail.setText(null);
                clmAddress.setText(null);
                clmState.setText(null);
                empName.setText(null);
                empNoOld.setText(null);
                EmpNo.setText(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    void deleteStaff(ActionEvent event) {

        try {
            int id = Integer.parseInt(clmID.getText());
            Staff s = new Staff(Integer.parseInt(clmID.getText()),
                    clmStaffName.getText(),
                    clmClasses.getText(),
                    clmGender.getValue(),
                    clmDOB.getValue (),
                    clmHired.getValue (),
                    clmPosition.getText(),
                    clmDepartment.getText(),
                    clmDegree.getText(),
                    clmSalary.getText(),
                    clmContact.getText(),
                    clmEmail.getText(),
                    clmAddress.getText(),
                    clmState.getText());

            int moveStaff = StaffController.moveStaff(s);
            if (moveStaff > 0) {

                int deleteStaff = StaffController.deleteStaff(id);
                if (deleteStaff > 0) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff " + id + " Has Been Deleted Successfully..!");
                    alert.showAndWait();

                    clmID.setText(null);
                    clmStaffName.setText(null);
                    clmClasses.setText(null);
                    clmGender.setValue(null);
                    clmDOB.setValue (null);
                    clmHired.setValue (null);
                    clmPosition.setText(null);
                    clmDepartment.setText(null);
                    clmDegree.setText(null);
                    clmSalary.setText(null);
                    clmContact.setText(null);
                    clmEmail.setText(null);
                    clmAddress.setText(null);
                    clmState.setText(null);


                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("There is an error deleting Staff..!");
                    alert.showAndWait();
                }
            }
        } catch(SQLException ex){
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    void printStaff(ActionEvent event) throws JRException {



            String id = clmID.getText ();

            InputStream report1 = getClass ().getResourceAsStream ("/Reports/StaffInfo.jrxml");
            InputStream report2 = getClass ().getResourceAsStream ("/Reports/StaffInfoPast.jrxml");

            JRDesignQuery query = new JRDesignQuery ();


            JasperDesign jd = JRXmlLoader.load (report1);
            query.setText ("select * from staffs where id = '" + id + "'");
            jd.setQuery (query);
            ReportViewController r1 = new ReportViewController ();
            r1.viewReport (jd);


            JasperDesign jd2 = JRXmlLoader.load (report2);
            query.setText ("select * from oldstaffs where id = '" + id + "'");
            jd2.setQuery (query);
            ReportViewController r2 = new ReportViewController ();
            r2.viewReport (jd2);


    }


    @FXML
    void update(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {

                int id = Integer.parseInt(clmID.getText());
                String name = clmStaffName.getText();
                String classes = clmClasses.getText();
                String gender = clmGender.getValue();
                String dob = String.valueOf (((clmDOB.getValue ())));
                String hired = String.valueOf (((clmHired.getValue ())));
                String department = clmDepartment.getText();
                String position = clmPosition.getText();
                String degree = clmDegree.getText();
                String salary = clmSalary.getText();
                String contact = clmContact.getText();
                String email = clmEmail.getText();
                String address = clmAddress.getText();
                String state = clmState.getText();

                Staff s = new Staff(id, name, classes, gender, dob, hired, department, position, degree, salary, contact, email, address, state);

                int i = updateStaff(s);

                int d = updateOldStaff(s);


        if (d > 0){

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff  " + name + " Information Updated Successfully..!");
                    alert.showAndWait();


            EmpNo.getText ();
            clmID.setText(null);
            clmStaffName.setText(null);
            clmClasses.setText(null);
            clmGender.setValue(null);
            clmDepartment.setText(null);
            clmPosition.setText(null);
            clmDOB.setValue (null);
            clmHired.setValue (null);
            clmDegree.setText(null);
            clmSalary.setText(null);
            clmContact.setText(null);
            clmEmail.setText(null);
            clmAddress.setText(null);
            clmState.setText(null);

                }
                else if (i > 0) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff  " + name + " Information Updated Successfully..!");
                    alert.showAndWait();

                clmID.setText(null);
                clmStaffName.setText(null);
                clmClasses.setText(null);
                clmGender.setValue(null);
                clmDepartment.setText(null);
                clmPosition.setText(null);
                clmDOB.setValue (null);
                clmHired.setValue (null);
                clmDegree.setText(null);
                clmSalary.setText(null);
                clmContact.setText(null);
                clmEmail.setText(null);
                clmAddress.setText(null);
                clmState.setText(null);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("OOPS there is an error updating Staff..!");
                    alert.showAndWait();
                }
            }


    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/staff/StaffManagement.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

}

