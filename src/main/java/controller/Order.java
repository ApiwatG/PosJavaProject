package controller;

import javax.swing.*;
import java.util.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import java.util.Date;

public class Order {
    private String orderID;
    private ArrayList<MenuItem> items;
    private Date orderTime;
    private double totalAmount;     // Total amount of the order
    private String Orderstatus;          // e.g., "Pending", "Preparing", "Ready", "Delivered"

    public Order() {
        this.orderID = generateOrderID();
        this.items = new ArrayList<>();
        this.orderTime = new Date();
        this.totalAmount = 0.0;
        this.Orderstatus = "Pending";
    }

    private String generateOrderID() {
        // Simple implementation - you might want something more sophisticated
        return "ORD" + System.currentTimeMillis();
    }

    public void addItem(MenuItem item) {
        items.add(item);
        totalAmount += item.getPrice();
    }

    public void removeItem(MenuItem item) {
        if (items.remove(item)) {
            totalAmount -= item.getPrice();
        }
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setOrderStatus(String status) {
        this.Orderstatus = status;
    }

    public String getStatus() {
        return Orderstatus;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public String getOrderID() {
        return orderID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderID).append("\n");
        sb.append("Order Time: ").append(orderTime).append("\n");
        sb.append("Status: ").append(Orderstatus).append("\n");
        sb.append("Items:\n");

        for (MenuItem item : items) {
            sb.append("- ").append(item.getName())
                    .append(" ($").append(String.format("%.2f", item.getPrice())).append(")\n");
        }

        sb.append("Total Amount: $").append(String.format("%.2f", totalAmount));

        return sb.toString();
    }
}