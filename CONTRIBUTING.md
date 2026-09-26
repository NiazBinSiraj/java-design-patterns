# Contributing

Want to add a pattern? Here's how to keep things consistent.

## Structure

Each pattern goes under `src/main/java/com/niaz/patterns/<pattern-name>/` with:

```
<pattern-name>/
├── README.md          # explanation, when to use, class diagram, how to run
├── SomeImpl.java      # the pattern implementation(s)
├── Demo.java          # runnable main() showing the pattern in action
└── *Test.java         # unit tests (JUnit 5)
```

## Pattern README Template

Each pattern's `README.md` should cover:

1. **What** — one-liner on what the pattern does
2. **When to use** — bullet list of real-world scenarios
3. **Implementations** — describe each variant with a short code snippet
4. **Trade-offs** — pros/cons of each approach
5. **How to run** — compile and run commands
6. **Class diagram** — ASCII or text-based diagram
7. **References** — books, links

## Naming Conventions

- Package names: lowercase, singular (`singleton`, `factory`, `observer`)
- Class names: descriptive of the real-world analogy, not just `Singleton.java`
- Demo class: `<Pattern>Demo.java` (e.g., `SingletonDemo.java`)

## Branches

- `feat/add-<pattern>-pattern` for new patterns
- `fix/<description>` for bug fixes
- `docs/<description>` for documentation changes
- `refactor/<description>` for refactors

## Code Style

- 4-space indentation
- Javadoc on public classes and non-obvious methods
- Keep demo classes simple — they're meant to be readable, not production code
