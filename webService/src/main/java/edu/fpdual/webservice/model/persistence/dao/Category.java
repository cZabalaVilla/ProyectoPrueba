package edu.fpdual.webservice.model.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

@Data
@NoArgsConstructor
public class Category {
    private int categoryId;
    private int userId;
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(ResultSet result) {
        try {
            this.categoryId = result.getInt("categoryId");
            this.categoryName = result.getString("categoryName");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
