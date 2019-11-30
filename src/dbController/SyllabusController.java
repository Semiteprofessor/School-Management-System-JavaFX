package dbController;

import Model.Syllabus;
import db.DBConnection;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.sql.*;


public class SyllabusController {

    public static int AddSyllabus(Syllabus syllabus) throws SQLException, ClassNotFoundException {
        String SQL="INSERT INTO syllabus VALUES(?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, syllabus.getId());
        stm.setObject(2, syllabus.getName());
        stm.setObject(3, syllabus.getTeacher ());
        stm.setObject(4, syllabus.getTerm());
        stm.setObject(5, syllabus.getOutline ());
        stm.setObject(6, syllabus.getNote ());

        return  stm.executeUpdate();
    }
    public static Syllabus searchSyllabus(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM syllabus WHERE id = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Syllabus s=new Syllabus (rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
            return s;
        }
        return null;
    }

    public static Syllabus searchSyllabusByName(String name) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM syllabus WHERE name LIKE '%"+name+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        // stm.setObject(1, name);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Syllabus bursary = new Syllabus (rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6));
            return bursary;
        }
        return null;
    }



    public static int deleteSyllabus(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM syllabus WHERE id ='"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }



    public static int updateSyllabus(Syllabus syllabus) throws ClassNotFoundException,SQLException {
        String sql = "UPDATE syllabus SET id= ? ,name= ? ,teacher= ? ,term= ? ,outline= ? ,note= ?   WHERE id= '" +syllabus.getId()+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, syllabus.getId());
        stm.setObject(2, syllabus.getName());
        stm.setObject(3, syllabus.getTeacher ());
        stm.setObject(4, syllabus.getTerm());
        stm.setObject(5, syllabus.getOutline ());
        stm.setObject(6, syllabus.getNote ());

        return  stm.executeUpdate();
    }



}
