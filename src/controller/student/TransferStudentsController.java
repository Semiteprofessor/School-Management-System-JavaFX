package controller.student;

import Model.Student;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import dbController.ClassesController;
import dbController.TransferController;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tableModel.StudentTableModel;
import db.TableSchema;
import db.DBConnection;



public class TransferStudentsController implements Initializable {

    @FXML
    private AnchorPane root;


    @FXML
    private Button move1;
    @FXML
    private Button btnBack;
    @FXML
    private Button move2;

    @FXML
    private ComboBox<String> loadCombo;

    @FXML
    private TextField yearField;

    @FXML
    private ComboBox<String> loadCombo1;

    @FXML
    private ComboBox<String> loadCombo2;


    @FXML
    private JFXButton Back;


    @FXML
    private JFXButton btnUpdate;


    ObservableList<Student> studentList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCombo.getItems().addAll("SS3");
        loadCombo1.getItems().addAll("JS1", "JS2", "JS3", "SS1", "SS2", "SS3");
        loadCombo2.getItems().addAll("JS1", "JS2", "JS3", "SS1", "SS2", "SS3");
        yearField();
    }

    private void setYearField() {

    }


    @FXML
    void btnUpdate(ActionEvent event) {

    }


    void yearField() {
        ArrayList arrayList = null;
        try {
            arrayList = ClassesController.getYears();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null) {
            yearField.setText(String.valueOf(observableArray));
        }
    }

    void setLoadCombo1() {
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
            loadCombo1.setItems(observableArray);
        }
    }

    void setLoadCombo2() {
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
            loadCombo2.setItems(observableArray);
        }
    }

    void setLoadCombo() {
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
            loadCombo.setItems(observableArray);
        }
    }

    @FXML
    void move1(ActionEvent event) {
        try {

            String classes = loadCombo.getValue();
            String year = yearField.getText();

            Connection conn = DBConnection.getDBConnection().getConnection();


            if (classes == "SS3") {
                String sql = "INSERT INTO oldstudents (id,name,classes, gender,dob,admitted,department, disability, designation, contact,address,state, year)" +
                "SELECT * FROM students where classes = 'SS3'";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.executeUpdate();


                int a = TransferController.deleteStudent(classes);
                int b = TransferController.updateClasses(year);

                if (a > 0) {

                    if (b > 0) {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Transfer Students");
                        alert.setHeaderText(null);
                        alert.setContentText("Updated..!");
                        alert.showAndWait();
                    }
                }
            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Transfer Students");
                alert.setHeaderText(null);
                alert.setContentText("Oops..! There is an Error in Transferring Students..!");
                alert.showAndWait();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void move2(ActionEvent event)  {
        String classA = loadCombo1.getValue ();
        String classB = loadCombo2.getValue ();

        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection ().getConnection ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        String sql = "UPDATE students SET classes= '" + classB + "' WHERE classes= '" + classA + "'";
        Alert alert;
        try (PreparedStatement stm = conn.prepareStatement (sql)) {
            stm.executeUpdate ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }


        alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle ("Transfer Students");
        alert.setHeaderText (null);
        alert.setContentText ("Class Updated Successfully..!");
        alert.showAndWait ();

        loadCombo1.setValue (null);
        loadCombo2.setValue (null);


    }





        @FXML
        private void btnBackHomeOnAction (ActionEvent event) throws IOException {
            Parent home = FXMLLoader.load(getClass().getResource("/View/student/StudentManagement.fxml"));
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(home));
        }

    @FXML
    private void loadComboBox(ActionEvent event) {
    }

    @FXML
    private void loadCombo1(ActionEvent event) {
    }

    @FXML
    private void loadCombo2(ActionEvent event) {
    }

    @FXML
    private void Back(ActionEvent event) {
    }
    }
