/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Bursary;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.TableSchema;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import db.DBConnection;
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

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class addPaymentController implements Initializable {

    @FXML
    private JFXTextField clmStudentName;
    @FXML
    private JFXTextField clmClasses;
    @FXML
    private JFXComboBox<String> clmTerm;
    @FXML
    private JFXTextField clmPayment1;
    @FXML
    private JFXTextField clmPayment2;
    @FXML
    private JFXTextField clmPayment3;
    @FXML
    private JFXTextField clmActualFee;
    @FXML
    private JFXComboBox<String> clmPaymentStatus;
    @FXML
    private JFXComboBox<String> clmPaymentMode;
    @FXML
    private JFXTextField clmID;
    @FXML
    private JFXTextField clmArrears;
    @FXML
    private ImageView imageViewPatientImage;

    ObservableList<String> term = FXCollections.observableArrayList("First", "Second", "Third");
    ObservableList<String> mode = FXCollections.observableArrayList("Cash", "Bank Deposit", "Transfer", "POS");
    ObservableList<String> status = FXCollections.observableArrayList("Fully Paid", "Not Paid", "Balanced", "Not Balanced");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clmPaymentMode.setItems(mode);
        clmTerm.setItems(term);
        clmPaymentStatus.setItems(status);
    }



    @FXML
    private void addPayment(ActionEvent event) throws SQLException, ClassNotFoundException  {

        Connection conn = DBConnection.getDBConnection().getConnection();

        try {

            String id = clmID.getText();
            String name = clmStudentName.getText();
            String classes = clmClasses.getText();
            String term = clmTerm.getValue ();
            String first = clmPayment1.getText();
            String second = clmPayment2.getText();
            String third = clmPayment3.getText();
            String actual = clmActualFee.getText();
            String status = clmPaymentStatus.getValue();
            String mode = clmPaymentMode.getValue();
            String arrears = clmArrears.getText();

            Statement statement = conn.createStatement();

            int addPayment = statement.executeUpdate("INSERT INTO bursary (id, name, classes, term, first_payment, second_payment, third_payment, actual_fee, status, mode_of_payment, arrears)" +
                    "VALUES('"+id+"','"+name+"', '"+classes+"', '"+term+"', '"+first+"', '"+second+"', '"+third+"', '"+actual+"', '"+status+"','"+mode+"', '"+arrears+"') ");



            if (addPayment > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Payment added Successfully");
                alert.show();


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void selectPatientImageOnAction(ActionEvent event) {
    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Bursary/bursary.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void Reset(ActionEvent event) {
    }




}
