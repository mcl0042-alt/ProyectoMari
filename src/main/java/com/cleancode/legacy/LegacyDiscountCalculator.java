package com.cleancode.legacy;

/**
 * CODE SMELLS:
 * 5. Temporary Fields (taxAmount and discountApplied are only used briefly in one method)
 * 6. Feature Envy (Calculator is too interested in CustomerProfile fields)
 */
public class LegacyDiscountCalculator {
    
    // SMELL: Temporary Fields
    private double taxAmount;
    private double discountApplied;

    public double calculateFinal(CustomerProfile profile, double basePrice) {
        // SMELL: Feature Envy - Accessing profile data repeatedly
        if (profile.getType().equals("GOLD") && profile.getYears() > 5) {
            discountApplied = basePrice * 0.20;
        } else {
            discountApplied = basePrice * 0.05;
        }

        taxAmount = (basePrice - discountApplied) * 0.21;
        return basePrice - discountApplied + taxAmount;
    }
}

/**
 * CODE SMELLS:
 * 7. Divergent Change - This class changes if business rules for Customers change, 
 *    BUT ALSO if Email format changes, AND if Address validation changes.
 */
class CustomerProfile {
    private String name;
    private String type;
    private int years;

    public CustomerProfile(String name, String type, int years) {
        this.name = name;
        this.type = type;
        this.years = years;
    }

    // This belongs here
    public String getType() { return type; }
    public int getYears() { return years; }

    // SMELL: Divergent Change - Email logic shouldn't be here
    public void formatEmailHeader() {
        System.out.println("Header for " + name);
    }

    // SMELL: Divergent Change - Address logic shouldn't be here
    public void validateAddress(String street, String city) {
        if (street == null || city == null) {
            System.out.println("Invalid address");
        }
    }
}
