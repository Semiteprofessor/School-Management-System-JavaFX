/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import animatefx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class HomeController implements Initializable {

    @FXML
    private Button library;
    @FXML
    private Button reportCard;
    @FXML
    private Button aboutSchool;


    private double xOffset;
    private double yOffset;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Pane homePage;
    @FXML
    private Button Min;
    @FXML
    private Button Max;
    @FXML
    private Button Close;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // ******** Code below is for Draggable windows **********

        // Set up Mouse Dragging for the Event pop up window
        homePage.setOnMousePressed(new EventHandler<MouseEvent> () {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) rootPane.getScene().getWindow();
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });
        // Set up Mouse Dragging for the Event pop up window
        homePage.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) rootPane.getScene().getWindow();
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
        // Change cursor when hover over draggable area
        homePage.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) rootPane.getScene().getWindow();
                Scene scene = stage.getScene();
                scene.setCursor(Cursor.HAND); //Change cursor to hand
            }
        });

        // Change cursor when hover over draggable area
        homePage.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) rootPane.getScene().getWindow();
                Scene scene = stage.getScene();
                scene.setCursor(Cursor.DEFAULT); //Change cursor to hand
            }
        });
    }    

    @FXML
    private void btnDashboard(ActionEvent event)throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Dashboard/Dashboard.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new Flip (home).play ();
    }

    @FXML
    private void btnResult(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Bursary/bursary.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new Flip (home).play ();

    }

    @FXML
    private void btnStudent(ActionEvent event)throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Student/StudentManagement.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new RotateInUpLeft (home).play ();
    }


    @FXML
    private void btnStaff(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/staff/StaffManagement.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new RotateIn (home).play ();
    }


    @FXML
    private void btnClasses(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/enterClasses.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new RollIn (home).play ();
    }


    @FXML
    private void btnLibraryOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/inventory.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new SlideInDown (home).play ();
        
    }


    @FXML
    private void btnSession(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/session/session.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new Wobble (home).play ();

    }


    @FXML
    private void btnAdmin(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Portal/mainPortal.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new ZoomIn (home).play ();
    }

    @FXML
    private void btnTimeTable(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/timeTable/timeTable.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new RubberBand (home).play ();
    }

    @FXML
    private void btnReportCard(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/reportCard/reportCard.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new Shake (home).play ();

    }

    @FXML
    private void btnSchoolInfo(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/school/AboutSchool.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new LightSpeedIn (home).play ();
    }

    @FXML
    private void btnExam(ActionEvent event)  throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Event/ui/main/FXMLDocument.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new Shake (home).play ();
    }

    @FXML
    private void btnSyllabus(ActionEvent event)  throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Syllabus/syllabus.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new BounceInDown (home).play ();
    }

    @FXML
    private void btnEvent(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Management/event.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new RotateInUpLeft (home).play ();
    }

    @FXML
    private void btnAttendance(ActionEvent event)  throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Attendance/attendance.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new FadeInDown (home).play ();
    }

    @FXML
    private void btnMinimize(ActionEvent event) {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setIconified(true);

    }

    @FXML
    private void btnMaximize(ActionEvent event) {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setFullScreen(true);
    }

    @FXML
    private void btnClose(ActionEvent event) {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
    
}
