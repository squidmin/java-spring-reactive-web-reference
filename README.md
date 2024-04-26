# java-spring-reactive-web-reference

Spring Boot Reactive Web application demonstrating the usage of Spring WebFlux to create non-blocking REST APIs.

## Prerequisites

Before you begin, ensure you have met the following requirements:
- **Java JDK 17** installed.
- IntelliJ IDEA (Community or Ultimate Edition), or your IDE of choice.
- **Gradle 8.7** (integrated with your IDE or installed separately).

## Getting Started

Clone the repository to your local machine:

```bash
git clone https://github.com/squidmin/java-spring-reactive-web-reference.git
cd /Users/username/path/to/spring-boot-reactive-web-reference
```

> Replace the path with the actual location of your clone of the project.

## Building the application

```bash
./gradlew build
```

## Running the application

```bash
./gradlew bootRun
```

The application will be available at `http://localhost:8080`.

### Available endpoints

- `GET /hello`: Returns a simple greeting.

## Running tests

```bash
./gradlew test
```
