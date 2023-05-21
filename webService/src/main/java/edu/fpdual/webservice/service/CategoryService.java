package edu.fpdual.webservice.service;

import edu.fpdual.webservice.model.persistence.connector.MySQLConnector;
import edu.fpdual.webservice.model.persistence.dao.Category;
import edu.fpdual.webservice.model.persistence.manager.CategoryManager;
import edu.fpdual.webservice.model.persistence.manager.impl.CategoryManagerImpl;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private final CategoryManager categoryManager;

    //@TODO Añadir javadoc
    public CategoryService(CategoryManagerImpl categoryManager) {

        this.categoryManager = categoryManager;
    }

    public List<Category> findAllCategories() throws SQLException, ClassNotFoundException {
        return categoryManager.findAll(new MySQLConnector().getMySQLConnection());
    }

    public Category findByCategoryName(String categoryName) throws SQLException, ClassNotFoundException {
        return categoryManager.findBy(new MySQLConnector().getMySQLConnection(), "categoryName", categoryName);
    }

    public boolean createCategory(Category category) throws SQLException, ClassNotFoundException {
        return categoryManager.create(new MySQLConnector().getMySQLConnection(), category);
    }

    public boolean updateCategory(Category category) throws SQLException, ClassNotFoundException {
        return categoryManager.update(new MySQLConnector().getMySQLConnection(), category);
    }

    public boolean deleteCategory(Category category) throws SQLException, ClassNotFoundException {
        return categoryManager.delete(new MySQLConnector().getMySQLConnection(), category);
    }

}
