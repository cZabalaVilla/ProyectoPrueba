package edu.fpdual.webservice.model.persistence.manager.impl;

import edu.fpdual.webservice.model.persistence.dao.Category;
import edu.fpdual.webservice.model.persistence.dao.User;
import edu.fpdual.webservice.model.persistence.manager.CategoryManager;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CategoryManagerImpl implements CategoryManager {
    String tableName = "CATEGORY";

    @Override
    public List<Category> findAll(Connection con) {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;

        try (Statement stm = con.createStatement()) {
            ResultSet result = stm.executeQuery(query);
            result.beforeFirst();
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

    @Override
    public boolean appendUserCategories(User user,Category category) {
        try{
            createNewCSV(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Category> extractUserCategories(User user) {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter("csv.txt"), CSVFormat.DEFAULT)) {
            printer.printRecord("id", "userName", "firstName", "lastName", "birthday");
            printer.printRecord(1, "john73", "John", "Doe", LocalDate.of(1973, 9, 15));
            printer.println();
            printer.printRecord(2, "mary", "Mary", "Meyer", LocalDate.of(1985, 3, 29));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void createNewCSV(User user) throws IOException {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter("csv.txt"), CSVFormat.DEFAULT)) {

        }
    }
}
