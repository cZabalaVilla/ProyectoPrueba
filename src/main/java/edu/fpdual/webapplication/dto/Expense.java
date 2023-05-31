package edu.fpdual.webapplication.dto;

import java.sql.Date;

public class Expense {
    private int budgetId;
    private int expenseId;
    private String expenseName;
    private String description;
    private Category category;
    private double amount;
    private boolean isRecurring;
    private Date date;

    public Expense(String expenseName, String description, Category category, double amount, boolean isRecurring) {
        this.expenseName = expenseName;
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.isRecurring = isRecurring;
    }
}
