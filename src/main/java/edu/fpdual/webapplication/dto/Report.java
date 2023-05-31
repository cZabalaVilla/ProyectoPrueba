package edu.fpdual.webapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Report {
    //añadir como pdf?

    private int reportId;
    private int userId;
    private String reportName;
    private Date reportDate;
    private Category category;
}
