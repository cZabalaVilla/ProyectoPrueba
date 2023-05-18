package edu.fpdual.webservice.model.persistence.manager;

import edu.fpdual.webservice.model.persistence.dao.User;

import java.sql.Connection;
import java.util.List;

public interface UserManager extends Manager<User>{
    /**
     * Find all admins.
     *
     * @param con DB connection
     * @return a {@link List} of {@link User} objects
     */
    List<User> findAllAdmins(Connection con);

}
