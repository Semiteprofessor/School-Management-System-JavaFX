/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.classes.SS3.Art;

import Model.Bursary;
import Model.Syllabus;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.ReportViewController;
import db.DBConnection;
import dbController.BursaryController;
import dbController.StudentController;
import dbController.SyllabusController;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class manageSubjectController implements Initializable {

    @FXML
    private AnchorPane manageStudents;
    @FXML
    private Button btnBack;
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
    @FXML
    private JFXTextField clmID;
    @FXML
    private JFXTextField clmName;
    @FXML
    private JFXTextField clmTeacher;
    @FXML
    private JFXComboBox<String> clmTerm;

    ObservableList<String> term = FXCollections.observableArrayList("First", "Second", "Third");
    @FXML
    private TextArea clmOutline;
    @FXML
    private TextArea clmNote;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        clmTerm.setItems(term);
    }


    void SearchStudent(ActionEvent event) {

        try {

            String name = AdNo.getText();
            Syllabus s = SyllabusController.searchSyllabusByName (name);
            if (s != null) {
                clmID.setText(String.valueOf(s.getId()));
                clmName.setText(s.getName());
                clmTeacher.setText(s.getTeacher ());
                clmTerm.setValue(s.getTerm ());
                clmOutline.setText (s.getOutline ());
                clmNote.setText (s.getNote ());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Subject Search");
                alert.setHeaderText(null);
                alert.setContentText("Subject Not Found");
                alert.showAndWait();


                AdNo.setText(null);
                clmID.setText(null);
                clmName.setText(null);
                clmTeacher.setText(null);
                clmTerm.setValue(null);
                clmOutline.setText (null);
                clmNote.setText (null);
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
            Integer id = Integer.valueOf (clmID.getText ());
            Syllabus s = new Syllabus (Integer.parseInt (clmID.getText ()),
                    clmName.getText (),
                    clmTeacher.getText (),
                    clmTerm.getValue (),
                    clmOutline.getText (),
                    clmNote.getText ());

            if (AdNo.getText ().isEmpty ()) {


                int deleteSyllabus = SyllabusController.deleteSyllabus (id);
                if (deleteSyllabus > 0) {

                    Alert alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle ("Delete Subject");
                    alert.setHeaderText (null);
                    alert.setContentText ("Subject " + id + " has been deleted successfully..!");
                    alert.showAndWait ();


                    AdNo.setText (null);
                    clmID.setText (null);
                    clmName.setText (null);
                    clmTeacher.setText (null);
                    clmTerm.setValue (null);
                    clmOutline.setText (null);
                    clmNote.setText (null);


                } else {
                    Alert alert = new Alert (Alert.AlertType.ERROR);
                    alert.setTitle ("Delete Subject");
                    alert.setHeaderText (null);
                    alert.setContentText ("There is an error deleting Subject");
                    alert.showAndWait ();
                }
            } else {
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle ("Delete Subject");
                alert.setHeaderText (null);
                alert.setContentText ("There is an error deleting Subject");
                alert.showAndWait ();
            }
        } catch (SQLException e) {
            e.printStackTrace ();
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
        String name = clmName.getText();
        String classes = clmTeacher.getText();
        String term = clmTerm.getValue ();
        String payment1 = clmOutline.getText ();
        String payment2 = clmNote.getText ();

        Syllabus s;
        s = new Syllabus (id, name, classes, term, payment1, payment2);
        int i = SyllabusController.updateSyllabus (s);

        if (i > 0) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Management");
            alert.setHeaderText(null);
            alert.setContentText("Student " + id + " Updated Successfully..!");
            alert.showAndWait();


            AdNo.setText(null);
            clmID.setText(null);
            clmName.setText(null);
            clmTeacher.setText(null);
            clmOutline.setText (null);
            clmNote.setText (null);

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
                clmName.setText(s.getName());
                clmTeacher.setText(s.getClasses());
                clmTerm.setValue(s.getTerm ());
                clmOutline.setText (s.getFirst_payment ());
                clmNote.setText (s.getSecond_payment ());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Student Search");
                alert.setHeaderText(null);
                alert.setContentText("Student Not Found");
                alert.showAndWait();

                AdNo.setText(null);
                clmID.setText(null);
                clmName.setText(null);
                clmTeacher.setText(null);
                clmTerm.setValue(null);
                clmOutline.setText (null);
                clmNote.setText (null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load (getClass ().getResource ("/View/classes/JS1/subject.fxml"));
        Node node = (Node) event.getSource ();
        Stage stage = (Stage) node.getScene ().getWindow ();
        stage.setScene (new Scene (home));
    }



}
