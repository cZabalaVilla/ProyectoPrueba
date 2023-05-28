package edu.fpdual.webapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Category {
    private int categoryId;
    private int userId;
    private String categoryName;

    public Category(int userId, String categoryName){
        this.userId = userId;
        this.categoryName = categoryName;
    }
}
