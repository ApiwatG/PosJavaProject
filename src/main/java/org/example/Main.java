package org.example;
import java.util.*;

import controller.MenuItem;
import controller.Order;
import controller.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");
        Order order = new Order();
        String d = order.getOrderTime();
        System.out.println(d);
        for (int i = 1; i <= 5; i++) {

        }
    }
}