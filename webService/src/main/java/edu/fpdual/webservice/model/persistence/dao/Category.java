package edu.fpdual.webservice.model.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
public class Category {
    private int categoryId;
    private int userId;
    private String categoryName;


    public Category(ResultSet result) {
        try {
            this.categoryId = result.getInt("categoryId");
            this.categoryName = result.getString("categoryName");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
