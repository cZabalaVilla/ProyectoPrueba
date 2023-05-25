package edu.fpdual.webservice.model.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
public class Fund {

    private int fundId;

    public Fund (ResultSet result) {
        try {
            this.fundId = result.getInt("fundId");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}