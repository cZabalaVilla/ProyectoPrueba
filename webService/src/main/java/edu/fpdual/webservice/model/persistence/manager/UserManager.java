package edu.fpdual.webservice.model.persistence.manager;

import edu.fpdual.webservice.model.persistence.dao.User;

import java.sql.Connection;
import java.util.List;

public interface UserManager extends Manager<User>{
    //@TODO Añadir javadoc
    List<User> findAllAdmins(Connection con);

    /**
     * Creates an entity.
     *
     * @param con DB connection
     * @param userName User name, userPassword User Password
     * @return a {@link Boolean}
     */

    int create(Connection con, String userName, String userPassword);
}
