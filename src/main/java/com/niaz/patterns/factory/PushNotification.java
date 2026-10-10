package com.niaz.patterns.factory;

/**
 * Concrete product — sends push notifications to mobile devices.
 */
public class PushNotification extends AbstractNotification {

    public PushNotification() {
        super(ChannelType.PUSH);
    }

    @Override
    public void send(String recipient, String message) {
        System.out.printf("[PUSH] DeviceToken: %s | Alert: %s%n", recipient, message);
    }
}
