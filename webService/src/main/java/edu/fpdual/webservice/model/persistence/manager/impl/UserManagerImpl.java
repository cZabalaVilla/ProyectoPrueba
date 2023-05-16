package edu.fpdual.webservice.model.persistence.manager.impl;


import edu.fpdual.webservice.model.persistence.dao.User;
import edu.fpdual.webservice.model.persistence.manager.UserManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserManagerImpl implements UserManager {
    String tableName = "USER";

    //@TODO AÑADIR JAVADOC
    public List<User> findAll(Connection con) {
        List<User> usuarios = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;

        try (Statement stm = con.createStatement()) {
            ResultSet result = stm.executeQuery(query);
            result.beforeFirst();
            while (result.next()) {
                usuarios.add(new User(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            usuarios = null;
        }
        return usuarios;
    }

    /*
     * Sin uso de momento
     * */

    @Override
    public List<User> findAllBy(Connection con, String fieldName, Set<Object> values) {
        return null;
    }

    @Override
    public List<User> findAllAdmins(Connection con) {
        List<User> usuarios = new ArrayList<>();
        String fieldName = "admn";
        String query = "SELECT * FROM " + tableName + " WHERE " + fieldName + " =?";
        try (PreparedStatement stm = con.prepareStatement(query)) {
            stm.setObject(1, 1);
            ResultSet result = stm.executeQuery(query);
            result.beforeFirst();
            while (result.next()) {
                usuarios.add(new User(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            usuarios = null;
        }
        return usuarios;
    }


    @Override
    public User findBy(Connection con, String fieldName, Object value) {
        User usuario = new User();
        String query = "SELECT * FROM " + tableName + " WHERE " + fieldName + " = ?";

        try (PreparedStatement stm = con.prepareStatement(query)) {
            stm.setObject(1, value);
            ResultSet result = stm.executeQuery();
            result.beforeFirst();
            while (result.next()) {
                usuario = new User(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            usuario = null;
        }
        return usuario;
    }

    @Override
    public boolean delete(Connection con, String fieldName, Object value) {
        boolean result;
        String query = "DELETE FROM " + tableName + " WHERE " + fieldName.toUpperCase() + " = ?";

        try (PreparedStatement stm = con.prepareStatement(query)) {
            stm.setObject(1, value);
            result = stm.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public int create(Connection con, User entity) {
        return 0;
    }

    /**
     * Cuando creas un usuario, el return del método debe de ser 4.
     */
    @Override
    public int create(Connection con, String username, String userPassword) {
        int affectedRows;
        String query = "INSERT INTO " + tableName + " (userName, userPassword, admn) values(?,?,?)";

        try (PreparedStatement stm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stm.setString(1, username);
            stm.setString(2, userPassword);
            stm.setInt(3, 0);

            /*
            if(isAdmn()) {
                stm.setInt(3, 1);
            } else {
                stm.setInt(3, 0);
            }
            */
            affectedRows = stm.executeUpdate();

            if (affectedRows > 0) {
                ResultSet resultSet = stm.getGeneratedKeys();
                resultSet.beforeFirst();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            affectedRows = 0;
        }
        return affectedRows;
    }

    /**
     *
     */
    @Override
    public boolean update(Connection con, User entity) {
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
