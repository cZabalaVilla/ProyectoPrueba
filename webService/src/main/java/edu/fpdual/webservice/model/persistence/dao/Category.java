package edu.fpdual.webservice.model.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
public class Category {

    int categoryId;
    String categoryName;

    public Category(ResultSet result) {
        try {
            this.categoryId = Integer.parseInt(result.getString("categoryId"));
            this.categoryName = result.getString("categoryName");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
