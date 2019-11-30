package controller.school;

import animatefx.animation.Pulse;
import controller.ReportViewController;
import db.DBConnection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import dbController.SchoolController;
import Model.School;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import db.TableSchema;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import dbController.StudentController;
import javafx.scene.control.Button;



public class AboutSchoolController implements Initializable {


    @FXML
    private AnchorPane root;
    @FXML
    private Button btnBack;
    @FXML
    private JFXTextField schoolNameField;
    @FXML
    private JFXTextField postalCodeField;
    @FXML
    private JFXTextField totalStaffField;
    @FXML
    private JFXTextField policeAreaField;
    @FXML
    private JFXTextField totalStudentField;
    @FXML
    private JFXTextField lgaField;
    @FXML
    private JFXTextField totalLandAreaField;
    @FXML
    private JFXTextField provinceField;
    @FXML
    private JFXTextField principalNumberField;
    @FXML
    private JFXTextField principalNameField;
    @FXML
    private JFXTextField schoolExamIDField;
    @FXML
    private JFXTextField schoolIDField;
    @FXML
    private JFXTextField dateEstablishedField;
    @FXML
    private JFXTextField municipalField;
    @FXML
    private JFXTextField adminDistrictField;
    @FXML
    private JFXTextField eduDistrictField;
    @FXML
    private JFXTextField eduZoneField;
    @FXML
    private JFXTextField schoolTypeField;
    @FXML
    private JFXTextField classAvailableField;
    @FXML
    private JFXTextField schoolAddressField;
    @FXML
    private JFXTextField schoolLocationField;
    @FXML
    private JFXTextField censusNumberField;
    @FXML
    private Button printDetails;
    @FXML
    private Button updateDetails;
    @FXML
    private JFXTextField stateField;
    @FXML
    private JFXTextField eMailField;
    @FXML
    private Button printDetails1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            School s = SchoolController.schoolInfo();
            if (s != null) {
                schoolNameField.setText(String.valueOf(s.getSchoolName()));
                schoolAddressField.setText(String.valueOf(s.getSchoolAddress()));
                classAvailableField.setText(String.valueOf(s.getClassAvailable()));
                schoolTypeField.setText(String.valueOf(s.getSchoolType()));
                eduZoneField.setText(String.valueOf(s.getEducationalZone()));
                eduDistrictField.setText(String.valueOf(s.getEducationalDistrict()));
                adminDistrictField.setText(String.valueOf(s.getAdministrativeDistrict()));
                municipalField.setText(String.valueOf(s.getMunicipal()));
                lgaField.setText(String.valueOf(s.getLga()));
                policeAreaField.setText(String.valueOf(s.getPoliceArea()));
                postalCodeField.setText(String.valueOf(s.getPostalCode()));
                dateEstablishedField.setText(String.valueOf(s.getDateEstablished()));
                schoolIDField.setText(String.valueOf(s.getSchoolID()));
                censusNumberField.setText(String.valueOf(s.getCensusNo()));
                schoolExamIDField.setText(String.valueOf(s.getSchoolExamID()));
                principalNameField.setText(String.valueOf(s.getPrincipalName()));
                principalNumberField.setText(String.valueOf(s.getPrincipalNo()));
                provinceField.setText(String.valueOf(s.getProvince()));
                totalLandAreaField.setText(String.valueOf(s.getTotalLandArea()));
                totalStudentField.setText(String.valueOf(s.getTotalStudent()));
                totalStaffField.setText(String.valueOf(s.getTotalStaff()));
                schoolLocationField.setText(String.valueOf(s.getLocation()));
                stateField.setText(String.valueOf(s.getState()));
                eMailField.setText(String.valueOf(s.getEmail()));


            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("No Information Found..!");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SchoolController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }



