
INSERT INTO USER (userId, userName, userPassword, isAdmin)
VALUES (0, 'fitpocket', '_?_', TRUE);

UPDATE USER
SET userId = 0
WHERE userId = 1;

INSERT INTO USER (userId, userName, userPassword, isAdmin)
VALUES (1, 'admin', 'admin', TRUE);

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
VALUES (0, 'OCIO');

INSERT INTO CATEGORY (userId, categoryName)
VALUES (0, 'VIAJE');

INSERT INTO BUDGET (userId, budgetName, description, creationDate)
VALUES (2, 'Mensualidad', 'Gastos mensuales', '2023-05-01');

INSERT INTO BUDGET (userId, budgetName, description, creationDate)
VALUES (2, 'Vacaciones', 'Gastos vacacionales', '2023-05-15');

INSERT INTO REPORT (userId, reportName, reportDate, categoryId)
VALUES (1, 'Reporte mensual de gastos', '2023-05-01', 2);

INSERT INTO REPORT (userId, reportName, reportDate, categoryId)
VALUES (2, 'Reporte de coche', '2023-05-15', 1);

INSERT INTO EXPENSE (budgetId, expenseName, description, categoryId, amount, isRecurring, creationDate)
VALUES (1, 'Rent', 'Monthly rent', 1, 1000.00, FALSE, '2023-05-05');

INSERT INTO EXPENSE (budgetId, expenseName, description, categoryId, amount, isRecurring, creationDate)
VALUES (1, 'Groceries', 'Grocery shopping', 1, 200.00, TRUE, '2023-05-06');

INSERT INTO INCOME (budgetId, incomeName, description, categoryId, amount, isRecurring, creationDate)
VALUES (1, 'Salary', 'Monthly salary', 1, 5000.00, TRUE, '2023-05-01');

INSERT INTO INCOME (budgetId, incomeName, description, categoryId, amount, isRecurring, creationDate)
VALUES (1, 'Freelance', 'Freelance income', 2, 1000.00, FALSE, '2023-05-15');
