package controller.student;

import controller.ReportViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import db.TableSchema;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import tableModel.StudentTableModel;
import db.DBConnection;
import dbController.ClassesController;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.Button;


public class PrintStudents2Controller implements Initializable {



    @FXML
    private ComboBox<String> loadYears;

    @FXML
    private ComboBox<String> loadGender;

    @FXML
    private Button generate;

    @FXML
    private Button printStudents;

    private AnchorPane root;
    ObservableList<StudentTableModel> studentList = FXCollections.observableArrayList();

    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<StudentTableModel, Integer> clmID;

    @FXML
    private TableColumn<StudentTableModel, String> clmStudentName;

    @FXML
    private TableColumn<StudentTableModel, String> clmClasses;

    @FXML
    private TableColumn<StudentTableModel, String> clmGender;

    @FXML
    private TableColumn<StudentTableModel, String> clmDOB;

    @FXML
    private TableColumn<StudentTableModel, String> clmDateAdmitted;

    @FXML
    private TableColumn<StudentTableModel, String> clmDepartment;

    @FXML
    private TableColumn<StudentTableModel, String> clmDisability;

    @FXML
    private TableColumn<StudentTableModel, String> clmDesignation;

    @FXML
    private TableColumn<StudentTableModel, String> clmContact;

    @FXML
    private TableColumn<StudentTableModel, String> clmAddress;
    
    @FXML
    private TableColumn<StudentTableModel, String> clmState;

    @FXML
    private TableView<StudentTableModel> studentTable;
    @FXML
    private ComboBox<String> loadGrades;

    void userAccount(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/View/fxml/UserAccount2.fxml")));
            root.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadGrades();
        loadYears();
        loadGender.getItems().addAll("All", "Male", "Female");
    }

    @FXML
    void loadGender() {

    }

    @FXML
    void loadGrades() {
        ArrayList arrayList = null;
        try {
            arrayList = ClassesController.getClasses();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null) {
            loadGrades.setItems(observableArray);
        }
    }


    @FXML
    void loadYears() {
        ArrayList arrayList = null;
        try {
            arrayList = ClassesController.getYears();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null) {
            loadYears.setItems(observableArray);
        }
    }

    @FXML
    void generate(ActionEvent event) {

        try {
            studentTable.getItems().clear();
            String grade = loadGrades.getValue();
            String gender = loadGender.getValue();
            String year = loadYears.getValue();

            Connection conn = DBConnection.getDBConnection().getConnection();

            // if((loadGrades != null)&&(loadGender != null)){

            if (gender == "All") {

                String sql = "select * from students where classes = '" + grade + "'";
                ResultSet rs = conn.createStatement().executeQuery(sql);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("year"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"));
                    studentList.add(s);
                }
            } else {
                String sql2 = "select * from students where classes = '" + grade + "' AND gender = '" + gender + "'";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("year"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"));
                    studentList.add(s);
                }
                //    }
            }
            if (loadGrades != null) {

                // studentTable.getItems().clear();

                if (gender == "All") {
                    String sql = "select * from oldstudents where year = '" + year + "'";
                    ResultSet rs = conn.createStatement().executeQuery(sql);

                    while (rs.next()) {
                        StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("classes"),
                                rs.getString("gender"),
                                rs.getString("dob"),
                                rs.getString("admitted"),
                                rs.getString("department"),
                                rs.getString("year"),
                                rs.getString("disability"),
                                rs.getString("designation"),
                                rs.getString("contact"),
                                rs.getString("address"),
                                rs.getString("state"));
                        studentList.add(s);
                    }
                } else {
                    String sql2 = "select * from oldstudents where year = '" + year + "' AND gender = '" + gender + "'";
                    ResultSet rs = conn.createStatement().executeQuery(sql2);

                    while (rs.next()) {
                        StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("classes"),
                                rs.getString("gender"),
                                rs.getString("dob"),
                                rs.getString("admitted"),
                                rs.getString("department"),
                                rs.getString("year"),
                                rs.getString("disability"),
                                rs.getString("designation"),
                                rs.getString("contact"),
                                rs.getString("address"),
                                rs.getString("state"));
                        studentList.add(s);
                    }
                }
            }
           /* if(adNoCheckBox.isSelected()){
                adNoColumn.setCellValueFactory(new PropertyValueFactory<>("adNo"));
                gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
                studentTable.setItems(studentList);

            }
            if(fullNameCheckBox.isSelected()){
                fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
                gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
                studentTable.setItems(studentList);
            }*/

            clmID.setCellValueFactory(new PropertyValueFactory<>("id"));
            clmStudentName.setCellValueFactory(new PropertyValueFactory<>("names"));
            clmClasses.setCellValueFactory(new PropertyValueFactory<>("classes"));
            clmGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            clmDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
            clmDateAdmitted.setCellValueFactory(new PropertyValueFactory<>("admitted"));
            clmDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
            clmDisability.setCellValueFactory(new PropertyValueFactory<>("disability"));
            clmDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));
            clmContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
            clmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            clmState.setCellValueFactory(new PropertyValueFactory<>("state"));

            studentTable.setItems(studentList);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }

    }

    @FXML
    void printStudents(ActionEvent event) {

        try {
            studentTable.getItems().clear();
            String grade = loadGrades.getValue();
            String gender = loadGender.getValue();
            String year = loadYears.getValue();

            Connection conn = DBConnection.getDBConnection().getConnection();

            InputStream report1 = getClass().getResourceAsStream("/Reports/StudentList.jrxml");
            InputStream report2 = getClass().getResourceAsStream("/Reports/StudentListGender.jrxml");
            InputStream report3 = getClass().getResourceAsStream("/Reports/PastStudentList.jrxml");
            InputStream report4 = getClass().getResourceAsStream("/Reports/PastStudentListGender.jrxml");

            JRDesignQuery query = new JRDesignQuery();

            if(loadYears.getValue()==null) {

                if (loadGrades != null) {

                    if (gender == "All") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where classes = '" + grade + "'");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                        /*conn = DBConnection.getConnection();
                        jd = JRXmlLoader.load("src\\Reports\\StudentList.jrxml");
                        query = new JRDesignQuery();
                query.setText("select * from students");
                query.setText("select * from students where classes = '"+grade+"'");
                jd.setQuery(query);
                        r = new ReportViewController();
                r.viewReport(jd);*/

                    } else {
                        JasperDesign jd2 = JRXmlLoader.load(report2);
                        query.setText("select * from students where classes = '" + grade + "' AND gender = '" + gender + "'");
                        jd2.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd2);
                    }
                }
            }
            if (loadYears.getValue() != null) {

                if (gender == "All") {

                    JasperDesign jd3 = JRXmlLoader.load(report3);
                    query.setText("select * from oldstudents where year = '" + year + "'");
                    jd3.setQuery(query);
                    ReportViewController r = new ReportViewController();
                    r.viewReport(jd3);

                } else {

                    JasperDesign jd4 = JRXmlLoader.load(report4);
                    query.setText("select * from oldstudents where year = '" + year + "' AND gender = '" + gender + "'");
                    jd4.setQuery(query);
                    ReportViewController r = new ReportViewController();
                    r.viewReport(jd4);
                }
            }

        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }

    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) {
    }




}

