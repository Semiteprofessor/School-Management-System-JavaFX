package dbController;

import Model.Student;
import db.DBConnection;
import Model.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StaffController {

    public static int AddStaff(Staff staff) throws SQLException, ClassNotFoundException {
        String SQL="INSERT INTO staffs VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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

        return  stm.executeUpdate();
    }

    public static Staff searchStaff(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM staffs WHERE id = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Staff staff = new Staff(rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13),
                    rst.getString(14));
            return staff;
        }
        return null;
    }

    public static Staff searchStaffByName(String name) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM staffs WHERE name LIKE '%"+name+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
       // stm.setObject(1, name);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Staff staff = new Staff(rst.getInt(1), rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13),
                    rst.getString(14));
            return staff;
        }
        return null;
    }

    public static Staff searchOldStaff(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM oldstaffs WHERE id = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Staff staff = new Staff(rst.getInt(1), rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13),
                    rst.getString(14));
            return staff;
        }
        return null;
    }

    public static int deleteStaff(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM staffs WHERE id ='"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }

    public static int moveStaff(Staff staff) throws SQLException, ClassNotFoundException {
        String SQL="INSERT INTO oldstaffs VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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

        return  stm.executeUpdate();
    }

    public static int updateStaff(Staff staff) throws ClassNotFoundException,SQLException {
        String sql = "UPDATE staffs SET id= ? ,name= ? ,classes= ? ,gender= ? ,dob= ? ,hired= ? ,department=? ,position= ? ,degree= ? ,salary= ? ,contact=? ,email=? ,address=? ,state=? WHERE id= '" +staff.getId()+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
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

        return  stm.executeUpdate();
    }


    public static int updateOldStaff(Staff staff) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE staffs SET id= ? ,name= ? ,gender= ? ,dob= ? ,position= ? ,degree= ? ,hired=? ,email= ? ,contact= ? ,address= ?  WHERE id= '" + staff.getId() + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
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

        return stm.executeUpdate();


    }


    public static int totalStaff() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = null;
        ResultSet resultSet = null;
        int total = 0;

        try {
            stm = conn.prepareStatement("SELECT COUNT(id) FROM staffs");
            resultSet = stm.executeQuery();

            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }

            resultSet.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  total;
    }
}
