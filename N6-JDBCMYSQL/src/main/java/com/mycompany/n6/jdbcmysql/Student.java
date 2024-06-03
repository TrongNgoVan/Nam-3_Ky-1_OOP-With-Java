/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n6.jdbcmysql;

/**
 *
 * @author MEDIAMART PHU SON
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Student extends JFrame {
    private JTextField idField, nameField, classField, gpaField;
    private JButton displayButton, addButton, updateButton, deleteButton, resetButton;
    private JTable table;

    private DefaultTableModel model;
    private Connection connection;
    private Statement statement;

    public Student() {
        super("Student Management System");

        // Initialize components
        idField = new JTextField();
        nameField = new JTextField();
        classField = new JTextField();
        gpaField = new JTextField();

        displayButton = new JButton("Hiển thị");
        addButton = new JButton("Thêm");
        updateButton = new JButton("Cập nhật");
        deleteButton = new JButton("Xóa");
        resetButton = new JButton("Reset");

        model = new DefaultTableModel();
        table = new JTable(model);

        // Set layout
        setLayout(null);
        idField.setBounds(20, 20, 150, 20);
        nameField.setBounds(20, 50, 150, 20);
        classField.setBounds(20, 80, 150, 20);
        gpaField.setBounds(20, 110, 150, 20);

        displayButton.setBounds(200, 20, 100, 30);
        addButton.setBounds(200, 60, 100, 30);
        updateButton.setBounds(200, 100, 100, 30);
        deleteButton.setBounds(200, 140, 100, 30);
        resetButton.setBounds(200, 180, 100, 30);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 220, 500, 200);

        add(idField);
        add(nameField);
        add(classField);
        add(gpaField);
        add(displayButton);
        add(addButton);
        add(updateButton);
        add(deleteButton);
        add(resetButton);
        add(scrollPane);
         String connectionUrl = "jdbc:mysql://localhost:3306/sv?user=root&password=Trong1308.";

         
          try {connection = DriverManager.getConnection(connectionUrl); statement = connection.createStatement();}
                 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
            
            e.printStackTrace();  // Bạn có thể xóa dòng này sau khi giải quyết vấn đề.
        }
 

        // Button actions
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayData();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addData();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateData();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteData();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
    }

    private void displayData() {
        model.setRowCount(0); // Clear the table
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sinhvien");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String className = resultSet.getString("class");
                double gpa = resultSet.getDouble("gpa");
                model.addRow(new Object[]{id, name, className, gpa});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addData() {
        String id = idField.getText();
        String name = nameField.getText();
        String className = classField.getText();
        String gpaStr = gpaField.getText();

        if (id.isEmpty() || name.isEmpty() || className.isEmpty() || gpaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
            return;
        }

        double gpa = Double.parseDouble(gpaStr);

        try {
            // Check if ID already exists
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sinhvien WHERE id = '" + id + "'");
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại.");
                return;
            }

            // Insert new data
            statement.executeUpdate("INSERT INTO sinhvien VALUES ('" + id + "', '" + name + "', '" + className + "', " + gpa + ")");
            JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công.");
            resetFields();
            displayData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để cập nhật.");
            return;
        }

        String id = idField.getText();
        String name = nameField.getText();
        String className = classField.getText();
        String gpaStr = gpaField.getText();

        if (id.isEmpty() || name.isEmpty() || className.isEmpty() || gpaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
            return;
        }

        double gpa = Double.parseDouble(gpaStr);

        try {
            statement.executeUpdate("UPDATE sinhvien SET name = '" + name + "', class = '" + className + "', gpa = " + gpa + " WHERE id = '" + id + "'");
            JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công.");
            resetFields();
            displayData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để xóa.");
            return;
        }

        String id = (String) model.getValueAt(selectedRow, 0);

        try {
            statement.executeUpdate("DELETE FROM sinhvien WHERE id = '" + id + "'");
            JOptionPane.showMessageDialog(this, "Xóa sinh viên thành công.");
            resetFields();
            displayData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void resetFields() {
        idField.setText("");
        nameField.setText("");
        classField.setText("");
        gpaField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Student());
    }
}

