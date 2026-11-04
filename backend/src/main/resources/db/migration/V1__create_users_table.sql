
CREATE TABLE users (
    id UUID PRIMARY KEY,

    email VARCHAR(254) NOT NULL,

    password_hash VARCHAR(255) NOT NULL,

    first_name VARCHAR(100) NOT NULL,

    last_name VARCHAR(100) NOT NULL,

    role VARCHAR(30) NOT NULL DEFAULT 'USER',

    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',

    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,

    version BIGINT NOT NULL DEFAULT 0,

    CONSTRAINT uk_users_email UNIQUE (email),

    CONSTRAINT chk_users_email_normalized
        CHECK (email = LOWER(BTRIM(email))),

    CONSTRAINT chk_users_password_hash
        CHECK (LENGTH(password_hash) > 0),

    CONSTRAINT chk_users_first_name
        CHECK (LENGTH(BTRIM(first_name)) > 0),

    CONSTRAINT chk_users_last_name
        CHECK (LENGTH(BTRIM(last_name)) > 0),

    CONSTRAINT chk_users_role
        CHECK (role IN ('USER', 'ANALYST', 'ADMIN')),

    CONSTRAINT chk_users_status
        CHECK (status IN ('ACTIVE', 'DISABLED', 'LOCKED')),

    CONSTRAINT chk_users_version
        CHECK (version >= 0)
);

CREATE INDEX idx_users_status ON users(status);

CREATE INDEX idx_users_role ON users(role);
