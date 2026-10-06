package com.niaz.patterns.factory;

/**
 * Concrete product — sends notifications via SMS.
 */
public class SmsNotification implements Notification {

    private static final int MAX_LENGTH = 160;

    @Override
    public void send(String recipient, String message) {
        String truncated = message.length() > MAX_LENGTH
                ? message.substring(0, MAX_LENGTH - 3) + "..."
                : message;
        System.out.printf("[SMS] To: %s | Message: %s%n", recipient, truncated);
    }

    @Override
    public String getType() {
        return "SMS";
    }
}
