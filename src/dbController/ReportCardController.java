package dbController;


import Model.ReportCard;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GeoCodec on 10/28/2019.
 */
public class ReportCardController {


    public static int AddReportCard(ReportCard reportCard)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO reportcard VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, reportCard.getId ());
        stm.setObject(2, reportCard.getSub1 ());
        stm.setObject(3, reportCard.getSub2 ());
        stm.setObject(4, reportCard.getSub3 ());
        stm.setObject(5, reportCard.getSub4 ());
        stm.setObject(6, reportCard.getSub5 ());
        stm.setObject(7, reportCard.getSub6 ());
        stm.setObject(8, reportCard.getSub7 ());
        stm.setObject(9, reportCard.getSub8 ());
        stm.setObject(10, reportCard.getSub9 ());
        stm.setObject(11, reportCard.getTest1 ());
        stm.setObject(12, reportCard.getTest2 ());
        stm.setObject(13, reportCard.getTest3 ());
        stm.setObject(14, reportCard.getTest4 ());
        stm.setObject(15, reportCard.getTest5 ());
        stm.setObject(16, reportCard.getTest6 ());
        stm.setObject(17, reportCard.getTest7 ());
        stm.setObject(18, reportCard.getTest8 ());
        stm.setObject(19, reportCard.getTest9 ());
        stm.setObject(20, reportCard.getEx1 ());
        stm.setObject(21, reportCard.getEx2 ());
        stm.setObject(22, reportCard.getEx3 ());
        stm.setObject(23, reportCard.getEx4 ());
        stm.setObject(24, reportCard.getEx5 ());
        stm.setObject(25, reportCard.getEx6 ());
        stm.setObject(26, reportCard.getEx7 ());
        stm.setObject(27, reportCard.getEx8 ());
        stm.setObject(28, reportCard.getEx9 ());
        stm.setObject(29, reportCard.getTot1 ());
        stm.setObject(30, reportCard.getTot2 ());
        stm.setObject(31, reportCard.getTot3 ());
        stm.setObject(32, reportCard.getTot4 ());
        stm.setObject(33, reportCard.getTot5 ());
        stm.setObject(34, reportCard.getTot6 ());
        stm.setObject(35, reportCard.getTot7 ());
        stm.setObject(36, reportCard.getTot8 ());
        stm.setObject(37, reportCard.getTot9 ());
        stm.setObject(38, reportCard.getGra1 ());
        stm.setObject(39, reportCard.getGra2 ());
        stm.setObject(40, reportCard.getGra3 ());
        stm.setObject(41, reportCard.getGra4 ());
        stm.setObject(42, reportCard.getGra5 ());
        stm.setObject(43, reportCard.getGra6 ());
        stm.setObject(44, reportCard.getGra7 ());
        stm.setObject(45, reportCard.getGra8 ());
        stm.setObject(46, reportCard.getGra9 ());
        stm.setObject(47, reportCard.getMor1 ());
        stm.setObject(48, reportCard.getMor2 ());
        stm.setObject(49, reportCard.getMor3 ());
        stm.setObject(50, reportCard.getAft1 ());
        stm.setObject(51, reportCard.getAft2 ());
        stm.setObject(52, reportCard.getAft3 ());
        stm.setObject(53, reportCard.getQtl1 ());
        stm.setObject(54, reportCard.getQtl2 ());
        stm.setObject(55, reportCard.getQtl3 ());
        stm.setObject(56, reportCard.getQtl4 ());
        stm.setObject(57, reportCard.getAvr1 ());
        stm.setObject(58, reportCard.getAvr2 ());
        stm.setObject(59, reportCard.getAvr3 ());
        stm.setObject(60, reportCard.getAvr4 ());
        stm.setObject(61, reportCard.getSession ());
        stm.setObject(62, reportCard.getAdviser ());
        stm.setObject(63, reportCard.getGrading ());
        stm.setObject(64, reportCard.getYear ());
        stm.setObject(65, reportCard.getName ());
        stm.setObject(66, reportCard.getComment ());

        return  stm.executeUpdate();
    }




    public static int updateReportCard(ReportCard reportCard) throws ClassNotFoundException,SQLException {
        String sql = "UPDATE reportcard SET id=? ,sub1= ? ,sub2= ? ,sub3= ? ,sub4= ? ,sub5= ? ,sub6= ? ,sub7=? ,sub8= ? ,sub9= ? ,test1= ? ,test2=? ,test3=? ,test4=? ,test5= ? ,test6= ? ,test7= ? ,test8= ? ,test9= ? ,ex1=? ,ex2= ? ,ex3= ? ,ex4= ? ,ex5=? ,ex6=? ,ex7=?" +
                " ,ex8= ? ,ex9= ? ,tot1= ? ,tot2= ? ,tot3= ? ,tot4=? ,tot5= ? ,tot6= ? ,tot7= ? ,tot8=? ,tot9=? ,gra1=? ,gra2= ? ,gra3= ? ,gra4= ? ,gra5= ? ,gra6= ? ,gra7=? ,gra8= ? ,gra9= ? ,mor1= ? ,mor2=? ,mor3=? ,aft1=?" +
                " ,aft2= ? ,aft3= ? ,qtl1= ? ,qtl2= ? ,qtl3= ? ,qtl4=? ,avr1= ? ,avr2= ? ,avr3= ? ,avr4=? ,session=? ,adviser= ? ,grading= ? ,year= ? ,name=? ,comment= ? WHERE id= '" +reportCard.getId ()+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, reportCard.getId ());
        stm.setObject(2, reportCard.getSub1 ());
        stm.setObject(3, reportCard.getSub2 ());
        stm.setObject(4, reportCard.getSub3 ());
        stm.setObject(5, reportCard.getSub4 ());
        stm.setObject(6, reportCard.getSub5 ());
        stm.setObject(7, reportCard.getSub6 ());
        stm.setObject(8, reportCard.getSub7 ());
        stm.setObject(9, reportCard.getSub8 ());
        stm.setObject(10, reportCard.getSub9 ());
        stm.setObject(11, reportCard.getTest1 ());
        stm.setObject(12, reportCard.getTest2 ());
        stm.setObject(13, reportCard.getTest3 ());
        stm.setObject(14, reportCard.getTest4 ());
        stm.setObject(15, reportCard.getTest5 ());
        stm.setObject(16, reportCard.getTest6 ());
        stm.setObject(17, reportCard.getTest7 ());
        stm.setObject(18, reportCard.getTest8 ());
        stm.setObject(19, reportCard.getTest9 ());
        stm.setObject(20, reportCard.getEx1 ());
        stm.setObject(21, reportCard.getEx2 ());
        stm.setObject(22, reportCard.getEx3 ());
        stm.setObject(23, reportCard.getEx4 ());
        stm.setObject(24, reportCard.getEx5 ());
        stm.setObject(25, reportCard.getEx6 ());
        stm.setObject(26, reportCard.getEx7 ());
        stm.setObject(27, reportCard.getEx8 ());
        stm.setObject(28, reportCard.getEx9 ());
        stm.setObject(29, reportCard.getTot1 ());
        stm.setObject(30, reportCard.getTot2 ());
        stm.setObject(31, reportCard.getTot3 ());
        stm.setObject(32, reportCard.getTot4 ());
        stm.setObject(33, reportCard.getTot5 ());
        stm.setObject(34, reportCard.getTot6 ());
        stm.setObject(35, reportCard.getTot7 ());
        stm.setObject(36, reportCard.getTot8 ());
        stm.setObject(37, reportCard.getTot9 ());
        stm.setObject(38, reportCard.getGra1 ());
        stm.setObject(39, reportCard.getGra2 ());
        stm.setObject(40, reportCard.getGra3 ());
        stm.setObject(41, reportCard.getGra4 ());
        stm.setObject(42, reportCard.getGra5 ());
        stm.setObject(43, reportCard.getGra6 ());
        stm.setObject(44, reportCard.getGra7 ());
        stm.setObject(45, reportCard.getGra8 ());
        stm.setObject(46, reportCard.getGra9 ());
        stm.setObject(47, reportCard.getMor1 ());
        stm.setObject(48, reportCard.getMor2 ());
        stm.setObject(49, reportCard.getMor3 ());
        stm.setObject(50, reportCard.getAft1 ());
        stm.setObject(51, reportCard.getAft2 ());
        stm.setObject(52, reportCard.getAft3 ());
        stm.setObject(53, reportCard.getQtl1 ());
        stm.setObject(54, reportCard.getQtl2 ());
        stm.setObject(55, reportCard.getQtl3 ());
        stm.setObject(56, reportCard.getQtl4 ());
        stm.setObject(57, reportCard.getAvr1 ());
        stm.setObject(58, reportCard.getAvr2 ());
        stm.setObject(59, reportCard.getAvr3 ());
        stm.setObject(60, reportCard.getAvr4 ());
        stm.setObject(61, reportCard.getSession ());
        stm.setObject(62, reportCard.getAdviser ());
        stm.setObject(63, reportCard.getGrading ());
        stm.setObject(64, reportCard.getYear ());
        stm.setObject(65, reportCard.getName ());
        stm.setObject(66, reportCard.getComment ());

        return  stm.executeUpdate();
    }


    public static ReportCard searchStudent(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM reportcard WHERE id = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            ReportCard s=new ReportCard (rst.getInt(1),
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
                    rst.getString(14),
                    rst.getString(15),
                    rst.getString(16),
                    rst.getString(17),
                    rst.getString(18),
                    rst.getString(19),
                    rst.getString(20),
                    rst.getString(21),
                    rst.getString(22),
                    rst.getString(23),
                    rst.getString(24),
                    rst.getString(25),
                    rst.getString(26),
                    rst.getString(27),
                    rst.getString(28),
                    rst.getString(29),
                    rst.getString(30),
                    rst.getString(31),
                    rst.getString(32),
                    rst.getString(33),
                    rst.getString(34),
                    rst.getString(35),
                    rst.getString(36),
                    rst.getString(37),
                    rst.getString(38),
                    rst.getString(39),
                    rst.getString(40),
                    rst.getString(41),
                    rst.getString(42),
                    rst.getString(43),
                    rst.getString(44),
                    rst.getString(45),
                    rst.getString(46),
                    rst.getString(47),
                    rst.getString(48),
                    rst.getString(49),
                    rst.getString(50),
                    rst.getString(51),
                    rst.getString(52),
                    rst.getString(53),
                    rst.getString(54),
                    rst.getString(55),
                    rst.getString(56),
                    rst.getString(57),
                    rst.getString(58),
                    rst.getString(59),
                    rst.getString(60),
                    rst.getString(61),
                    rst.getString(62),
                    rst.getString(63),
                    rst.getString(64),
                    rst.getString(65),
                    rst.getString(66));
            return s;
        }
        return null;
    }


    }







