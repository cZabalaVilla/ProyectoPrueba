package edu.fpdual.webapplication.dto;

import edu.fpdual.webapplication.annotations.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@Model(type = "Data",version = "1.0", date = "01/06/2023")
public class Income {
    private int budgetId;
    private int incomeId;
    private String incomeName;
    private String description;
    private Category category;
    private double amount;
    private boolean isRecurrent;
    private Date date;

    public Income(String incomeName, String description, Category category, double amount, boolean isRecurrent) {
        this.incomeName = incomeName;
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.isRecurrent = isRecurrent;
    }
}
