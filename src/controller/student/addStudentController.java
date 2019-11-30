/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import Model.Student;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import db.TableSchema;
import com.jfoenix.controls.JFXTextField;
import java.sql.Connection;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dbController.ClassesController;
import dbController.StudentController;
import javafx.stage.FileChooser.ExtensionFilter;

import java.util.*;

import javafx.stage.FileChooser;
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
import javafx.scene.image.ImageView;
import db.DBConnection;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.sql.Connection;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class addStudentController implements Initializable {

    private JFXTextField clmName;
    @FXML
    private JFXTextField clmDepartment;
    @FXML
    private JFXComboBox<String> clmGender;
    @FXML
    private JFXDatePicker clmDateAdmitted;
    @FXML
    private JFXTextField clmDesignation;
    @FXML
    private JFXDatePicker clmDOB;
    @FXML
    private JFXTextField clmDisability;
    @FXML
    private JFXTextField clmContact;
    @FXML
    private JFXTextField clmAddress;
    @FXML
    private JFXTextField clmState;

    ObservableList<String> list = FXCollections.observableArrayList("Male", "Female");
    @FXML
    private JFXTextField clmStudentName;
    @FXML
    private JFXTextField clmClasses;
    @FXML
    private JFXTextField clmID;
    @FXML
    private JFXTextField clmYear;
    @FXML
    private ImageView imageViewStudentImage;
    @FXML
    private Button selectImage;


    StudentController studentController = new StudentController ();

    File file = null;
    File copyFile = null;
    FileChooser chooser = new FileChooser();
    FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
    FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
    String path = System.getProperty("user.home");
    Random rand = new Random();
    int n = rand.nextInt(999999999) + 1;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {



        clmGender.setItems(list);
    }





    @FXML
    private void addStud(ActionEvent event) throws SQLException, ClassNotFoundException {


        Connection conn = DBConnection.getDBConnection().getConnection();


        try {

            String id = clmID.getText ();
            String name = clmStudentName.getText ();
            String classes = clmClasses.getText ();
            String gender = clmGender.getValue ();
            String dob = String.valueOf (clmDOB.getValue ());
            String admitted = String.valueOf (clmDateAdmitted.getValue ());
            String department = clmDepartment.getText ();
            String disability = clmDisability.getText ();
            String designation = clmDesignation.getText ();
            String contact = clmContact.getText ();
            String address = clmAddress.getText ();
            String state = clmState.getText ();
            String year = clmYear.getText ();


            int addStud;
            try (Statement statement = conn.createStatement ()) {

                addStud = statement.executeUpdate ("INSERT INTO students (id, name, classes, gender, dob, admitted, department, disability, designation, contact, address, state, year  )" +
                        "VALUES('" + id + "', '" + name + "', '" + classes + "', '" + gender + "', '" + dob + "', '" + admitted + "', '" + department + "', '" + disability + "', '" + designation + "', '" + contact + "', '" + address + "', '" + state + "', '" + year + "') ");
            }


            if (clmID.getText().isEmpty() || clmStudentName.getText().isEmpty() || clmClasses.getText().isEmpty() || clmGender.getItems().isEmpty() || clmDOB.getPromptText().isEmpty() || clmDateAdmitted.getPromptText().isEmpty() || clmDepartment.getText().isEmpty() || clmDisability.getText().isEmpty() || clmDesignation.getText().isEmpty() ||
                    clmContact.getText().isEmpty() || clmAddress.getText().isEmpty() || clmState.getText().isEmpty() || clmYear.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("All field required");
                alert.setHeaderText(null);
                alert.setContentText("Please fill the required field");
                alert.show();

            }if (addStud > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Student Registered Successfully");
                alert.show();

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText(null);
                alert.setContentText("OOOps! There is a problem registering student");
                alert.show();
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }



}


    @FXML
    private void Reset(ActionEvent event) {

        clmID.setText(null);
        clmStudentName.setText(null);
        clmClasses.setText(null);
        clmGender.setValue(null);
        clmDOB.setValue (null);
        clmDateAdmitted.setValue (null);
        clmDepartment.setText(null);
        clmDisability.setText(null);
        clmDesignation.setText(null);
        clmContact.setText(null);
        clmAddress.setText(null);
        clmState.setText(null);
        clmYear.setText(null);
    }

    @FXML
    private void loadComboBox(){
        ArrayList arrayList = null;
        try {
            arrayList = ClassesController.getClasses ();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null){
            clmGender.setItems(observableArray);
        }

    }



    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Student/StudentManagement.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void selectStudentImageOnAction(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle("Choos a thumbnail (Image only)");
        chooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        file = chooser.showOpenDialog(stage);
        String imagePath = file.getPath();

        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageViewStudentImage.setImage(image);
        } catch (IOException e) {
            e.printStackTrace ();
        }


    }

    private void resetForm() {
        Image image = new Image("/Images/avater.jpg");
        imageViewStudentImage.setImage(image);
    }

    private String copyImage() {
        if (file != null) {
            copyFile = new File(path + "\\Documents\\SchoolManagement\\" + n + file.getName());
        } else {
            return null;
        }
        System.out.println(copyFile.getPath());

        try {
            Files.copy(Paths.get(file.getPath()), Paths.get(copyFile.getPath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace ();
        }

        return copyFile.getName();


    }


    
}
