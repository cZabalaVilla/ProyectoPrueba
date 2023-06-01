package edu.fpdual.webapplication.dto;

import edu.fpdual.webapplication.annotations.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Model(type = "Data",version = "1.0", date = "01/06/2023")
public class Budget {
    private int userId;
    private int budgetId;
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
