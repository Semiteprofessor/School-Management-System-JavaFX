/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TableSchema {

    public static void connect() {
        Connection conn = null;
        Statement stmt = null;

        String url = "jdbc:sqlite:School.db";

        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS `users` (\n"
                    + "	`username`	TEXT,\n"
                    + "	`password`	TEXT NOT NULL,\n"
                    + ");"

                    + "CREATE TABLE IF NOT EXISTS `students` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`name`          TEXT NOT NULL UNIQUE,\n"
                    + "	`classes`	TEXT NOT NULL,\n"
                    + " `gender`          TEXT,\n"
                    + "	`dob`	TEXT\n"
                    + "	`admitted`	TEXT NOT NULL,\n"
                    + " `department`          TEXT,\n"
                    + "	`disability`	TEXT\n"
                    + "	`designation`	TEXT NOT NULL,\n"
                    + " `contact`          TEXT,\n"
                    + "	`address`	TEXT\n"
                    + "	`state`	TEXT NOT NULL,\n"
                    + " `year` TEXT,\n"
                    + ");"

                    + "CREATE TABLE IF NOT EXISTS `staffs` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + " `name`     TEXT,\n"
                    + "	`classes`          TEXT NOT NULL,\n"
                    + " `gender` TEXT NOT NULL,\n"
                    + " `dob`           INTEGER NOT NULL,\n"
                    + "	`hired`         TEXT,\n"
                    + "	`department`         TEXT,\n"
                    + "	`position`	TEXT,\n"
                    + "	`degree`	TEXT\n"
                    + "	`salary`	TEXT NOT NULL,\n"
                    + " `contact`          TEXT,\n"
                    + "	`email`	TEXT\n"
                    + "	`address`	TEXT NOT NULL,\n"
                    + " `state`          TEXT,\n"
                    + ");"

                    + "CREATE TABLE IF NOT EXISTS `schoolinfo` (\n"
                    + " `schoolName`     TEXT,\n"
                    + "	`schoolAddress`          TEXT NOT NULL,\n"
                    + " `classAvailable` TEXT NOT NULL,\n"
                    + " `schoolType`           INTEGER NOT NULL,\n"
                    + "	`educationalZone`         TEXT,\n"
                    + "	`educationalDistrict`         TEXT,\n"
                    + "	`administrativeDistrict`	TEXT,\n"
                    + "	`municipal`	TEXT\n"
                    + "	`lga`	TEXT NOT NULL,\n"
                    + " `policeArea`          TEXT,\n"
                    + "	`postalCode`	TEXT\n"
                    + "	`dateEstablished`	TEXT NOT NULL,\n"
                    + " `schoolID`          TEXT,\n"
                    + " `censusNo`     TEXT,\n"
                    + "	`schoolExamID`          TEXT NOT NULL,\n"
                    + " `principalName` TEXT NOT NULL,\n"
                    + " `principalNo`           INTEGER NOT NULL,\n"
                    + "	`province`         TEXT,\n"
                    + "	`totalLandArea`         TEXT,\n"
                    + "	`totalStudent`	TEXT,\n"
                    + "	`totalStaff`	TEXT\n"
                    + "	`location`	TEXT NOT NULL,\n"
                    + " `state`          TEXT,\n"
                    + "	`email`	TEXT\n"
                    + ");"

                    + "CREATE TABLE IF NOT EXISTS `class` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`classes`          TEXT,\n"
                    + " `noOfStudents`          TEXT,\n"
                    + ");"

                    + "CREATE TABLE IF NOT EXISTS `subject` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`subjects`          TEXT,\n"
                    + " `noOfSubjects`          TEXT,\n"
                    + ");"

                    + "CREATE TABLE IF NOT EXISTS `oldstaffs` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + " `name`   TEXT NOT NULL,\n"
                    + "	`gender`	TEXT NOT NULL,\n"
                    + "	`dob`	TEXT,\n"
                    + "	`position`	TEXT,\n"
                    + "	`degree`	TEXT,\n"
                    + "	`hired`	TEXT,\n"
                    + "	`emain`	TEXT\n"
                    + "	`contact`	TEXT,\n"
                    + "	`address`	TEXT\n"
                    + ");"

                    + "CREATE TABLE IF NOT EXISTS `oldstudents` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`name`	TEXT NOT NULL,\n"
                    + "	`gender`          TEXT NOT NULL,\n"
                    + "	`dob`            TEXT,\n"
                    + "	`admitted`            TEXT,\n"
                    + "	`year`            TEXT,\n"
                    + "	`contact`            TEXT,\n"
                    + "	`address`	TEXT,\n"
                    + "	`designation`	TEXT,\n"
                    + " `department`    TEXT\n"
                    + ");"

                    + "CREATE TABLE IF NOT EXISTS `bursary` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`name`	TEXT NOT NULL,\n"
                    + "	`classes`          TEXT NOT NULL,\n"
                    + "	`term`            TEXT,\n"
                    + "	`first_payment`            TEXT,\n"
                    + "	`second_payment`            TEXT,\n"
                    + "	`third_payment`            TEXT,\n"
                    + "	`actual_fee`	TEXT,\n"
                    + "	`status`	TEXT,\n"
                    + " `mode_of_payment`    TEXT\n"
                    + " `arrears`    TEXT\n"
                    + ");"
                    + "CREATE TABLE IF NOT EXISTS `leftstudents` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`name`	TEXT NOT NULL,\n"
                    + "	`classes`	TEXT NOT NULL,\n"
                    + "	`gender`	TEXT,\n"
                    + "	`department`	TEXT,\n"
                    + "	`disability`	TEXT,\n"
                    + "	`designation`	TEXT,\n"
                    + "	`contact`	TEXT\n"
                    + "	`address`	TEXT,\n"
                    + "	`state`	TEXT\n"
                    + ");";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(TableSchema.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
