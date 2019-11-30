/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.classes.JS1;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class addSubjectController implements Initializable {

    @FXML
    private JFXTextField clmID;
    @FXML
    private JFXTextField clmName;
    @FXML
    private JFXTextField clmTeacher;
    @FXML
    private JFXComboBox<?> clmTerm;
    @FXML
    private TextArea clmOutline;
    @FXML
    private TextArea clmNote;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load (getClass ().getResource ("/View/classes/JS1/subject.fxml"));
        Node node = (Node) event.getSource ();
        Stage stage = (Stage) node.getScene ().getWindow ();
        stage.setScene (new Scene (home));
    }

        @FXML
    private void addStud(ActionEvent event) {
    }

    @FXML
    private void Reset(ActionEvent event) {
    }
    
}
