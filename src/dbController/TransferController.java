package dbController;

import db.DBConnection;
import Model.Student;

import java.sql.*;
import java.util.ArrayList;


public class TransferController {

    public static int transferStudent(ArrayList<Student> student) throws ClassNotFoundException, SQLException {
        String SQL="INSERT INTO oldstudents VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        /*stm.setObject(1, student.getAdNo());
        stm.setObject(2, student.getFullName());
        stm.setObject(3, student.getName());
        stm.setObject(4, student.getDob());
        stm.setObject(5, student.getDoa());
        stm.setObject(6, student.getGender());
        stm.setObject(7, student.getGrade());
        stm.setObject(8, student.getParentName());
        stm.setObject(9, student.getNic());
        stm.setObject(10, student.getPhone());
        stm.setObject(11, student.getAddress());*/

        return stm.executeUpdate();
    }

    public static int updateClasses(String year) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE oldstudents SET year= '" + year + "'  WHERE year= 'SS3'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
//        stm.setObject(1, student.getGrade());

        return stm.executeUpdate();
    }

    public static int deleteStudent(String classes) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM Students WHERE classes ='" + classes + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return stm.executeUpdate();
    }

    public static ArrayList<Student> getSS3() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("Select * From students Where classes = 'SS3'");
        ArrayList<Student> studentList = new ArrayList<>();
        while (rst.next()) {
            Student student = new Student(rst.getInt(1),
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
                    rst.getString(13)
            );
            studentList.add(student);
        }
        return studentList;
    }
}
