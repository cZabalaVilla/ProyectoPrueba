package edu.fpdual.webservice.model.persistence.manager.impl;

import edu.fpdual.webservice.model.persistence.dao.Budget;
import edu.fpdual.webservice.model.persistence.dao.Category;
import edu.fpdual.webservice.model.persistence.manager.BudgetManager;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BudgetManagerImpl implements BudgetManager {
    String tableName = "BUDGET";
    @Override
    public List<Budget> findAll(Connection con) {
        List<Budget> presupuestos = new ArrayList<>();
        String query = "SELECT * FROM " +tableName;

        try (Statement stm = con.createStatement()) {
            ResultSet result = stm.executeQuery(query);
            result.beforeFirst();

            while (result.next()) {
               // presupuestos.add(new Budget(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            presupuestos = null;
        }
        return presupuestos;
    }

    @Override
    public List<Budget> findAllBy(Connection con, String fieldName, Object value) {
        return null;
    }

    @Override
    public Budget findBy(Connection con, String fieldName, Object value) {
        Budget presupuesto = new Budget();
        String query = "SELECT * FROM " +tableName +" WHERE " + fieldName.toUpperCase() + " = ?";

        try (PreparedStatement stm = con.prepareStatement(query)) {
            stm.setObject(1, value);
            ResultSet result = stm.executeQuery();
            result.beforeFirst();

            while (result.next()) {
                //presupuesto = new Budget(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            presupuesto = null;
        }

        return presupuesto;
    }

    @Override
    public boolean delete(Connection con, Budget budget) {
        boolean result = false;

        String query = "DELETE FROM " +tableName +" WHERE budgetName = ?";

        try (PreparedStatement stm = con.prepareStatement(query)) {
            stm.setObject(1, budget.getBudgetName());
            result = stm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }




    @Override
    public boolean create(Connection con, Budget entity) {
        //Hay que ver los atributos de Budget
        String query = "INSERT INTO " +tableName +"(userID, budgetId, budgetName, creationDate) values (?, ?, ?, ?)";
        int affectedRows;

        try(PreparedStatement stm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stm.setInt(1, entity.getUserId());
            stm.setInt(2, entity.getBudgetId());
            stm.setString(3, entity.getBudgetName());
            stm.setDate(4, (Date) entity.getCreationDate());

            affectedRows = stm.executeUpdate();

            if (affectedRows <= 0) {
                //
            } else {
                ResultSet resultSet = stm.getGeneratedKeys();
                resultSet.beforeFirst();
                resultSet.next();

                affectedRows = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            affectedRows = 0;
        }
        return false;
    }

    @Override
    public boolean update(Connection con, Budget entity) {
        boolean result;
        String query = "UPDATE " +tableName +" SET budgetName = ?, creationDate = ? WHERE budgetId = ?";

        try (PreparedStatement stm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stm.setInt(1, entity.getUserId());
            stm.setInt(2, entity.getBudgetId());
            stm.setString(3, entity.getBudgetName());
            stm.setDate(4, (Date) entity.getCreationDate());

            result = stm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }
}
