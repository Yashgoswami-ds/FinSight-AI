# Progress

## Verified environment

- Java 17.0.16 (Temurin): installed and working.
- Maven 3.9.10: installed and working with Java 17.
- Git 2.51.0: installed and working.
- Python 3.13.7: installed and working.
- Node.js 22.19.0: installed and working.
- npm 10.9.3: installed and working.
- Docker CLI 29.6.1 and Compose v5.1.4: installed.
- Docker Desktop daemon: available and healthy.

## Setup completed

- Synced the empty GitHub repository.
- Added initial Maven, Python, frontend, and infrastructure workspace configuration.
- Created the Python virtual environment and installed the requirements in `ml-service/requirements.txt`.
- Installed frontend dependencies.
- Verified the backend Maven build.
- Validated `docker-compose.yml` syntax without starting containers.
- Verified `.gitignore` excludes credentials, virtual environments, dependencies,
  build outputs, and IDE files.
- Verified `.env.example` contains placeholders only.
- Confirmed the repository has no commits yet and retains the configured
  `origin` remote.
- Docker reserved host port `5432`, so PostgreSQL is mapped to host port
  `5433` while retaining container port `5432`.
- Started PostgreSQL and Redis successfully; both containers report healthy.
- Created the initial backend user/auth slice:
  - `POST /api/auth/register`
  - `GET /api/users/{id}`
  - BCrypt password hashing and duplicate-email handling.
  - Flyway `V1__create_users_table` migration.
- Added Spring Security API configuration with CSRF disabled for the API,
  CORS support, public auth routes, and public user lookup for development.
- Added the initial React entry point and landing screen; Vite frontend is
  verified at `http://localhost:5173`.
- Verified registration with HTTP 201 and user lookup with HTTP 200.
- Verified duplicate registration returns HTTP 409.
- Verified backend tests and frontend production build.

## Current runtime

- Backend: `http://localhost:8080`
- Frontend: `http://localhost:5173`
- PostgreSQL: host port `5433`, container port `5432`
- Redis: host port `6379`
- Kafka: not started; remains behind the `kafka` Compose profile.

## Next step

Implement login/token authentication and protect user/business APIs. Keep
Kafka, fraud detection, and transaction features in later milestones.
