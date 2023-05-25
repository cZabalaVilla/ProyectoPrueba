package edu.fpdual.webapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Category {
    private int categoryId;
    private String categoryName;

    @Override
    public String toString() {
        return "Categoria: " + categoryName
                + " | Id de categoria: " + categoryId;
    }

}
