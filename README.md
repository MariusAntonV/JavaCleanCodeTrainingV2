# Java Clean Code Training V2

A small Maven-based Java training project used to practice clean code, debugging, and refactoring techniques.

## What this project contains

- **Training domain** (`training`, `trainers` packages):
  - Students gain XP by participating in topics and trainings.
  - Trainers have different levels (`J`, `M`, `S`) that affect XP growth.
- **Wallet domain** (`others` package):
  - A sample wallet implementation used to discuss design issues such as command/query separation.

The codebase intentionally includes bugfix/refactoring exercises validated by tests.

## Tech stack

- Java 22
- Maven
- JUnit 4.13.1



## Run tests

From the project root:

```powershell
mvn test
```
