/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.classes.SS2.Science;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Bursary;
import controller.ReportViewController;
import db.DBConnection;
import dbController.TermController;
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
import Model.Syllabus;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class subjectController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TextField tfSearch;
    @FXML
    private TableView<Syllabus> tableView;
    @FXML
    private TableColumn<Syllabus, String> clmID1;
    @FXML
    private TableColumn<Syllabus, String> clmID;
    @FXML
    private Button printPayment;
    @FXML
    private Button checkPayment;
    @FXML
    private Button addPayment;
    @FXML
    private ComboBox<String> loadTerm;
    @FXML
    private Button editPayment;
    @FXML
    private TableColumn<Syllabus, String> clmName;
    @FXML
    private TableColumn<Syllabus, String> clmTeacher;
    @FXML
    private TableColumn<Syllabus, String> clmOutline;
    @FXML
    private TableColumn<Syllabus, String> clmNote;
    @FXML
    private TableColumn<Syllabus, String> clmTerm;


    ObservableList<Syllabus> oblist = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTerm.getItems().addAll("First", "Second", "Third", "None");

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
            resultSet = conn.createStatement ().executeQuery ("SELECT * FROM classsubject");
        } catch (SQLException e) {
            e.printStackTrace ();
        }


        try {
            while (resultSet.next ()) {
                oblist.addAll (new Syllabus (
                        resultSet.getInt ("id"),
                        resultSet.getString ("name"),
                        resultSet.getString ("teacher"),
                        resultSet.getString ("outline"),
                        resultSet.getString ("term"),
                        resultSet.getString ("note")
                ));


                clmID.setCellValueFactory (new PropertyValueFactory<> ("id"));
                clmName.setCellValueFactory (new PropertyValueFactory<> ("name"));
                clmTeacher.setCellValueFactory (new PropertyValueFactory<> ("teacher"));
                clmOutline.setCellValueFactory (new PropertyValueFactory<> ("outline"));
                clmTerm.setCellValueFactory (new PropertyValueFactory<> ("term"));
                clmNote.setCellValueFactory (new PropertyValueFactory<> ("note"));

                tableView.setItems (oblist);

            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    void setLoadTerm() {
        ArrayList arrayList = null;
        try {
            arrayList = TermController.getTerm();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
        ObservableList observableArray = FXCollections.observableArrayList();

        if (observableArray != null) {
            loadTerm.setItems(observableArray);
        }
    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load (getClass ().getResource ("/View/classes/SS2/Science/SS2.fxml"));
        Node node = (Node) event.getSource ();
        Stage stage = (Stage) node.getScene ().getWindow ();
        stage.setScene (new Scene (home));
    }

    @FXML
    private void tfSearchOnAction(ActionEvent event) {
    }

    @FXML
    private void handleSearchButton(ActionEvent event) {
    }

    @FXML
    private void btnPrintPayment(ActionEvent event)  throws SQLException, ClassNotFoundException {

        tableView.getItems().clear();
        String term = loadTerm.getValue();

        Connection conn = DBConnection.getDBConnection().getConnection();
        try {
            InputStream report1 = getClass().getResourceAsStream("/Reports/SyllabusFirst.jrxml");
            InputStream report2 = getClass().getResourceAsStream("/Reports/SyllabusSecond.jrxml");
            InputStream report3 = getClass().getResourceAsStream("/Reports/SyllabusThird.jrxml");

            JRDesignQuery query = new JRDesignQuery();

            JasperDesign jd1 = JRXmlLoader.load(report1);
            query.setText("select * from classsubject where term = 'First'");
            jd1.setQuery(query);
            ReportViewController r = new ReportViewController();
            r.viewReport(jd1);

            JasperDesign jd2 = JRXmlLoader.load(report2);
            query.setText("select * from classsubject where term = 'Second'");
            jd2.setQuery(query);
            ReportViewController r2 = new ReportViewController();
            r.viewReport(jd2);

            JasperDesign jd3 = JRXmlLoader.load(report2);
            query.setText("select * from classsubject where term = 'Third'");
            jd2.setQuery(query);
            ReportViewController r3 = new ReportViewController();
            r.viewReport(jd3);


        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void btnCheckPayment(ActionEvent event) {

        try {
            tableView.getItems().clear();
            String term = loadTerm.getValue();

            Connection conn = DBConnection.getDBConnection().getConnection();

            // if((loadGrades != null)&&(loadGender != null)){


            if (term == "First") {

                String sql = "select * from classsubject WHERE term = 'First'";
                ResultSet rs = conn.createStatement().executeQuery(sql);

                while (rs.next()) {
                    Syllabus s = new Syllabus (rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("teacher"),
                            rs.getString("outline"),
                            rs.getString("term"),
                            rs.getString("note"));
                    oblist.add(s);
                }
            }
            if (term == "Second") {

                String sql = "select * from classsubject WHERE term = 'Second'";
                ResultSet rs = conn.createStatement().executeQuery(sql);

                while (rs.next()) {
                    Syllabus s = new Syllabus (rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("teacher"),
                            rs.getString("outline"),
                            rs.getString("term"),
                            rs.getString("note"));
                    oblist.add(s);
                }
            }
            if (term == "Third") {

                String sql = "select * from classsubject WHERE term = 'Third'";
                ResultSet rs = conn.createStatement().executeQuery(sql);

                while (rs.next()) {
                    Syllabus s = new Syllabus (rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("teacher"),
                            rs.getString("outline"),
                            rs.getString("term"),
                            rs.getString("note"));
                    oblist.add(s);
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }


    @FXML
    private void btnAddPayment(ActionEvent event)  throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/SS2/Science/addSubject.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnEditPayment(ActionEvent event)  throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/SS2/Science/manageSubject.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

}