    void addDetails(ActionEvent event) {            //This Method Button Removed Due to Unwanted
        try {
            String schoolName = schoolNameField.getText();
            String schoolAddress = schoolAddressField.getText();
            String classAvailable = classAvailableField.getText();
            String schoolType = schoolTypeField.getText();
            String educationalZone = eduZoneField.getText();
            String educationalDistrict = eduDistrictField.getText();
            String administrativeDistrict = adminDistrictField.getText();
            String municipal = municipalField.getText();
            String lga = lgaField.getText();
            String policeArea = policeAreaField.getText();
            String postalCode = postalCodeField.getText();
            String dateEstablished = dateEstablishedField.getText();
            String schoolID = schoolIDField.getText();
            String censusNo = censusNumberField.getText();
            String schoolExamID = schoolExamIDField.getText();
            String principalName = principalNameField.getText();
            String principalNo = principalNumberField.getText();
            String province = provinceField.getText();
            String totalLandArea = totalLandAreaField.getText();
            String totalStudent = totalStudentField.getText();
            String totalStaff = totalStaffField.getText();
            String location = schoolLocationField.getText();
            String state = stateField.getText();
            String email = eMailField.getText();


            School sch = new School(schoolName, schoolAddress, classAvailable, schoolType, educationalZone, educationalDistrict, administrativeDistrict, municipal, lga, policeArea, postalCode, dateEstablished, schoolID, censusNo, schoolExamID, principalName, principalNo, province, totalLandArea, totalStudent, totalStaff, location, email, state);
            int i = SchoolController.AddDetails(sch);

            if (i > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("Updated Successfully");
                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("OOPs there is an error in Updating Details..!");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    void printDetails(ActionEvent event) throws SQLException, ClassNotFoundException {


        Connection conn = DBConnection.getDBConnection().getConnection();



        try {
            InputStream report = getClass().getResourceAsStream("/Reports/SchoolInfos.jrxml");
            JasperDesign jd = JRXmlLoader.load(report);
            JRDesignQuery query = new JRDesignQuery();
            query.setText("select * from schoolinfo");
            jd.setQuery(query);
            ReportViewController r = new ReportViewController();
            r.viewReport(jd);


        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void updateDetails(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        try {
            String schoolName = schoolNameField.getText();
            String schoolAddress = schoolAddressField.getText();
            String classAvailable = classAvailableField.getText();
            String schoolType = schoolTypeField.getText();
            String educationalZone = eduZoneField.getText();
            String educationalDistrict = eduDistrictField.getText();
            String administrativeDistrict = adminDistrictField.getText();
            String municipal = municipalField.getText();
            String lga = lgaField.getText();
            String policeArea = policeAreaField.getText();
            String postalCode = postalCodeField.getText();
            String dateEstablished = dateEstablishedField.getText();
            String schoolID = schoolIDField.getText();
            String censusNo = censusNumberField.getText();
            String schoolExamID = schoolExamIDField.getText();
            String principalName = principalNameField.getText();
            String principalNo = principalNumberField.getText();
            String province = provinceField.getText();
            String totalLandArea = totalLandAreaField.getText();
            String totalStudent = totalStudentField.getText();
            String totalStaff = totalStaffField.getText();
            String location = schoolLocationField.getText();
            String state = stateField.getText();
            String email = eMailField.getText();

            School sch = new School(schoolName, schoolAddress, classAvailable, schoolType, educationalZone, educationalDistrict, administrativeDistrict, municipal, lga, policeArea, postalCode, dateEstablished, schoolID, censusNo, schoolExamID, principalName, principalNo, province, totalLandArea, totalStudent, totalStaff, location, state, email);
            int i = SchoolController.updateDetails(sch);

            if (i > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("Information Updated Successfully...!");
                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("OOPs there is an error Updating Details");
                alert.showAndWait();
            }

        }catch (SQLException ex) {
            Logger.getLogger(SchoolController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }

    }

    @FXML
    private void btnBackHomeOnAction(javafx.event.ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new Pulse (home).play ();
    }

}
