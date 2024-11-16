-- CREATE DATABASE IF NOT EXISTS docker;
USE FLUTTER-BACKEND-E-DOCKER;

/*Create all tables*/
CREATE TABLE IF NOT EXISTS users( 
    id VARCHAR(36) NOT NULL,
    role ENUM("admin", "normal") NOT NULL DEFAULT "normal",
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(70) NOT NULL,
    created_at DATE,
    updated_at DATE,

    PRIMARY KEY(id) 
);

/*Insert the first values in tables*/
INSERT INTO users (id, role, name, email, password, created_at)
    VALUES
        ("92056f79-327d-4792-9543-ccf68f8597a8", "admin", "User Admin", "user.admin@gmail.com", "$2y$10$.Fq2PLvs8YeHLi7IFWdK.eYjqxpM3E1UaoBACX8CHlJl54mpLY7I2", "2024-11-15"), /*pass1*/
        ("abdf792c-b82b-4b2f-bef2-1bd708113b91", "normal", "User normal", "user.normal@gmail.com", "$2y$10$Ni1/8wojSN5iVuPtvQ45SuGVqRfJAhfE2olUbUL3gyFDFTDP.7N.i", "2024-11-15"), /*pass2*/
        ("3a846da6-3ea2-4203-864d-eb0100d19ddc", "normal", "User normal2", "user.normal2@gmail.com", "$2y$10$vd9oG4g7IP.28rTZT9yRme5y4hZCi4oVdYdTIkNWoOnrPsRK1QkwO", "2024-11-15"), /*pass3*/
        ("a8487c8b-9602-4610-bb46-6243dc21d041", "normal", "User normal3", "user.normal3@gmail.com", "$2y$10$nTVekmgNAO5wyyY6qXnPtOa33o3uIN9QY/zqxPP2XzqlYfbKPmdUq", "2024-11-15"), /*pass4*/
        ("1db4d68f-9117-40eb-ba46-4e0c76fc8b16", "normal", "User normal4", "user.normal4@gmail.com", "$2y$10$FUhCrYuEWfW34e1eO.r.zu/DjDnqZyWYcqciySfghc6E5g3ubFtG.", "2024-11-15"), /*pass5*/
        ("ddc280ef-7d2e-40ec-9c03-7849697148aa", "normal", "User normal5", "user.normal5@gmail.com", "$2y$10$jkx/8mrsYKio1d9SuO8e/eYqrLVBfbSOBRxAIm1iSkAQrQlmUi8im", "2024-11-15"); /*pass6*/ 