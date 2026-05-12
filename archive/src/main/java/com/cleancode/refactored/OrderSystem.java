package com.cleancode.refactored;

import java.util.List;

/**
 * REFACTORED VERSION:
 * 1. Strategy Pattern for Payments (Fixed Switch Statement)
 * 2. Single Responsibility (Fixed Large Class)
 * 3. Encapsulation (Fixed Inappropriate Intimacy)
 */

// Strategy interface for Payments
interface PaymentStrategy {
    void process(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void process(double amount) { System.out.println("Processing Credit Card: " + amount); }
}

class PayPalPayment implements PaymentStrategy {
    public void process(double amount) { System.out.println("Processing PayPal: " + amount); }
}

class CryptoPayment implements PaymentStrategy {
    public void process(double amount) { System.out.println("Processing Crypto: " + amount); }
}

// Dedicated Logger (Fixed Shotgun Surgery)
class AppLogger {
    private static final String PREFIX = "[APP-LOG]";
    public static void log(String level, String msg) {
        System.out.println(PREFIX + " " + level + ": " + msg);
    }
}

// Clean Order System
public class OrderSystem {
    private double totalAmount;

    public void processOrder(String customerName, List<Double> prices, boolean isVIP) {
        AppLogger.log("INFO", "Starting process for " + customerName);
        
        double subtotal = calculateSubtotal(prices);
        this.totalAmount = applyDiscounts(subtotal, isVIP);
        
        AppLogger.log("INFO", "Order processed. Total: " + totalAmount);
    }

    private double calculateSubtotal(List<Double> prices) {
        return prices.stream().mapToDouble(Double::doubleValue).sum();
    }

    private double applyDiscounts(double amount, boolean isVIP) {
        double discounted = isVIP ? amount * 0.90 : amount;
        if (discounted > 100) discounted -= 5;
        return discounted;
    }

    public double getTotalAmount() { return totalAmount; }
}
