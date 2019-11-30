package controller.session;

import animatefx.animation.Pulse;
import com.calendarfx.model.Calendar;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.view.CalendarView;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import javafx.application.Platform;
import javafx.application.Application;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class sessionController implements Initializable {


    private CalendarView calendarView;

    @FXML
    private Button btnBack;
    @FXML
    private ScrollPane scrollPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        calendarView = new CalendarView ();

        Calendar classes = new Calendar ("Classes");
        Calendar meetings = new Calendar ("Meetings");

        classes.setStyle (Calendar.Style.STYLE1);
        meetings.setStyle (Calendar.Style.STYLE2);

        CalendarSource myCalendarSource = new CalendarSource ("School Calenders");
        myCalendarSource.getCalendars ().addAll (classes, meetings);

        calendarView.getCalendarSources ().addAll (myCalendarSource);

        calendarView.setRequestedTime (LocalTime.now ());


        Thread updateTimeThread = new Thread ("Calendar: Update Time Thread") {

            @Override
            public void run() {
                while (true) {
                    Platform.runLater (() -> {
                        calendarView.setToday (LocalDate.now ());
                        calendarView.setTime (LocalTime.now ());
                    });

                    try {
                        // update every 10 seconds
                        sleep (10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace ();
                    }

                }
            }
        };


        updateTimeThread.setPriority (Thread.MIN_PRIORITY);
        updateTimeThread.setDaemon (true);
        updateTimeThread.start ();

        calendarView.showMonthPage ();
        scrollPane.setContent (calendarView);
    }



    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new Pulse (home).play ();
    }


}

