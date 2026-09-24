package com.niaz.patterns.singleton;

/**
 * Quick demo showing both singleton variants in action.
 */
public class SingletonDemo {

    public static void main(String[] args) {
        // --- Double-checked locking singleton ---
        System.out.println("=== DatabaseConnection (DCL Singleton) ===");

        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println("Same instance? " + (db1 == db2)); // true

        db1.connect();
        db2.connect(); // should say already connected
        db1.disconnect();

        // --- Enum singleton ---
        System.out.println();
        System.out.println("=== AppConfig (Enum Singleton) ===");

        AppConfig config = AppConfig.INSTANCE;
        System.out.println("App: " + config.getProperty("app.name"));
        System.out.println("Version: " + config.getProperty("app.version"));

        config.setProperty("app.env", "production");
        System.out.println("Env: " + AppConfig.INSTANCE.getProperty("app.env")); // production

        System.out.println("All props: " + config.getAllProperties());
    }
}
