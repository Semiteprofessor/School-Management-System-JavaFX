package dbController;

import db.DBConnection;
import Model.Staff;

import java.sql.*;
import java.util.ArrayList;


public class MoveController {

    public static int moveStaff(Staff staff) throws ClassNotFoundException, SQLException {
        String SQL="INSERT INTO oldstaff VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, staff.getId());
        stm.setObject(2, staff.getName());
        stm.setObject(3, staff.getClasses());
        stm.setObject(4, staff.getGender());
        stm.setObject(5, staff.getDob());
        stm.setObject(6, staff.getHired());
        stm.setObject(7, staff.getDepartment());
        stm.setObject(8, staff.getPosition());
        stm.setObject(9, staff.getDegree());
        stm.setObject(10, staff.getSalary());
        stm.setObject(11, staff.getContact());
        stm.setObject(12, staff.getEmail());
        stm.setObject(13, staff.getAddress());
        stm.setObject(14, staff.getState());

        return stm.executeUpdate();
    }

    public static int updateStaff(String name) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE oldstaff ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
//        stm.setObject(1, student.getGrade());

        return stm.executeUpdate();
    }

    public static int deleteStaff(String name) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM staffs WHERE name ='" + name + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return stm.executeUpdate();
    }

}
