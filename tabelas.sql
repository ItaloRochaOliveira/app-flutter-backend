-- CREATE DATABASE IF NOT EXISTS docker;
USE FLUTTER-BACKEND-E-DOCKER;

/*Create all tables*/
CREATE TABLE IF NOT EXISTS users( 
    id VARCHAR(36) NOT NULL,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    created_at DATE,
    updated_at DATE DEFAULT NULL,

    PRIMARY KEY(id) 
);

/*Insert the first values in tables*/
INSERT INTO users (id, name, email, telefone, created_at)
    VALUES
        ("92056f79-327d-4792-9543-ccf68f8597a8", "User1", "user.admin@gmail.com", "62912341234", "2024-11-15"), /*pass1*/
        ("abdf792c-b82b-4b2f-bef2-1bd708113b91", "User2", "user.normal@gmail.com", "62912341235", "2024-11-15"), /*pass2*/
        ("3a846da6-3ea2-4203-864d-eb0100d19ddc", "User3", "user.normal2@gmail.com", "62912341236", "2024-11-15"), /*pass3*/
        ("a8487c8b-9602-4610-bb46-6243dc21d041", "User4", "user.normal3@gmail.com", "62912341237", "2024-11-15"), /*pass4*/
        ("1db4d68f-9117-40eb-ba46-4e0c76fc8b16", "User5", "user.normal4@gmail.com", "62912341238", "2024-11-15"), /*pass5*/
        ("ddc280ef-7d2e-40ec-9c03-7849697148aa", "User6", "user.normal5@gmail.com", "62912341239", "2024-11-15"); /*pass6*/ 