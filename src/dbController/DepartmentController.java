package dbController;

import com.mysql.jdbc.PreparedStatement;
import db.DBConnection;
import Model.Department;
import db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DepartmentController {

    public static ArrayList<String> getDepartments() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select departments FROM department");

        ArrayList<String>departmentList=new ArrayList<>();
        while(rst.next()){
            //Grade grade;
            //grade = new Grade(rst.getString("grade"));
            departmentList.add(rst.getString("dept"));
        }
        return departmentList;
    }



}
