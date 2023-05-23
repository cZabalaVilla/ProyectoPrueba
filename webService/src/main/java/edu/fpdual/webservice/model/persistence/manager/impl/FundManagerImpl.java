package edu.fpdual.webservice.model.persistence.manager.impl;

import edu.fpdual.webservice.model.persistence.dao.Fund;
import edu.fpdual.webservice.model.persistence.manager.FundManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FundManagerImpl implements FundManager {
    final String tableName = "FUND";

    @Override
    public List<Fund> findAll(Connection con) {
        List<Fund> entities = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;

        try (Statement stm = con.createStatement()) {
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                entities.add(new Fund(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            entities = null;
        }
        return entities;
    }

    @Override
    public List<Fund> findAllBy(Connection con, String fieldName, Object value) {
        List<Fund> entities = new ArrayList<>();
        String query = "SELECT * FROM " + tableName + " WHERE " + fieldName + " = ?";
        try (PreparedStatement stm = con.prepareStatement(query)) {
            stm.setObject(1, value);
            ResultSet result = stm.executeQuery(query);
            result.beforeFirst();
            while (result.next()) {
                entities.add(new Fund(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            entities = null;
        }
        return entities;
    }

    @Override
    public Fund findBy(Connection con, String fieldName, Object value) {
        Fund fund = new Fund();
        String query = "SELECT * FROM " + tableName + " WHERE " + fieldName + " = ?";

        try (PreparedStatement stm = con.prepareStatement(query)) {
            if (value.getClass().equals(String.class)) {
                value = ((String) value).toLowerCase();
            }
            stm.setObject(1, value);
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                fund = new Fund(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fund = null;
        }
        return fund;
    }

    @Override
    public boolean delete(Connection con, Fund entity) {
        boolean result;
        String query = "DELETE FROM " + tableName + " WHERE userName" + " = ?";

        try (PreparedStatement stm = con.prepareStatement(query)) {
            stm.setObject(1, entity.getUserName().toLowerCase());
            result = stm.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public boolean create(Connection con, Fund entity) {
        boolean result;
        String query = "INSERT INTO " + tableName + " (userName, userPassword, admn) values(?,?,?)";

        try (PreparedStatement stm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stm.setString(1, entity.getUserName().toLowerCase());
            stm.setString(2, entity.getUserPassword());
            stm.setInt(3, entity.isAdmn() ? 1 : 0);

            result = stm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public boolean update(Connection con, Fund entity) {
        boolean result;
        String query = "UPDATE " + tableName + " SET userName = ? , userPassword = ? WHERE userId = ?";

        try (PreparedStatement stm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stm.setString(1, entity.getUserName());
            stm.setString(2, entity.getUserPassword());
            stm.setInt(3, entity.getUserId());

            result = stm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}
