package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class POSSystem {
    private List<MenuItem> menu;
    private List<Order> orders;
    private Kitchen kitchen;
    private List<Payment> payments;
    private Dashboard dashboard;

    public POSSystem() {
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.kitchen = new Kitchen();
        this.payments = new ArrayList<>();
        this.dashboard = new Dashboard();
    }

    public Order takeOrder(List<MenuItem> items) {
        Order newOrder = new Order(generateOrderId());
        items.forEach(newOrder::addItem);
        orders.add(newOrder);
        return newOrder;
    }

    public void processPayment(Order order, Payment payment) {
        if (payment.getAmount() >= order.getTotalAmount()) {
            payment.setStatus("Completed");
            order.setOrderStatus("Paid");
            recordPayment(payment);
        }
    }

    public void recordPayment(Payment payment) {
        payments.add(payment);
        updateDashboard();
    }

    public void sendOrderToKitchen(Order order) {
        kitchen.receiveOrder(order);
    }

    public List<Payment> getPendingPayments() {
        return payments.stream()
                .filter(p -> p.getStatus().equals("Pending"))
                .collect(Collectors.toList());
    }

    public void updateDashboard() {
        dashboard.updateSummary(orders, payments);
    }

    private int generateOrderId() {
        return orders.size() + 1;
    }

    // Getters
    public List<MenuItem> getMenu() { return menu; }
    public List<Order> getOrders() { return orders; }
    public Kitchen getKitchen() { return kitchen; }
    public Dashboard getDashboard() { return dashboard; }

    // Menu management methods
    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void removeMenuItem(MenuItem item) {
        menu.remove(item);
    }
}