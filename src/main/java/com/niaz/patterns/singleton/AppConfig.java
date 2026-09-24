package com.niaz.patterns.singleton;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Enum-based Singleton — the simplest and most bulletproof approach.
 * Handles serialization and reflection attacks out of the box.
 */
public enum AppConfig {

    INSTANCE;

    private final Map<String, String> properties = new HashMap<>();

    AppConfig() {
        // load defaults
        properties.put("app.name", "java-design-patterns");
        properties.put("app.version", "1.0.0");
        properties.put("app.env", "development");
    }

    public String getProperty(String key) {
        return properties.get(key);
    }

    public void setProperty(String key, String value) {
        properties.put(key, value);
    }

    public Map<String, String> getAllProperties() {
        return Collections.unmodifiableMap(properties);
    }
}
