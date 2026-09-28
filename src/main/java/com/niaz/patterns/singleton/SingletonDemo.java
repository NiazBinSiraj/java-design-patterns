package com.niaz.patterns.singleton;

/**
 * Demo showing both singleton variants.
 *
 * - DatabaseConnection: Holder idiom (lazy, thread-safe, no sync overhead)
 * - AppConfig: Enum singleton (serialization-safe, reflection-safe)
 */
public class SingletonDemo {

    public static void main(String[] args) {
        System.out.println("=== DatabaseConnection (Holder Idiom) ===");

        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println("Same instance? " + (db1 == db2));
        System.out.println("URL: " + db1.getConnectionUrl());

        db1.connect();
        db2.connect(); // already connected
        db1.disconnect();

        System.out.println();
        System.out.println("=== AppConfig (Enum Singleton) ===");

        AppConfig config = AppConfig.INSTANCE;
        System.out.println("App: " + config.getProperty("app.name"));
        System.out.println("Version: " + config.getProperty("app.version"));
        System.out.println("Missing key: " + config.getProperty("app.missing", "N/A"));

        config.setProperty("app.env", "production");
        System.out.println("Env: " + AppConfig.INSTANCE.getProperty("app.env"));
        System.out.println("Has debug? " + config.hasProperty("app.debug"));

        System.out.println("All props: " + config.getAllProperties());
    }
}
