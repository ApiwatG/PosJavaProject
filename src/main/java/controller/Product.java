package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Product class that generates SQL files to store order information
 * Works with the existing Order class
 */
public class Product {
    private String name;
    private double price;
    private Order order; // Reference to the order this product belongs to

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
     * Generate SQL INSERT statement for this product in its order
     * @return SQL INSERT statement
     */
    public String generateSqlInsert() {
        if (order == null) {
            throw new IllegalStateException("Product must be associated with an order before generating SQL");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String formattedDate = dateFormat.format(inputFormat.parse(order.getOrderTime()));

            return String.format(
                    "INSERT INTO orders (order_id, product_name, price, order_time) " +
                            "VALUES ('%s', '%s', %.2f, '%s');",
                    order.getOrderID(), name, price, formattedDate);
        } catch (Exception e) {
            System.err.println("Error formatting date: " + e.getMessage());
            return "-- Error generating SQL for " + name;
        }
    }

    /**
     * Save this product's order to SQL file
     * @return true if successful, false otherwise
     */
    public boolean saveToSqlFile(String filePath) {
        if (order == null) {
            throw new IllegalStateException("Product must be associated with an order before saving to SQL");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(generateSqlInsert());
            return true;
        } catch (IOException e) {
            System.err.println("Error writing to SQL file: " + e.getMessage());
            return false;
        }
    }

    /**
     * Generate SQL file with table creation and multiple orders
     * @param orders List of Order objects to include in the SQL file
     * @param filePath Path to save the SQL file
     * @return true if successful, false otherwise
     */
    public static boolean generateSqlFile(List<Order> orders, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Write SQL table creation statement
            writer.println("-- SQL Script to create orders table and insert data");
            writer.println("CREATE TABLE IF NOT EXISTS orders (");
            writer.println("    id INT AUTO_INCREMENT PRIMARY KEY,");
            writer.println("    order_id VARCHAR(50) NOT NULL,");
            writer.println("    product_name VARCHAR(100) NOT NULL,");
            writer.println("    price DECIMAL(10, 2) NOT NULL,");
            writer.println("    order_time DATETIME NOT NULL,");
            writer.println("    INDEX (order_id)");
            writer.println(");");
            writer.println();

            // Format for SQL dates
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            // Write SQL inserts for each product in each order
            writer.println("-- Order data");
            for (Order order : orders) {
                ArrayList<MenuItem> items = order.getItems();
                for (MenuItem item : items) {
                    Product product = new Product(item, order);
                    writer.println(product.generateSqlInsert());
                }
            }

            return true;
        } catch (IOException e) {
            System.err.println("Error creating SQL file: " + e.getMessage());
            return false;
        }
    }

    /**
     * Generate SQL file for a single order with all its items
     * @param order The order to convert to SQL
     * @param filePath Path to save the SQL file
     * @return true if successful, false otherwise
     */
    public static boolean generateOrderSqlFile(Order order, String filePath) {
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        return generateSqlFile(orders, filePath);
    }

    /**
     * Convert all menu items in an order to products and save to SQL
     * @param order The order containing menu items
     * @param filePath Path to save the SQL file
     * @return true if successful, false otherwise
     */
    public static boolean saveOrderToSqlFile(Order order, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            String formattedDate = dateFormat.format(inputFormat.parse(order.getOrderTime()));

            for (MenuItem item : order.getItems()) {
                String sqlInsert = String.format(
                        "INSERT INTO orders (order_id, product_name, price, order_time) " +
                                "VALUES ('%s', '%s', %.2f, '%s');",
                        order.getOrderID(), item.getName(), item.getPrice(), formattedDate);

                writer.println(sqlInsert);
            }

            return true;
        } catch (Exception e) {
            System.err.println("Error writing to SQL file: " + e.getMessage());
            return false;
        }
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

