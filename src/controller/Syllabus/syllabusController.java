/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Syllabus;

import animatefx.animation.Pulse;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class syllabusController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private AnchorPane rootAnchorPane;
    @FXML
    private Button viewSubject;
    @FXML
    private Button updateSubject;
    @FXML
    private Button classNote;
    @FXML
    private JFXComboBox<String> sub1;
    @FXML
    private JFXComboBox<String> sub2;
    @FXML
    private JFXComboBox<String> sub3;
    @FXML
    private JFXComboBox<String> sub4;
    @FXML
    private JFXComboBox<String> sub5;
    @FXML
    private JFXComboBox<String> sub6;
    @FXML
    private JFXComboBox<String> sub7;
    @FXML
    private JFXComboBox<String> sub8;
    @FXML
    private JFXComboBox<String> sub9;
    @FXML
    private JFXComboBox<String> sub10;
    @FXML
    private JFXTextField teach1;
    @FXML
    private JFXTextField teach2;
    @FXML
    private JFXTextField teach3;
    @FXML
    private JFXTextField teach4;
    @FXML
    private JFXTextField teach5;
    @FXML
    private JFXTextField teach6;
    @FXML
    private JFXTextField teach7;
    @FXML
    private JFXTextField teach8;
    @FXML
    private JFXTextField teach9;
    @FXML
    private JFXTextField teach10;
    @FXML
    private JFXTextArea out1;
    @FXML
    private JFXTextArea out2;
    @FXML
    private JFXTextArea out3;
    @FXML
    private JFXTextArea out4;
    @FXML
    private JFXTextArea out5;
    @FXML
    private JFXTextArea out6;
    @FXML
    private JFXTextArea out7;
    @FXML
    private JFXTextArea out9;
    @FXML
    private JFXTextArea out10;
    @FXML
    private JFXComboBox<String> term1;
    @FXML
    private JFXComboBox<String> term2;
    @FXML
    private JFXComboBox<String> term3;
    @FXML
    private JFXComboBox<String> term4;
    @FXML
    private JFXComboBox<String> term5;
    @FXML
    private JFXComboBox<String> term6;
    @FXML
    private JFXComboBox<String> term7;
    @FXML
    private JFXComboBox<String> term8;
    @FXML
    private JFXComboBox<String> term9;
    @FXML
    private JFXComboBox<String> term10;
    @FXML
    private JFXTextArea note1;
    @FXML
    private JFXTextArea note2;
    @FXML
    private JFXTextArea note3;
    @FXML
    private JFXTextArea note4;
    @FXML
    private JFXTextArea note5;
    @FXML
    private JFXTextArea note6;
    @FXML
    private JFXTextArea note7;
    @FXML
    private JFXTextArea note8;
    @FXML
    private JFXTextArea note9;
    @FXML
    private JFXTextArea note10;




    ObservableList<String> list = FXCollections.observableArrayList("ENGLISH", "MATHEMATICS", "CIVIC EDUCATION", "ECONOMICS",
            "LITERATURE IN ENG", "GOVERNMENT", "PHYSICS", "CHEMISTRY", "AGRIC SCIENCE", "BIOLOGY", "F/MATHS", "I.R.S", "C.R.S",
            "MUSIC", "HISTORY", "COMMERCE", "ACCOUNT", "YORUBA", "HAUSA", "IGBO", "FRENCH", "MARKETING",
            "HEALTH EDUCATION", "PHYSICAL EDUCATION", "GEOGRAPHY", "BASIC SCIENCE", "SOCIAL STUDIES", "FINE ART", "BUSINESS STUDIES", "COMPUTER", "HOME ECONOMICS",
            "BASIC TECH", "INTRO TECH");

    ObservableList<String> list1 = FXCollections.observableArrayList("FIRST", "SECOND", "THIRD");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sub1.setItems(list);sub2.setItems(list);sub3.setItems(list);sub4.setItems(list);sub5.setItems(list);
        sub6.setItems(list);sub7.setItems(list);sub8.setItems(list);sub9.setItems(list);term1.setItems(list1);
        term2.setItems(list1);term3.setItems(list1);term4.setItems(list1);term5.setItems(list1);term6.setItems(list1);
        term7.setItems(list1);term8.setItems(list1);term9.setItems(list1);term10.setItems(list1);
    }    

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));

        new Pulse (home).play ();
    }

    @FXML
    private void btnPrintSubject(ActionEvent event) {
    }

    @FXML
    private void btnUpdateSubject(ActionEvent event) {


    }

    @FXML
    private void btnSubjectView(ActionEvent event)  throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Syllabus/subjectView.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnClassNote(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Syllabus/classNote.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }
    
}
