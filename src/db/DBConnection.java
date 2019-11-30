package db;

import java.sql.*;


public class DBConnection{
    private Connection conn;
    private static DBConnection dbConnection;

    DBConnection()throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/geocodecschool","root","");
    }
    public Connection getConnection(){

        return conn;
    }
    public static DBConnection getDBConnection()throws ClassNotFoundException,SQLException{
        if(dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }

}


