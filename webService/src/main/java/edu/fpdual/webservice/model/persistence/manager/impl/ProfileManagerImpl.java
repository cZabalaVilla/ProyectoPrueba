package edu.fpdual.webservice.model.persistence.manager.impl;

import edu.fpdual.webservice.model.persistence.dao.Profile;
import edu.fpdual.webservice.model.persistence.dao.User;
import edu.fpdual.webservice.model.persistence.manager.ProfileManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileManagerImpl implements ProfileManager {
    final String tableName = "PROFILE";

    @Override
    public List<Profile> findAll(Connection con) {
        List<Profile> entities = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;

        try (Statement stm = con.createStatement()) {
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                entities.add(new Profile(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            entities = null;
        }
        return entities;
    }

    @Override
    public List<Profile> findAllBy(Connection con, String fieldName, Object value) {
        List<Profile> entities = new ArrayList<>();
        String query = "SELECT * FROM " + tableName + " WHERE " + fieldName + " = ?";
        try (PreparedStatement stm = con.prepareStatement(query)) {
            stm.setObject(1, value);
            ResultSet result = stm.executeQuery(query);
            result.beforeFirst();
            while (result.next()) {
                entities.add(new Profile(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            entities = null;
        }
        return entities;
    }

    @Override
    public Profile findBy(Connection con, String fieldName, Object value) {
        Profile entity = new Profile();
        String query = "SELECT * FROM " + tableName + " WHERE " + fieldName + " = ?";

        try (PreparedStatement stm = con.prepareStatement(query)) {
            if (value.getClass().equals(String.class)) {
                value = ((String) value).toLowerCase();
            }
            stm.setObject(1, value);
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                entity = new Profile(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            entity = null;
        }
        return entity;
    }

    @Override
    public boolean delete(Connection con, Profile entity) {
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

    /**
     * Cuando creas un usuario, el return del método debe de ser 4.
     */
    @Override
    public boolean create(Connection con, Profile entity) {
        boolean result;
        String query = "INSERT INTO " + tableName + " (userName, userPassword, admn) values(?,?,?)";

        try (PreparedStatement stm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stm.setString(1, entity.getUserName().toLowerCase());
            stm.setString(2, entity.getUserPassword());

            result = stm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    /**
     *
     */
    @Override
    public boolean update(Connection con, Profile entity) {
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

