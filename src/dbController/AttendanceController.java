package dbController;


import Model.Attendance;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceController {

    public static int AddAttendance(Attendance attendance) throws SQLException, ClassNotFoundException {
        String SQL="INSERT INTO attendance VALUES(?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, attendance.getId());
        stm.setObject(2, attendance.getName());
        stm.setObject(3, attendance.getClasses());
        stm.setObject(4, attendance.getTerm());
        stm.setObject(5, attendance.getDate ());
        stm.setObject(6, attendance.getAttendance ());
        stm.setObject(7, attendance.getExcuse ());
        stm.setObject(7, attendance.getTotaldays ());
        stm.setObject(8, attendance.getTotalpresent ());
        stm.setObject(9, attendance.getTotalabsent ());

        return  stm.executeUpdate();
    }
    public static Attendance searchAttendance(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM attendance WHERE id = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Attendance s=new Attendance(rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getInt (8),
                    rst.getInt (9),
                    rst.getInt (10));

            return s;
        }
        return null;
    }

    public static Attendance searchAttendanceByName(String name) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM attendance WHERE name LIKE '%"+name+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        // stm.setObject(1, name);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Attendance attendance = new Attendance (rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getInt (8),
                    rst.getInt (9),
                    rst.getInt (10));
            return attendance;
        }
        return null;
    }



    public static int deleteAttendance(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM attendance WHERE id ='"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }



    public static int updateAttendance(Attendance attendance) throws ClassNotFoundException,SQLException {
        String sql = "UPDATE attendance SET id= ? ,name= ? ,classes= ? ,term= ? ,date= ? ,attendance= ? ,excuse=? ,totaldays=? ,totalpresent= ? ,totalabsent= ?  WHERE id= '" +attendance.getId()+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, attendance.getId());
        stm.setObject(2, attendance.getName());
        stm.setObject(3, attendance.getClasses());
        stm.setObject(4, attendance.getTerm());
        stm.setObject(5, attendance.getDate ());
        stm.setObject(6, attendance.getAttendance ());
        stm.setObject(7, attendance.getExcuse ());
        stm.setObject(7, attendance.getTotaldays ());
        stm.setObject(8, attendance.getTotalpresent ());
        stm.setObject(9, attendance.getTotalabsent ());
        return  stm.executeUpdate();
    }



}
