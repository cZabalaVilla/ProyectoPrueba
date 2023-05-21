package edu.fpdual.webapplication.dto;

import java.util.Date;

public class Expense {
    private int userId;
    private int expenseId;
    private String expenseName;
    private double amount;
    private String description;
    private Date fecha;
    private boolean isRecurring;
    private Category category;
}
