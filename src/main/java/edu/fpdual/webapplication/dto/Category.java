package edu.fpdual.webapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private int categoryId;
    private String categoryName;

    //private ArrayList<Category> categories = new ArrayList<Category>();

    @Override
    public String toString() {
        return "Usuario: " + categoryName
                + " | Id de categoria: " + categoryId;
    }

}
