# Decisions

- Use Java 17 and Spring Boot 3.5.x with Maven.
- Keep the backend as a modular monolith initially.
- Use Flyway for schema management; Hibernate schema auto-update is not used.
- Keep ML inference in Python and business/risk decisions in Java.
- Use synthetic financial data only.
- Keep credentials in environment variables and do not commit secrets.
- Use UUIDs for user identifiers and normalize email addresses to lowercase.
- Store passwords only as BCrypt hashes; never expose password data in responses.
- Keep Kafka disabled behind the Compose profile until its dedicated milestone.
