package edu.fpdual.webapplication.service;

import edu.fpdual.webapplication.annotations.Model;
import edu.fpdual.webapplication.client.CategoryClient;
import edu.fpdual.webapplication.dto.Category;

import java.util.List;

@Model(type = "Service", version = "1.0", date = "01/06/2023")
public class CategoryService {
    private final CategoryClient categoryClient;

    public CategoryService(CategoryClient categoryClient) {
        this.categoryClient = categoryClient;
    }

    public String ping() {
        return categoryClient.ping();
    }

    public List<Category> getAllCategories() {
        return categoryClient.get();
    }

    public Category getCategory(String categoryName) {
        return categoryClient.get(categoryName);
    }

    public boolean updateCategory(Category category) {
        return categoryClient.put(category);
    }

    public boolean createCategory(Category category) {
        return categoryClient.post(category);
    }

    public boolean deleteCategory(Category category) {
        return categoryClient.delete(category);
    }
}