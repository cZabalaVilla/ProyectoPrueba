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

    @Override
    public List<User> findAllBy(Connection con, String fieldName, Object value) {
        List<User> usuarios = new ArrayList<>();
        String query = "SELECT * FROM " + tableName + " WHERE " + fieldName + " = ?";
        try (PreparedStatement stm = con.prepareStatement(query)) {
            stm.setObject(1, value);
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
    public List<User> findAllAdmins(Connection con) {
        List<User> usuarios = new ArrayList<>();
        String query = "SELECT * FROM " + tableName + " WHERE ADMN" + " = ?";
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
            if (value.getClass().equals(String.class)) {
                value = ((String) value).toLowerCase();
            }
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
    public boolean delete(Connection con, User user) {
        boolean result;
        String query = "DELETE FROM " + tableName + " WHERE userName" + " = ?";

        try (PreparedStatement stm = con.prepareStatement(query)) {
            stm.setObject(1, user.getUserName().toLowerCase());
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
    public boolean create(Connection con, User user) {
        boolean result;
        String query = "INSERT INTO " + tableName + " (userName, userPassword, admn) values(?,?,?)";

        try (PreparedStatement stm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stm.setString(1, user.getUserName().toLowerCase());
            stm.setString(2, user.getUserPassword());
            stm.setInt(3, user.isAdmn() ? 1 : 0);

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
    public boolean update(Connection con, User user) {
        boolean result;
        String query = "UPDATE " + tableName + " SET userName = ? , userPassword = ? WHERE userId = ?";

        try (PreparedStatement stm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stm.setString(1, user.getUserName());
            stm.setString(2, user.getUserPassword());
            stm.setInt(3, user.getUserId());

            result = stm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}
