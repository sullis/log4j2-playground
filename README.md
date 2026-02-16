# log4j2-playground

A playground repository for experimenting with [Apache Log4j2](https://logging.apache.org/log4j/2.x/) asynchronous logging capabilities.

## Overview

This project demonstrates the usage of Log4j2's async logging features with the [LMAX Disruptor](https://lmax-exchange.github.io/disruptor/) library for high-performance, low-latency logging. It includes examples of both native Log4j2 API usage and SLF4J facade integration.

## Features

- **Asynchronous Logging**: Utilizes Log4j2's `AsyncLoggerContextSelector` for fully async logging
- **LMAX Disruptor Integration**: High-performance inter-thread messaging for logging events
- **SLF4J2 Compatibility**: Demonstrates Log4j2 as an SLF4J2 implementation
- **Modern Java**: Built with Java 21
- **Comprehensive Tests**: Unit tests validating async logger behavior

## Prerequisites

- Java 21 or later
- Maven 3.x

## Building the Project

```bash
mvn clean install
```

## Running Tests

```bash
mvn test
```

The test suite includes:
- `LoggingTest`: Validates native Log4j2 async logger functionality
- `Slf4jTest`: Confirms SLF4J facade correctly wraps Log4j2 async loggers

## Key Dependencies

| Dependency | Version | Purpose |
|------------|---------|---------|
| Apache Log4j2 | 2.25.3 | Core logging framework |
| SLF4J | 2.0.17 | Logging facade API |
| LMAX Disruptor | 4.0.0 | High-performance async event processing |
| JUnit Jupiter | 6.0.3 | Testing framework |

## Configuration

The project uses async logging by setting the system property:

```java
System.setProperty(
    "log4j2.contextSelector",
    "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
```

This enables all loggers to be async by default, providing better throughput and lower latency.

## License

This project is licensed under the [Apache License 2.0](LICENSE).

## CI/CD

This project uses GitHub Actions for continuous integration. All pull requests are automatically built and tested.
