package edu.fpdual.webservice.model.persistence.manager.impl;

import edu.fpdual.webservice.model.persistence.dao.Category;
import edu.fpdual.webservice.model.persistence.dao.User;
import edu.fpdual.webservice.model.persistence.manager.CategoryManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryManagerImpl implements CategoryManager {
    final String tableName = "CATEGORY";

    @Override
    public List<Category> findAll(Connection con) {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;

        try (Statement stm = con.createStatement()) {
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                categories.add(new Category(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            categories = null;
        }
        return categories;
    }

    @Override
    public List<Category> findAllBy(Connection con, String fieldName, Object value) {
        return null;
    }

    @Override
    public Category findBy(Connection con, String fieldName, Object value) {
        return null;
    }

    @Override
    public boolean delete(Connection con, Category entity) {
        return false;
    }

    @Override
    public boolean create(Connection con, Category entity) {
        return false;
    }

    @Override
    public boolean update(Connection con, Category entity) {
        return false;
    }

}
