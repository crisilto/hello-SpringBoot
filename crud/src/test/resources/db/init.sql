CREATE DATABASE IF NOT EXISTS books_system;

USE books_system;

CREATE TABLE books (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,

  CONSTRAINT books_name_uniq UNIQUE (name)
);

INSERT INTO books (name) VALUES ('Harry Potter'), ('Twilight'), ('Clean Code'), ('The Pragmatic Programmer');
