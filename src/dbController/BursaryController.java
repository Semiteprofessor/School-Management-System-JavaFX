package dbController;

import Model.Bursary;
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


public class BursaryController {

    public static int AddBursary(Bursary bursary) throws SQLException, ClassNotFoundException {
        String SQL="INSERT INTO bursary VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, bursary.getId());
        stm.setObject(2, bursary.getName());
        stm.setObject(3, bursary.getClasses());
        stm.setObject(4, bursary.getTerm());
        stm.setObject(5, bursary.getFirst_payment());
        stm.setObject(6, bursary.getSecond_payment());
        stm.setObject(7, bursary.getThird_payment());
        stm.setObject(8, bursary.getActual_fee());
        stm.setObject(9, bursary.getStatus());
        stm.setObject(10, bursary.getMode_of_payment());
        stm.setObject(11, bursary.getArrears());

        return  stm.executeUpdate();
    }
    public static Bursary searchBursary(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM bursary WHERE id = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Bursary s=new Bursary(rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11)
            );
            return s;
        }
        return null;
    }

    public static Bursary searchBursaryByName(String name) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM bursary WHERE name LIKE '%"+name+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        // stm.setObject(1, name);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Bursary bursary = new Bursary (rst.getInt(1), rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11));
            return bursary;
        }
        return null;
    }



    public static int deleteBursary(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM bursary WHERE id ='"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }

    public static int moveBursary(Bursary bursary) throws SQLException, ClassNotFoundException {
        String SQL="INSERT INTO oldstaffs VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, bursary.getId());
        stm.setObject(2, bursary.getName());
        stm.setObject(3, bursary.getClasses());
        stm.setObject(4, bursary.getTerm());
        stm.setObject(5, bursary.getFirst_payment());
        stm.setObject(6, bursary.getSecond_payment());
        stm.setObject(7, bursary.getThird_payment());
        stm.setObject(8, bursary.getActual_fee());
        stm.setObject(9, bursary.getStatus());
        stm.setObject(10, bursary.getMode_of_payment());
        stm.setObject(11, bursary.getArrears());

        return  stm.executeUpdate();
    }

    public static int updateBursary(Bursary bursary) throws ClassNotFoundException,SQLException {
        String sql = "UPDATE bursary SET id= ? ,name= ? ,classes= ? ,term= ? ,first_payment= ? ,second_payment= ? ,third_payment=? ,actual_fee= ? ,status= ? ,mode_of_payment= ? ,arrears=?  WHERE id= '" +bursary.getId()+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, bursary.getId());
        stm.setObject(2, bursary.getName());
        stm.setObject(3, bursary.getClasses());
        stm.setObject(4, bursary.getTerm());
        stm.setObject(5, bursary.getFirst_payment());
        stm.setObject(6, bursary.getSecond_payment());
        stm.setObject(7, bursary.getThird_payment());
        stm.setObject(8, bursary.getActual_fee());
        stm.setObject(9, bursary.getStatus());
        stm.setObject(10, bursary.getMode_of_payment());
        stm.setObject(11, bursary.getArrears());

        return  stm.executeUpdate();
    }



}
