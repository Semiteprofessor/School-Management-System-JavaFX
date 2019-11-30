/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Dashboard;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animatefx.animation.Pulse;
import db.TableSchema;
import dbController.SubjectController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.chart.PieChart;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import dbController.StudentController;
import dbController.StaffController;
import dbController.ClassesController;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class DashboardController implements Initializable {

    private PieChart pieChart;
    @FXML
    private Text lblTotalStudents;
    @FXML
    private Text lblTotalStaff;
    @FXML
    private Text lblTotalCLasses;
    @FXML
    private Text lblTotalStudents1;
    @FXML
    private Text lblTotalStaff1;
    @FXML
    private Text lblTotalCLasses1;
    @FXML
    private Text lblTotalBook1;
    @FXML
    private Text lblTotalStudents11;
    @FXML
    private Text lblTotalStaff11;
    @FXML
    private Text lblTotalCLasses11;
    @FXML
    private Text lblTotalBook11;
    @FXML
    private Text lblTotalSubject;
    @FXML
    private AnchorPane dashboardRoot;
    @FXML
    private Pane dragPane;


    private double xOffset;
    private double yOffset;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // ******** Code below is for Draggable windows **********

        // Set up Mouse Dragging for the Event pop up window
        dragPane.setOnMousePressed(new EventHandler<MouseEvent> () {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) dashboardRoot.getScene().getWindow();
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });
        // Set up Mouse Dragging for the Event pop up window
        dragPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) dashboardRoot.getScene().getWindow();
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
        // Change cursor when hover over draggable area
        dragPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) dashboardRoot.getScene().getWindow();
                Scene scene = stage.getScene();
                scene.setCursor(Cursor.HAND); //Change cursor to hand
            }
        });

        // Change cursor when hover over draggable area
        dragPane.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) dashboardRoot.getScene().getWindow();
                Scene scene = stage.getScene();
                scene.setCursor(Cursor.DEFAULT); //Change cursor to hand
            }
        });


        try {
            lblTotalStudents.setText(String.valueOf(StudentController.totalStudent()));
        } catch (SQLException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
        try {
            lblTotalStaff.setText(String.valueOf(StaffController.totalStaff()));
        } catch (SQLException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
        try {
            lblTotalCLasses.setText(String.valueOf(ClassesController.totalClasses()));
        } catch (SQLException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
        try {
            lblTotalSubject.setText(String.valueOf(SubjectController.totalSubject ()));
        } catch (SQLException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }


    }

    private void max(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setFullScreen(true);

    }

    private void min(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setIconified(true);

    }

    private void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }


    double x = 0, y = 0;





    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new Pulse (home).play ();

    }






}