package dbController;

import com.mysql.jdbc.PreparedStatement;
import db.DBConnection;
import Model.Bursary;
import db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class StatusController {

    public static ArrayList<String> getStatus() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select status From status");

        ArrayList<String>statusList=new ArrayList<>();
        while(rst.next()){
            //Grade grade;
            //grade = new Grade(rst.getString("grade"));
            statusList.add(rst.getString("status"));
        }
        return statusList;
    }


}
