package edu.fpdual.webapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Income {
    private int budgetId;
    private int incomeId;
    private String incomeName;
    private String description;
    private Category category;
    private double amount;
    private boolean isRecurring;
    private Date date;

    public Income(String incomeName, String description, Category category, double amount, boolean isRecurring) {
        this.incomeName = incomeName;
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.isRecurring = isRecurring;
        this.date = new Date();
    }
}
