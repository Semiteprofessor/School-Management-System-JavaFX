package dbController;

import com.mysql.jdbc.PreparedStatement;
import db.DBConnection;
import Model.Subject;
import db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class SubjectController {

    public static ArrayList<String> getSubject() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select subjects From subject");

        ArrayList<String>classList=new ArrayList<>();
        while(rst.next()){
            //Grade grade;
            //grade = new Grade(rst.getString("grade"));
            classList.add(rst.getString("subject"));
        }
        return classList;
    }



    public static int totalSubject() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        java.sql.PreparedStatement stm = null;
        ResultSet resultSet = null;
        int total = 0;

        try {
            stm = conn.prepareStatement("SELECT COUNT(id) FROM subject");
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
