/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import View.*;

/**
 *
 * @author 2ndyrGroupA
 */
public class MedicineModel {
    
    public boolean addMedicine(String bname, String gname, double price, int qty, String type){
        boolean success = false;
        AddMedicine addMe = new AddMedicine();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "");
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO `medicine`(`BrandName`, `GenericName`,`Quantity`, `Price`) VALUES ('"+bname+"','"+gname+"','"+type+"',"+price+","+qty+")";
            stmt.executeUpdate(sql);
            return success = true;
        } catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(addMe, "Error connecting to database!");       
        }
        return success;
    }
    
    
    
}
