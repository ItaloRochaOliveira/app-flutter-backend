-- CREATE DATABASE IF NOT EXISTS docker;
USE consulta-SQL;

/*Create all tables*/
CREATE TABLE IF NOT EXISTS users( 
    id VARCHAR(36) NOT NULL,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at VARCHAR(24),

    PRIMARY KEY(id) 
);

/*Insert the first values in tables*/
INSERT INTO users (id, name, email, password, created_at)
    VALUE ("92056f79-327d-4792-9543-ccf68f8597a8", "User Admin", "user.admin@gmail.com", "2024-05-31");