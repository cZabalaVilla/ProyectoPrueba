package edu.fpdual.webservice.model.persistence.manager;

import edu.fpdual.webservice.model.persistence.dao.Category;
import edu.fpdual.webservice.model.persistence.dao.User;

import java.util.List;

public interface CategoryManager extends Manager<Category> {

    List<Category> extractUserCategories(User user);

    boolean appendUserCategories(User user,Category category);
}
