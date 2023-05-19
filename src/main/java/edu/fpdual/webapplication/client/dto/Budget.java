package edu.fpdual.webapplication.client.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@XmlRootElement
public class Budget {
    private int userID;
    private int budgetID;
    private String budgetName;
    private String description;
    private LocalDateTime creationDate;
    //private Currency currency;
    //private ArrayList<Expense> expenses;

    public Budget(String budgetName, String descripcion, LocalDateTime creationDate) {
        this.budgetName = budgetName;
        this.description = description;
        this.creationDate = LocalDateTime.now();
    }

}
