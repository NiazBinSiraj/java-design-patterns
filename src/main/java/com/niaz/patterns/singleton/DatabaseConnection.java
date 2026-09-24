package com.niaz.patterns.singleton;

/**
 * Thread-safe Singleton using double-checked locking.
 * Simulates a database connection pool — the classic singleton use case.
 */
public class DatabaseConnection {

    private static volatile DatabaseConnection instance;

    private final String connectionUrl;
    private boolean connected;

    private DatabaseConnection(String connectionUrl) {
        this.connectionUrl = connectionUrl;
        this.connected = false;
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection("jdbc:postgresql://localhost:5432/appdb");
                }
            }
        }
        return instance;
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

    /**
     * Only for testing — resets the singleton instance.
     */
    static void resetInstance() {
        instance = null;
    }
}
