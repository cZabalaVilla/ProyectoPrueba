package edu.fpdual.webservice.model.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Budget implements Comparable<Budget>{
    private int userId;
    private int budgetId;
    private String budgetName;
    private String description;
    private LocalDateTime creationDate;

    //Atributo de datos

    //Si queremos poner que se pueda elegir el tipo de moneda en la que se hará el presupuesto.
    //Habría que crear un enum o una tabla en bbdd con la moneda y el símbolo
    //Moneda moneda;

    public Budget(String budgetName, String description) {
        this.budgetName = budgetName;
        this.description = description;
        this.creationDate = LocalDateTime.now();
    }

    public Budget (ResultSet result) {
        try {
            this.userId = result.getInt("userId");
            this.budgetId = result.getInt("budgetId");
            this.budgetName = result.getString("budgetName");
            this.description = result.getString("description");
            //this.creationDate = result.getDate("creationDate");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Budget o) {
        return 0;
    }
}
