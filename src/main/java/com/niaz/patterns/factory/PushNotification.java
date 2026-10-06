package com.niaz.patterns.factory;

/**
 * Concrete product — sends push notifications to mobile devices.
 */
public class PushNotification implements Notification {

    @Override
    public void send(String recipient, String message) {
        System.out.printf("[PUSH] DeviceToken: %s | Alert: %s%n", recipient, message);
    }

    @Override
    public String getType() {
        return "PUSH";
    }
}
