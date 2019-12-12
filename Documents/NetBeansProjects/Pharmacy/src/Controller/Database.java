/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author 2ndyrGroupB
 */
public class Database {
    public boolean userExist = false;
    public void saveData(String name, int age, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java", "root", "");
            //here sonoo is database name, root is username and password  
            Statement stmt = (Statement) con.createStatement();

            //insert data into database
            String sqlString = "insert into tblregister(name, age, username, password) values (?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sqlString);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, username);
            pstmt.setString(4, password);
            ///pstmt.setString(3, SchoolName);
            pstmt.executeUpdate();
            pstmt.close();

            ResultSet rs = stmt.executeQuery("select * from tblregister");

            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void PharmacistInfo(String name, int age, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java", "root", "");
            //here sonoo is database name, root is username and password  
            Statement stmt = (Statement) con.createStatement();

            //insert data into database
            String sqlString = "insert into tblpharmacist(name, age, username, password) values (?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sqlString);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, username);
            pstmt.setString(4, password);
            ///pstmt.setString(3, SchoolName);
            pstmt.executeUpdate();
            pstmt.close();

            ResultSet rs = stmt.executeQuery("select * from tblpharmacist");

            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public boolean login(String username, String password){
        try {
             String dbUsername = "";
             String dbPassword = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java", "root", "");
            //here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();

            //insert data into database
            String sqlString = "SELECT * FROM `tblregister` WHERE `username`= ? AND `password`=?";
            PreparedStatement pstmt = con.prepareStatement(sqlString);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ///pstmt.setString(3, SchoolName);
            pstmt.executeQuery();
            pstmt.close();

            ResultSet rs = stmt.executeQuery("select * from tblregister");
           
            while(rs.next()){
                dbUsername = rs.getString("username");
                dbPassword = rs.getString("password");
                // true;  
            }
            if(username.equals(dbUsername) && password.equals(dbPassword)){
                return true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean Pharmacistlogin(String username, String password){
        try {
             String dbUsername = "";
             String dbPassword = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java", "root", "");
            //here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();

            //insert data into database
            String sqlString = "SELECT * FROM `tblpharmacist` WHERE `username`= ? AND `password`=?";
            PreparedStatement pstmt = con.prepareStatement(sqlString);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ///pstmt.setString(3, SchoolName);
            pstmt.executeQuery();
            pstmt.close();

            ResultSet rs = stmt.executeQuery("select * from tblpharmacist");
           
            while(rs.next()){
                dbUsername = rs.getString("username");
                dbPassword = rs.getString("password");
                // true;  
            }
            if(username.equals(dbUsername) && password.equals(dbPassword)){
                return true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}