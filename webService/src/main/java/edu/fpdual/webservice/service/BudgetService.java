package edu.fpdual.webservice.service;

import edu.fpdual.webservice.model.persistence.connector.MySQLConnector;
import edu.fpdual.webservice.model.persistence.dao.Budget;
import edu.fpdual.webservice.model.persistence.manager.BudgetManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BudgetService {
  /*  private final BudgetManager budgetManager;
    private final LogService logService;


    public BudgetService() {
        this.budgetManager = budgetManager;
        this.logService = new LogService();
    }

    public List<Budget> findAll(Connection con) {
        return null;
    }

    //public List<Budget> findAll() throws SQLException, ClassNotFoundException, JsonProcessingException {}

    public Budget findByBudgetName(String budgetName) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return budgetManager.findBy(con, "budgetName", budgetName);
        }
    }
    public boolean deleteBudget(Budget budget) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return budgetManager.delete(con, "budgetName", budget.getBudgetId());
        }
    }
    public int createBudget(Budget budget) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return budgetManager.create(con, budget);
        }
    }
    public boolean updateBudget(Budget budget) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return budgetManager.update(con, budget);
        }
    }

 */
}


