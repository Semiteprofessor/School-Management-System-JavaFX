/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.classes;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.BroadSheet1;
import db.DBConnection;
import dbController.ClassesController;
import dbController.TermController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class broadSheetController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TableView<BroadSheet1> tableView;
    @FXML
    private TableColumn<BroadSheet1, String> clmID;
    @FXML
    private TableColumn<BroadSheet1, String> clmStudentName;
    @FXML
    private TableColumn<BroadSheet1, String> clmClasses;
    @FXML
    private TableColumn<BroadSheet1, String> clmTerm;
    @FXML
    private Button printPayment;
    @FXML
    private Button checkPayment;
    @FXML
    private Button addPayment;
    @FXML
    private ComboBox<String> loadTerm;
    @FXML
    private ComboBox<String> loadClasses;
    @FXML
    private Button editPayment;
    @FXML
    private Button calculator;
    @FXML
    private Button receipt;
    @FXML
    private TableColumn<BroadSheet1, String> clmEngTest;
    @FXML
    private TableColumn<BroadSheet1, String> clmEngExam;
    @FXML
    private TableColumn<BroadSheet1, String> clmEngTotal;
    @FXML
    private TableColumn<BroadSheet1, String> clmEngGrade;
    @FXML
    private TableColumn<BroadSheet1, String> clmMathTest;
    @FXML
    private TableColumn<BroadSheet1, String> clmMathExam;
    @FXML
    private TableColumn<BroadSheet1, String> clmMathTotal;
    @FXML
    private TableColumn<BroadSheet1, String> clmMathGrade;
    @FXML
    private TableColumn<BroadSheet1, String> clmPhyTest;
    @FXML
    private TableColumn<BroadSheet1, String> clmPhyExam;
    @FXML
    private TableColumn<BroadSheet1, String> clmPhyTotal;
    @FXML
    private TableColumn<BroadSheet1, String> clmPhyGrade;
    @FXML
    private TableColumn<BroadSheet1, String> clmChemTest;
    @FXML
    private TableColumn<BroadSheet1, String> clmCHemExam;
    @FXML
    private TableColumn<BroadSheet1, String> clmCHemTotal;
    @FXML
    private TableColumn<BroadSheet1, String> clmChemGrade;
    @FXML
    private TableColumn<BroadSheet1, String> clmBioTest;
    @FXML
    private TableColumn<BroadSheet1, String> clmBioExam;
    @FXML
    private TableColumn<BroadSheet1, String> clmBioTotal;
    @FXML
    private TableColumn<BroadSheet1, String> clmBioGrade;
    @FXML
    private TableColumn<BroadSheet1, String> clmAgricTest;
    @FXML
    private TableColumn<BroadSheet1, String> clmAgricExam;
    @FXML
    private TableColumn<BroadSheet1, String> clmAgricTotal;
    @FXML
    private TableColumn<BroadSheet1, String> clmAgricGrade;
    @FXML
    private TableColumn<BroadSheet1, String> clmEconsTest;
    @FXML
    private TableColumn<BroadSheet1, String> clmEconExam;
    @FXML
    private TableColumn<BroadSheet1, String> clmEconsTotal;
    @FXML
    private TableColumn<BroadSheet1, String> clmEconsGrade;
    @FXML
    private TableColumn<BroadSheet1, String> clmFMathTest;
    @FXML
    private TableColumn<BroadSheet1, String> clmFMathExam;
    @FXML
    private TableColumn<BroadSheet1, String> clmFMathTotal;
    @FXML
    private TableColumn<BroadSheet1, String> clmFMathGrade;
    @FXML
    private TableColumn<BroadSheet1, String> clmBTechTest;
    @FXML
    private TableColumn<BroadSheet1, String> clmBtechExam;
    @FXML
    private TableColumn<BroadSheet1, String> clmBTechTotal;
    @FXML
    private TableColumn<BroadSheet1, String> clmBTechGrade;
    @FXML
    private TableColumn<BroadSheet1, String> clmBSciTest;
    @FXML
    private TableColumn<BroadSheet1, String> clmBSciExam;
    @FXML
    private TableColumn<BroadSheet1, String> clmBSciTotal;
    @FXML
    private TableColumn<BroadSheet1, String> clmBSciGrade;
    @FXML
    private TableColumn<BroadSheet1, String> clmCivicTest;
    @FXML
    private TableColumn<BroadSheet1, String> clmCivicExam;
    @FXML
    private TableColumn<BroadSheet1, String> clmCivicTotal;
    @FXML
    private TableColumn<BroadSheet1, String> clmCivicGrade;



    ObservableList<BroadSheet1> oblist = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTerm.getItems().addAll("First", "Second", "Third", "None");
        loadClasses.getItems().addAll("JS1", "JS2", "JS3", "SS1", "SS2", "SS3", "All Classes", "None");

        try {
            try (
                    Connection conn = DBConnection.getDBConnection().getConnection ()) {
            } catch (ClassNotFoundException e) {
                e.printStackTrace ();
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }



                clmID.setCellValueFactory (new PropertyValueFactory<> ("id"));
                clmStudentName.setCellValueFactory (new PropertyValueFactory<> ("name"));
                clmClasses.setCellValueFactory (new PropertyValueFactory<> ("classes"));
                clmTerm.setCellValueFactory (new PropertyValueFactory<> ("term"));

                tableView.setItems (oblist);

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
    private void btnBackHomeOnAction(ActionEvent event) {
    }

    @FXML
    private void btnPrintPayment(ActionEvent event) {
    }

    @FXML
    private void btnCheckPayment(ActionEvent event) {
    }

    @FXML
    private void btnAddPayment(ActionEvent event) {
    }

    @FXML
    private void btnEditPayment(ActionEvent event) {
    }

    @FXML
    private void btnCalculator(ActionEvent event) {
    }

    @FXML
    private void btnReceipt(ActionEvent event) {
    }
    
}
