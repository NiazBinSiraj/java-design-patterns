package com.niaz.patterns.factory;

/**
 * Concrete product — sends notifications via email.
 */
public class EmailNotification implements Notification {

    @Override
    public void send(String recipient, String message) {
        System.out.printf("[EMAIL] To: %s | Subject: Notification | Body: %s%n", recipient, message);
    }

    @Override
    public String getType() {
        return "EMAIL";
    }
}
