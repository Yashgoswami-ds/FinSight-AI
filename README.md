# FinSight AI

Real-time fraud detection, financial risk analytics, and AI-powered
investigation platform.

## Current status

The development environment, local PostgreSQL/Redis services, initial backend
auth/user APIs, and frontend landing screen are ready.

### Local URLs

- Frontend: `http://localhost:5173`
- Backend: `http://localhost:8080`
- Health: `http://localhost:8080/actuator/health`

### Available APIs

Register a user:

```http
POST /api/auth/register
Content-Type: application/json
```

```json
{
  "name": "Example User",
  "email": "user@example.com",
  "password": "replace-with-a-strong-password"
}
```

Get a user:

```http
GET /api/users/{id}
```

Passwords are stored as BCrypt hashes and are never returned by the API.
Login/token authentication is the next backend milestone.

For verified setup details and remaining work, see [PROGRESS.md](./PROGRESS.md)
and [TASKS.md](./TASKS.md).
