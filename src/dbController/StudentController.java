package dbController;


import Model.Staff;
import Model.Student;
import db.DBConnection;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;


public class StudentController {



    public static int AddStudent(Student student)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO students VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, student.getId());
        stm.setObject(2, student.getName());
        stm.setObject(3, student.getClasses());
        stm.setObject(4, student.getGender());
        stm.setObject(5, student.getDob());
        stm.setObject(6, student.getAdmitted());
        stm.setObject(7, student.getDepartment());
        stm.setObject(8, student.getDisability());
        stm.setObject(9, student.getDesignation());
        stm.setObject(10, student.getContact());
        stm.setObject(11, student.getAddress());
        stm.setObject(12, student.getState());
        stm.setObject(13, student.getYear());


        return  stm.executeUpdate();
    }



    public static Student searchStudent(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM students WHERE id = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Student s=new Student(rst.getInt(1),
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
                    rst.getString(13));
            return s;
        }
        return null;
    }


    public static Student searchStudentByName(String name) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM students WHERE name LIKE '%"+name+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, name);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Student student = new Student (rst.getInt(1),
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
                    rst.getString(13));
            return student;
        }
        return null;
    }

    public static Student searchPastStudent(Integer id) throws ClassNotFoundException,SQLException {
        String sql = "SELECT * FROM leftstudents WHERE id = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Student s=new Student(rst.getInt(1),
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
                    rst.getString(13));

            return s;
        }
        return null;
    }

    public static int deleteStudent(Integer id) throws ClassNotFoundException,SQLException {

        String sql = "DELETE FROM Students WHERE id ='"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return Integer.parseInt (null);
    }

    public static int deleteLeftStudent(Integer id) throws ClassNotFoundException,SQLException {

        String sql = "DELETE FROM leftstudents WHERE id ='"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);


        return  stm.executeUpdate();
    }

    public static int moveStudent(Student student) throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO leftstudents VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, student.getId());
        stm.setObject(2, student.getName());
        stm.setObject(3, student.getClasses());
        stm.setObject(4, student.getGender());
        stm.setObject(5, student.getDob());
        stm.setObject(6, student.getAdmitted());
        stm.setObject(7, student.getDepartment());
        stm.setObject(8, student.getDisability());
        stm.setObject(9, student.getDesignation());
        stm.setObject(10, student.getContact());
        stm.setObject(11, student.getAddress());
        stm.setObject(12, student.getState());
        stm.setObject(13, student.getYear());

        return  stm.executeUpdate();
    }

    public static int updateStudent(Student student) throws ClassNotFoundException,SQLException {
        String sql = "UPDATE students SET id= ? ,name= ? ,classes= ? ,gender= ? ,dob= ? ,admitted= ? ,department=? ,disability= ? ,designation= ? ,contact= ? ,address=? ,state=? ,year=? WHERE id= '" +student.getId()+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, student.getId());
        stm.setObject(2, student.getName());
        stm.setObject(3, student.getClasses());
        stm.setObject(4, student.getGender());
        stm.setObject(5, student.getDob());
        stm.setObject(6, student.getAdmitted());
        stm.setObject(7, student.getDepartment());
        stm.setObject(8, student.getDisability());
        stm.setObject(9, student.getDesignation());
        stm.setObject(10, student.getContact());
        stm.setObject(11, student.getAddress());
        stm.setObject(12, student.getState());
        stm.setObject(13, student.getYear());

        return  stm.executeUpdate();
    }

    public static int updateLeftStudent(Student student) throws ClassNotFoundException,SQLException {
        String sql = "UPDATE leftstudents SET id= ? ,name= ? ,classes= ? ,gender= ? ,dob= ? ,admitted= ? ,department=? ,disability= ? ,designation= ? ,contact= ? ,address=? ,state=? ,year=? WHERE id= '" +student.getId()+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, student.getId());
        stm.setObject(2, student.getName());
        stm.setObject(3, student.getClasses());
        stm.setObject(4, student.getGender());
        stm.setObject(5, student.getDob());
        stm.setObject(6, student.getAdmitted());
        stm.setObject(7, student.getDepartment());
        stm.setObject(8, student.getDisability());
        stm.setObject(9, student.getDesignation());
        stm.setObject(10, student.getContact());
        stm.setObject(11, student.getAddress());
        stm.setObject(12, student.getState());
        stm.setObject(13, student.getYear());

        return  stm.executeUpdate();
    }


    public static int updateOldStudent(Student student) throws ClassNotFoundException,SQLException {
        String sql = "UPDATE oldstudents SET id= ? ,name= ? ,classes= ? ,gender= ? ,dob= ? ,admitted= ? ,department=? ,disability= ? ,designation= ? ,contact= ? ,address=? ,state=? ,year=? WHERE id= '" +student.getId()+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, student.getId());
        stm.setObject(2, student.getName());
        stm.setObject(3, student.getClasses());
        stm.setObject(4, student.getGender());
        stm.setObject(5, student.getDob());
        stm.setObject(6, student.getAdmitted());
        stm.setObject(7, student.getDepartment());
        stm.setObject(8, student.getDisability());
        stm.setObject(9, student.getDesignation());
        stm.setObject(10, student.getContact());
        stm.setObject(11, student.getAddress());
        stm.setObject(12, student.getState());
        stm.setObject(13, student.getYear());

        return  stm.executeUpdate();
    }


 public static int totalStudent() throws SQLException, ClassNotFoundException {
        String SQL = "SELECT COUNT(id) FROM students";
        Connection connection = DBConnection.getDBConnection ().getConnection ();
        PreparedStatement statement = connection.prepareStatement (SQL);
        ResultSet resultSet = statement.executeQuery ();

        int total = 0;

        if (resultSet.next ()){
            total = resultSet.getInt (1);
        }
        return total;
 }


}
