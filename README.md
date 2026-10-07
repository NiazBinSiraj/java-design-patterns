# Java Design Patterns

Curated collection of design pattern implementations in Java.

Each pattern lives in its own package under `src/main/java/com/niaz/patterns/` with:
- The pattern implementation
- A demo class showing usage
- A `README.md` explaining the pattern, trade-offs, and how to run it
- Unit tests (coming soon)

## Patterns

### Creational
- [x] [Singleton](src/main/java/com/niaz/patterns/singleton/) — thread-safe DCL + enum-based variants
- [x] [Factory Method](src/main/java/com/niaz/patterns/factory/) — parameterized factory with notification sender example
- [ ] Abstract Factory
- [ ] Builder
- [ ] Prototype

### Structural
- [ ] Adapter
- [ ] Decorator
- [ ] Facade
- [ ] Proxy

### Behavioral
- [ ] Observer
- [ ] Strategy
- [ ] Command
- [ ] Template Method

## Getting Started

Each pattern is self-contained. Pick one, read its README, and run the demo:

```bash
# Example: run the factory method demo
javac -d out src/main/java/com/niaz/patterns/factory/*.java
java -cp out com.niaz.patterns.factory.FactoryMethodDemo
```

See [CONTRIBUTING.md](CONTRIBUTING.md) for the pattern structure and naming conventions.
