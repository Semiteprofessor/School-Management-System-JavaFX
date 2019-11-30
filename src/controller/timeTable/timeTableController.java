/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.timeTable;

import animatefx.animation.Pulse;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import controller.ReportViewController;
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
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import tableModel.StudentTableModel;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class timeTableController implements Initializable {

    @FXML
    private Button btnBack;
    private JFXListView viewer;
    @FXML
    private AnchorPane rootAnchorPane;




    ObservableList<String> list = FXCollections.observableArrayList("ENGLISH", "MATHEMATICS", "CIVIC EDUCATION", "ECONOMICS",
            "LITERATURE IN ENG", "GOVERNMENT", "PHYSICS", "CHEMISTRY", "AGRIC SCIENCE", "BIOLOGY", "F/MATHS", "I.R.S", "C.R.S",
            "MUSIC", "HISTORY", "COMMERCE", "ACCOUNT", "YORUBA", "HAUSA", "IGBO", "FRENCH", "MARKETING",
            "HEALTH EDUCATION", "PHYSICAL EDUCATION", "GEOGRAPHY", "BASIC SCIENCE", "SOCIAL STUDIES", "FINE ART", "BUSINESS STUDIES", "COMPUTER", "HOME ECONOMICS",
            "BASIC TECH", "INTRO TECH");
    @FXML
    private JFXComboBox<String> clm1;
    @FXML
    private JFXComboBox<String> clm7;
    @FXML
    private JFXComboBox<String> clm23;
    @FXML
    private JFXComboBox<String> clm12;
    @FXML
    private JFXComboBox<String> clm22;
    @FXML
    private JFXComboBox<String> clm6;
    @FXML
    private JFXComboBox<String> clm17;
    @FXML
    private JFXComboBox<String> clm13;
    @FXML
    private JFXComboBox<String> clm18;
    @FXML
    private JFXComboBox<String> clm9;
    @FXML
    private JFXComboBox<String> clm4;
    @FXML
    private JFXComboBox<String> clm14;
    @FXML
    private JFXComboBox<String> clm24;
    @FXML
    private JFXComboBox<String> clm19;
    @FXML
    private JFXComboBox<String> clm10;
    @FXML
    private JFXComboBox<String> clm5;
    @FXML
    private JFXComboBox<String> clm15;
    @FXML
    private JFXComboBox<String> clm25;
    @FXML
    private JFXComboBox<String> clm20;
    @FXML
    private JFXComboBox<String> clm11;
    @FXML
    private JFXComboBox<String> clm21;
    @FXML
    private JFXComboBox<String> clm16;
    @FXML
    private JFXComboBox<String> clm3;
    @FXML
    private JFXComboBox<String> clm8;
    @FXML
    private JFXComboBox<String> clm2;
    private JFXComboBox<String> clmView;
    private JFXComboBox<String> clmUpdate;
    @FXML
    private Button viewTimeTable;
    @FXML
    private Button updateTimeTable;
    @FXML
    private JFXTextField clm26;
    @FXML
    private JFXTextField clm27;
    @FXML
    private JFXTextField clm28;
    @FXML
    private JFXTextField clm29;
    @FXML
    private JFXTextField clm30;
    @FXML
    private JFXTextField clmClass;
    @FXML
    private JFXTextField clmID;
    @FXML
    private TextField AdNo;
    @FXML
    private Button searchStudent;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clm1.setItems(list);clm2.setItems(list);clm3.setItems(list);clm4.setItems(list);clm5.setItems(list);
        clm6.setItems(list);clm7.setItems(list);clm8.setItems(list);clm9.setItems(list);clm10.setItems(list);
        clm11.setItems(list);clm12.setItems(list);clm13.setItems(list);clm14.setItems(list);clm15.setItems(list);
        clm16.setItems(list);clm17.setItems(list);clm18.setItems(list);clm19.setItems(list);clm20.setItems(list);
        clm21.setItems(list);clm22.setItems(list);clm23.setItems(list);clm24.setItems(list);clm25.setItems(list);


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
    private void viewTimeTable(ActionEvent event) throws SQLException, ClassNotFoundException {

        Connection conn = DBConnection.getDBConnection().getConnection();

            try {



                InputStream report = getClass().getResourceAsStream("/Reports/TimeTable.jrxml");
                JasperDesign jd = JRXmlLoader.load(report);
                JRDesignQuery query = new JRDesignQuery();
                query.setText("select * from timetable");
                jd.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd);

            } catch (JRException e) {
                e.printStackTrace();
            }

    }

    @FXML
    private void updateTimeTable(ActionEvent event) throws SQLException, ClassNotFoundException {



        Connection conn = DBConnection.getDBConnection().getConnection();



        try {

            String classes = clmClass.getText ();
            String c1 = clm1.getValue ();
            String c2 = clm2.getValue ();
            String c3 = clm3.getValue ();
            String c4 = clm4.getValue ();
            String c5 = clm5.getValue ();
            String c6 = clm6.getValue ();
            String c7 = clm7.getValue ();
            String c8 = clm8.getValue ();
            String c9 = clm9.getValue ();
            String c10 = clm10.getValue ();
            String c11 = clm11.getValue ();
            String c12 = clm12.getValue ();
            String c13 = clm13.getValue ();
            String c14 = clm14.getValue ();
            String c15 = clm15.getValue ();
            String c16 = clm16.getValue ();
            String c17 = clm17.getValue ();
            String c18 = clm18.getValue ();
            String c19 = clm19.getValue ();
            String c20 = clm20.getValue ();
            String c21 = clm21.getValue ();
            String c22 = clm22.getValue ();
            String c23 = clm23.getValue ();
            String c24 = clm24.getValue ();
            String c25 = clm25.getValue ();
            String c26 = clm26.getText ();
            String c27 = clm27.getText ();
            String c28 = clm28.getText ();
            String c29 = clm29.getText ();
            String c30 = clm30.getText ();


            int addStud;
            try (Statement statement = conn.createStatement ()) {
                    addStud = statement.executeUpdate ("INSERT INTO timetable (c1, c1, c3, c4, c6, c6, c7,c8,c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, classes)" +
                            "VALUES('" + c1 + "', '" + c2 + "','" + c3 + "', '" + c4 + "', '" + c5 + "', '" + c6 + "', '" + c7 + "', '" + c8 + "', '" + c9 + "', '" + c10 + "', '" + c11 + "', '" + c12 + "', '" + c13 + "', '" + c14 + "', " +
                            "'" + c15 + "', '" + c16 + "','" + c17 + "', '" + c18 + "', '" + c19 + "', '" + c20 + "', '" + c21 + "', '" + c21 + "', '" + c23 + "', '" + c24 + "', '" + c25 + "', '" + c26 + "', '" + c27 + "', '" + c28 + "', '" + c29 + "', '" + c30 + "', '" + classes + "') ");
                }


            if (clm1.getValue ().isEmpty() || clm2.getValue ().isEmpty() || clm3.getValue ().isEmpty() || clm4.getValue ().isEmpty() || clm5.getValue ().isEmpty() || clm6.getValue ().isEmpty() || clm7.getValue ().isEmpty() ||
                    clm8.getValue ().isEmpty() || clm9.getValue ().isEmpty() || clm10.getValue ().isEmpty() || clm11.getValue ().isEmpty() || clm12.getValue ().isEmpty() || clm13.getValue ().isEmpty() || clm14.getValue ().isEmpty() ||
                    clm15.getValue ().isEmpty() || clm16.getValue ().isEmpty() || clm17.getValue ().isEmpty() || clm18.getValue ().isEmpty() || clm19.getValue ().isEmpty() || clm20.getValue ().isEmpty() || clm21.getValue ().isEmpty() ||
                    clm22.getValue ().isEmpty() || clm22.getValue ().isEmpty() || clm23.getValue ().isEmpty() || clm24.getValue ().isEmpty() || clm25.getValue ().isEmpty() || clm26.getText ().isEmpty() || clm27.getText ().isEmpty() ||
                    clm28.getText ().isEmpty() || clm29.getText ().isEmpty() || clm30.getText().isEmpty())  {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("All field required");
                alert.setHeaderText(null);
                alert.setContentText("Please enter your username, email and password to signup");
                alert.show();

            }if (addStud > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Time table Updated Successfully");
                alert.show();

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Data");
                alert.show();
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }




    }

    @FXML
    private void searchStudent(ActionEvent event) {
    }

  

}
