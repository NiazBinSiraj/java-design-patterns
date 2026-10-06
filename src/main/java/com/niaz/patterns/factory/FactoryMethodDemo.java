package com.niaz.patterns.factory;

/**
 * Demo — shows how the factory decouples notification creation from usage.
 *
 * The caller doesn't need to know which concrete class gets instantiated;
 * it just asks the factory for a channel and calls send().
 */
public class FactoryMethodDemo {

    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        String[] channels = {"email", "sms", "push"};

        for (String channel : channels) {
            Notification notification = factory.createNotification(channel);
            System.out.println("Created: " + notification.getType());
            notification.send("niaz@example.com", "Your order #1234 has been shipped.");
            System.out.println();
        }

        // Demonstrate error handling for unknown channel
        try {
            factory.createNotification("pigeon");
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}
