package edu.fpdual.webservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.fpdual.webservice.model.persistence.connector.MySQLConnector;
import edu.fpdual.webservice.model.persistence.dao.Budget;
import edu.fpdual.webservice.model.persistence.manager.BudgetManager;
import edu.fpdual.webservice.model.persistence.manager.impl.BudgetManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class BudgetService {
    private final BudgetManager budgetManager;


    public BudgetService(BudgetManagerImpl budgetManagerImpl) {
        this.budgetManager = budgetManagerImpl;
    }

    public List<Budget> findAll(Connection con) {
        return null;
    }

    public List<Budget> findAll() throws SQLException, ClassNotFoundException, JsonProcessingException {
        return null;
    }

    public Budget findByBudgetDate(Date budgetDate) throws SQLException, ClassNotFoundException {
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
    public boolean createBudget(Budget budget) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return budgetManager.create(con, budget);
        }
    }
    public boolean updateBudget(Budget budget) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return budgetManager.update(con, budget);
        }
    }


}


