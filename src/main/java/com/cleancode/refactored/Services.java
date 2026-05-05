package com.cleancode.refactored;

/**
 * REFACTORED VERSION:
 * 4. Separate responsibilities (Fixed Divergent Change)
 * 5. Move Method (Fixed Feature Envy)
 * 6. Local variables (Fixed Temporary Fields)
 */

class Customer {
    private String name;
    private String type;
    private int years;

    public Customer(String name, String type, int years) {
        this.name = name;
        this.type = type;
        this.years = years;
    }

    // Fixed Feature Envy: Customer now calculates its own discount eligibility
    public double getDiscountRate() {
        return (type.equals("GOLD") && years > 5) ? 0.20 : 0.05;
    }

    public String getName() { return name; }
}

class EmailService {
    public void sendHeader(Customer customer) {
        System.out.println("Header for " + customer.getName());
    }
}

class TaxCalculator {
    private static final double TAX_RATE = 0.21;

    public double calculateFinalPrice(Customer customer, double basePrice) {
        // Fixed Temporary Fields: Using local variables
        double discount = basePrice * customer.getDiscountRate();
        double taxableAmount = basePrice - discount;
        return taxableAmount + (taxableAmount * TAX_RATE);
    }
}

class Config {
    // Fixed Inappropriate Intimacy: Encapsulated fields
    private String dbUrl = "jdbc:mysql://localhost:3306/mydb";
    
    public String getDbUrl() { return dbUrl; }
    public void setDbUrl(String url) { this.dbUrl = url; }
}
