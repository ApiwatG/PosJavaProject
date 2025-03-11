package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private List<MenuItem> items;
    private double totalAmount;
    private String orderStatus;
    private Date orderDate;

    public Order(int orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.orderDate = new Date();
        this.orderStatus = "Processing";
        this.totalAmount = 0.0;
    }

    public void addItem(MenuItem item) {
        items.add(item);
        calculateTotal();
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
        calculateTotal();
    }

    public void calculateTotal() {
        this.totalAmount = items.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
    }

    // Getters
    public int getOrderId() { return orderId; }
    public List<MenuItem> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
    public String getOrderStatus() { return orderStatus; }
    public Date getOrderDate() { return orderDate; }

    // Setters
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setItems(List<MenuItem> items) {
        this.items = items;
        calculateTotal();
    }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
}
