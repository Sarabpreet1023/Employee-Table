CREATE DATABASE your_database_name;
USE your_database_name;

CREATE TABLE Employee (
    EmpID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Salary DOUBLE
);

INSERT INTO Employee (Name, Salary) VALUES
('John Doe', 50000),
('Aparna Sengar', 65000),
('Ravi Kumar', 45000);

