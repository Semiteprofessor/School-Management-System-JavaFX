package controller.student;

import com.jfoenix.controls.JFXButton;
import db.TableSchema;
import controller.ReportViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import dbController.DepartmentController;
import tableModel.StudentTableModel;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.Button;


public class PrintStudentsController implements Initializable {


    @FXML
    private ComboBox<String> loadYears;

    @FXML
    private ComboBox<String> loadGender;

    @FXML
    private Button generate;

    @FXML
    private Button printStudents;
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
    private TableView<StudentTableModel> tableView;
    @FXML
    private ComboBox<String> loadClasses;
    @FXML
    private ComboBox<String> loadDepartment;
    @FXML
    private TableColumn<StudentTableModel, String> clmYear;
    @FXML
    private TableColumn<?, ?> clmID1;
    @FXML
    private TableColumn<StudentTableModel, String> clmAdmitted;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadClasses.getItems().addAll("JS1", "JS2", "JS3", "SS1", "SS2", "SS3", "All Classes", "None");
        loadYears();
        loadGender.getItems().addAll("All", "Male", "Female", "None");
        loadDepartment.getItems().addAll("Science", "Commercial", "Art", "None");
    }

    private void setLoadYears() {

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


    void setLoadDepartment() {
        ArrayList arrayList = null;
        try {
            arrayList = DepartmentController.getDepartments();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
        ObservableList observableArray = FXCollections.observableArrayList();

        if (observableArray != null) {
            loadDepartment.setItems(observableArray);
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
            tableView.getItems().clear();
            String classes = loadClasses.getValue();
            String gender = loadGender.getValue();
            String year = loadYears.getValue();
            String department = loadDepartment.getValue();

            Connection conn = DBConnection.getDBConnection().getConnection();

            // if((loadGrades != null)&&(loadGender != null)){

            if (gender == "All") {

                String sql = "select * from students";
                ResultSet rs = conn.createStatement().executeQuery(sql);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }
            if (gender == "Male") {
                String sql2 = "select * from students where gender = 'Male' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }
            if (gender == "Female") {
                String sql2 = "select * from students where gender = 'Female' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }

            if (classes == "All Classes") {

                String sql = "select * from students";
                ResultSet rs = conn.createStatement().executeQuery(sql);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }
            if (classes == "JS1") {
                String sql2 = "select * from students where classes = 'JS1' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }
            if (classes == "JS2") {
                String sql2 = "select * from students where classes = 'JS2' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }

            if (classes == "JS3") {
                String sql2 = "select * from students where classes = 'JS3' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }
            if (classes == "SS1") {
                String sql2 = "select * from students where classes = 'SS1' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }

            if (classes == "SS2") {
                String sql2 = "select * from students where classes = 'SS2' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }
            if (classes == "SS3") {
                String sql2 = "select * from students where classes = 'SS3' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }

            if (department == "Science") {
                String sql2 = "select * from students where department = 'Science' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }

            if (department == "Commercial") {
                String sql2 = "select * from students where department = 'Commercial' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }
            if (department == "Art") {
                String sql2 = "select * from students where department = 'Art' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (classes == "SS1" && department == "Science") {
                String sql2 = "select * from students where classes = 'SS1' or department = 'Science' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (classes == "SS1" && department == "Commercial") {
                String sql2 = "select * from students where classes = 'SS1' or department = 'Commercial' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (classes == "SS1" && department == "Art") {
                String sql2 = "select * from students where classes = 'SS1' or department = 'Art' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (classes == "SS2" && department == "Science") {
                String sql2 = "select * from students where classes = 'SS2' or department = 'Science' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (classes == "SS2" && department == "Commercial") {
                String sql2 = "select * from students where classes = 'SS2' or department = 'Commercial' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (classes == "SS2" && department == "Art") {
                String sql2 = "select * from students where classes = 'SS2' or department = 'Art' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (classes == "SS3" && department == "Science") {
                String sql2 = "select * from students where classes = 'SS3' or department = 'Science' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (classes == "SS3" && department == "Commercial") {
                String sql2 = "select * from students where classes = 'SS3' or department = 'Commercial' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (classes == "SS3" && department == "Art") {
                String sql2 = "select * from students where classes = 'SS3' or department = 'Art' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2010" ) {
                String sql2 = "select * from oldstudents where year = '2010' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2011" ) {
                String sql2 = "select * from oldstudents where year = '2011' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2012" ) {
                String sql2 = "select * from oldstudents where year = '2012' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2013" ) {
                String sql2 = "select * from oldstudents where year = '2013' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2014" ) {
                String sql2 = "select * from oldstudents where year = '2014' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2015" ) {
                String sql2 = "select * from oldstudents where year = '2015' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2016" ) {
                String sql2 = "select * from oldstudents where year = '2016' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2017" ) {
                String sql2 = "select * from oldstudents where year = '2017' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2018" ) {
                String sql2 = "select * from oldstudents where year = '2018' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2019" ) {
                String sql2 = "select * from oldstudents where year = '2019' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2020" ) {
                String sql2 = "select * from oldstudents where year = '2020' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2021" ) {
                String sql2 = "select * from oldstudents where year = '2021' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2022" ) {
                String sql2 = "select * from oldstudents where year = '2022' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2023" ) {
                String sql2 = "select * from oldstudents where year = '2023' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2024" ) {
                String sql2 = "select * from oldstudents where year = '2024' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2025" ) {
                String sql2 = "select * from oldstudents where year = '2025' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2026" ) {
                String sql2 = "select * from oldstudents where year = '2026' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2027" ) {
                String sql2 = "select * from oldstudents where year = '2027' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2028" ) {
                String sql2 = "select * from oldstudents where year = '2028' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2029" ) {
                String sql2 = "select * from oldstudents where year = '2029' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2030" ) {
                String sql2 = "select * from oldstudents where year = '2030' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2031" ) {
                String sql2 = "select * from oldstudents where year = '2031' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2032" ) {
                String sql2 = "select * from oldstudents where year = '2032' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2033" ) {
                String sql2 = "select * from oldstudents where year = '2033' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2034" ) {
                String sql2 = "select * from oldstudents where year = '2034' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2035" ) {
                String sql2 = "select * from oldstudents where year = '2035' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2036" ) {
                String sql2 = "select * from oldstudents where year = '2036' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2037" ) {
                String sql2 = "select * from oldstudents where year = '2037' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2038" ) {
                String sql2 = "select * from oldstudents where year = '2038' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2039" ) {
                String sql2 = "select * from oldstudents where year = '2039' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }if (year == "2040" ) {
                String sql2 = "select * from oldstudents where year = '2040' ";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("admitted"),
                            rs.getString("department"),
                            rs.getString("disability"),
                            rs.getString("designation"),
                            rs.getString("contact"),
                            rs.getString("address"),
                            rs.getString("state"),
                            rs.getString("year"));
                    studentList.add(s);
                }
            }





           /*if(adNoCheckBox.isSelected()){
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
            clmStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
            clmClasses.setCellValueFactory(new PropertyValueFactory<>("classes"));
            clmGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            clmDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
            clmAdmitted.setCellValueFactory(new PropertyValueFactory<>("admitted"));
            clmDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
            clmDisability.setCellValueFactory(new PropertyValueFactory<>("disability"));
            clmDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));
            clmContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
            clmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            clmState.setCellValueFactory(new PropertyValueFactory<>("state"));
            clmYear.setCellValueFactory(new PropertyValueFactory<>("year"));

            tableView.setItems(studentList);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }

    }


    @FXML
    private void btnBackOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/student/StudentManagement.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void printStudents(ActionEvent event)  throws JRException {
        try {
            tableView.getItems().clear();
            String classes = loadClasses.getValue();
            String gender = loadGender.getValue();
            String year = loadYears.getValue();
            String department = loadDepartment.getValue();

            Connection conn = DBConnection.getDBConnection().getConnection();

            InputStream report1 = getClass().getResourceAsStream("/Reports/StudentList.jrxml");
            InputStream report2 = getClass().getResourceAsStream("/Reports/StudentListGender.jrxml");
            InputStream report3 = getClass().getResourceAsStream("/Reports/PastStudentList.jrxml");
            InputStream report4 = getClass().getResourceAsStream("/Reports/PastStudentListGender.jrxml");
            InputStream report5 = getClass().getResourceAsStream("/Reports/StudentInfo.jrxml");


           /* JasperDesign jd = JRXmlLoader.load("src\\sms\\Reports\\StudentList.jrxml");
            JasperDesign jd2 = JRXmlLoader.load("src\\sms\\Reports\\StudentListGender.jrxml");
            JasperDesign jd3 = JRXmlLoader.load("src\\sms\\Reports\\PastStudentList.jrxml");
            JasperDesign jd4 = JRXmlLoader.load("src\\sms\\Reports\\PastStudentListGender.jrxml");
            */
            JRDesignQuery query = new JRDesignQuery();

            if (loadYears.getValue() == null) {

                if (loadClasses != null) {

                    if (gender == "All") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    } if (gender == "Male") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where gender = Male");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (gender == "Female") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where gender = Female");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (classes == "JS1") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where classes = JS1");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (classes == "JS2") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where classes = JS2");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (classes == "JS3") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where classes = JS3");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (classes == "SS1") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where classes = SS1");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (classes == "SS2") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where classes = SS2");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (classes == "SS3") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where classes = SS3");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (department == "Science") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where department = Science");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (department == "Commercial") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where department = Commercial");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (department == "Art") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where department = Art");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2020") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2020");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2021") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2021");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2022") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2022");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2023") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2023");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2024") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2024");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2025") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2025");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2026") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2026");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2027") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2027");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2028") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 202028");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2029") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2029");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2030") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2030");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2031") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2031");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2032") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2032");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2033") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2033");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2034") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2034");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2035") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2035");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2036") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2036");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2037") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2037");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2038") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2038");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2039") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2039");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2040") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2040");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2041") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2041");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2042") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2042");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2043") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2043");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2044") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2044");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2045") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2045");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2046") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2046");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2047") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2047");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2048") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2048");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2049") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2049");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }if (year == "2050") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where year = 2050");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    }
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
    private void loadClasses (ActionEvent event){
    }

    @FXML
    private void loadDepartment (ActionEvent event){
    }

    @FXML
    private void loadGender (ActionEvent event){
    }


}








