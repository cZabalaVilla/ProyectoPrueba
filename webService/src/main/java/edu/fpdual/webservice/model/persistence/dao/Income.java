package edu.fpdual.webservice.model.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

@Data
@NoArgsConstructor
public class Income implements Comparable<Income>{
    private int budgetId;
    private int incomeId;
    private String incomeName;
    private String description;
    private double amount;
    private boolean isRecurrent;
    private LocalDate creationDate;
    //private LocalTime creationTime;

    public Income (String incomeName, String description, double amount) {
        this.incomeName = incomeName;
        this.description = description;
        this.amount = amount;
        this.isRecurrent = isRecurrent;
        this.creationDate = LocalDate.now();
        //this.creationTime = LocalTime.now();
    }

    public Income (ResultSet result) {
        try {
            this.budgetId = result.getInt("budgetId");
            this.incomeId = result.getInt("incomeId");
            this.incomeName = result.getString("incomeName");
            this.description = result.getString("description");
            this.amount = result.getDouble("amount");
            this.isRecurrent = result.getBoolean("isRecurring");
            this.creationDate = result.getDate("creationDate")
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            //this.creationTime = result.getTime("creationTime");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Income o) {
        return this.incomeId - o.incomeId;
    }
}
