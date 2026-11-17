-- ==============================================================================
-- DevOps Student Management System - Database Initialization Script
-- Database: MySQL 8.0+
-- ==============================================================================

-- Create Database if not exists
CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

-- Drop table if exists for clean re-runs
DROP TABLE IF EXISTS students;

-- Create Students Table
CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    department VARCHAR(100) NOT NULL,
    semester INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert Sample Seed Records for Testing
INSERT INTO students (first_name, last_name, email, department, semester) VALUES
('Atharv', 'Patil', 'atharv.patil@example.com', 'Computer Science & Engineering', 6),
('Neha', 'Deshmukh', 'neha.deshmukh@example.com', 'Computer Science & Engineering', 6),
('Rohan', 'Kulkarni', 'rohan.kulkarni@example.com', 'Information Technology', 5),
('Pooja', 'Jadhav', 'pooja.jadhav@example.com', 'Electronics & Telecommunication', 7),
('Amit', 'Shinde', 'amit.shinde@example.com', 'Mechanical Engineering', 8);

-- Verification Query
SELECT * FROM students;
