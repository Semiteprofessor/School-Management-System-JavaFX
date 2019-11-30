/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.reportCard;

import Model.ReportCard;
import animatefx.animation.Pulse;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import dbController.ReportCardController;
import controller.ReportViewController;
import db.DBConnection;
import dbController.StudentController;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class reportCardController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private AnchorPane rootAnchorPane;
    @FXML
    private Button printReportCard;
    @FXML
    private Button updateReportCard;
    @FXML
    private JFXComboBox<String> clmSubject1;
    @FXML
    private JFXComboBox<String> clmSubject9;
    @FXML
    private JFXComboBox<String> clmSubject7;
    @FXML
    private JFXComboBox<String> clmSubject8;
    @FXML
    private JFXComboBox<String> clmSubject6;
    @FXML
    private JFXComboBox<String> clmSubject5;
    @FXML
    private JFXComboBox<String> clmSubject4;
    @FXML
    private JFXComboBox<String> clmSubject3;
    @FXML
    private JFXComboBox<String> clmSubject2;
    @FXML
    private JFXTextField clmTest9;
    @FXML
    private JFXTextField clmTest8;
    @FXML
    private JFXTextField clmTest7;
    @FXML
    private JFXTextField clmTest6;
    @FXML
    private JFXTextField clmTest5;
    @FXML
    private JFXTextField clmTest4;
    @FXML
    private JFXTextField clmTest3;
    @FXML
    private JFXTextField clmTest2;
    @FXML
    private JFXTextField clmTest1;
    @FXML
    private JFXTextField clmExam9;
    @FXML
    private JFXTextField clmExam8;
    @FXML
    private JFXTextField clmExam7;
    @FXML
    private JFXTextField clmExam6;
    @FXML
    private JFXTextField clmExam5;
    @FXML
    private JFXTextField clmExam4;
    @FXML
    private JFXTextField clmExam3;
    @FXML
    private JFXTextField clmExam2;
    @FXML
    private JFXTextField clmExam1;
    @FXML
    private JFXTextField clmGrade9;
    @FXML
    private JFXTextField clmGrade8;
    @FXML
    private JFXTextField clmGrade7;
    @FXML
    private JFXTextField clmGrade6;
    @FXML
    private JFXTextField clmGrade5;
    @FXML
    private JFXTextField clmGrade4;
    @FXML
    private JFXTextField clmGrade3;
    @FXML
    private JFXTextField clmGrade2;
    @FXML
    private JFXTextField clmGrade1;
    @FXML
    private JFXTextField clmTotal9;
    @FXML
    private JFXTextField clmTotal8;
    @FXML
    private JFXTextField clmTotal7;
    @FXML
    private JFXTextField clmTotal6;
    @FXML
    private JFXTextField clmTotal5;
    @FXML
    private JFXTextField clmTotal4;
    @FXML
    private JFXTextField clmTotal3;
    @FXML
    private JFXTextField clmTotal2;
    @FXML
    private JFXTextField clmTotal1;
    @FXML
    private JFXTextField clmName;
    @FXML
    private JFXTextField clmYearSession;
    @FXML
    private JFXTextField clmClassAdviser;
    @FXML
    private JFXTextField clmGradingPeriod;
   
    private JFXTextField clm30s;
    private JFXTextField clm40s2;
    private JFXTextField clm40s;
    private JFXTextField clm50s;
    private JFXTextField clm60s;
    private JFXTextField clm70s;
    private JFXTextField clmF;
    private JFXTextField clmE;
    private JFXTextField clmD;
    private JFXTextField clmC;
    @FXML
    private JFXTextField clmMorning3;
    @FXML
    private JFXTextField clmMorning2;
    @FXML
    private JFXTextField clmMorning1;
    @FXML
    private JFXTextField clmAverage1;
    @FXML
    private JFXTextField clmQtly1;
    @FXML
    private JFXTextField clmAfternoon3;
    @FXML
    private JFXTextField clmAfternoon2;
    @FXML
    private JFXTextField clmAfternoon1;
    @FXML
    private JFXTextField clmAverage2;
    @FXML
    private JFXTextField clmQtly2;
    @FXML
    private JFXTextField clmAverage3;
    @FXML
    private JFXTextField clmQtly3;
    @FXML
    private JFXTextField clmAverage4;
    @FXML
    private JFXTextField clmQtly4;

    ObservableList<String> list = FXCollections.observableArrayList("ENGLISH LANGUAGE", "MATHEMATICS", "CIVIC EDUCATION", "ECONOMICS",
            "LITERATURE IN ENG", "GOVERNMENT", "PHYSICS", "CHEMISTRY", "AGRIC SCIENCE", "BIOLOGY", "FURTHER MATHS", "I.R.S", "C.R.S",
            "MUSIC", "HISTORY", "COMMERCE", "ACCOUNT", "YORUBA", "HAUSA", "IGBO", "FRENCH", "MARKETING",
            "HEALTH EDUCATION", "PHYSICAL EDUCATION", "GEOGRAPHY", "BASIC SCIENCE", "SOCIAL STUDIES", "FINE ART", "BUSINESS STUDIES", "COMPUTER", "HOME ECONOMICS",
            "BASIC TECH", "INTRO TECH");
    @FXML
    private JFXTextField clmSchoolYear;
    @FXML
    private JFXTextArea clmComment;
    @FXML
    private JFXTextField clmID;
    @FXML
    private TextField AdNo;
    @FXML
    private Button searchStudent;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        clmSubject1.setItems(list);
        clmSubject2.setItems(list);
        clmSubject3.setItems(list);
        clmSubject4.setItems(list);
        clmSubject5.setItems(list);
        clmSubject6.setItems(list);
        clmSubject7.setItems(list);
        clmSubject8.setItems(list);
        clmSubject9.setItems(list);
    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));

        new Pulse (home).play ();
    }

    @FXML
    private void printReportCard(ActionEvent event)  throws SQLException, ClassNotFoundException  {

        try {

            Connection conn = DBConnection.getDBConnection().getConnection();

            InputStream report1 = getClass().getResourceAsStream("/Reports/reportCard.jrxml");

            JRDesignQuery query = new JRDesignQuery();

            /*HashMap<String,Object> Logo = new HashMap<String, Object>();

            URL url = this.getClass().getClassLoader().getResource("Images/dp.png");
            Logo.put("logo", url);*/


                JasperDesign jd1 = JRXmlLoader.load(report1);
                query.setText("select * from reportcard");
                jd1.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd1);


        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void updateReportCard(ActionEvent event)throws SQLException, ClassNotFoundException{

    Connection conn = DBConnection.getDBConnection().getConnection();

        Integer id = Integer.valueOf (clmID.getText());
        String sub1 = clmSubject1.getValue ();
        String sub2 = clmSubject2.getValue ();
        String sub3 = clmSubject3.getValue ();
        String sub4 = clmSubject4.getValue ();
        String sub5 = clmSubject5.getValue ();
        String sub6 = clmSubject6.getValue ();
        String sub7 = clmSubject7.getValue ();
        String sub8 = clmSubject8.getValue ();
        String sub9 = clmSubject9.getValue ();
        String test1 = clmTest1.getText ();
        String test2 = clmTest2.getText ();
        String test3 = clmTest3.getText ();
        String test4 = clmTest4.getText ();
        String test5 = clmTest5.getText ();
        String test6 = clmTest6.getText ();
        String test7 = clmTest7.getText ();
        String test8 = clmTest8.getText ();
        String test9 = clmTest9.getText ();
        String ex1 = clmExam1.getText ();
        String ex2 = clmExam2.getText ();
        String ex3 = clmExam3.getText ();
        String ex4 = clmExam4.getText ();
        String ex5 = clmExam5.getText ();
        String ex6 = clmExam6.getText ();
        String ex7 = clmExam7.getText ();
        String ex8 = clmExam8.getText ();
        String ex9 = clmExam9.getText ();
        String tot1 = clmTotal1.getText ();
        String tot2 = clmTotal2.getText ();
        String tot3 = clmTotal3.getText ();
        String tot4 = clmTotal4.getText ();
        String tot5 = clmTotal5.getText ();
        String tot6 = clmTotal6.getText ();
        String tot7 = clmTotal7.getText ();
        String tot8 = clmTotal8.getText ();
        String tot9 = clmTotal9.getText ();
        String gra1 = clmGrade1.getText ();
        String gra2 = clmGrade2.getText ();
        String gra3 = clmGrade3.getText ();
        String gra4 = clmGrade4.getText ();
        String gra5 = clmGrade5.getText ();
        String gra6 = clmGrade6.getText ();
        String gra7 = clmGrade7.getText ();
        String gra8 = clmGrade8.getText ();
        String gra9 = clmGrade9.getText ();
            String mor1 = clmMorning1.getText ();
            String mor2 = clmMorning2.getText ();
            String mor3 = clmMorning3.getText ();
            String aft1 = clmAfternoon1.getText ();
            String aft2 = clmAfternoon2.getText ();
            String aft3 = clmAfternoon3.getText ();
            String qtl1 = clmQtly1.getText ();
            String qtl2 = clmQtly2.getText ();
            String qtl3 = clmQtly3.getText ();
            String qtl4 = clmQtly4.getText ();
            String avr1 = clmAverage1.getText ();
            String avr2 = clmAverage2.getText ();
            String avr3 = clmAverage3.getText ();
            String avr4 = clmAverage4.getText ();
            String session = clmYearSession.getText ();
            String adviser = clmClassAdviser.getText ();
            String grading = clmGradingPeriod.getText ();
            String year = clmSchoolYear.getText ();
            String name = clmName.getText ();
            String comment = clmComment.getText ();


        ReportCard s;
        s = new ReportCard  ( id, sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8, sub9, test1, test2, test3, test4, test5, test6, test7, test8, test9, ex1, ex2, ex3, ex4, ex5, ex6, ex7, ex8, ex9, tot1, tot2, tot3, tot4,tot5, tot6, tot7, tot8, tot9, gra1, gra2, gra3, gra4, gra5, gra6, gra7, gra8, gra9, mor1, mor2, mor3, aft1,aft2, aft3, qtl1, qtl2, qtl3, qtl4, avr1, avr2, avr3, avr4, session, grading, adviser, year, name, comment);

        int i = ReportCardController.updateReportCard (s);

        if (i > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Report Card updated Successfully");
            alert.showAndWait ();

            clmID.setText (null);
            clmSubject1.setValue (null);
            clmSubject2.setValue (null);
            clmSubject3.setValue (null);
            clmSubject4.setValue (null);
            clmSubject5.setValue (null);
            clmSubject6.setValue (null);
            clmSubject7.setValue (null);
            clmSubject8.setValue (null);
            clmSubject9.setValue (null);
            clmTest1.setText (null);
            clmTest2.setText (null);
            clmTest3.setText (null);
            clmTest4.setText (null);
            clmTest5.setText (null);
            clmTest6.setText (null);
            clmTest7.setText (null);
            clmTest8.setText (null);
            clmTest9.setText (null);
            clmExam1.setText (null);
            clmExam2.setText (null);
            clmExam3.setText (null);
            clmExam4.setText (null);
            clmExam5.setText (null);
            clmExam6.setText (null);
            clmExam7.setText (null);
            clmExam8.setText (null);
            clmExam9.setText (null);
            clmTotal1.setText (null);
            clmTotal2.setText (null);
            clmTotal3.setText (null);
            clmTotal4.setText (null);
            clmTotal5.setText (null);
            clmTotal6.setText (null);
            clmTotal7.setText (null);
            clmTotal8.setText (null);
            clmTotal9.setText (null);
            clmGrade1.setText (null);
            clmGrade2.setText (null);
            clmGrade3.setText (null);
            clmGrade4.setText (null);
            clmGrade5.setText (null);
            clmGrade6.setText (null);
            clmGrade7.setText (null);
            clmGrade8.setText (null);
            clmGrade9.setText (null);
            clmMorning1.setText (null);
            clmMorning2.setText (null);
            clmMorning3.setText (null);
            clmAfternoon1.setText (null);
            clmAfternoon2.setText (null);
            clmAfternoon3.setText (null);
            clmQtly1.setText (null);
            clmQtly2.setText (null);
            clmQtly3.setText (null);
            clmQtly4.setText (null);
            clmAverage1.setText (null);
            clmAverage2.setText (null);
            clmAverage3.setText (null);
            clmAverage4.setText (null);
            clmYearSession.setText (null);
            clmClassAdviser.setText (null);
            clmGradingPeriod.setText (null);
            clmSchoolYear.setText (null);
            clmName.setText (null);
            clmComment.setText (null);

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(null);
            alert.setContentText("OOOps! There is a problem updating Report Card");
            alert.show();
        }






}

    @FXML
    private void searchStudent(ActionEvent event) {

        try {
            int adNo = Integer.parseInt(AdNo.getText());
            ReportCard s = ReportCardController.searchStudent(adNo);
            if (s != null) {
                clmID.setText(String.valueOf(s.getId ()));
                clmSubject1.setValue (s.getSub1 ());
                clmSubject2.setValue (s.getSub2 ());
                clmSubject3.setValue (s.getSub3 ());
                clmSubject4.setValue (s.getSub4 ());
                clmSubject5.setValue (s.getSub5 ());
                clmSubject6.setValue (s.getSub6 ());
                clmSubject7.setValue (s.getSub7 ());
                clmSubject8.setValue (s.getSub8 ());
                clmSubject9.setValue (s.getSub9 ());
                clmTest1.setText (s.getTest1 ());
                clmTest2.setText (s.getTest2 ());
                clmTest3.setText (s.getTest3 ());
                clmTest4.setText (s.getTest4 ());
                clmTest5.setText (s.getTest5 ());
                clmTest6.setText (s.getTest6 ());
                clmTest7.setText (s.getTest7 ());
                clmTest8.setText (s.getTest8 ());
                clmTest9.setText (s.getTest9 ());
                clmExam1.setText (s.getEx1 ());
                clmExam2.setText (s.getEx2 ());
                clmExam3.setText (s.getEx3 ());
                clmExam4.setText (s.getEx4 ());
                clmExam5.setText (s.getEx5 ());
                clmExam6.setText (s.getEx6 ());
                clmExam7.setText (s.getEx7 ());
                clmExam8.setText (s.getEx8 ());
                clmExam9.setText (s.getEx9 ());
                clmTotal1.setText (s.getTot1 ());
                clmTotal2.setText (s.getTot2 ());
                clmTotal3.setText (s.getTot3 ());
                clmTotal4.setText (s.getTot4 ());
                clmTotal5.setText (s.getTot5 ());
                clmTotal6.setText (s.getTot6 ());
                clmTotal7.setText (s.getTot7 ());
                clmTotal8.setText (s.getTot8 ());
                clmTotal9.setText (s.getTot9 ());
                clmGrade1.setText (s.getGra1 ());
                clmGrade2.setText (s.getGra2 ());
                clmGrade3.setText (s.getGra3 ());
                clmGrade4.setText (s.getGra4 ());
                clmGrade5.setText (s.getGra5 ());
                clmGrade6.setText (s.getGra6 ());
                clmGrade7.setText (s.getGra7 ());
                clmGrade8.setText (s.getGra8 ());
                clmGrade9.setText (s.getGra9 ());
                clmMorning1.setText (s.getMor1 ());
                clmMorning2.setText (s.getMor2 ());
                clmMorning3.setText (s.getMor3 ());
                clmAfternoon1.setText (s.getAft1 ());
                clmAfternoon2.setText (s.getAft2 ());
                clmAfternoon3.setText (s.getAft3 ());
                clmQtly1.setText (s.getQtl1 ());
                clmQtly2.setText (s.getQtl2 ());
                clmQtly3.setText (s.getQtl3 ());
                clmQtly4.setText (s.getQtl4 ());
                clmAverage1.setText (s.getAvr1 ());
                clmAverage2.setText (s.getAvr2 ());
                clmAverage3.setText (s.getAvr3 ());
                clmAverage4.setText (s.getAvr4 ());
                clmYearSession.setText (s.getSession ());
                clmClassAdviser.setText (s.getAdviser ());
                clmGradingPeriod.setText (s.getGrading ());
                clmSchoolYear.setText (s.getYear ());
                clmName.setText (s.getName ());
                clmComment.setText (s.getComment ());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Student Search");
                alert.setHeaderText(null);
                alert.setContentText("Student Not Found");
                alert.showAndWait();

                clmID.setText(null);
                clmSubject1.setValue (null);
                clmSubject2.setValue (null);
                clmSubject3.setValue (null);
                clmSubject4.setValue (null);
                clmSubject5.setValue (null);
                clmSubject6.setValue (null);
                clmSubject7.setValue (null);
                clmSubject8.setValue (null);
                clmSubject9.setValue (null);
                clmTest1.setText (null);
                clmTest2.setText (null);
                clmTest3.setText (null);
                clmTest4.setText (null);
                clmTest5.setText (null);
                clmTest6.setText (null);
                clmTest7.setText (null);
                clmTest8.setText (null);
                clmTest9.setText (null);
                clmExam1.setText (null);
                clmExam2.setText (null);
                clmExam3.setText (null);
                clmExam4.setText (null);
                clmExam5.setText (null);
                clmExam6.setText (null);
                clmExam7.setText (null);
                clmExam8.setText (null);
                clmExam9.setText (null);
                clmTotal1.setText (null);
                clmTotal2.setText (null);
                clmTotal3.setText (null);
                clmTotal4.setText (null);
                clmTotal5.setText (null);
                clmTotal6.setText (null);
                clmTotal7.setText (null);
                clmTotal8.setText (null);
                clmTotal9.setText (null);
                clmGrade1.setText (null);
                clmGrade2.setText (null);
                clmGrade3.setText (null);
                clmGrade4.setText (null);
                clmGrade5.setText (null);
                clmGrade6.setText (null);
                clmGrade7.setText (null);
                clmGrade8.setText (null);
                clmGrade9.setText (null);
                clmMorning1.setText (null);
                clmMorning2.setText (null);
                clmMorning3.setText (null);
                clmAfternoon1.setText (null);
                clmAfternoon2.setText (null);
                clmAfternoon3.setText (null);
                clmQtly1.setText (null);
                clmQtly2.setText (null);
                clmQtly3.setText (null);
                clmQtly4.setText (null);
                clmAverage1.setText (null);
                clmAverage2.setText (null);
                clmAverage3.setText (null);
                clmAverage4.setText (null);
                clmYearSession.setText (null);
                clmClassAdviser.setText (null);
                clmGradingPeriod.setText (null);
                clmSchoolYear.setText (null);
                clmName.setText (null);
                clmComment.setText (null);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReportCardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
