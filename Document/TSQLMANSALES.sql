Create Database SalesManagementSystem;
Go

Use [SalesManagementSystem]
Go

-- Tạo bảng Employee
CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY NOT NULL,
    Name VARCHAR(50) NOT NULL,
    Phone VARCHAR(12),
    Username VARCHAR(30) NOT NULL UNIQUE, -- Tên người dùng duy nhất
    Password VARCHAR(255) NOT NULL,
    Role BIT -- Vai trò: 1 là quản trị viên, 0 là nhân viên
	FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID) -- Khóa ngoại
)
GO


-- Tạo bảng Customer
CREATE TABLE Customer (
    CustomerID NCHAR(10) PRIMARY KEY NOT NULL,
    CompanyName VARCHAR(50) NOT NULL,
    Phone VARCHAR(12),
    Address VARCHAR(60),
    Email VARCHAR(30) UNIQUE -- Email khách hàng là duy nhất
)
GO


-- Tạo bảng Category
CREATE TABLE Category (
    CategoryID INT PRIMARY KEY NOT NULL,
    CategoryName VARCHAR(25) NOT NULL
)
GO

-- Tạo bảng Supplier
CREATE TABLE Supplier (
    SupplierID INT PRIMARY KEY NOT NULL,
    SupplierName VARCHAR(50) NOT NULL,
    Phone VARCHAR(12),
    Address VARCHAR(60),
    Email VARCHAR(30)
)
GO

-- Tạo bảng Product
CREATE TABLE Product (
    ProductID INT PRIMARY KEY IDENTITY(1,1), -- ID tự động tăng
    ProductName VARCHAR(50) NOT NULL,
    CategoryID INT, -- Khóa ngoại tham chiếu đến Category
    SupplierID INT, -- Khóa ngoại tham chiếu đến Supplier
    Price MONEY NOT NULL,
    Quantity INT NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID),
    FOREIGN KEY (SupplierID) REFERENCES Supplier(SupplierID)
)
GO

-- Tạo bảng Orders
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY IDENTITY(1,1), -- ID tự động tăng
    CustomerID NCHAR(10), -- Khóa ngoại tham chiếu đến Customer
    EmployeeID INT, -- Khóa ngoại tham chiếu đến Employee
    OrderDate DATE NOT NULL,
    TotalAmount MONEY NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
)
GO

-- Tạo bảng OrderDetail
CREATE TABLE OrderDetail (
    OrderID INT, -- Khóa ngoại tham chiếu đến Orders
    ProductID INT, -- Khóa ngoại tham chiếu đến Product
    Quantity SMALLINT NOT NULL,
    UnitPrice MONEY NOT NULL,
    PRIMARY KEY (OrderID, ProductID), -- Khóa chính là sự kết hợp của OrderID và ProductID
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
)
GO

-- Xem tất các bảng trong
SELECT TABLE_NAME 
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_TYPE = 'BASE TABLE';
GO

-- Xem thuộc tính bảng
EXEC sp_help 'Employee';
GO

