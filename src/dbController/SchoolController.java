package dbController;

import db.DBConnection;
import Model.School;
import Model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SchoolController {

    public static School schoolInfo() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM schoolinfo";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            School s=new School(rst.getString("schoolName"),
                    rst.getString("schoolAddress"),
                    rst.getString("classAvailable"),
                    rst.getString("schoolType"),
                    rst.getString("educationalZone"),
                    rst.getString("educationalDistrict"),
                    rst.getString("administrativeDistrict"),
                    rst.getString("municipal"),
                    rst.getString("lga"),
                    rst.getString("policeArea"),
                    rst.getString("postalCode"),
                    rst.getString("dateEstablished"),
                    rst.getString("schoolID"),
                    rst.getString("censusNo"),
                    rst.getString("schoolExamID"),
                    rst.getString("principalName"),
                    rst.getString("principalNo"),
                    rst.getString("province"),
                    rst.getString("totalLandArea"),
                    rst.getString("totalStudent"),
                    rst.getString("totalStaff"),
                    rst.getString("location"),
                    rst.getString("state"),
                    rst.getString("email"));

            return s;
        }
        return null;
    }

    public static int AddDetails(School school) throws SQLException, ClassNotFoundException {
        String SQL="INSERT INTO schoolinfo VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, school.getSchoolName());
        stm.setObject(2, school.getSchoolAddress());
        stm.setObject(3, school.getClassAvailable());
        stm.setObject(4, school.getSchoolType());
        stm.setObject(5, school.getEducationalZone());
        stm.setObject(6, school.getEducationalDistrict());
        stm.setObject(7, school.getAdministrativeDistrict());
        stm.setObject(8, school.getMunicipal());
        stm.setObject(9, school.getLga());
        stm.setObject(10, school.getPoliceArea());
        stm.setObject(11, school.getPostalCode());
        stm.setObject(12, school.getDateEstablished());
        stm.setObject(13, school.getSchoolID());
        stm.setObject(14, school.getCensusNo());
        stm.setObject(15, school.getSchoolExamID());
        stm.setObject(16, school.getPrincipalName());
        stm.setObject(17, school.getPrincipalNo());
        stm.setObject(18, school.getProvince());
        stm.setObject(19, school.getTotalLandArea());
        stm.setObject(20, school.getTotalStudent());
        stm.setObject(21, school.getTotalStaff());
        stm.setObject(22, school.getLocation());
        stm.setObject(23, school.getState());
        stm.setObject(24, school.getEmail());


        return  stm.executeUpdate();
    }

    public static int updateDetails(School school) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE schoolinfo SET schoolName= ? ," +
                "schoolAddress= ? ," +
                "classAvailable= ? ," +
                "schoolType= ? ," +
                "educationalZone= ? ," +
                "educationalDistrict= ? ," +
                "administrativeDistrict=? ," +
                "municipal= ? ," +
                "lga= ? ," +
                "policeArea= ? ," +
                "postalCode=? ," +
                "dateEstablished=? ," +
                "schoolID=? ," +
                "censusNo=? ," +
                "schoolExamID=? ," +
                "principalName=? ," +
                "principalNo=? ," +
                "province=? ," +
                "totalLandArea=? ," +
                "totalStudent=? , " +
                "totalStaff=? , " +
                "location=? , " +
                "state=? , " +
                "email=?  ";


        PreparedStatement stm;


        Connection conn = DBConnection.getDBConnection().getConnection();
        stm = conn.prepareStatement(sql);

        stm.setObject(1, school.getSchoolName());
        stm.setObject(2, school.getSchoolAddress());
        stm.setObject(3, school.getClassAvailable());
        stm.setObject(4, school.getSchoolType());
        stm.setObject(5, school.getEducationalZone());
        stm.setObject(6, school.getEducationalDistrict());
        stm.setObject(7, school.getAdministrativeDistrict());
        stm.setObject(8, school.getMunicipal());
        stm.setObject(9, school.getLga());
        stm.setObject(10, school.getPoliceArea());
        stm.setObject(11, school.getPostalCode());
        stm.setObject(12, school.getDateEstablished());
        stm.setObject(13, school.getSchoolID());
        stm.setObject(14, school.getCensusNo());
        stm.setObject(15, school.getSchoolExamID());
        stm.setObject(16, school.getPrincipalName());
        stm.setObject(17, school.getPrincipalNo());
        stm.setObject(18, school.getProvince());
        stm.setObject(19, school.getTotalLandArea());
        stm.setObject(20, school.getTotalStudent());
        stm.setObject(21, school.getTotalStaff());
        stm.setObject(22, school.getLocation());
        stm.setObject(23, school.getState());
        stm.setObject(24, school.getEmail());


        return  stm.executeUpdate();
    }
}
