package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import View.Home;
public class Login extends JFrame {
    
    // สำหรับเก็บข้อมูลผู้ใช้ (ในระบบจริงควรใช้ฐานข้อมูล)
    private static Map<String, String> userCredentials = new HashMap<>();
    
    // Components สำหรับหน้า Login
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;
    
    public Login() {
        // ตั้งค่าข้อมูลผู้ใช้ตัวอย่าง
        userCredentials.put("admin", "admin123");
        userCredentials.put("user", "user123");
        
        // ตั้งค่าหน้าต่าง
        setTitle("POS System Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // สร้าง GUI
        initializeUI();
        
        // แสดงหน้าต่าง
        setVisible(true);
    }
    
    private void initializeUI() {
        // สร้าง panel หลัก
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // สร้าง panel สำหรับส่วน login
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2, 10, 10));
        
        // Username field
        loginPanel.add(new JLabel("Username:"));
        usernameField = new JTextField(15);
        loginPanel.add(usernameField);
        
        // Password field
        loginPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        loginPanel.add(passwordField);
        
        // Login button
        loginButton = new JButton("Login");
        loginPanel.add(new JLabel("")); // ช่องว่างสำหรับการจัดวาง
        loginPanel.add(loginButton);
        
        // Status label
        statusLabel = new JLabel("กรุณาป้อนชื่อผู้ใช้และรหัสผ่าน", JLabel.CENTER);
        statusLabel.setForeground(Color.BLUE);
        
        // เพิ่ม logo หรือชื่อระบบ (header)
        JLabel headerLabel = new JLabel("POS System", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        // เพิ่มส่วนประกอบเข้า panel หลัก
        mainPanel.add(headerLabel, BorderLayout.NORTH);
        mainPanel.add(loginPanel, BorderLayout.CENTER);
        mainPanel.add(statusLabel, BorderLayout.SOUTH);
        
        // เพิ่ม event สำหรับปุ่ม login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
        
        // เพิ่มความสามารถในการกด Enter เพื่อ login
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
        
        // เพิ่ม panel หลักเข้า frame
        add(mainPanel);
    }
    
   private void performLogin() {
    String username = usernameField.getText();
    String password = new String(passwordField.getPassword());
    
    // ตรวจสอบความถูกต้องของข้อมูล
    if (username.isEmpty() || password.isEmpty()) {
        statusLabel.setText("กรุณาป้อนข้อมูลให้ครบ");
        statusLabel.setForeground(Color.RED);
        return;
    }
    
    // ตรวจสอบความถูกต้องของรหัสผ่าน
    if (userCredentials.containsKey(username) && 
        userCredentials.get(username).equals(password)) {
        statusLabel.setText("Login สำเร็จ! กำลังเปิดหน้าหลัก..."); 
        statusLabel.setForeground(Color.GREEN);
        
        // เรียกเมธอดที่จะเปิดหน้า Home แทน OrderView
        openHomeView();
        
    } else {
        statusLabel.setText("ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง");
        statusLabel.setForeground(Color.RED);
    }
}
    
    private void openHomeView() {
    // หน่วงเวลาเล็กน้อยเพื่อให้ผู้ใช้เห็นว่าการ login สำเร็จ
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // ปิดหน้า login
            dispose();
            
            // เปิดหน้า Home
            Home home = new Home();
            home.setVisible(true);
        }
    });
    timer.setRepeats(false);
    timer.start();
}
    
    public static void main(String[] args) {
        // ใช้ Look and Feel ของระบบ
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // เรียกใช้งาน application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });
    }
}

// สมมติว่านี่คือคลาส OrderView_version_WB ที่จะเปิดหลังจาก login สำเร็จ
class OrderView_version_WB extends JFrame {
    
    private void openOrderView() {
    // หน่วงเวลาเล็กน้อยเพื่อให้ผู้ใช้เห็นว่าการ login สำเร็จ
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // ปิดหน้า login
            dispose();
            
            // เปิดหน้า Home แทน OrderView
            Home home = new Home();
            home.setVisible(true);
        }
    });
    timer.setRepeats(false);
    timer.start();
}
    private void openHomeView() {
    // หน่วงเวลาเล็กน้อยเพื่อให้ผู้ใช้เห็นว่าการ login สำเร็จ
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // ปิดหน้า login
            dispose();
            
            // เปิดหน้า Home แทน OrderView
            Home home = new Home();
            home.setVisible(true);
        }
    });
    timer.setRepeats(false);
    timer.start();
}
    
}