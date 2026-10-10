package com.niaz.patterns.factory;

import java.util.Objects;

/**
 * Base class that handles the repetitive channel type wiring.
 * Subclasses only need to implement send() — no more copy-pasting getChannelType().
 */
public abstract class AbstractNotification implements Notification {

    private final ChannelType channelType;

    protected AbstractNotification(ChannelType channelType) {
        this.channelType = Objects.requireNonNull(channelType, "channelType must not be null");
    }

    @Override
    public final ChannelType getChannelType() {
        return channelType;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{channel=" + channelType + "}";
    }
}
