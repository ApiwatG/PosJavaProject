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


public class Orderview_version_WB extends JFrame {
    private DefaultTableModel tableModel;
    private int orderId = 1;
    private JTextField textField;
    static Order o = new Order();
    static MenuItem M = new MenuItem();
    private JLabel lblNewLabel_1; // Make this a class field for easier access
    
    // Declare all buttons as class fields
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_1_1;
    private JButton btnNewButton_1_1_1;
    private JButton btnNewButton_1_2;
    private JButton btnNewButton_2;
    private JButton btnNewButton_1_1_1_1;
    private JButton btnNewButton_1_2_1;
    private JButton btnNewButton_2_1;

    public Orderview_version_WB() {
        setTitle("New Orderview");
        setSize(998, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Table setup
        String[] columnNames = {"ID", "Name", "price", "Time"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(507, 34, 465, 316);
        getContentPane().add(scrollPane);
        
        // Initialize all buttons first
        btnNewButton = new JButton("New button");
        btnNewButton_1 = new JButton("New button");
        btnNewButton_1_1 = new JButton("New button");
        btnNewButton_1_1_1 = new JButton("New button");
        btnNewButton_1_2 = new JButton("New button");
        btnNewButton_2 = new JButton("New button");
        btnNewButton_1_1_1_1 = new JButton("New button");
        btnNewButton_1_2_1 = new JButton("New button");
        btnNewButton_2_1 = new JButton("New button");
        
        // Initialize labels
        JLabel lblNewLabel = new JLabel("Total :");
        lblNewLabel.setBounds(507, 343, 79, 77);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        getContentPane().add(lblNewLabel);
        
        // Initialize the total label and make sure it's visible
        lblNewLabel_1 = new JLabel("0.0");
        lblNewLabel_1.setBounds(596, 361, 120, 37); // Made wider for larger totals
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        getContentPane().add(lblNewLabel_1);
        lblNewLabel_1.setVisible(true);
        
        JLabel lblCash = new JLabel("Cash :");
        lblCash.setBounds(507, 398, 140, 77);
        lblCash.setFont(new Font("Tahoma", Font.PLAIN, 25));
        getContentPane().add(lblCash);
        
        JLabel lblBalance = new JLabel("Balance :");
        lblBalance.setBounds(507, 463, 108, 61);
        lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 25));
        getContentPane().add(lblBalance);
        
        JLabel lblNewLabel_1_1 = new JLabel("0");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel_1_1.setBounds(626, 473, 120, 37); // Made wider for larger values
        getContentPane().add(lblNewLabel_1_1);
        
        textField = new JTextField();
        textField.setBounds(591, 422, 108, 30);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        // Now define the action listener that uses the buttons
        ActionListener menuItemAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get information about which button was clicked
                JButton source = (JButton) e.getSource();
                
                // Determine which menu item to add based on the button
                if (source == btnNewButton) {
                    M.MenuItem(1, "luGshin", 58.0, 1);
                } else if (source == btnNewButton_1) {
                    M.MenuItem(2, "donustod", 50.0, 1);
                } else if (source == btnNewButton_1_1) {
                    M.MenuItem(3, "kungtodkateam", 70.0, 1);
                } else if (source == btnNewButton_1_1_1) {
                    M.MenuItem(2, "krawpadkung", 75.0, 1);
                } else if (source == btnNewButton_1_2) {
                    M.MenuItem(5, "krawpadsubparod", 75.0, 1);
                } else if (source == btnNewButton_2) {
                    M.MenuItem(4, "Krawmadkai", 65.0, 1);
                } else if (source == btnNewButton_1_1_1_1) {
                    M.MenuItem(4, "namnung", 75.0, 1);
                } else if (source == btnNewButton_1_2_1) {
                    M.MenuItem(8, "padthai", 65.0, 1);
                } else if (source == btnNewButton_2_1) {
                    M.MenuItem(7, "Muusadte", 75.0, 1);
                }
                
                // Add the item to the order
                o.addItem(M, M.getPrice());
                
                // Add the item to the table
                tableModel.addRow(new Object[]{o.getOrderID(), M.getName(), 
                                              M.getPrice(), o.getOrderTime()});
                
                // Update the total display
                updateTotalDisplay();
            }
        };
        
        // Configure and add action listeners to buttons
        btnNewButton.setBounds(31, 34, 140, 124);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/1.png"));
            btnNewButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        btnNewButton.addActionListener(menuItemAction);
        getContentPane().add(btnNewButton);
        
        btnNewButton_1.setBounds(181, 34, 140, 124);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/2.png"));
            btnNewButton_1.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        btnNewButton_1.addActionListener(menuItemAction);
        getContentPane().add(btnNewButton_1);
        
        btnNewButton_1_1.setBounds(331, 34, 140, 124);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/3.png"));
            btnNewButton_1_1.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        btnNewButton_1_1.addActionListener(menuItemAction);
        getContentPane().add(btnNewButton_1_1);
        
        btnNewButton_1_1_1.setBounds(331, 181, 140, 124);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/4.png"));
            btnNewButton_1_1_1.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        btnNewButton_1_1_1.addActionListener(menuItemAction);
        getContentPane().add(btnNewButton_1_1_1);
        
        btnNewButton_1_2.setBounds(181, 181, 140, 124);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/5.png"));
            btnNewButton_1_2.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        btnNewButton_1_2.addActionListener(menuItemAction);
        getContentPane().add(btnNewButton_1_2);
        
        btnNewButton_2.setBounds(31, 181, 140, 124);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/6.png"));
            btnNewButton_2.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        btnNewButton_2.addActionListener(menuItemAction);
        getContentPane().add(btnNewButton_2);
        
        btnNewButton_1_1_1_1.setBounds(331, 343, 140, 124);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/7.png"));
            btnNewButton_1_1_1_1.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        btnNewButton_1_1_1_1.addActionListener(menuItemAction);
        getContentPane().add(btnNewButton_1_1_1_1);
        
        btnNewButton_1_2_1.setBounds(181, 343, 140, 124);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/8.png"));
            btnNewButton_1_2_1.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        btnNewButton_1_2_1.addActionListener(menuItemAction);
        getContentPane().add(btnNewButton_1_2_1);
        
        btnNewButton_2_1.setBounds(31, 343, 140, 124);
        try {
            Image img = ImageIO.read(getClass().getResource("pic/9.png"));
            btnNewButton_2_1.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        btnNewButton_2_1.addActionListener(menuItemAction);
        getContentPane().add(btnNewButton_2_1);
        
        JButton btnNewButton_1_1_1_1_1 = new JButton("Pay");
        btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double cashAmount = Double.parseDouble(textField.getText());
                    double totalAmount = o.getTotalAmount();
                    double balance = cashAmount - totalAmount;
                    
                    if (balance >= 0) {
                        lblNewLabel_1_1.setText(String.format("%.2f", balance));
                        JOptionPane.showMessageDialog(null, "Payment successful! Balance: $" + 
                                String.format("%.2f", balance));
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient cash amount!", 
                                "Payment Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid cash amount!", 
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnNewButton_1_1_1_1_1.setBounds(793, 374, 140, 124);
        getContentPane().add(btnNewButton_1_1_1_1_1);
        
        JButton btnNewButton_1_1_1_1_1_1 = new JButton("Remove");
        btnNewButton_1_1_1_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow(); // Get selected row index
                if (selectedRow != -1) { // Ensure a row is selected
                    // Get the price of the item to be removed
                    double price = (double) tableModel.getValueAt(selectedRow, 2);
                    
                    // Remove the item from the table
                    tableModel.removeRow(selectedRow);
                    
                    // Manually update the order's total
                    o.removeItemAmount(price);  // Assuming there's a method to decrease total
                    
                    // Update the total display
                    updateTotalDisplay();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to remove.");
                }
            }
        });
        btnNewButton_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnNewButton_1_1_1_1_1_1.setBounds(793, 523, 140, 124);
        getContentPane().add(btnNewButton_1_1_1_1_1_1);
        
        JButton btnNewButton_1_1_1_1_1_1_1 = new JButton("Print");
        btnNewButton_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Generate a receipt or print functionality
                JOptionPane.showMessageDialog(null, 
                    "Order #" + o.getOrderID() + "\n" +
                    "Date/Time: " + o.getOrderTime() + "\n" +
                    "Total Amount: $" + String.format("%.2f", o.getTotalAmount()) + "\n" +
                    "Thank you for your order!"
                );
            }
        });
        btnNewButton_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnNewButton_1_1_1_1_1_1_1.setBounds(606, 523, 140, 124);
        getContentPane().add(btnNewButton_1_1_1_1_1_1_1);
        
        // Initialize the total display to show 0.00
        updateTotalDisplay();
    }
    
    // Method to update the total display label
    private void updateTotalDisplay() {
        lblNewLabel_1.setText(String.format("%.2f", o.getTotalAmount()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Orderview_version_WB().setVisible(true));
    }
}