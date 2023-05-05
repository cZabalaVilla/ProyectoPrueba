package edu.fpdual.webservice.model.persistence.manager.impl;


import edu.fpdual.webservice.model.persistence.dao.User;
import edu.fpdual.webservice.model.persistence.manager.UserManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserManagerImpl implements UserManager {
    String tableName = "USUARIO";

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

    //NO FUNCIONA DE MOMENTO
    @Override
    public List<User> findAllBy(Connection con, String fieldName, Set<Object> values) {
        List<User> usuarios = new ArrayList<>();
        String query = "SELECT * FROM " + tableName + " WHERE " + fieldName + " =?";

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
        return null;
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
        boolean result = false;
        String query = "DELETE FROM " + tableName + " WHERE " + fieldName + " = ?";

        try (PreparedStatement stm = con.prepareStatement(query)) {
            stm.setObject(1, value);
            result = stm.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int create(Connection con, User entity) {
        //prepare SQL statement
        String query = "INSERT INTO " + tableName + " (name, countryCode, district, population) values(?,?,?,?)";

        // Create general statement
        try (PreparedStatement stm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            //Add Parameters
            stm.setInt(1, entity.getUserId());
            stm.setString(2, entity.getUserName());
            stm.setString(3, entity.getUserPassword());
            // Queries the DB
            int affectedRows = stm.executeUpdate();

            if (affectedRows <= 0) {
                return 0;
            }

            ResultSet resultSet = stm.getGeneratedKeys();
            resultSet.beforeFirst();
            resultSet.next();

            return resultSet.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean update(Connection con, User entity) {
        return false;
    }
}
