package com.niaz.patterns.factory;

/**
 * Factory Method — creates the right Notification subtype based on a channel string.
 *
 * In a real app you'd probably make this abstract with subclass factories,
 * but a parameterized factory method keeps things simple for the demo.
 */
public class NotificationFactory {

    /**
     * Factory method — returns the appropriate Notification implementation.
     *
     * @param channel one of "email", "sms", "push"
     * @return a Notification instance for that channel
     * @throws IllegalArgumentException if the channel isn't recognized
     */
    public Notification createNotification(String channel) {
        if (channel == null || channel.isBlank()) {
            throw new IllegalArgumentException("Channel must not be null or blank");
        }

        return switch (channel.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SmsNotification();
            case "push" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown channel: " + channel);
        };
    }
}
