package edu.fpdual.webapplication.client;

import edu.fpdual.webapplication.dto.Category;

public class CategoryClient extends Client<Category> {
    @Override
    public String ping() {
        return null;
    }

    @Override
    public Category get(String str) {
        return null;
    }

    @Override
    public boolean put(Category entity) {
        return false;
    }

    @Override
    public boolean post(Category entity) {
        return false;
    }

    @Override
    public boolean delete(Category entity) {
        return false;
    }
}
