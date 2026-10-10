package com.niaz.patterns.factory;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Factory Method — creates Notification instances from a ChannelType.
 *
 * Uses an EnumMap registry instead of a switch, so adding a new channel
 * is just one line in the static block instead of a new case branch.
 */
public class NotificationFactory {

    private static final Map<ChannelType, Supplier<Notification>> REGISTRY = new EnumMap<>(ChannelType.class);

    static {
        REGISTRY.put(ChannelType.EMAIL, EmailNotification::new);
        REGISTRY.put(ChannelType.SMS, SmsNotification::new);
        REGISTRY.put(ChannelType.PUSH, PushNotification::new);
    }

    /**
     * Creates a notification for the given channel type.
     *
     * @param channelType the channel to create
     * @return a new Notification instance
     * @throws IllegalArgumentException if the channel type has no registered supplier
     */
    public Notification createNotification(ChannelType channelType) {
        if (channelType == null) {
            throw new IllegalArgumentException("Channel type must not be null");
        }

        Supplier<Notification> supplier = REGISTRY.get(channelType);
        if (supplier == null) {
            throw new IllegalArgumentException("No factory registered for channel: " + channelType);
        }
        return supplier.get();
    }

    /**
     * Convenience overload — parses a string into a ChannelType, then creates.
     * Keeps backward compat with callers still passing strings.
     */
    public Notification createNotification(String channel) {
        return createNotification(ChannelType.fromString(channel));
    }
}
