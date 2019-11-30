package db;

import org.checkerframework.checker.units.qual.C;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by GeoCodec on 11/12/2019.
 */
public class ABC {

   private Connection connection;
   private  static DBConnection dbConnection;

   private ABC() throws ClassNotFoundException, SQLException {
       Class.forName ("com.mysql.jdbc.Driver");
       connection = DriverManager.getConnection ("mysql:jdbc://localhost/geocodecschool", "root", "");
   }

   private Connection getConnection(){
       return connection;
   }

   public static DBConnection getDbConnection() throws SQLException, ClassNotFoundException {
       if (dbConnection==null){
           dbConnection = new DBConnection ();
       }
       return dbConnection;
   }
}
