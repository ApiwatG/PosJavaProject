package controller;

import java.util.ArrayList;
import java.util.List;

public class Kitchen {
    private List<Order> pendingOrders;

    public Kitchen() {
        this.pendingOrders = new ArrayList<>();
    }

    public void receiveOrder(Order order) {
        pendingOrders.add(order);
        order.setOrderStatus("In Kitchen");
    }

    public void processOrder(Order order) {
        order.setOrderStatus("Preparing");
        // Additional logic for processing order
    }

    public void completeOrder(Order order) {
        pendingOrders.remove(order);
        order.setOrderStatus("Completed");
    }

    public List<Order> getPendingOrders() {
        return pendingOrders;
    }
}