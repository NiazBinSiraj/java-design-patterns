# Factory Method Pattern

Defines an interface for creating objects, but lets subclasses (or a parameterized method) decide which class to instantiate.

## When to Use

- You don't know ahead of time which concrete class you'll need
- You want to decouple object creation from the code that uses it
- Adding new product types shouldn't require changing existing client code
- Common in frameworks — Spring's `BeanFactory`, JDBC's `DriverManager.getConnection()`

## Implementation

### Parameterized Factory (`NotificationFactory`)

A single factory class with a `createNotification(channel)` method that returns the right `Notification` implementation based on a string parameter. In a stricter GoF setup you'd have abstract creator subclasses, but this keeps it simple for a notification sender use case.

```java
NotificationFactory factory = new NotificationFactory();
Notification n = factory.createNotification("email");
n.send("user@example.com", "Your order shipped.");
```

The factory uses a `switch` expression (Java 14+) to map channel names to concrete types:

| Channel   | Concrete Class       | Notes                          |
|-----------|----------------------|--------------------------------|
| `email`   | `EmailNotification`  | Simple print to stdout         |
| `sms`     | `SmsNotification`    | Truncates messages to 160 chars|
| `push`    | `PushNotification`   | Uses device token as recipient |

**Trade-offs:**
- Easy to understand — single factory, one method
- Adding a new channel means touching the switch — violates OCP in theory
- Null/blank channel input throws `IllegalArgumentException`
- No reflection magic, no DI — just plain Java

## Class Diagram

```
                    ┌──────────────────────┐
                    │  «interface»          │
                    │    Notification       │
                    ├──────────────────────┤
                    │ + send(to, msg)       │
                    │ + getType(): String   │
                    └──────────┬───────────┘
                               │ implements
              ┌────────────────┼────────────────┐
              │                │                │
┌─────────────┴──┐  ┌─────────┴────┐  ┌────────┴──────────┐
│ EmailNotification│  │SmsNotification│  │PushNotification  │
├────────────────┤  ├──────────────┤  ├──────────────────┤
│ + send()       │  │ MAX_LENGTH   │  │ + send()         │
│ + getType()    │  │ + send()     │  │ + getType()      │
└────────────────┘  │ + getType()  │  └──────────────────┘
                    └──────────────┘

┌──────────────────────┐
│  NotificationFactory │
├──────────────────────┤        creates
│ + createNotification │ ─────────────────► Notification
│   (channel): Notif.  │
└──────────────────────┘
```

## Running the Demo

```bash
javac -d out src/main/java/com/niaz/patterns/factory/*.java
java -cp out com.niaz.patterns.factory.FactoryMethodDemo
```

Expected output:

```
Created: EMAIL
[EMAIL] To: niaz@example.com | Subject: Notification | Body: Your order #1234 has been shipped.

Created: SMS
[SMS] To: niaz@example.com | Message: Your order #1234 has been shipped.

Created: PUSH
[PUSH] DeviceToken: niaz@example.com | Alert: Your order #1234 has been shipped.

Expected error: Unknown channel: pigeon
```

## References

- Head First Design Patterns, Ch. 4
- Effective Java, Item 1 (static factory methods)
- [Refactoring Guru — Factory Method](https://refactoring.guru/design-patterns/factory-method)
