/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Portal.assessmentPortal;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.chart.*;
import animatefx.animation.Pulse;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import tableModel.StudentTableModel;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class assessmentController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private ComboBox<String> loadTerm;
    @FXML
    private ComboBox<String> loadClasses;
    @FXML
    private StackedBarChart<String, Double> chartView;
    @FXML
    private Button checkStat;
    @FXML
    private ComboBox<String> loadSubject;
    private AreaChart<String, Double> areaView;
    @FXML
    private ScatterChart<String, Double> scatterView;
    @FXML
    private BarChart<String, Double> lineChart;
    @FXML
    private ComboBox<String> loadDepartment;
    @FXML
    private PieChart PieChart;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        loadClasses.getItems().addAll("JS1", "JS2", "JS3", "SS1", "SS2", "SS3", "All Classes", "None");
        loadTerm.getItems ().addAll ("First", "Second", "Third", "None");
        loadDepartment.getItems().addAll("Science", "Commercial", "Art", "None");
        loadSubject.getItems().addAll("ENGLISH", "MATHEMATICS", "CIVIC EDUCATION", "ECONOMICS",
                "LITERATURE IN ENG", "GOVERNMENT", "PHYSICS", "CHEMISTRY", "AGRIC SCIENCE", "BIOLOGY", "F/MATHS", "I.R.S", "C.R.S",
                "MUSIC", "HISTORY", "COMMERCE", "ACCOUNT", "YORUBA", "HAUSA", "IGBO", "FRENCH", "MARKETING",
                "HEALTH EDUCATION", "PHYSICAL EDUCATION", "GEOGRAPHY", "BASIC SCIENCE", "SOCIAL STUDIES", "FINE ART", "BUSINESS STUDIES", "COMPUTER", "HOME ECONOMICS",
                "BASIC TECH", "INTRO TECH");
    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load (getClass ().getResource ("/View/Portal/mainPortal.fxml"));
        Node node = (Node) event.getSource ();
        Stage stage = (Stage) node.getScene ().getWindow ();
        stage.setScene (new Scene (home));

        new Pulse (home).play ();
    }


    @FXML
    private void btnCheckStatistics(ActionEvent event) throws SQLException {

        ObservableList<PieChart.Data>piechartdata;

        piechartdata  = FXCollections.observableArrayList();
        ArrayList<Integer> cell = new ArrayList<Integer> ();
        ArrayList<String> name = new ArrayList<String> ();


        StackedBarChart.Series<String, Double> series = new StackedBarChart.Series<> ();
        ScatterChart.Series<String, Double> series1 = new ScatterChart.Series<> ();
        LineChart.Series<String, Double> series3 = new LineChart.Series<> ();


        String classes = loadClasses.getValue();
        String term = loadTerm.getValue();
        String subject = loadSubject.getValue();
        String department = loadDepartment.getValue();

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }


        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        ResultSet resultSet = null;
        try {

            if (classes == "JS1") {
                resultSet = conn.createStatement ().executeQuery ("SELECT name, totaleng FROM broadsheetscience1 ORDER BY totaleng ");




                // if((loadGrades != null)&&(loadGender != null)){


                while (resultSet.next()) {
                    series.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    series1.getData ().add (new XYChart.Data<>  (resultSet.getString (1), resultSet.getDouble (2)));
                    series3.getData ().add (new XYChart.Data<>  (resultSet.getString (1), resultSet.getDouble (2)));
                    piechartdata.add (new PieChart.Data (resultSet.getString (1), resultSet.getInt (2)));
                    name.add (resultSet.getString (1));
                    cell.add (resultSet.getInt (2));


                chartView.getData ().add (series);
                scatterView.getData ().add (series1);
                lineChart.getData ().add (series3);

                name.add (resultSet.getString (1));
                cell.add (resultSet.getInt (2));

                PieChart.setData (piechartdata);

}
            } else if (classes == "JS2") {

                resultSet = conn.createStatement ().executeQuery ("SELECT name, totaleng FROM broadsheetscience1 ORDER BY totaleng ");


                // if((loadGrades != null)&&(loadGender != null)){


                while (resultSet.next ()) {
                    series.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    series1.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    series3.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    piechartdata.add (new PieChart.Data (resultSet.getString (1), resultSet.getInt (2)));
                    name.add (resultSet.getString (1));
                    cell.add (resultSet.getInt (2));


                chartView.getData ().add (series);
                scatterView.getData ().add (series1);
                lineChart.getData ().add (series3);

                name.add (resultSet.getString (1));
                cell.add (resultSet.getInt (2));

                PieChart.setData (piechartdata);
}
            }else if (classes == "JS3") {

                resultSet = conn.createStatement ().executeQuery ("SELECT name, totaleng FROM broadsheetscience1 ORDER BY totaleng ");


                // if((loadGrades != null)&&(loadGender != null)){


                while (resultSet.next ()) {
                    series.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    series1.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    series3.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    piechartdata.add (new PieChart.Data (resultSet.getString (1), resultSet.getInt (2)));
                    name.add (resultSet.getString (1));
                    cell.add (resultSet.getInt (2));


                chartView.getData ().add (series);
                scatterView.getData ().add (series1);
                lineChart.getData ().add (series3);

                name.add (resultSet.getString (1));
                cell.add (resultSet.getInt (2));

                PieChart.setData (piechartdata);
}
            }else if (classes == "SS1" && department == "Science") {

                resultSet = conn.createStatement ().executeQuery ("SELECT name, totaleng FROM broadsheetscience1 ORDER BY totaleng ");


                // if((loadGrades != null)&&(loadGender != null)){


                while (resultSet.next ()) {
                    series.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    series1.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    series3.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    piechartdata.add (new PieChart.Data (resultSet.getString (1), resultSet.getInt (2)));
                    name.add (resultSet.getString (1));
                    cell.add (resultSet.getInt (2));


                chartView.getData ().add (series);
                scatterView.getData ().add (series1);
                lineChart.getData ().add (series3);

                name.add (resultSet.getString (1));
                cell.add (resultSet.getInt (2));

                PieChart.setData (piechartdata);
}
            }else if (classes == "SS1" && department == "Science") {

                resultSet = conn.createStatement ().executeQuery ("SELECT name, totaleng FROM broadsheetscience1 ORDER BY totaleng ");


                // if((loadGrades != null)&&(loadGender != null)){


                while (resultSet.next ()) {
                    series.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    series1.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    series3.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    piechartdata.add (new PieChart.Data (resultSet.getString (1), resultSet.getInt (2)));
                    name.add (resultSet.getString (1));
                    cell.add (resultSet.getInt (2));


                chartView.getData ().add (series);
                scatterView.getData ().add (series1);
                lineChart.getData ().add (series3);

                name.add (resultSet.getString (1));
                cell.add (resultSet.getInt (2));

                PieChart.setData (piechartdata);
}
            }else if (classes == "JS2") {

                resultSet = conn.createStatement ().executeQuery ("SELECT name, totaleng FROM broadsheetscience1 ORDER BY totaleng ");


                // if((loadGrades != null)&&(loadGender != null)){


                while (resultSet.next ()) {
                    series.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    series1.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    series3.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    piechartdata.add (new PieChart.Data (resultSet.getString (1), resultSet.getInt (2)));
                    name.add (resultSet.getString (1));
                    cell.add (resultSet.getInt (2));


                chartView.getData ().add (series);
                scatterView.getData ().add (series1);
                lineChart.getData ().add (series3);
;
                name.add (resultSet.getString (1));
                cell.add (resultSet.getInt (2));

                PieChart.setData (piechartdata);
}
            }else if (classes == "JS2") {

                resultSet = conn.createStatement ().executeQuery ("SELECT name, totaleng FROM broadsheetscience1 ORDER BY totaleng ");


                // if((loadGrades != null)&&(loadGender != null)){


                while (resultSet.next ()) {
                    series.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    series1.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    series3.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    piechartdata.add (new PieChart.Data (resultSet.getString (1), resultSet.getInt (2)));
                    name.add (resultSet.getString (1));
                    cell.add (resultSet.getInt (2));


                chartView.getData ().add (series);
                scatterView.getData ().add (series1);
                lineChart.getData ().add (series3);


                PieChart.setData (piechartdata);
}
            }else if (classes == "JS2"){

                resultSet = conn.createStatement ().executeQuery ("SELECT name, totaleng FROM broadsheetscience1 ORDER BY totaleng ");




                while (resultSet.next()) {
                    series.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                    series1.getData ().add (new XYChart.Data<>  (resultSet.getString (1), resultSet.getDouble (2)));
                    series3.getData ().add (new XYChart.Data<>  (resultSet.getString (1), resultSet.getDouble (2)));
                    piechartdata.add (new PieChart.Data (resultSet.getString (1), resultSet.getInt (2)));
                    name.add (resultSet.getString (1));
                    cell.add (resultSet.getInt (2));


                chartView.getData ().add (series);
                scatterView.getData ().add (series1);
                lineChart.getData ().add (series3);

                name.add (resultSet.getString (1));
                cell.add (resultSet.getInt (2));

                PieChart.setData (piechartdata);

}
                                    }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}