package controller.staff;

import Model.Staff;
import animatefx.animation.Pulse;
import db.TableSchema;
import com.jfoenix.controls.JFXButton;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tableModel.StaffTableModel;




public class StaffManagementController implements Initializable {



    @FXML
    private TableView<Staff> tableView;

    @FXML
    private TableColumn<Staff, Integer> clmID;

    @FXML
    private TableColumn<Staff, String> clmStaffName;
    @FXML
    private TableColumn<Staff, String> clmClasses;
    @FXML
    private TableColumn<Staff, String> clmGender;
    @FXML
    private TableColumn<Staff, String> clmDOB;
    @FXML
    private TableColumn<Staff, String> clmHired;
    @FXML
    private TableColumn<Staff, String> clmDepartment;
    @FXML
    private TableColumn<Staff, String> clmPosition;
    @FXML
    private TableColumn<Staff, String> clmDegree;
    @FXML
    private TableColumn<Staff, String> clmSalary;
    @FXML
    private TableColumn<Staff, String> clmContact;
    @FXML
    private TableColumn<Staff, String> clmEmail;
    @FXML
    private TableColumn<Staff, String> clmAddress;
    @FXML
    private TableColumn<Staff, String> clmState;


    ObservableList<Staff> staffList = FXCollections.observableArrayList();
    @FXML
    private Button btnBack;
    @FXML
    private TextField tfSearch;
    @FXML
    private Button btnAddStaff;
    @FXML
    private Button btnPrintStaff;
    @FXML
    private Button btnManageStaff;
    @FXML
    private Button moveStaff;
    @FXML
    private TableColumn<?, ?> clmID1;




    @Override
    public void initialize(URL location, ResourceBundle resources) {


        FilteredList<Staff> filteredData = new FilteredList<>(staffList, e -> true);
        tfSearch.setOnKeyReleased (e -> {
            tfSearch.textProperty ().addListener ((observable, oldValue, newValue) -> {
                filteredData.setPredicate ((Predicate<? super Staff>) staff-> {
                    if (newValue == null || newValue.isEmpty ()) {
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase ();
                    if (staff.getName ().toLowerCase ().contains (lowerCaseFilter)){
                        return  true;
                    }else if (staff.getClasses ().toLowerCase ().contains (lowerCaseFilter)){
                        return  true;
                    }else if (staff.getGender ().toLowerCase ().contains (lowerCaseFilter)) {
                        return  true;
                    }else  if (staff.getDepartment ().toLowerCase ().contains (lowerCaseFilter)) {
                        return true;
                    }else if (staff.getPosition ().toLowerCase ().contains (lowerCaseFilter)){
                        return true;
                    }else if (staff.getState ().toLowerCase ().contains (lowerCaseFilter)){
                        return  true;


                    }return false;


                });
            });

            SortedList<Staff> sortedData = new SortedList<> (filteredData);

            sortedData.comparatorProperty ().bind (tableView.comparatorProperty ());

            tableView.setItems (sortedData);
        });


            try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM staffs");

            while (resultSet.next()) {
                staffList.addAll(new Staff(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("classes"),
                        resultSet.getString("gender"),
                        resultSet.getString("dob"),
                        resultSet.getString("hired"),
                        resultSet.getString("position"),
                        resultSet.getString("department"),
                        resultSet.getString("degree"),
                        resultSet.getString("salary"),
                        resultSet.getString("contact"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("state")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }


        clmID.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmStaffName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmClasses.setCellValueFactory(new PropertyValueFactory<>("classes"));
        clmGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        clmDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        clmHired.setCellValueFactory(new PropertyValueFactory<>("hired"));
        clmPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        clmDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        clmDegree.setCellValueFactory(new PropertyValueFactory<>("degree"));
        clmSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        clmContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        clmEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        clmState.setCellValueFactory(new PropertyValueFactory<>("state"));


        tableView.setItems(staffList);


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
    private void addStaffOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Staff/addStaff.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void manageStaffOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Staff/ManageStaffs.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }



    @FXML
    private void printStaffOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Staff/PrintStaffs.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

    }

    @FXML
    private void tfSearchOnAction(ActionEvent event) {
    }




    @FXML
    private void handleSearchButton(ActionEvent event) {

    }

    @FXML
    private void btnMoveStaff(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Staff/MoveStaff.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }


}
