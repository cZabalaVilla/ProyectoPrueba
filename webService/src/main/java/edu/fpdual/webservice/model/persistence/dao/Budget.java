package edu.fpdual.webservice.model.persistence.dao;

import edu.fpdual.webservice.model.persistence.manager.impl.ExpenseManagerImpl;
import edu.fpdual.webservice.model.persistence.manager.impl.IncomeManagerImpl;
import edu.fpdual.webservice.service.ExpenseService;
import edu.fpdual.webservice.service.IncomeService;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
public class Budget implements Comparable<Budget>{
    private int userId;
    private int budgetId;
    private String budgetName;
    private String description;
    private List<Income> incomeList;
    private List<Expense> expenseList;
    private Timestamp creationDate;
    //private LocalTime creationTime;

    //Atributo de datos

    //Si queremos poner que se pueda elegir el tipo de moneda en la que se hará el presupuesto.
    //Habría que crear un enum o una tabla en bbdd con la moneda y el símbolo
    //Moneda moneda;



    public Budget (ResultSet result) {
        try {
            this.userId = result.getInt("userId");
            this.budgetId = result.getInt("budgetId");
            this.budgetName = result.getString("budgetName");
            this.description = result.getString("description");
            this.incomeList = new IncomeService(new IncomeManagerImpl()).findAllIncomesBy("budgetId",budgetId);
            this.expenseList = new ExpenseService(new ExpenseManagerImpl()).findAllExpensesBy("budgetId",budgetId);
            this.creationDate = result.getTimestamp("creationTime");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Budget o) {
        return this.budgetId - o.budgetId;
    }
}
