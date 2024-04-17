CREATE DATABASE Inventory_Management;

USE market;

CREATE TABLE addItems (
    AddItemID INT AUTO_INCREMENT PRIMARY KEY,
    pid VARCHAR(50) NOT NULL,
    storeid CHAR(5) NOT NULL,
    Quntity INT NOT NULL,
    date DATE NOT NULL,
    description NVARCHAR(250) NULL,
    StoreItemId INT NOT NULL
);

CREATE TABLE AddItemsHistory (
    pid VARCHAR(50) NOT NULL,
    storeid INT NOT NULL,
    Quntity NCHAR(10) NOT NULL,
    description NVARCHAR(250) NULL,
    ChangeDate DATE NOT NULL,
    ChangeType DATE NOT NULL,
    StoreItemid INT NOT NULL
);

CREATE TABLE address (
    aid INT AUTO_INCREMENT PRIMARY KEY,
    city NVARCHAR(50) NOT NULL,
    village NVARCHAR(50) NOT NULL,
    srtreet NVARCHAR(50) NULL,
    phone NVARCHAR(50) NOT NULL,
    email VARCHAR(50) NULL
);

CREATE TABLE branch (
    bid INT AUTO_INCREMENT PRIMARY KEY,
    bname NVARCHAR(50) NOT NULL,
    location NVARCHAR(50) NOT NULL,
    phone NVARCHAR(50) NOT NULL,
    storeid CHAR(5) NOT NULL,
    FOREIGN KEY (storeid) REFERENCES store(storeid)
);

CREATE TABLE Category (
    Categoryid INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);

CREATE TABLE customer (
    cid INT AUTO_INCREMENT PRIMARY KEY,
    firstname NVARCHAR(55) NOT NULL,
    lastname NVARCHAR(50) NULL,
    phone NVARCHAR(50) NOT NULL,
    DateOfBirth DATE NOT NULL,
    description TEXT NULL,
    city NVARCHAR(50) NOT NULL,
    village NVARCHAR(50) NOT NULL,
    street NVARCHAR(50) NULL,
    building NVARCHAR(50) NOT NULL
);

CREATE TABLE debts (
    oid INT NOT NULL,
    cid INT NOT NULL,
    PRIMARY KEY (oid, cid),
    FOREIGN KEY (oid) REFERENCES torder(oid),
    FOREIGN KEY (cid) REFERENCES customer(cid)
);

CREATE TABLE employees (
    Eid INT AUTO_INCREMENT PRIMARY KEY,
    Efull_name VARCHAR(55) NOT NULL,
    Ebirth DATE NOT NULL,
    Ephone VARCHAR(10) NOT NULL,
    email VARCHAR(50) NULL,
    Eid_card INT NOT NULL,
    address NVARCHAR(50) NOT NULL,
    village NVARCHAR(50) NOT NULL,
    salary DECIMAL(6, 1) NOT NULL,
    bouns DECIMAL(5, 1) NULL,
    bid INT NOT NULL,
    FOREIGN KEY (bid) REFERENCES branch(bid)
);

CREATE TABLE employees_history (
    Eid INT NOT NULL,
    Efullname NVARCHAR(50) NOT NULL,
    Ebirth DATE NOT NULL,
    Ephone NVARCHAR(50) NOT NULL,
    email VARCHAR(50) NULL,
    Eid_card INT NOT NULL,
    address NVARCHAR(50) NOT NULL,
    village NVARCHAR(50) NOT NULL,
    salary DECIMAL(18, 5) NOT NULL,
    bouns DECIMAL(18, 5) NULL,
    bid CHAR(4) NOT NULL,
    ChangeType VARCHAR(10) NOT NULL,
    ChangeDate DATE NOT NULL
);

CREATE TABLE torder (
    oid INT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    totalprice DECIMAL(18, 2) NOT NULL,
    cid INT NULL,
    bid INT NOT NULL,
    FOREIGN KEY (bid) REFERENCES branch(bid)
);

CREATE TABLE order_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    oid INT NOT NULL,
    StoreItemID INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(18, 2) NOT NULL,
    FOREIGN KEY (oid) REFERENCES torder(oid),
    FOREIGN KEY (StoreItemID) REFERENCES stor_items(id)
);

CREATE TABLE product (
    Pid VARCHAR(50) PRIMARY KEY,
    Pname NVARCHAR(55) NOT NULL,
    Description TEXT NULL,
    Categoryid INT NOT NULL,
    PurchasingPrice DECIMAL(18, 2) NOT NULL,
    sellingPrice DECIMAL(18, 2) NOT NULL,
    FOREIGN KEY (Categoryid) REFERENCES Category(Categoryid)
);

CREATE TABLE product_supplier (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pid VARCHAR(50) NOT NULL,
    sid INT NOT NULL,
    price DECIMAL(18, 5) NOT NULL,
    FOREIGN KEY (pid) REFERENCES product(Pid),
    FOREIGN KEY (sid) REFERENCES supplier(id)
);

CREATE TABLE stor_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pid VARCHAR(50) NOT NULL,
    storeid CHAR(5) NOT NULL,
    TotalQuntity INT NOT NULL,
    FOREIGN KEY (pid) REFERENCES product(Pid),
    FOREIGN KEY (storeid) REFERENCES store(storeid)
);

CREATE TABLE store (
    storeid CHAR(5) PRIMARY KEY,
    location NVARCHAR(50) NOT NULL,
    description NVARCHAR(555) NULL
);

CREATE TABLE supplier (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sname VARCHAR(50) NOT NULL,
    sphone VARCHAR(50) NOT NULL,
    scity NVARCHAR(50) NOT NULL,
    semail VARCHAR(50) NULL,
    sdescroition NVARCHAR(50) NOT NULL
);

select * from product ;
select * from store ;
select * from store_items ; 
 
ALTER TABLE supplier
DROP COLUMN croition;
