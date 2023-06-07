package edu.fpdual.webservice.model.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Currency {
    private int currencyId;
    private String currencyName;
    private char currencySymbol;

    public Currency(ResultSet result) {
        try {
            this.currencyId = result.getInt("currencyId");
            this.currencyName = result.getString("currencyName");
            this.currencySymbol = result.getString("currencySymbol").charAt(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
