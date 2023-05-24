package edu.fpdual.webservice.service;

import edu.fpdual.webservice.model.persistence.connector.MySQLConnector;
import edu.fpdual.webservice.model.persistence.dao.Budget;
import edu.fpdual.webservice.model.persistence.dao.Income;
import edu.fpdual.webservice.model.persistence.manager.IncomeManager;
import edu.fpdual.webservice.model.persistence.manager.impl.IncomeManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.List;

public class IncomeService {
    private final IncomeManager incomeManager;

    public IncomeService(IncomeManagerImpl incomeManager) {

        this.incomeManager = incomeManager;
    }

    public List<Income> findAll() throws SQLException, ClassNotFoundException{
        try(Connection con = new MySQLConnector().getMySQLConnection()) {
            return incomeManager.findAll(con);
        }
    }

    public Budget findByIncomeDate(LocalDate incomeDate) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return incomeManager.findBy(con, "incomeDate", incomeDate);
        }
    }

    public Income findByIncomeName(String incomeName) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return incomeManager.findBy(con, "incomeName", incomeName);
        }
    }
    public boolean deleteIncome(Income income) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return incomeManager.delete(con, income);
        }
    }
    public boolean createIncome(String incomeName, String description, double amount, boolean isRecurrent, LocalDate creationDate) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return incomeManager.create(con, new Income(incomeName, description, isRecurrent, amount, creationDate));
        }
    }
    public boolean updateIncome(Income income) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return incomeManager.update(con, income);
        }
    }

}
