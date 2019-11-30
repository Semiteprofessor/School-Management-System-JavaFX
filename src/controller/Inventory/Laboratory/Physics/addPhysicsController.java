/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Inventory.Laboratory.Physics;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;

import db.DBConnection;
import dbController.StudentController;
import dbController.SubjectController;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class addPhysicsController implements Initializable {

    private JFXTextField clmStudentName;
    private JFXTextField clmDesignation;
    @FXML
    private JFXTextField clmID;
    @FXML
    private ImageView imageViewStudentImage;
    @FXML
    private Button selectImage;


    SubjectController subjectController = new SubjectController ();

    File file = null;
    File copyFile = null;
    FileChooser chooser = new FileChooser();
    FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
    FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
    String path = System.getProperty("user.home");
    Random rand = new Random();
    int n = rand.nextInt(999999999) + 1;
    @FXML
    private JFXTextField clmApparatusName;
    @FXML
    private JFXTextField clmQuantity;
    @FXML
    private JFXTextArea clmNote;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/Laboratory/Physics/physicsLab.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));
    }



    @FXML
    private void Reset(ActionEvent event) {
    }



    @FXML
    private void addApparatusOnAction(ActionEvent event) {


        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }


        try {

            String id = clmID.getText ();
            Image image = imageViewStudentImage.getImage ();
            String name = clmApparatusName.getText ();
            String quantity = clmQuantity.getText ();
            String note = clmNote.getText ();


            int addStud;
            try (Statement statement = conn.createStatement ()) {

                addStud = statement.executeUpdate ("INSERT INTO physicslab (id, image, name, quantity, note)" +
                        "VALUES('" + id + "', '" + image + "', '" + name + "', '" + quantity + "', '" + note + "') ");
            }


            if (clmID.getText().isEmpty() || clmApparatusName.getText().isEmpty() || clmQuantity.getText().isEmpty() || clmNote.getText ().isEmpty()) {
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
    private void selectImageOnAction(ActionEvent event) {

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
            copyFile = new File (path + "\\Documents\\SchoolManagement\\" + n + file.getName());
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
