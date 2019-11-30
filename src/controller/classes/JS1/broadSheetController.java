/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.classes.JS1;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import Model.BroadSheet2;
import db.DBConnection;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.gembox.spreadsheet.*;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class broadSheetController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TableView<BroadSheet2> tableView;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmID;
    @FXML
    private TableColumn<BroadSheet2, String> clmStudentName;
    @FXML
    private TableColumn<BroadSheet2, String> clmClasses;
    @FXML
    private TableColumn<BroadSheet2, String> clmTerm;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmEngTest;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmEngExam;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmEngTotal;
    @FXML
    private TableColumn<BroadSheet2, String> clmEngGrade;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmMathTest;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmMathExam;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmMathTotal;
    @FXML
    private TableColumn<BroadSheet2, String> clmMathGrade;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmPhyTest;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmPhyExam;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmPhyTotal;
    @FXML
    private TableColumn<BroadSheet2, String> clmPhyGrade;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmChemTest;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmCHemExam;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmCHemTotal;
    @FXML
    private TableColumn<BroadSheet2, String> clmChemGrade;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmBioTest;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmBioExam;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmBioTotal;
    @FXML
    private TableColumn<BroadSheet2, String> clmBioGrade;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmAgricTest;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmAgricExam;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmAgricTotal;
    @FXML
    private TableColumn<BroadSheet2, String> clmAgricGrade;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmEconsTest;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmEconExam;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmEconsTotal;
    @FXML
    private TableColumn<BroadSheet2, String> clmEconsGrade;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmFMathTest;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmFMathExam;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmFMathTotal;
    @FXML
    private TableColumn<BroadSheet2, String> clmFMathGrade;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmBTechTest;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmBtechExam;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmBTechTotal;
    @FXML
    private TableColumn<BroadSheet2, String> clmBTechGrade;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmBSciTest;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmBSciExam;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmBSciTotal;
    @FXML
    private TableColumn<BroadSheet2, String> clmBSciGrade;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmCivicTest;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmCivicExam;
    @FXML
    private TableColumn<BroadSheet2, Integer> clmCivicTotal;
    @FXML
    private TableColumn<BroadSheet2, String> clmCivicGrade;

    ObservableList<BroadSheet2> oblist = FXCollections.observableArrayList();
    @FXML
    private AnchorPane broadSheet;


    public TableView table;
    @FXML
    private ComboBox<?> loadTerm;
    @FXML
    private ComboBox<?> loadClasses;
    @FXML
    private Button checkStat;
    @FXML
    private Button importExcel;
    @FXML
    private Button addScore;
    @FXML
    private Button printScore;
    @FXML
    private Button editScore;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
            resultSet = conn.createStatement ().executeQuery ("SELECT * FROM broadsheetscience1");
        } catch (SQLException e) {
            e.printStackTrace ();
        }


        try {
            while (resultSet.next ()) {
                oblist.addAll (new BroadSheet2 (
                        resultSet.getInt ("id"),
                        resultSet.getString ("name"),
                        resultSet.getString ("classes"),
                        resultSet.getString ("term"),
                        resultSet.getInt ("testeng"),
                        resultSet.getInt ("exameng"),
                        resultSet.getInt ("totaleng"),
                        resultSet.getString ("gradeeng"),
                        resultSet.getInt ("testmath"),
                        resultSet.getInt ("exammath"),
                        resultSet.getInt ("totalmath"),
                        resultSet.getString ("grademath"),
                        resultSet.getInt ("testphy"),
                        resultSet.getInt ("examphy"),
                        resultSet.getInt ("totalphy"),
                        resultSet.getString ("gradephy"),
                        resultSet.getInt ("testche"),
                        resultSet.getInt ("examche"),
                        resultSet.getInt ("totalche"),
                        resultSet.getString ("gradeche"),
                        resultSet.getInt ("testbio"),
                        resultSet.getInt ("exambio"),
                        resultSet.getInt ("totalbio"),
                        resultSet.getString ("gradebio"),
                        resultSet.getInt ("testagr"),
                        resultSet.getInt ("examagr"),
                        resultSet.getInt ("totalagr"),
                        resultSet.getString ("gradeagr"),
                        resultSet.getInt ("testecon"),
                        resultSet.getInt ("examecon"),
                        resultSet.getInt ("totalecon"),
                        resultSet.getString ("gradeecon"),
                        resultSet.getInt ("testfmath"),
                        resultSet.getInt ("examfmath"),
                        resultSet.getInt ("totalfmath"),
                        resultSet.getString ("gradefmath"),
                        resultSet.getInt ("testbasict"),
                        resultSet.getInt ("exambasict"),
                        resultSet.getInt ("totalbasict"),
                        resultSet.getString ("gradebasict"),
                        resultSet.getInt ("testbasics"),
                        resultSet.getInt ("exambasics"),
                        resultSet.getInt ("totalbasics"),
                        resultSet.getString ("gradebasics"),
                        resultSet.getInt ("testcivic"),
                        resultSet.getInt ("examcivic"),
                        resultSet.getInt ("totalcivic"),
                        resultSet.getString ("gradecivic")
                ));


                clmID.setCellValueFactory (new PropertyValueFactory<> ("id"));
                clmStudentName.setCellValueFactory (new PropertyValueFactory<> ("name"));
                clmClasses.setCellValueFactory (new PropertyValueFactory<> ("classes"));
                clmTerm.setCellValueFactory (new PropertyValueFactory<> ("term"));
                clmEngTest.setCellValueFactory (new PropertyValueFactory<> ("testeng"));
                clmEngExam.setCellValueFactory (new PropertyValueFactory<> ("exameng"));
                clmEngTotal.setCellValueFactory (new PropertyValueFactory<> ("totaleng"));
                clmEngGrade.setCellValueFactory (new PropertyValueFactory<> ("gradeeng"));
                clmMathTest.setCellValueFactory (new PropertyValueFactory<> ("testmath"));
                clmMathExam.setCellValueFactory (new PropertyValueFactory<> ("exammath"));
                clmMathTotal.setCellValueFactory (new PropertyValueFactory<> ("totalmath"));
                clmMathGrade.setCellValueFactory (new PropertyValueFactory<> ("grademath"));
                clmPhyTest.setCellValueFactory (new PropertyValueFactory<> ("testphy"));
                clmPhyExam.setCellValueFactory (new PropertyValueFactory<> ("examphy"));
                clmPhyTotal.setCellValueFactory (new PropertyValueFactory<> ("totalphy"));
                clmPhyGrade.setCellValueFactory (new PropertyValueFactory<> ("gradephy"));
                clmChemTest.setCellValueFactory (new PropertyValueFactory<> ("testche"));
                clmCHemExam.setCellValueFactory (new PropertyValueFactory<> ("examche"));
                clmCHemTotal.setCellValueFactory (new PropertyValueFactory<> ("totalche"));
                clmChemGrade.setCellValueFactory (new PropertyValueFactory<> ("gradeche"));
                clmBioTest.setCellValueFactory (new PropertyValueFactory<> ("testbio"));
                clmBioExam.setCellValueFactory (new PropertyValueFactory<> ("exambio"));
                clmBioTotal.setCellValueFactory (new PropertyValueFactory<> ("totalbio"));
                clmBioGrade.setCellValueFactory (new PropertyValueFactory<> ("gradebio"));
                clmAgricTest.setCellValueFactory (new PropertyValueFactory<> ("testagr"));
                clmAgricExam.setCellValueFactory (new PropertyValueFactory<> ("examagr"));
                clmAgricTotal.setCellValueFactory (new PropertyValueFactory<> ("totalagr"));
                clmAgricGrade.setCellValueFactory (new PropertyValueFactory<> ("gradeagr"));
                clmEconsTest.setCellValueFactory (new PropertyValueFactory<> ("testecon"));
                clmEconExam.setCellValueFactory (new PropertyValueFactory<> ("examecon"));
                clmEconsTotal.setCellValueFactory (new PropertyValueFactory<> ("totalecon"));
                clmEconsGrade.setCellValueFactory (new PropertyValueFactory<> ("gradeecon"));
                clmFMathTest.setCellValueFactory (new PropertyValueFactory<> ("testfmath"));
                clmFMathExam.setCellValueFactory (new PropertyValueFactory<> ("examfmath"));
                clmFMathTotal.setCellValueFactory (new PropertyValueFactory<> ("totalfmath"));
                clmFMathGrade.setCellValueFactory (new PropertyValueFactory<> ("gradefmath"));
                clmBTechTest.setCellValueFactory (new PropertyValueFactory<> ("testbasict"));
                clmBtechExam.setCellValueFactory (new PropertyValueFactory<> ("exambasict"));
                clmBTechTotal.setCellValueFactory (new PropertyValueFactory<> ("totalbasict"));
                clmBTechGrade.setCellValueFactory (new PropertyValueFactory<> ("gradebasict"));
                clmBSciTest.setCellValueFactory (new PropertyValueFactory<> ("testbasics"));
                clmBSciExam.setCellValueFactory (new PropertyValueFactory<> ("exambasics"));
                clmBSciTotal.setCellValueFactory (new PropertyValueFactory<> ("totalbasics"));
                clmBSciGrade.setCellValueFactory (new PropertyValueFactory<> ("gradebasics"));
                clmCivicTest.setCellValueFactory (new PropertyValueFactory<> ("testcivic"));
                clmCivicExam.setCellValueFactory (new PropertyValueFactory<> ("examcivic"));
                clmCivicTotal.setCellValueFactory (new PropertyValueFactory<> ("totalcivic"));
                clmCivicGrade.setCellValueFactory (new PropertyValueFactory<> ("gradecivic"));


                tableView.setItems (oblist);
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/JS1/JS1.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));
    }



    private void btnAddPayment(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/JS1/addBroadSheet.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }


    @FXML
    private void btnImportExcel(ActionEvent event) throws SQLException, ClassNotFoundException  {

        Connection conn = DBConnection.getDBConnection().getConnection();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
        File file = fileChooser.showOpenDialog(tableView.getScene().getWindow());

        ExcelFile workbook = null;
        try {
            workbook = ExcelFile.load(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace ();
        }
        ExcelWorksheet worksheet = workbook.getWorksheet(0);
        String[][] sourceData = new String[100][26];
        for (int row = 0; row < sourceData.length; row++) {
            for (int column = 0; column < sourceData[row].length; column++) {
                ExcelCell cell = worksheet.getCell(row, column);
                if (cell.getValueType() != CellValueType.NULL)
                    sourceData[row][column] = cell.getValue().toString();
            }
        }
        fillTable(sourceData);
    }

    private void fillTable(String[][] dataSource) {
        table.getColumns().clear();

        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
        for (String[] row : dataSource)
            data.add(FXCollections.observableArrayList(row));
        table.setItems(data);

        for (int i = 0; i < dataSource[0].length; i++) {
            final int currentColumn = i;
            TableColumn<ObservableList<String>, String> column = new TableColumn<>(ExcelColumnCollection.columnIndexToName(currentColumn));
            column.setCellValueFactory(param -> new ReadOnlyObjectWrapper<> (param.getValue().get(currentColumn)));
            column.setEditable(true);
            column.setCellFactory(TextFieldTableCell.forTableColumn());
            column.setOnEditCommit(
                    (TableColumn.CellEditEvent<ObservableList<String>, String> t) -> {
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).set(t.getTablePosition().getColumn(), t.getNewValue());
                    });
            table.getColumns().add(column);
        }
    }

    public void save(ActionEvent event) throws IOException {
        ExcelFile file = new ExcelFile();
        ExcelWorksheet worksheet = file.addWorksheet("sheet");
        for (int row = 0; row < table.getItems().size(); row++) {
            ObservableList cells = (ObservableList) table.getItems().get(row);
            for (int column = 0; column < cells.size(); column++) {
                if (cells.get(column) != null)
                    worksheet.getCell(row, column).setValue(cells.get(column).toString());
            }
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx"),
                new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls"),
                new FileChooser.ExtensionFilter("ODS files (*.ods)", "*.ods"),
                new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"),
                new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html")
        );
        File saveFile = fileChooser.showSaveDialog(table.getScene().getWindow());

        file.save(saveFile.getAbsolutePath());
    }


    @FXML
    private void btnCheckStatistics(ActionEvent event)  throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Portal/assessmentPortal/assessment.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));
    }

    @FXML
    private void btnPrintScore(ActionEvent event) {
    }

    @FXML
    private void btnAddScore(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/classes/JS1/addBroadSheet.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));
    }

    @FXML
    private void btnEditScore(ActionEvent event) {
    }


    }



