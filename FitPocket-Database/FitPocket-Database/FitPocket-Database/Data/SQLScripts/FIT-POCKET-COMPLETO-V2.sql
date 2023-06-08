CREATE DATABASE fitpocket;
USE fitpocket;

/*DROP TABLE EXPENSE;
DROP TABLE INCOME;
DROP TABLE BUDGET;
DROP TABLE CURRENCY; 
DROP TABLE CATEGORY;
DROP TABLE PROFILE;
DROP TABLE USER;*/



CREATE TABLE USER (
    userId INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(255) UNIQUE,
    userPassword VARCHAR(255) NOT NULL,
    isAdmin BOOLEAN NOT NULL
);

CREATE TABLE PROFILE (
    userId INT PRIMARY KEY,
    description VARCHAR(255),
    email VARCHAR(255) NOT NULL UNIQUE,
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
CREATE TABLE CURRENCY (
    currencyId INT AUTO_INCREMENT,
    currencyName VARCHAR(255) NOT NULL,
    currencySymbol VARCHAR(255) NOT NULL,
    PRIMARY KEY (currencyId)
);

CREATE TABLE BUDGET (
    budgetId INT AUTO_INCREMENT,
    userId INT NOT NULL,
    budgetName VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    currencyId INT, 
    creationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (budgetId),
    FOREIGN KEY (userId)
        REFERENCES USER (userId),
	FOREIGN KEY (currencyId)
		REFERENCES CURRENCY (currencyId)
);

CREATE TABLE EXPENSE (
    expenseId INT AUTO_INCREMENT,
    budgetId INT NOT NULL,
    expenseName VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    categoryId INT NOT NULL,
    amount DOUBLE NOT NULL,
    isRecurrent BOOLEAN NOT NULL,
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
    isRecurrent BOOLEAN NOT NULL,
    creationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (incomeId),
    FOREIGN KEY (budgetId)
        REFERENCES BUDGET (budgetId),
    FOREIGN KEY (categoryId)
        REFERENCES CATEGORY (categoryId)
);


INSERT INTO USER (userId, userName, userPassword, isAdmin)
VALUES (0, 'fitpocket', '_?_', TRUE);

UPDATE USER
SET userId = 0
WHERE userId = 1;

INSERT INTO USER (userId, userName, userPassword, isAdmin)
VALUES (1, 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', TRUE);

INSERT INTO USER (userName, userPassword, isAdmin)
VALUES ('john_doe', 'password123', FALSE);

INSERT INTO USER (userName, userPassword, isAdmin)
VALUES ('jane_smith', 'securepass', FALSE);

INSERT INTO PROFILE (userId, description, email, link, location, phone)
VALUES (1, 'Administrator', 'fitpocketapp@gmail.com', 'www.fit-pocket.com', 'Seville', 123123123);

INSERT INTO PROFILE (userId, description, email, link, location, phone)
VALUES (2, 'Software Engineer with 5 years of experience.', 'john.doe@example.com', 'www.johndoe.com', 'New York', 1234567890);

INSERT INTO PROFILE (userId, description, email, link, location, phone)
VALUES (3, 'Marketing Specialist with a passion for digital marketing.', 'jane.smith@example.com', 'www.janesmith.com', 'San Francisco', 9876543210);

INSERT INTO CATEGORY (userId, categoryName)
VALUES (0, 'ocio');

INSERT INTO CATEGORY (userId, categoryName)
VALUES (0, 'viaje');

INSERT INTO CURRENCY (currencyName, currencySymbol)
VALUES ('EUR', '€');

INSERT INTO CURRENCY (currencyName, currencySymbol)
VALUES ('USD', '$');

INSERT INTO CURRENCY (currencyName, currencySymbol)
VALUES ('GBP', '£');

INSERT INTO CURRENCY (currencyName, currencySymbol)
VALUES ('JPY', '¥');

INSERT INTO BUDGET (userId, budgetName, description, currencyId, creationDate)
VALUES (2, 'mensualidad', 'Gastos mensuales', 1, '2023-05-01');

INSERT INTO BUDGET (userId, budgetName, description, currencyId, creationDate)
VALUES (2, 'vacaciones', 'Gastos vacacionales', 2, '2023-05-15');

INSERT INTO EXPENSE (budgetId, expenseName, description, categoryId, amount, isRecurrent, creationDate)
VALUES (1, 'Rent', 'Monthly rent', 1, 1000.00, FALSE, '2023-05-05');

INSERT INTO EXPENSE (budgetId, expenseName, description, categoryId, amount, isRecurrent, creationDate)
VALUES (1, 'Groceries', 'Grocery shopping', 1, 200.00, TRUE, '2023-05-06');

INSERT INTO INCOME (budgetId, incomeName, description, categoryId, amount, isRecurrent, creationDate)
VALUES (1, 'Salary', 'Monthly salary', 1, 5000.00, TRUE, '2023-05-01');

INSERT INTO INCOME (budgetId, incomeName, description, categoryId, amount, isRecurrent, creationDate)
VALUES (1, 'Freelance', 'Freelance income', 2, 1000.00, FALSE, '2023-05-15');


SELECT * FROM USER;
