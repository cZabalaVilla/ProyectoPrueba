/*
CREATE DATABASE fitpocket;
*/

USE fitpocket;
/*
DROP TABLE EXPENSE;
DROP TABLE INCOME;
DROP TABLE REPORT;
DROP TABLE BUDGET;
DROP TABLE CATEGORY;
DROP TABLE PROFILE;
DROP TABLE USER;
*/

CREATE TABLE USER (
    userId INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(255) UNIQUE,
    userPassword VARCHAR(255) NOT NULL,
    isAdmin BOOLEAN NOT NULL
);

CREATE TABLE PROFILE (
    userId INT PRIMARY KEY,
    description VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    link VARCHAR(255),
    location VARCHAR(255),
    phone BIGINT,
    FOREIGN KEY (userId)
        REFERENCES USER (userId)
);

CREATE TABLE CATEGORY (
    categoryId INT AUTO_INCREMENT,
    userId INT NOT NULL,
    categoryName VARCHAR(255) NOT NULL,
    PRIMARY KEY (categoryId),
    FOREIGN KEY (userId)
        REFERENCES USER (userId)
);

CREATE TABLE BUDGET (
    budgetId INT AUTO_INCREMENT,
    userId INT NOT NULL,
    budgetName VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    creationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (budgetId),
    FOREIGN KEY (userId)
        REFERENCES USER (userId)
);

CREATE TABLE REPORT (
    reportId INT AUTO_INCREMENT,
    userId INT NOT NULL,
    reportName VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    reportDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    categoryId INT,
    PRIMARY KEY (reportId),
    FOREIGN KEY (categoryId)
        REFERENCES CATEGORY (categoryId)
);

CREATE TABLE EXPENSE (
    expenseId INT AUTO_INCREMENT,
    budgetId INT NOT NULL,
    expenseName VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    categoryId INT NOT NULL,
    amount DOUBLE NOT NULL,
    isRecurring BOOLEAN NOT NULL,
    creationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (expenseId),
    FOREIGN KEY (budgetId)
        REFERENCES BUDGET (budgetId),
    FOREIGN KEY (categoryId)
        REFERENCES CATEGORY (categoryId)
);

CREATE TABLE INCOME (
    incomeId INT AUTO_INCREMENT,
    budgetId INT NOT NULL,
    incomeName VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    categoryId INT NOT NULL,
    amount DOUBLE NOT NULL,
    isRecurring BOOLEAN NOT NULL,
    creationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (incomeId),
    FOREIGN KEY (budgetId)
        REFERENCES BUDGET (budgetId),
    FOREIGN KEY (categoryId)
        REFERENCES CATEGORY (categoryId)
);