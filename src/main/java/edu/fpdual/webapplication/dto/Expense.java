package edu.fpdual.webapplication.dto;

import edu.fpdual.webapplication.annotations.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@Model(type = "Data", version = "1.0", date = "01/06/2023")
public class Expense {
    private int budgetId;
    private int expenseId;
    private String expenseName;
    private String description;
    private int categoryId;
    private double amount;
    private boolean isRecurrent;
    private Date date;

    public Expense(String expenseName, String description, int categoryId, double amount, boolean isRecurrent) {
        this.expenseName = expenseName;
        this.description = description;
        this.categoryId = categoryId;
        this.amount = amount;
        this.isRecurrent = isRecurrent;
    }
}
