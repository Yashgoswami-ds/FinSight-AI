# FinSight AI Project Context

FinSight AI is a portfolio-grade platform for real-time fraud detection,
financial risk analytics, and AI-assisted investigation using synthetic data.

The initial architecture is a modular monolith:

- Java/Spring Boot owns business logic, transactions, and risk decisions.
- Python/FastAPI owns ML inference.
- React/TypeScript/Vite provides the frontend.
- PostgreSQL, Redis, and Kafka are local infrastructure services.
- LLM-assisted investigation is controlled and cannot approve or block transactions.
