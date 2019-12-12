/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Date;
import View.*;
import javax.swing.JOptionPane;
import Model.*;

/**
 *
 * @author 2ndyrGroupA
 */
public class CRUD {

    MedicineModel model = new MedicineModel();

    public Connection connectToDB() {
        try {
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/java";
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(myUrl, "root", "");
            return connection;
        } catch (Exception e) {
            System.err.println("An error occur!");
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void create() {
        try {
            Connection connection = connectToDB();
            Statement statement = connection.createStatement();
            String sqlString = "INSERT INTO `medicine`( `BrandName`, `GenericName`, `Price`) VALUES ([value-2],[value-3],[value-4])";
            statement.executeUpdate(sqlString);
            connection.close();
            System.out.println("Added successfully!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void retrieve() {

        try {
            Connection connection = connectToDB();
            Statement statement = connection.createStatement();
            String sqlString = "Select * From tblMedicine";
            statement.executeUpdate(sqlString);
            connection.close();
            System.out.println("Retrieve successfully!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(int id) {

        try {
            Connection connection = connectToDB();
            Statement statement = connection.createStatement();
            String sqlString = "Select * From tblMedicine Where id = id ";
            statement.executeUpdate(sqlString);
            connection.close();
            System.out.println("Update successfully!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(int id) {

        try {
            Connection connection = connectToDB();
            Statement statement = connection.createStatement();
            String sqlString = "DELETE From tblMedicine Where id = id ";
            statement.executeUpdate(sqlString);
            connection.close();
            System.out.println("Delete successfully!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public boolean addMedicine(String bname, String gname, String price1, String quantity, String type) {
        boolean success = false;
        AddMedicine addMe = new AddMedicine();

        try {
            double price = Double.parseDouble(price1);
            try {
                int qty = Integer.parseInt(quantity);
                if (model.addMedicine(bname, gname, price, qty, type) == true) {
                    return success = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(addMe, "Quantity should be a number!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(addMe, "Price should be a number!");
        }

        return success;
    }

}
