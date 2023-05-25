package edu.fpdual.webapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Income {
    private int userId;
    private int incomeId;
    private String incomeName;
    private double amount;
    private String description;
    private Date fecha;
    private boolean isRecurring;
    private Category category;

}
