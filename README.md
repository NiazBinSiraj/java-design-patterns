# Java Design Patterns

Curated collection of design pattern implementations in Java.

Each pattern lives in its own package under `src/main/java/com/niaz/patterns/` with:
- The pattern implementation
- A demo class showing usage
- A `README.md` explaining the pattern, trade-offs, and how to run it
- Unit tests (coming soon)

## Patterns

### Creational
- [x] [Singleton](src/main/java/com/niaz/patterns/singleton/) — double-checked locking + enum-based
- [ ] Factory Method
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

No build tool required for now — just compile and run any demo:

```bash
# example: run the singleton demo
javac -d out src/main/java/com/niaz/patterns/singleton/*.java
java -cp out com.niaz.patterns.singleton.SingletonDemo
```

See [CONTRIBUTING.md](CONTRIBUTING.md) for how to add new patterns.
