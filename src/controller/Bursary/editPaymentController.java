/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Bursary;

import Model.Bursary;
import Model.Student;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.ReportViewController;
import db.DBConnection;
import db.TableSchema;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import dbController.BursaryController;
import dbController.StudentController;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import static dbController.StudentController.*;
import static dbController.StudentController.updateStudent;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class editPaymentController implements Initializable {

    @FXML
    private JFXTextField clmStudentName;
    @FXML
    private JFXTextField clmClasses;
    @FXML
    private JFXTextField clmPayment1;
    @FXML
    private JFXTextField clmPayment2;
    @FXML
    private JFXTextField clmPayment3;
    @FXML
    private JFXTextField clmActualFee;
    @FXML
    private JFXTextField clmID;
    @FXML
    private JFXTextField clmArrears;
    @FXML
    private JFXComboBox<String> clmPaymentMode;
    @FXML
    private JFXComboBox<String> clmPaymentStatus;
    @FXML
    private JFXComboBox<String> clmTerm;
    @FXML
    private ImageView imageViewPatientImage;
    @FXML
    private Button btnPrint;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private TextField AdNo;
    @FXML
    private Button searchStudent;



    ObservableList<String> term = FXCollections.observableArrayList("First", "Second", "Third");
    ObservableList<String> mode = FXCollections.observableArrayList("Cash", "Bank Deposit", "Transfer", "POS");
    ObservableList<String> status = FXCollections.observableArrayList("Fully Paid", "Not Paid", "Balanced", "Not Balanced");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        clmPaymentMode.setItems(term);
        clmPaymentMode.setItems(mode);
        clmPaymentMode.setItems(status);
    }


    void SearchStudent(ActionEvent event) {

        try {

            String name = AdNo.getText();
            Bursary s = BursaryController.searchBursaryByName(name);
            if (s != null) {
                clmID.setText(String.valueOf(s.getId()));
                clmStudentName.setText(s.getName());
                clmClasses.setText(s.getClasses());
                clmTerm.setValue(s.getTerm ());
                clmPayment1.setText (s.getFirst_payment ());
                clmPayment2.setText (s.getSecond_payment ());
                clmPayment3.setText(s.getThird_payment ());
                clmActualFee.setText (s.getActual_fee ());
                clmPaymentStatus.setValue (s.getStatus ());
                clmPaymentMode.setValue (s.getMode_of_payment ());
                clmArrears.setText(s.getArrears ());


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
                clmTerm.setValue(null);
                clmPayment1.setText (null);
                clmPayment2.setText (null);
                clmPayment3.setText(null);
                clmActualFee.setText(null);
                clmPaymentStatus.setValue (null);
                clmPaymentMode.setValue (null);
                clmArrears.setText(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BursaryController.class.getName()).log(Level.SEVERE, null, ex);
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
            Bursary s = new Bursary (Integer.parseInt(clmID.getText()),
                    clmStudentName.getText(),
                    clmClasses.getText(),
                    clmTerm.getValue(),
                    clmPayment1.getText (),
                    clmPayment2.getText (),
                    clmPayment3.getText(),
                    clmActualFee.getText(),
                    clmPaymentStatus.getValue (),
                    clmPaymentMode.getValue (),
                    clmArrears.getText());

            if(AdNo.getText().isEmpty()) {

                int moveBursary = BursaryController.moveBursary (s);
                if (moveBursary > 0) {

                    int deleteBursary = BursaryController.deleteBursary (id);
                    if (deleteBursary > 0) {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Delete Student");
                        alert.setHeaderText(null);
                        alert.setContentText("Student " + id + " has been deleted successfully..!");
                        alert.showAndWait();


                        AdNo.setText(null);
                        clmID.setText(null);
                        clmStudentName.setText(null);
                        clmClasses.setText(null);
                        clmTerm.setValue(null);
                        clmPayment1.setText (null);
                        clmPayment2.setText (null);
                        clmPayment3.setText(null);
                        clmActualFee.setText(null);
                        clmPaymentStatus.setValue (null);
                        clmPaymentMode.setValue (null);
                        clmArrears.setText(null);


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
             else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Delete Student");
                    alert.setHeaderText(null);
                    alert.setContentText("There is an error deleting Student");
                    alert.showAndWait();
                }

        } catch(SQLException ex){
            Logger.getLogger(BursaryController.class.getName()).log(Level.SEVERE, null, ex);
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


        int id = Integer.parseInt(clmID.getText());
        String name = clmStudentName.getText();
        String classes = clmClasses.getText();
        String term = clmTerm.getValue ();
        String payment1 = clmPayment1.getText ();
        String payment2 = clmPayment2.getText ();
        String payment3 = clmPayment3.getText ();
        String actual = clmActualFee.getText();
        String status = clmPaymentStatus.getValue ();
        String mode = clmPaymentMode.getValue ();
        String arrears = clmArrears.getText();

        Bursary s;
        s = new Bursary (id, name, classes, term, payment1, payment2, payment3, actual, status, mode, arrears);
        int i = BursaryController.updateBursary (s);

       if (i > 0) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Management");
            alert.setHeaderText(null);
            alert.setContentText("Student " + id + " Updated Successfully..!");
            alert.showAndWait();


            AdNo.setText(null);
            clmID.setText(null);
            clmStudentName.setText(null);
            clmClasses.setText(null);
            clmTerm.setValue(null);
            clmPayment1.setText (null);
            clmPayment2.setText (null);
            clmPayment3.setText(null);
            clmActualFee.setText(null);
            clmPaymentStatus.setValue (null);
            clmPaymentMode.setValue (null);
            clmArrears.setText(null);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Student Management");
            alert.setHeaderText(null);
            alert.setContentText("OOPs there is an error updating Student..!");
            alert.showAndWait();
        }
    }



    //Search Method
    @FXML
    void searchStudent(ActionEvent event) {
        try {
            int id = Integer.parseInt(AdNo.getText());
            Bursary s = BursaryController.searchBursary (id);
            if (s != null) {
                clmID.setText(String.valueOf(s.getId()));
                clmStudentName.setText(s.getName());
                clmClasses.setText(s.getClasses());
                clmTerm.setValue(s.getTerm ());
                clmPayment1.setText (s.getFirst_payment ());
                clmPayment2.setText (s.getSecond_payment ());
                clmPayment3.setText(s.getThird_payment ());
                clmActualFee.setText (s.getActual_fee ());
                clmPaymentStatus.setValue (s.getStatus ());
                clmPaymentMode.setValue (s.getMode_of_payment ());
                clmArrears.setText(s.getArrears ());


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
                clmTerm.setValue(null);
                clmPayment1.setText (null);
                clmPayment2.setText (null);
                clmPayment3.setText(null);
                clmActualFee.setText(null);
                clmPaymentStatus.setValue (null);
                clmPaymentMode.setValue (null);
                clmArrears.setText(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Bursary/bursary.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void selectPatientImageOnAction(ActionEvent event) {
    }


}
