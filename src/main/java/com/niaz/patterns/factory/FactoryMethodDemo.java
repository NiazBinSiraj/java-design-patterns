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

        // Type-safe iteration over all channels
        for (ChannelType channel : ChannelType.values()) {
            Notification notification = factory.createNotification(channel);
            System.out.println("Created: " + notification.getChannelType());
            notification.send("niaz@example.com", "Your order #1234 has been shipped.");
            System.out.println();
        }

        // String overload still works for backward compat
        Notification email = factory.createNotification("email");
        System.out.println("From string: " + email.getChannelType());
        System.out.println();

        // Demonstrate error handling for unknown channel
        try {
            factory.createNotification("pigeon");
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}
