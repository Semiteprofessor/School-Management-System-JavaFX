package controller.users;

import db.TableSchema;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.stage.Stage;





public class UserAccountController implements Initializable {

    @FXML
    private Button btnBack;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private AnchorPane userAccount;

    @FXML
    private Button btnLogout;

    @FXML
    private Button ManageUsers;


    @FXML
    private void ManageUsers(javafx.event.ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/users/ManageUsers.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }




    @FXML
    private void btnBackHomeOnAction(javafx.event.ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnLogout(javafx.event.ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/view/users/login.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }
}
