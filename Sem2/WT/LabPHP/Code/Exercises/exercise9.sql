-- Create the database
CREATE DATABASE staff;

-- Use the database
USE staff;

-- Create the date_personale table
CREATE TABLE date_personale (
    cnp VARCHAR(13) PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    father_name VARCHAR(50),
    mother_name VARCHAR(50),
    id_series VARCHAR(50),
    id_number VARCHAR(50),
    married_status BOOLEAN,
    children INTEGER(20),
    date_of_birth DATE,
    address VARCHAR(255)
);

-- Create the salaries table
CREATE TABLE salaries (
    cnp VARCHAR(13),
    net_salary DECIMAL(10, 2),
    gross_salary DECIMAL(10, 2),
    tax_amount INTEGER(10),
    payment_date DATE,
    start_date DATE,
    end_date DATE,
    increase_reason VARCHAR(255),
    PRIMARY KEY (cnp, payment_date),
    FOREIGN KEY (cnp) REFERENCES date_personale(cnp)
);
