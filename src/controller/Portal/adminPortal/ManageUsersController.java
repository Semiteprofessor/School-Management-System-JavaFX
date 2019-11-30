/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Portal.adminPortal;

import Model.User;
import animatefx.animation.Pulse;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dbController.UserController;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tableModel.UserTableModel;


public class ManageUsersController implements Initializable {

    @FXML
    private Button btnBack;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTable();
    }


    private final ObservableList<UserTableModel> data = FXCollections.observableArrayList();

    @FXML
    private TableView<UserTableModel> usersTable;

    @FXML
    private TableColumn<UserTableModel, String> UsernameColumn;

    @FXML
    private TableColumn<UserTableModel, String> passwordColumn;

    @FXML
    private Button addUser;

    @FXML
    private JFXTextField userNameField;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private Button searchUser;

    @FXML
    private Button updateUser;

    @FXML
    private Button deleteUser;


    private AnchorPane root;





    void loadTable(){
        //Wrote this Method as Sepereate Because can use this for Table Refresh as well.

        UsernameColumn.setCellValueFactory(new PropertyValueFactory<UserTableModel, String> ("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<UserTableModel, String>("password"));

        try {
            usersTable.setItems(data);
            ArrayList<User> users = null;
            users = UserController.getAllUsers();

            for (User user : users) {
                UserTableModel ctm = new UserTableModel();
                ctm.setUsername(user.getUsername());
                ctm.setPassword(user.getPassword());
                data.add(ctm);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void addUser() {

        try {

            String username = userNameField.getText();
            String password = passwordField.getText();

            User user = new User(username, password);
            int i = 0;
            try {
                i = UserController.addUser(user);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (i > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("User Management");
                alert.setHeaderText(null);
                alert.setContentText("User Registered Successfully..!");
                alert.showAndWait();

                userNameField.setText(null);
                passwordField.setText(null);
            }
            data.clear();               //Refresh Table
            loadTable();                //Refresh Table

        } catch (SQLException e1) {
            e1.printStackTrace();

        }

    }

    @FXML
    void deleteUser(ActionEvent event) {
        String username = userNameField.getText();

        try {
            int deleteUser = UserController.deleteUser(username);

            if(deleteUser > 0){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("User Management");
                alert.setHeaderText(null);
                alert.setContentText("User Deleted Sucessfully..!");
                alert.showAndWait();

                userNameField.setText(null);
                passwordField.setText(null);

                data.clear();               //Refresh Table
                loadTable();                //Refresh Table

            } else {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("User Management");
                alert.setHeaderText(null);
                alert.setContentText("There is an Error in Deleting User..!");
                alert.showAndWait();

                userNameField.setText(null);
                passwordField.setText(null);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void searchUser(ActionEvent event) {

        String username = userNameField.getText();

        try {
            User search = UserController.searchUser(username);

            if(search != null){

                userNameField.setText(search.getUsername());
                passwordField.setText(search.getPassword());

            }else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("User Management");
                alert.setHeaderText(null);
                alert.setContentText("User Not Found");
                alert.showAndWait();

                userNameField.setText(null);
                passwordField.setText(null);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void updateUser(ActionEvent event) {

        String username = userNameField.getText();
        String password = passwordField.getText();

        try {

            User user = new User(username,password);
            int update = UserController.updateUser(user);

            if(update > 0){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("User Management");
                alert.setHeaderText(null);
                alert.setContentText("User Updated Successfully..!");
                alert.showAndWait();

                userNameField.setText(null);
                passwordField.setText(null);

                data.clear();
                loadTable();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Portal/adminPortal/UserAccount.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new Pulse (home).play ();
    }

}
