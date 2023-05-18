package edu.fpdual.webservice.model.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

@Data
@NoArgsConstructor
public class Category {

    private int categoryId;
    private String categoryName;
    private static HashSet<Category> categories;

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        initCategories();
    }

    public Category(ResultSet result) {
        try {
            this.categoryId = result.getInt("categoryId");
            this.categoryName = result.getString("categoryName");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initCategories() {
        if (categories == null) {
            categories = new HashSet<Category>();
            categories.add(new Category(0, "CASA"));
            categories.add(new Category(0, "VIAJE"));
        }
    }
}
