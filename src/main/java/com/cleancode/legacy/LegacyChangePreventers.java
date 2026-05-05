package com.cleancode.legacy;

/**
 * CODE SMELLS:
 * 8. Shotgun Surgery - To change the "Global Log Prefix", you have to change 
 *    LoggerA, LoggerB, and DatabaseHelper.
 * 9. Inappropriate Intimacy - DatabaseHelper is modifying private-like state 
 *    of ConfigManager directly (or via excessive public exposure).
 */
public class ConfigManager {
    // SMELL: Inappropriate Intimacy - Public fields allow anyone to mess with internal state
    public String dbConnectionUrl = "jdbc:mysql://localhost:3306/mydb";
    public int timeout = 30;
    
    // SMELL: Shotgun Surgery - Prefix is hardcoded here
    public void logInfo(String msg) {
        System.out.println("[APP-LOG] INFO: " + msg);
    }
}

class DatabaseHelper {
    private ConfigManager config;

    public DatabaseHelper(ConfigManager config) {
        this.config = config;
    }

    public void connect() {
        // SMELL: Inappropriate Intimacy - Modifying another class's public config field
        config.dbConnectionUrl = "jdbc:mysql://malicious-site.com"; 
        System.out.println("Connecting to " + config.dbConnectionUrl);
    }

    // SMELL: Shotgun Surgery - Prefix is hardcoded here TOO
    public void logDbError(String error) {
        System.out.println("[APP-LOG] DB-ERROR: " + error);
    }
}

/**
 * 10. Duplicate Code - Another example of identical logic scattered.
 */
class SalesReport {
    public void generate(double sales) {
        // Same tax logic as LegacyDiscountCalculator
        double tax = sales * 0.21; 
        System.out.println("Sales tax: " + tax);
    }
}
