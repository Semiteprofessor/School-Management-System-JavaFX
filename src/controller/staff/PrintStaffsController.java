package controller.staff;


import db.DBConnection;
import db.TableSchema;
import controller.ReportViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import tableModel.StaffTableModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.control.Button;


public class PrintStaffsController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TableView<StaffTableModel> staffTable;
    @FXML
    private TableColumn<StaffTableModel, Integer> clmID;
    @FXML
    private TableColumn<StaffTableModel, String> clmStaffName;
    @FXML
    private TableColumn<StaffTableModel, String> clmClasses;
    @FXML
    private TableColumn<StaffTableModel, String> clmGender;
    @FXML
    private TableColumn<StaffTableModel, String> clmDOB;
    @FXML
    private TableColumn<StaffTableModel, String> clmHired;
    @FXML
    private TableColumn<StaffTableModel, String> clmDepartment;
    @FXML
    private TableColumn<StaffTableModel, String> clmPosition;
    @FXML
    private TableColumn<StaffTableModel, String> clmDegree;
    @FXML
    private TableColumn<StaffTableModel, String> clmContact;
    @FXML
    private TableColumn<StaffTableModel, String> clmEmail;
    @FXML
    private TableColumn<StaffTableModel, String> clmAddress;
    @FXML
    private TableColumn<StaffTableModel, String> clmState;
    @FXML
    private TableColumn<StaffTableModel, String> clmSalary;

    @FXML
    private Button printStaff;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Type.getItems().addAll("Current Staffs", "Old Staffs");
    }
    private AnchorPane root;

    @FXML
    private ComboBox<String> Type;


    @FXML
    private Button generate;




    ObservableList<StaffTableModel> staffList = FXCollections.observableArrayList();

    void Back() {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/view/staff/StaffManagement.fxml")));
            root.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    void Type(ActionEvent event) {

    }
    //Below code for On key press methods..

    /*@FXML
    void gen(KeyEvent event){
        generate.setOnKeyTyped((e)->{
            if (e.getCode() == KeyCode.G){
                generate();
            }
        });
    }*/

    @FXML
    void generate() {

        try{
            staffTable.getItems().clear();
            String type = Type.getValue();

            Connection conn = DBConnection.getDBConnection().getConnection();



            if (type == "Current Staffs") {


                String sql = "select * from staffs";
                ResultSet rs = conn.createStatement().executeQuery(sql);


                while (rs.next()) {

                    StaffTableModel staff = new StaffTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("hired"),
                            rs.getString("position"),
                            rs.getString("department"),
                            rs.getString("degree"),
                            rs.getString("salary"),
                            rs.getString("contact"),
                            rs.getString("email"),
                            rs.getString("address"),
                            rs.getString("state"));
                    staffList.add(staff);
                }
            }
            else if (type == "Old Staffs"){

                String sql = "select * from oldstaff";
                ResultSet rs = conn.createStatement().executeQuery(sql);


                while (rs.next()) {

                    StaffTableModel staff = new StaffTableModel(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("classes"),
                            rs.getString("gender"),
                            rs.getString("dob"),
                            rs.getString("hired"),
                            rs.getString("position"),
                            rs.getString("department"),
                            rs.getString("degree"),
                            rs.getString("salary"),
                            rs.getString("contact"),
                            rs.getString("email"),
                            rs.getString("address"),
                            rs.getString("state"));
                    staffList.add(staff);
                }
            }



            //Ctrl+D for copy above line
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

            staffTable.setItems(staffList);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }



    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/staff/StaffManagement.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    private void printStudents(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/staff/PrintStaffs.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void printStaff(ActionEvent event) throws SQLException {staffTable.getItems().clear();
        String type = Type.getValue();

        try {

            Connection conn = DBConnection.getDBConnection().getConnection();

            InputStream report1 = getClass().getResourceAsStream("/Reports/StaffList.jrxml");
            InputStream report2 = getClass().getResourceAsStream("/Reports/StaffListPast.jrxml");

            JRDesignQuery query = new JRDesignQuery();

            /*HashMap<String,Object> Logo = new HashMap<String, Object>();

            URL url = this.getClass().getClassLoader().getResource("Images/dp.png");
            Logo.put("logo", url);*/

            if (type == "Current Staffs"){

                JasperDesign jd = JRXmlLoader.load(report1);
                query.setText("select * from staffs");
                jd.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd);
            }
            else {

                JasperDesign jd2 = JRXmlLoader.load(report2);
                query.setText("select * from oldstaffs");
                jd2.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd2);
            }
        } catch (JRException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

}
