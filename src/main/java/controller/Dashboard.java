package controller;

import java.util.List;

public class Dashboard {
    private int totalOrders;
    private double totalRevenue;
    private int totalPayments;

    public Dashboard() {
        this.totalOrders = 0;
        this.totalRevenue = 0.0;
        this.totalPayments = 0;
    }

    public void updateSummary(List<Order> orders, List<Payment> payments) {
        this.totalOrders = orders.size();
        this.totalRevenue = orders.stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();
        this.totalPayments = payments.size();
    }

    // Getters
    public int getTotalOrders() { return totalOrders; }
    public double getTotalRevenue() { return totalRevenue; }
    public int getTotalPayments() { return totalPayments; }
}