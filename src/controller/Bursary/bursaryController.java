/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Bursary;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Student;
import animatefx.animation.Pulse;
import controller.ReportViewController;
import db.TableSchema;
import Model.Bursary;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import db.DBConnection;
import dbController.ClassesController;
import dbController.StatusController;
import dbController.TermController;
import dbController.DepartmentController;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class bursaryController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TextField tfSearch;
    @FXML
    private TableView<Bursary> tableView;
    @FXML
    private TableColumn<Bursary, Integer> clmID;
    @FXML
    private TableColumn<Bursary, String> clmStudentName;
    @FXML
    private TableColumn<Bursary, String> clmClasses;
    @FXML
    private TableColumn<Bursary, String> clmTerm;
    @FXML
    private TableColumn<Bursary, String> clmFirstPayment;
    @FXML
    private TableColumn<Bursary, String> clmSecondPayment;
    @FXML
    private TableColumn<Bursary, String> clmThirdPayment;
    @FXML
    private TableColumn<Bursary, String> clmActualFee;
    @FXML
    private TableColumn<Bursary, String> clmPaymentStatus;
    @FXML
    private TableColumn<Bursary, String> clmModeOfPayment;
    @FXML
    private TableColumn<Bursary, String> clmArrears;
    @FXML
    private Button printPayment;
    @FXML
    private Button checkPayment;
    @FXML
    private Button addPayment;


    @FXML
    private ComboBox<String> loadClasses;
    @FXML
    private ComboBox<String> loadTerm;



    ObservableList<Bursary> oblist = FXCollections.observableArrayList();

    @FXML
    private Button editPayment;
    @FXML
    private Button calculator;
    @FXML
    private Button receipt;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTerm.getItems().addAll("First", "Second", "Third", "None");
        loadClasses.getItems().addAll("JS1", "JS2", "JS3", "SS1", "SS2", "SS3", "All Classes", "None");

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
            resultSet = conn.createStatement ().executeQuery ("SELECT * FROM bursary");
        } catch (SQLException e) {
            e.printStackTrace ();
        }


        try {
            while (resultSet.next ()) {
                oblist.addAll (new Bursary (
                        resultSet.getInt ("id"),
                        resultSet.getString ("name"),
                        resultSet.getString ("classes"),
                        resultSet.getString ("term"),
                        resultSet.getString ("first_payment"),
                        resultSet.getString ("second_payment"),
                        resultSet.getString ("third_payment"),
                        resultSet.getString ("actual_fee"),
                        resultSet.getString ("status"),
                        resultSet.getString ("mode_of_payment"),
                        resultSet.getString ("arrears")
                ));


                clmID.setCellValueFactory (new PropertyValueFactory<> ("id"));
                clmStudentName.setCellValueFactory (new PropertyValueFactory<> ("name"));
                clmClasses.setCellValueFactory (new PropertyValueFactory<> ("classes"));
                clmTerm.setCellValueFactory (new PropertyValueFactory<> ("term"));
                clmFirstPayment.setCellValueFactory (new PropertyValueFactory<> ("first_payment"));
                clmSecondPayment.setCellValueFactory (new PropertyValueFactory<> ("second_payment"));
                clmThirdPayment.setCellValueFactory (new PropertyValueFactory<> ("third_payment"));
                clmActualFee.setCellValueFactory (new PropertyValueFactory<> ("actual_fee"));
                clmPaymentStatus.setCellValueFactory (new PropertyValueFactory<> ("status"));
                clmModeOfPayment.setCellValueFactory (new PropertyValueFactory<> ("mode_of_payment"));
                clmArrears.setCellValueFactory (new PropertyValueFactory<> ("arrears"));

                tableView.setItems (oblist);

            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    void setLoadClasses() {
        ArrayList arrayList = null;
        try {
            arrayList = ClassesController.getClasses();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
        ObservableList observableArray = FXCollections.observableArrayList();

        if (observableArray != null) {
            loadClasses.setItems(observableArray);
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
        Parent home = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new Pulse (home).play ();
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
        String classes = loadClasses.getValue();
        String term = loadTerm.getValue();

        Connection conn = DBConnection.getDBConnection().getConnection();
        try {
            InputStream report1 = getClass().getResourceAsStream("/Reports/BursaryFirst.jrxml");
            InputStream report2 = getClass().getResourceAsStream("/Reports/BursarySecond.jrxml");
            InputStream report3 = getClass().getResourceAsStream("/Reports/BursaryThird.jrxml");

            JRDesignQuery query = new JRDesignQuery();

            JasperDesign jd1 = JRXmlLoader.load(report1);
            query.setText("select * from bursary where term = 'First'");
            jd1.setQuery(query);
            ReportViewController r = new ReportViewController();
            r.viewReport(jd1);

            JasperDesign jd2 = JRXmlLoader.load(report2);
            query.setText("select * from bursary where term = 'Second'");
            jd2.setQuery(query);
            ReportViewController r2 = new ReportViewController();
            r.viewReport(jd2);

            JasperDesign jd3 = JRXmlLoader.load(report2);
            query.setText("select * from bursary where term = 'Third'");
            jd2.setQuery(query);
            ReportViewController r3 = new ReportViewController();
            r.viewReport(jd3);


        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void btnAddPayment(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Bursary/addPayment.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnCheckPayment(ActionEvent event) {


        try {

            tableView.getItems().clear();
            String classes = loadClasses.getValue();
            String term = loadTerm.getValue();


            Connection conn = DBConnection.getDBConnection().getConnection();
            // if((loadGrades != null)&&(loadGender != null)){


            if (term == "First") {
                String sql2 = "select * from bursary where term = 'First' ";
                ResultSet rs = conn.createStatement ().executeQuery (sql2);

                while (rs.next ()) {
                    Bursary s = new Bursary (rs.getInt ("id"),
                            rs.getString ("name"),
                            rs.getString ("classes"),
                            rs.getString ("term"),
                            rs.getString ("first_payment"),
                            rs.getString ("second_payment"),
                            rs.getString ("third_payment"),
                            rs.getString ("actual_fee"),
                            rs.getString ("status"),
                            rs.getString ("mode_of_payment"),
                            rs.getString ("arrears"));
                    oblist.add (s);
                }
            }
            if (term == "Second") {
                String sql2 = "select * from bursary where term = 'Second' ";
                ResultSet rs = conn.createStatement ().executeQuery (sql2);

                while (rs.next ()) {
                    Bursary s = new Bursary (rs.getInt ("id"),
                            rs.getString ("name"),
                            rs.getString ("classes"),
                            rs.getString ("term"),
                            rs.getString ("first_payment"),
                            rs.getString ("second_payment"),
                            rs.getString ("third_payment"),
                            rs.getString ("actual_fee"),
                            rs.getString ("status"),
                            rs.getString ("mode_of_payment"),
                            rs.getString ("arrears"));
                    oblist.add (s);
                }
            }
            if (term == "Third") {
                String sql2 = "select * from bursary where term = 'Third' ";
                ResultSet rs = conn.createStatement ().executeQuery (sql2);

                while (rs.next ()) {
                    Bursary s = new Bursary (rs.getInt ("id"),
                            rs.getString ("name"),
                            rs.getString ("classes"),
                            rs.getString ("term"),
                            rs.getString ("first_payment"),
                            rs.getString ("second_payment"),
                            rs.getString ("third_payment"),
                            rs.getString ("actual_fee"),
                            rs.getString ("status"),
                            rs.getString ("mode_of_payment"),
                            rs.getString ("arrears"));
                    oblist.add (s);
                }
            }

            if (classes == "All Classes") {

                String sql = "select * from bursary";
                ResultSet rs = conn.createStatement().executeQuery(sql);

                while (rs.next()) {
                    Bursary s = new Bursary(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("term"),
                            rs.getString("first_payment"),
                            rs.getString("second_payment"),
                            rs.getString("third_payment"),
                            rs.getString("actual_fee"),
                            rs.getString("status"),
                            rs.getString("mode_of_payment"),
                            rs.getString("arrears"));
                    oblist.add(s);
                }
            }
            if (classes == "JS1") {
                String sql2 = "select * from bursary where classes = 'JS1' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    Bursary s = new Bursary(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("term"),
                            rs.getString("first_payment"),
                            rs.getString("second_payment"),
                            rs.getString("third_payment"),
                            rs.getString("actual_fee"),
                            rs.getString("status"),
                            rs.getString("mode_of_payment"),
                            rs.getString("arrears"));
                    oblist.add(s);
                }
            }
            if (classes == "JS2") {
                String sql2 = "select * from bursary where classes = 'JS2' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    Bursary s = new Bursary(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("term"),
                            rs.getString("first_payment"),
                            rs.getString("second_payment"),
                            rs.getString("third_payment"),
                            rs.getString("actual_fee"),
                            rs.getString("status"),
                            rs.getString("mode_of_payment"),
                            rs.getString("arrears"));
                    oblist.add(s);
                }
            }

            if (classes == "JS3") {
                String sql2 = "select * from bursary where classes = 'JS3' ";
                ResultSet rs = conn.createStatement ().executeQuery (sql2);

                while (rs.next ()) {
                    Bursary s = new Bursary (rs.getInt ("id"),
                            rs.getString ("name"),
                            rs.getString ("classes"),
                            rs.getString ("term"),
                            rs.getString ("first_payment"),
                            rs.getString ("second_payment"),
                            rs.getString ("third_payment"),
                            rs.getString ("actual_fee"),
                            rs.getString ("status"),
                            rs.getString ("mode_of_payment"),
                            rs.getString ("arrears"));
                    oblist.add (s);
                }
            }
                if (classes == "SS1") {
                    String sql2 = "select * from bursary where classes = 'SS1' ";
                    ResultSet rs = conn.createStatement ().executeQuery (sql2);

                    while (rs.next ()) {
                        Bursary s = new Bursary (rs.getInt ("id"),
                                rs.getString ("name"),
                                rs.getString ("classes"),
                                rs.getString ("term"),
                                rs.getString ("first_payment"),
                                rs.getString ("second_payment"),
                                rs.getString ("third_payment"),
                                rs.getString ("actual_fee"),
                                rs.getString ("status"),
                                rs.getString ("mode_of_payment"),
                                rs.getString ("arrears"));
                        oblist.add (s);
                    }
                }

                if (classes == "SS2") {
                    String sql2 = "select * from bursary where classes = 'SS2' ";
                    ResultSet rs = conn.createStatement ().executeQuery (sql2);

                    while (rs.next ()) {
                        Bursary s = new Bursary (rs.getInt ("id"),
                                rs.getString ("name"),
                                rs.getString ("classes"),
                                rs.getString ("term"),
                                rs.getString ("first_payment"),
                                rs.getString ("second_payment"),
                                rs.getString ("third_payment"),
                                rs.getString ("actual_fee"),
                                rs.getString ("status"),
                                rs.getString ("mode_of_payment"),
                                rs.getString ("arrears"));
                        oblist.add (s);
                    }
                }
                if (classes == "SS3") {
                    String sql2 = "select * from bursary where classes = 'SS3' ";
                    ResultSet rs = conn.createStatement ().executeQuery (sql2);

                    while (rs.next ()) {
                        Bursary s = new Bursary (rs.getInt ("id"),
                                rs.getString ("name"),
                                rs.getString ("classes"),
                                rs.getString ("term"),
                                rs.getString ("first_payment"),
                                rs.getString ("second_payment"),
                                rs.getString ("third_payment"),
                                rs.getString ("actual_fee"),
                                rs.getString ("status"),
                                rs.getString ("mode_of_payment"),
                                rs.getString ("arrears"));
                        oblist.add (s);
                    }
                }








        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    private void btnEditPayment(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Bursary/editPayment.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

    }

    @FXML
    private void btnCalculator(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Bursary/calculator.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));


    }

    @FXML
    private void btnReceipt(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Bursary/receipt.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }



    

}