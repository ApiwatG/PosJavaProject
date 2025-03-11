package controller;

import javax.swing.*;
import java.awt.*;

public class PosGUI extends JFrame {

    public PosGUI() {
        super("POS System Dashboard");

        // Setup the main frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Create and add the side menu panel
        JPanel menuPanel = createMenuPanel();
        add(menuPanel, BorderLayout.WEST);

        // Create and add the dashboard panel
        JPanel dashboardPanel = createDashboardPanel();
        add(dashboardPanel, BorderLayout.CENTER);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(250, getHeight()));
        panel.setBorder(BorderFactory.createTitledBorder("Menu"));

        // Example menu buttons
        JButton menuButton1 = new JButton("Home");
        JButton menuButton2 = new JButton("Orders");
        JButton menuButton3 = new JButton("Products");

        menuButton1.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton3.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(20)); // Adds space at the top
        panel.add(menuButton1);
        panel.add(Box.createVerticalStrut(10));
        panel.add(menuButton2);
        panel.add(Box.createVerticalStrut(10));
        panel.add(menuButton3);

        return panel;
    }

    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Dashboard"));

        JLabel message = new JLabel("Welcome to the POS Dashboard", SwingConstants.CENTER);
        panel.add(message, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PosGUI frame = new PosGUI();
            frame.setVisible(true);
        });
    }
}