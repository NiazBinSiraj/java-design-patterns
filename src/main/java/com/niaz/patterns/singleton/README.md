# Singleton Pattern

Ensures a class has only one instance and provides a global point of access to it.

## When to Use

- Shared resource that's expensive to create (DB connections, thread pools)
- Global configuration that needs to stay consistent across the app
- Logging, caching, or registry objects

## Implementations

### 1. Double-Checked Locking (`DatabaseConnection`)

Thread-safe lazy initialization using `volatile` + `synchronized`. The instance is only created when `getInstance()` is first called, and the double-check avoids synchronization overhead on subsequent calls.

```java
DatabaseConnection db = DatabaseConnection.getInstance();
db.connect();
```

**Trade-offs:**
- Lazy init — instance isn't created until needed
- Thread-safe, but slightly more complex code
- Can be broken by reflection (not handled here)

### 2. Enum-Based (`AppConfig`)

The approach recommended by Joshua Bloch in Effective Java. The JVM guarantees a single instance, and it handles serialization and reflection for free.

```java
AppConfig config = AppConfig.INSTANCE;
String env = config.getProperty("app.env");
```

**Trade-offs:**
- Simplest and safest approach
- Eager init — created when the enum class is loaded
- Can't extend other classes (enums can't inherit)

## Running the Demo

```bash
javac -d out src/main/java/com/niaz/patterns/singleton/*.java
java -cp out com.niaz.patterns.singleton.SingletonDemo
```

## Class Diagram

```
┌──────────────────────────┐      ┌─────────────────────────┐
│   DatabaseConnection     │      │     AppConfig «enum»    │
├──────────────────────────┤      ├─────────────────────────┤
│ - instance: volatile     │      │   INSTANCE              │
│ - connectionUrl: String  │      │ - properties: Map       │
│ - connected: boolean     │      ├─────────────────────────┤
├──────────────────────────┤      │ + getProperty(key)      │
│ - DatabaseConnection()   │      │ + setProperty(key, val) │
│ + getInstance()          │      │ + getAllProperties()    │
│ + connect()              │      └─────────────────────────┘
│ + disconnect()           │
│ + isConnected()          │
└──────────────────────────┘
```

## References

- Effective Java, Item 3 (Joshua Bloch)
- Head First Design Patterns, Ch. 5
- [Refactoring Guru — Singleton](https://refactoring.guru/design-patterns/singleton)
