import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableRowSorter;



 class MyJTable extends JFrame implements ActionListener{
    private JPanel interface_1 = new JPanel();
    private final JButton start = new JButton("Start");
    private final JButton sort_A_Z = new JButton("A-Z");
    private final JButton sort_Z_A = new JButton("Z-A");
    private JTextField input;
    private final JTextField annou = new JTextField("INPUT FILE PO LEASE");
    
    public MyJTable(String label){
        super(label);
        start.addActionListener(this);
        interface_1.add(start);//BorderLayout.NORTH);
        interface_1.add(sort_A_Z);//BorderLayout.NORTH);
        interface_1.add(sort_Z_A);//BorderLayout.NORTH);
        interface_1.add(annou);//BorderLayout.SOUTH);
        input = new JTextField(50);
        interface_1.add(input);//BorderLayout.CENTER );
        this.add(interface_1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
            if(e.getSource() == start) {
        // Xóa tất cả các thành phần khỏi interface_1
            interface_1.removeAll();
        // Thêm lại các thành phần cố định
            interface_1.add(start);
            interface_1.add(sort_A_Z);
            interface_1.add(sort_Z_A);
            interface_1.add(annou);
            interface_1.add(input);
        // Tạo bảng mới
        
            output();
            }
        }
    }
    public void output(){
        String file_name = input.getText();
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable jTable = new JTable(tableModel);
        tableModel.addColumn("WORDS");
        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setPreferredSize(new Dimension(500,150));
        boolean check = true;
        try{
            File file = new File(file_name);
            Scanner scanner = new Scanner(file);
            //tableModel.setRowCount(0);
            while(scanner.hasNext()){
                String data = scanner.next();
                tableModel.addRow(new Object[]{data});
            }
        }
        catch(FileNotFoundException ex){
            check = false;
            JTextArea jtext = new JTextArea("DUONG DAN SAI VUI LONG NHAP LAI DUONG DAN");
            interface_1.add(jtext);
        }
        if(check){
            interface_1.add(scrollPane,BorderLayout.CENTER);
        }
        interface_1.revalidate();
        interface_1.repaint();
        //interface_1.repaint();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable.getModel());
        jTable.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sorter.setSortKeys(sortKeys);
        sort_A_Z.addActionListener(e -> {
            sortKeys.clear();
            sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
        });

        sort_Z_A.addActionListener(e -> {
            sortKeys.clear();
            sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
            sorter.setSortKeys(sortKeys);
        });
    }
}

public class Bai7 extends JFrame{
    public static void main(String[] args) {
        MyJTable jtable = new MyJTable("JTable");
        jtable.setSize(600, 250);
        jtable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jtable.setVisible(true);
    }
}
