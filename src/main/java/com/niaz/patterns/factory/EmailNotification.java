package com.niaz.patterns.factory;

/**
 * Concrete product — sends notifications via email.
 */
public class EmailNotification extends AbstractNotification {

    public EmailNotification() {
        super(ChannelType.EMAIL);
    }

    @Override
    public void send(String recipient, String message) {
        System.out.printf("[EMAIL] To: %s | Subject: Notification | Body: %s%n", recipient, message);
    }
}
