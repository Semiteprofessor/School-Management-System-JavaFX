/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.classes.SS1.Commercial;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class broadSheetController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> clmID;
    @FXML
    private TableColumn<?, ?> clmStudentName;
    @FXML
    private TableColumn<?, ?> clmClasses;
    @FXML
    private TableColumn<?, ?> clmTerm;
    @FXML
    private TableColumn<?, ?> clmEngTest;
    @FXML
    private TableColumn<?, ?> clmEngExam;
    @FXML
    private TableColumn<?, ?> clmEngTotal;
    @FXML
    private TableColumn<?, ?> clmEngGrade;
    @FXML
    private TableColumn<?, ?> clmMathTest;
    @FXML
    private TableColumn<?, ?> clmMathExam;
    @FXML
    private TableColumn<?, ?> clmMathTotal;
    @FXML
    private TableColumn<?, ?> clmMathGrade;
    @FXML
    private TableColumn<?, ?> clmPhyTest;
    @FXML
    private TableColumn<?, ?> clmPhyExam;
    @FXML
    private TableColumn<?, ?> clmPhyTotal;
    @FXML
    private TableColumn<?, ?> clmPhyGrade;
    @FXML
    private TableColumn<?, ?> clmChemTest;
    @FXML
    private TableColumn<?, ?> clmCHemExam;
    @FXML
    private TableColumn<?, ?> clmCHemTotal;
    @FXML
    private TableColumn<?, ?> clmChemGrade;
    @FXML
    private TableColumn<?, ?> clmBioTest;
    @FXML
    private TableColumn<?, ?> clmBioExam;
    @FXML
    private TableColumn<?, ?> clmBioTotal;
    @FXML
    private TableColumn<?, ?> clmBioGrade;
    @FXML
    private TableColumn<?, ?> clmAgricTest;
    @FXML
    private TableColumn<?, ?> clmAgricExam;
    @FXML
    private TableColumn<?, ?> clmAgricTotal;
    @FXML
    private TableColumn<?, ?> clmAgricGrade;
    @FXML
    private TableColumn<?, ?> clmEconsTest;
    @FXML
    private TableColumn<?, ?> clmEconExam;
    @FXML
    private TableColumn<?, ?> clmEconsTotal;
    @FXML
    private TableColumn<?, ?> clmEconsGrade;
    @FXML
    private TableColumn<?, ?> clmFMathTest;
    @FXML
    private TableColumn<?, ?> clmFMathExam;
    @FXML
    private TableColumn<?, ?> clmFMathTotal;
    @FXML
    private TableColumn<?, ?> clmFMathGrade;
    @FXML
    private TableColumn<?, ?> clmBTechTest;
    @FXML
    private TableColumn<?, ?> clmBtechExam;
    @FXML
    private TableColumn<?, ?> clmBTechTotal;
    @FXML
    private TableColumn<?, ?> clmBTechGrade;
    @FXML
    private TableColumn<?, ?> clmBSciTest;
    @FXML
    private TableColumn<?, ?> clmBSciExam;
    @FXML
    private TableColumn<?, ?> clmBSciTotal;
    @FXML
    private TableColumn<?, ?> clmBSciGrade;
    @FXML
    private TableColumn<?, ?> clmCivicTest;
    @FXML
    private TableColumn<?, ?> clmCivicExam;
    @FXML
    private TableColumn<?, ?> clmCivicTotal;
    @FXML
    private TableColumn<?, ?> clmCivicGrade;
    @FXML
    private Button printPayment;
    @FXML
    private Button checkPayment;
    @FXML
    private Button addPayment;
    @FXML
    private ComboBox<?> loadTerm;
    @FXML
    private ComboBox<?> loadClasses;
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
        // TODO
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
