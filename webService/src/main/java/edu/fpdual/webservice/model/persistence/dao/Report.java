package edu.fpdual.webservice.model.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
public class Report {

    private int reportId;

    public Report (ResultSet result) {
        try {
            this.reportId = result.getInt("reportId");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
