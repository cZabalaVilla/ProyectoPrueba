package edu.fpdual.webapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Budget {
    private int userID;
    private int budgetID;
    private String budgetName;
    private String description;
    private List<Expense> expenseList;
    private List<Income> incomeList;
    private Date creationDate;
    //private Currency currency;

    public Budget(String budgetName, String description) {
        this.budgetName = budgetName;
        this.description = description;
        this.expenseList = new ArrayList<>();
        this.incomeList = new ArrayList<>();
        this.creationDate = new Date();
    }

}
