package controller.users;

import db.TableSchema;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.stage.Stage;




public class loginController implements Initializable {



    @FXML
    private Button btnBack;

    @FXML
    private JFXTextField usernameField;

    @FXML
    private JFXPasswordField pwdField;
    @FXML
    private Button Login;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }


    @FXML
    private void btnBackHomeOnAction(javafx.event.ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void Login(javafx.event.ActionEvent event) throws SQLException, IOException, ClassNotFoundException {

        String username = usernameField.getText();
        String password = pwdField.getText();

        Connection conn = DBConnection.getDBConnection().getConnection();

        Statement statement = conn.createStatement();


        ResultSet resultSet = statement.executeQuery("select * from users where username = '' "+username+"'   OR password =  ''"+password+"' ");

        if (resultSet.next()) {
            Parent root = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));

            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(root));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Login Successful");
            alert.show();

        } else if (usernameField.getText().isEmpty() || pwdField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("All field required");
            alert.setHeaderText(null);
            alert.setContentText("Please enter your username and password to login");
            alert.show();


        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Username or Password");
            alert.show();

        }
    }




}