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



public class ClassesController {

    public static ArrayList<String> getClasses() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select classes From class");

        ArrayList<String>classList=new ArrayList<>();
        while(rst.next()){
            //Grade grade;
            //grade = new Grade(rst.getString("grade"));
            classList.add(rst.getString("class"));
        }
        return classList;
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


        public static int totalClasses() throws SQLException, ClassNotFoundException {
            Connection conn = DBConnection.getDBConnection().getConnection();
            java.sql.PreparedStatement stm = null;
            ResultSet resultSet = null;
            int total = 0;

            try {
                stm = conn.prepareStatement("SELECT COUNT(id) FROM class");
                resultSet = stm.executeQuery();

                if (resultSet.next()) {
                    total = resultSet.getInt(1);
                }

                resultSet.close();
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return total;
        }

}
