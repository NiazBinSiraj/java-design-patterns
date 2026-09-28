package com.niaz.patterns.singleton;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Enum-based Singleton — the simplest and most bulletproof approach.
 * Handles serialization and reflection attacks out of the box.
 *
 * Switched internal map to ConcurrentHashMap so setProperty() is
 * safe to call from multiple threads without external sync.
 */
public enum AppConfig {

    INSTANCE;

    private final Map<String, String> properties = new ConcurrentHashMap<>();

    AppConfig() {
        properties.put("app.name", "java-design-patterns");
        properties.put("app.version", "1.0.0");
        properties.put("app.env", "development");
    }

    public String getProperty(String key) {
        return properties.get(key);
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getOrDefault(key, defaultValue);
    }

    public void setProperty(String key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("key and value must not be null");
        }
        properties.put(key, value);
    }

    public boolean hasProperty(String key) {
        return properties.containsKey(key);
    }

    public Map<String, String> getAllProperties() {
        return Collections.unmodifiableMap(properties);
    }
}
