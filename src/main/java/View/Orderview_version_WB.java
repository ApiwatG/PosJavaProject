package View;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controller.Order;
import controller.MenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.image.*;
import java.awt.*;


public class Orderview_version_WB extends JFrame{
	private DefaultTableModel tableModel;
    private int orderId = 1;
    private JTextField textField;
    static Order o = new Order();
    static MenuItem M = new MenuItem();
    public Orderview_version_WB() {
        setTitle("New Orderview");
        setSize(998, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Table setup
        String[] columnNames = {"ID", "Name", "price","Time"};
        tableModel = new DefaultTableModel(columnNames, 0);
        getContentPane().setLayout(null);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(507, 34, 465, 316);
        getContentPane().add(scrollPane);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(31, 34, 140, 124);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/1.png"));
            btnNewButton.setIcon(new ImageIcon(img));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		M.MenuItem(1,"luGshin",58.0,1);
        		o.addItem(M, M.getPrice());
        		tableModel.addRow(new Object[]{o.getOrderID(),M.getName(),M.getPrice(),o.getOrderTime()});
        	}
        });
        getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		M.MenuItem(2,"donustod",50.0,1);
        		o.addItem(M, M.getPrice());
        		tableModel.addRow(new Object[]{o.getOrderID(),M.getName(),M.getPrice(),o.getOrderTime()});
        	}
        });
        btnNewButton_1.setBounds(181, 34, 140, 124);
        getContentPane().add(btnNewButton_1);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/2.png"));
            btnNewButton_1.setIcon(new ImageIcon(img));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        
        
        JButton btnNewButton_1_1 = new JButton("New button");
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		M.MenuItem(3,"kungtodkateam",70.0,1);
        		o.addItem(M, M.getPrice());
        		tableModel.addRow(new Object[]{o.getOrderID(),M.getName(),M.getPrice(),o.getOrderTime()});
        	}
        });
        btnNewButton_1_1.setBounds(331, 34, 140, 124);
        getContentPane().add(btnNewButton_1_1);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/3.png"));
            btnNewButton_1_1.setIcon(new ImageIcon(img));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        
        
        JButton btnNewButton_1_1_1 = new JButton("New button");
        btnNewButton_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		M.MenuItem(2,"krawpadkung",75.0,1);
        		o.addItem(M, M.getPrice());
        		tableModel.addRow(new Object[]{o.getOrderID(),M.getName(),M.getPrice(),o.getOrderTime()});
        	}
        });
        btnNewButton_1_1_1.setBounds(331, 181, 140, 124);
        getContentPane().add(btnNewButton_1_1_1);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/4.png"));
            btnNewButton_1_1_1.setIcon(new ImageIcon(img));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        
        
        JButton btnNewButton_1_2 = new JButton("New button");
        btnNewButton_1_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		M.MenuItem(5,"krawpadsubparod",75.0,1);
        		o.addItem(M, M.getPrice());
        		tableModel.addRow(new Object[]{o.getOrderID(),M.getName(),M.getPrice(),o.getOrderTime()});
        	}
        });
        btnNewButton_1_2.setBounds(181, 181, 140, 124);
        getContentPane().add(btnNewButton_1_2);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/5.png"));
            btnNewButton_1_2.setIcon(new ImageIcon(img));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        
        
        JButton btnNewButton_2 = new JButton("New button");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		M.MenuItem(4,"Krawmadkai",65.0,1);
        		o.addItem(M, M.getPrice());
        		tableModel.addRow(new Object[]{o.getOrderID(),M.getName(),M.getPrice(),o.getOrderTime()});
        	}
        });
        btnNewButton_2.setBounds(31, 181, 140, 124);
        getContentPane().add(btnNewButton_2);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/6.png"));
            btnNewButton_2.setIcon(new ImageIcon(img));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        
        
        JButton btnNewButton_1_1_1_1 = new JButton("New button");
        btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		M.MenuItem(4,"namnung",75.0,1);
        		o.addItem(M, M.getPrice());
        		tableModel.addRow(new Object[]{o.getOrderID(),M.getName(),M.getPrice(),o.getOrderTime()});
        	}
        });
        btnNewButton_1_1_1_1.setBounds(331, 343, 140, 124);
        getContentPane().add(btnNewButton_1_1_1_1);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/7.png"));
            btnNewButton_1_1_1_1.setIcon(new ImageIcon(img));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        
        
        JButton btnNewButton_1_2_1 = new JButton("New button");
        btnNewButton_1_2_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		M.MenuItem(8,"padthai",65.0,1);
        		o.addItem(M, M.getPrice());
        		tableModel.addRow(new Object[]{o.getOrderID(),M.getName(),M.getPrice(),o.getOrderTime()});
        	}
        });
        btnNewButton_1_2_1.setBounds(181, 343, 140, 124);
        getContentPane().add(btnNewButton_1_2_1);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/8.png"));
            btnNewButton_1_2_1.setIcon(new ImageIcon(img));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        
        
        JButton btnNewButton_2_1 = new JButton("New button");
        btnNewButton_2_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		M.MenuItem(7,"Muusadte",75.0,1);
        		o.addItem(M, M.getPrice());
        		tableModel.addRow(new Object[]{o.getOrderID(),M.getName(),M.getPrice(),o.getOrderTime()});
        	}
        });
        btnNewButton_2_1.setBounds(31, 343, 140, 124);
        getContentPane().add(btnNewButton_2_1);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/9.png"));
            btnNewButton_2_1.setIcon(new ImageIcon(img));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        
        
        JLabel lblNewLabel = new JLabel("Total :");
        lblNewLabel.setBounds(507, 343, 79, 77);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        getContentPane().add(lblNewLabel);
        
        
        
        JLabel lblCash = new JLabel("Cash :");
        lblCash.setBounds(507, 398, 140, 77);
        lblCash.setFont(new Font("Tahoma", Font.PLAIN, 25));
        getContentPane().add(lblCash);
        
        
        
        JLabel lblBalance = new JLabel("Balance :");
        lblBalance.setBounds(507, 463, 108, 61);
        lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 25));
        getContentPane().add(lblBalance);
        
        
        
        JLabel lblNewLabel_1 = new JLabel("0.0");
        lblNewLabel_1.setBounds(596, 361, 51, 37);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        getContentPane().add(lblNewLabel_1);
        lblNewLabel_1.setVisible(true);
        
        JLabel lblNewLabel_1_1 = new JLabel("0");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel_1_1.setBounds(626, 473, 21, 37);
        getContentPane().add(lblNewLabel_1_1);
        
        textField = new JTextField();
        textField.setBounds(591, 422, 108, 30);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton_1_1_1_1_1 = new JButton("Pay");
        btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnNewButton_1_1_1_1_1.setBounds(709, 376, 140, 124);
        getContentPane().add(btnNewButton_1_1_1_1_1);
        
        JButton btnNewButton_1_1_1_1_1_1 = new JButton("Remove");
        btnNewButton_1_1_1_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		  int selectedRow = table.getSelectedRow(); // Get selected row index
        	        if (selectedRow != -1) { // Ensure a row is selected
        	            tableModel.removeRow(selectedRow); // Remove from table
        	      
        	        } else {
        	            JOptionPane.showMessageDialog(null, "Please select a row to remove.");
        	        }
        	}
        });
        btnNewButton_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnNewButton_1_1_1_1_1_1.setBounds(709, 523, 140, 124);
        getContentPane().add(btnNewButton_1_1_1_1_1_1);
        
        JButton btnNewButton_1_1_1_1_1_1_1 = new JButton("Print");
        btnNewButton_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnNewButton_1_1_1_1_1_1_1.setBounds(533, 523, 140, 124);
        getContentPane().add(btnNewButton_1_1_1_1_1_1_1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Orderview_version_WB().setVisible(true));
    }
}