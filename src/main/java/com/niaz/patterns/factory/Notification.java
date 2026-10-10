package com.niaz.patterns.factory;

/**
 * Product interface — all notifications must implement send().
 */
public interface Notification {

    void send(String recipient, String message);

    ChannelType getChannelType();
}
