/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n6.jdbcmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author MEDIAMART PHU SON
 */
public class Test {
     public static void main(String[] args) {
        String connectionUrl = "jdbc:mysql://localhost:3306/sv?user=root&password=Trong1308.";

         
          try ( Connection con = DriverManager.getConnection(connectionUrl);
                  Statement sttm = con.createStatement();){
                   ResultSet rs = sttm.executeQuery("SELECT * FROM sinhvien");
                  
                   while(rs.next()){
                       System.out.println(rs.getString("id")+rs.getString("name") );
                   }
        } catch (Exception e) {
            
            e.printStackTrace();  // Bạn có thể xóa dòng này sau khi giải quyết vấn đề.
        }
    }
}
