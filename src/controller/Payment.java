package controller;

import java.util.Date;

public class Payment {
    private int paymentId;
    private double amount;
    private String status;
    private Date paymentDate;
    private Order order;

    public Payment(int paymentId, double amount, Order order) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.order = order;
        this.status = "Pending";
        this.paymentDate = new Date();
    }

    // Getters
    public int getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
    public Date getPaymentDate() { return paymentDate; }
    public Order getOrder() { return order; }

    // Setters
    public void setStatus(String status) { this.status = status; }
    public void setAmount(double amount) { this.amount = amount; }
}