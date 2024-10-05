-- Tạo cơ sở dữ liệu
CREATE DATABASE SalesManagement;

-- Sử dụng cơ sở dữ liệu
USE SalesManagement;

-- Tạo bảng Employee
CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(50) NOT NULL,
    Phone VARCHAR(15),
    UserName VARCHAR(30),
    Password VARCHAR(30),
    Role BIT DEFAULT 0, -- 0 = User, 1 = Admin
    Image BLOB
);