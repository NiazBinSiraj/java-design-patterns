package com.niaz.patterns.singleton;

/**
 * Thread-safe Singleton using the Initialization-on-Demand Holder idiom.
 *
 * Replaced double-checked locking — the holder class isn't loaded until
 * getInstance() is called, and class loading is inherently thread-safe.
 * No volatile, no synchronized block needed.
 */
public class DatabaseConnection {

    private final String connectionUrl;
    private boolean connected;

    private DatabaseConnection(String connectionUrl) {
        this.connectionUrl = connectionUrl;
        this.connected = false;
    }

    /**
     * Inner static class that holds the singleton instance.
     * JVM guarantees this is loaded lazily and thread-safe.
     */
    private static class Holder {
        private static final DatabaseConnection INSTANCE =
                new DatabaseConnection("jdbc:postgresql://localhost:5432/appdb");
    }

    public static DatabaseConnection getInstance() {
        return Holder.INSTANCE;
    }

    public void connect() {
        if (!connected) {
            System.out.println("Connecting to " + connectionUrl);
            this.connected = true;
        } else {
            System.out.println("Already connected.");
        }
    }

    public void disconnect() {
        if (connected) {
            System.out.println("Disconnecting from " + connectionUrl);
            this.connected = false;
        }
    }

    public boolean isConnected() {
        return connected;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }
}
