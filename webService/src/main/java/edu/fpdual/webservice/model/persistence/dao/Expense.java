package edu.fpdual.webservice.model.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;

@Data
@NoArgsConstructor
public class Expense implements Comparable<Expense>{
    private int budgetId;
    private int expenseId;
    private String expenseName;
    private String description;
    private double amount;
    private boolean isRecurrent;
    private Date creationDate;
    //private LocalTime creationTime;

    public Expense (String expenseName, String description, double amount, boolean isRecurrent) {
        this.expenseName = expenseName;
        this.description = description;
        this.amount = amount;
        this.isRecurrent = isRecurrent;
        //this.creationTime = LocalTime.now();
    }

    public Expense (ResultSet result) {
        try {
            this.budgetId = result.getInt("budgetId");
            this.expenseId = result.getInt("expenseId");
            this.expenseName = result.getString("expenseName");
            this.description = result.getString("description");
            this.amount = result.getDouble("amount");
            this.isRecurrent = result.getBoolean("isRecurring");

            //this.creationTime = result.getTime("creationTime");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Expense o) {
        return this.expenseId - o.expenseId;
    }
}
