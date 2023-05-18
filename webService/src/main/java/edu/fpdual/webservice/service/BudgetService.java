package edu.fpdual.webservice.service;

import edu.fpdual.webservice.model.persistence.connector.MySQLConnector;
import edu.fpdual.webservice.model.persistence.dao.Budget;
import edu.fpdual.webservice.model.persistence.manager.BudgetManager;
import edu.fpdual.webservice.model.persistence.manager.impl.BudgetManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class BudgetService {
    private final BudgetManager budgetManager;


    public BudgetService(BudgetManagerImpl budgetManager) {

        this.budgetManager = budgetManager;
    }

    public List<Budget> findAll() throws SQLException, ClassNotFoundException{
        try(Connection con = new MySQLConnector().getMySQLConnection()) {
            return budgetManager.findAll(con);
        }
    }

    public Budget findByBudgetDate(LocalDateTime budgetDate) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return budgetManager.findBy(con, "budgetDate", budgetDate);
        }
    }

    public Budget findByBudgetName(String budgetName) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return budgetManager.findBy(con, "budgetName", budgetName);
        }
    }
    public boolean deleteBudget(Budget budget) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return budgetManager.delete(con, budget);
        }
    }
    public boolean createBudget(String budgetName, String description) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return budgetManager.create(con, new Budget(budgetName, description));
        }
    }
    public boolean updateBudget(Budget budget) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return budgetManager.update(con, budget);
        }
    }


}


