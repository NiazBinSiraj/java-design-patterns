package com.niaz.patterns.factory;

/**
 * Enum for supported notification channels.
 *
 * Replaces raw string matching — no more typos, IDE autocomplete works,
 * and adding a channel is a compile-time checklist instead of a runtime surprise.
 */
public enum ChannelType {

    EMAIL,
    SMS,
    PUSH;

    /**
     * Case-insensitive lookup. Throws if the value doesn't match any constant.
     */
    public static ChannelType fromString(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Channel must not be null or blank");
        }
        try {
            return valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown channel: " + value);
        }
    }
}
