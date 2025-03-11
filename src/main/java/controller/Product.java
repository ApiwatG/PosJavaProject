package controller;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

/**
 * Product class that generates SQL files to store order information
 * Works with the existing Order class
 */
public class Product {
    private String name;
    private double price;
    private Order order; // Reference to the order this product belongs to

    // Database file location - can be changed as needed
    private static final String DB_FILE = "orders.db";
    private static final String DB_URL = "jdbc:sqlite:" + DB_FILE;

    /**
     * Constructor for Product with name and price
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Constructor for creating a Product from a MenuItem with order reference
     */
    public Product(MenuItem menuItem, Order order) {
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();
        this.order = order;
    }

    /**
     * Create and initialize a new database file
     * @param dbFilePath Path where the database file should be created
     * @return true if successful, false otherwise
     */
    public static boolean createDatabaseFile(String dbFilePath) {
        // Use the specified path or default if not provided
        String dbUrl = "jdbc:sqlite:" + (dbFilePath != null ? dbFilePath : DB_FILE);

        try (Connection conn = DriverManager.getConnection(dbUrl);
             Statement stmt = conn.createStatement()) {

            // Create the orders table
            String createTableSQL =
                    "CREATE TABLE IF NOT EXISTS orders (" +
                            "    id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "    order_id TEXT NOT NULL," +
                            "    product_name TEXT NOT NULL," +
                            "    price REAL NOT NULL," +
                            "    order_time TEXT NOT NULL" +
                            ");";

            stmt.execute(createTableSQL);

            // Create an index on order_id for faster lookups
            stmt.execute("CREATE INDEX IF NOT EXISTS idx_order_id ON orders (order_id);");

            System.out.println("Database file created successfully at: " +
                    (dbFilePath != null ? dbFilePath : new File(DB_FILE).getAbsolutePath()));
            return true;
        } catch (SQLException e) {
            System.err.println("Error creating database file: " + e.getMessage());
            return false;
        }
    }

    /**
     * Save this product to the database file
     * @return true if successful, false otherwise
     */
    public boolean saveToDatabase() {
        if (order == null) {
            throw new IllegalStateException("Product must be associated with an order before saving to database");
        }

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO orders (order_id, product_name, price, order_time) VALUES (?, ?, ?, ?)")) {

            pstmt.setString(1, order.getOrderID());
            pstmt.setString(2, name);
            pstmt.setDouble(3, price);
            pstmt.setString(4, order.getOrderTime());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error saving to database: " + e.getMessage());
            return false;
        }
    }

    /**
     * Save multiple orders to the database file
     * @param orders List of Order objects to include in the database
     * @return true if successful, false otherwise
     */
    public static boolean saveOrdersToDatabase(List<Order> orders) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO orders (order_id, product_name, price, order_time) VALUES (?, ?, ?, ?)")) {

            conn.setAutoCommit(false);

            for (Order order : orders) {
                ArrayList<MenuItem> items = order.getItems();

                for (MenuItem item : items) {
                    pstmt.setString(1, order.getOrderID());
                    pstmt.setString(2, item.getName());
                    pstmt.setDouble(3, item.getPrice());
                    pstmt.setString(4, order.getOrderTime());
                    pstmt.addBatch();
                }
            }

            int[] results = pstmt.executeBatch();
            conn.commit();

            return results.length > 0;

        } catch (SQLException e) {
            System.err.println("Error saving orders to database: " + e.getMessage());
            return false;
        }
    }

    /**
     * Save a single order to the database file
     * @param order The order to save
     * @return true if successful, false otherwise
     */
    public static boolean saveOrderToDatabase(Order order) {
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        return saveOrdersToDatabase(orders);
    }

    /**
     * Retrieve all orders from the database file
     * @return List of order records as strings
     */
    public static List<String> retrieveAllOrders() {
        List<String> results = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM orders ORDER BY order_time")) {

            while (rs.next()) {
                String orderRecord = String.format(
                        "Order ID: %s, Product: %s, Price: $%.2f, Time: %s",
                        rs.getString("order_id"),
                        rs.getString("product_name"),
                        rs.getDouble("price"),
                        rs.getString("order_time")
                );
                results.add(orderRecord);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving orders: " + e.getMessage());
        }

        return results;
    }

    /**
     * Retrieve orders by order ID from the database file
     * @param orderId The order ID to search for
     * @return List of order records as strings
     */
    public static List<String> retrieveOrderById(String orderId) {
        List<String> results = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT * FROM orders WHERE order_id = ? ORDER BY order_time")) {

            pstmt.setString(1, orderId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String orderRecord = String.format(
                            "Order ID: %s, Product: %s, Price: $%.2f, Time: %s",
                            rs.getString("order_id"),
                            rs.getString("product_name"),
                            rs.getDouble("price"),
                            rs.getString("order_time")
                    );
                    results.add(orderRecord);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving order by ID: " + e.getMessage());
        }

        return results;
    }

    /**
     * Check if the database file exists
     * @param dbFilePath Optional custom path to check
     * @return true if the database file exists, false otherwise
     */
    public static boolean databaseFileExists(String dbFilePath) {
        File dbFile = new File(dbFilePath != null ? dbFilePath : DB_FILE);
        return dbFile.exists();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
