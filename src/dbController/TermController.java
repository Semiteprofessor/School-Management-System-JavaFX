package dbController;

import com.mysql.jdbc.PreparedStatement;
import db.DBConnection;
import Model.Classes;
import db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class TermController {

    public static ArrayList<String> getTerm() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select terms From term");

        ArrayList<String>termList=new ArrayList<>();
        while(rst.next()){
            //Grade grade;
            //grade = new Grade(rst.getString("grade"));
            termList.add(rst.getString("term"));
        }
        return termList;
    }


    public static ArrayList<String> getYears() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("Select distinct year from oldstudents");

        ArrayList<String> yearlist = new ArrayList<>();
        while (rst.next()) {
            yearlist.add(rst.getString("year"));
        }
        return yearlist;
    }

}
