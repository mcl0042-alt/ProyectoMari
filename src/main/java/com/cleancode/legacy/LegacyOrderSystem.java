package com.cleancode.legacy;

import java.util.ArrayList;
import java.util.List;

/**
 * CODE SMELLS: 
 * 1. Large Class (Handles everything)
 * 2. Switch Statements (Payment type)
 * 3. Dead Code (unused methods)
 * 4. Long Method (processOrder)
 */
public class LegacyOrderSystem {

    private List<String> items = new ArrayList<>();
    private double totalAmount = 0;

    // SMELL: Large Class - handling database logic here (simulated)
    public void saveToDatabase() {
        System.out.println("Saving order to DB...");
    }

    // SMELL: Large Class - handling email logic here (simulated)
    public void sendEmailNotification(String email) {
        System.out.println("Sending email to " + email);
    }

    // SMELL: Switch Statements
    public void processPayment(String type, double amount) {
        switch (type) {
            case "CREDIT_CARD":
                System.out.println("Processing Credit Card payment: " + amount);
                break;
            case "PAYPAL":
                System.out.println("Processing PayPal payment: " + amount);
                break;
            case "CRYPTO":
                System.out.println("Processing Crypto payment: " + amount);
                break;
            default:
                throw new IllegalArgumentException("Unknown payment type");
        }
    }

    // SMELL: Long Method & Duplicate Code
    public void processOrder(String customerName, List<Double> prices, boolean isVIP) {
        System.out.println("Starting process for " + customerName);
        
        double subtotal = 0;
        for (Double price : prices) {
            subtotal += price;
        }

        // SMELL: Duplicate logic (this could be a separate method)
        if (isVIP) {
            subtotal = subtotal * 0.90; // 10% discount
        }

        if (subtotal > 100) {
            subtotal -= 5; // Extra 5 discount for big orders
        }

        this.totalAmount = subtotal;
        
        saveToDatabase();
        sendEmailNotification("customer@example.com");
        
        System.out.println("Order processed. Total: " + totalAmount);
    }

    // SMELL: Dead Code (Never used)
    public void oldLegacyMethodThatIsNoLongerNeeded() {
        System.out.println("This is old...");
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
