package edu.fpdual.webapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Budget {
    private int userID;
    private int budgetID;
    private String budgetName;
    private String description;
    private LocalDateTime creationDate;
    //private Currency currency;
    //private ArrayList<Expense> expenses;

    public Budget(String budgetName, String description, LocalDateTime creationDate) {
        this.budgetName = budgetName;
        this.description = description;
        this.creationDate = LocalDateTime.now();
    }

}
