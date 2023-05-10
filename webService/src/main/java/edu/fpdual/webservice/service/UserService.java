package edu.fpdual.webservice.service;

import edu.fpdual.webservice.model.persistence.connector.MySQLConnector;
import edu.fpdual.webservice.model.persistence.dao.User;
import edu.fpdual.webservice.model.persistence.manager.UserManager;
import edu.fpdual.webservice.model.persistence.manager.impl.UserManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class UserService {

    private final UserManager userManager;
    private final LogService logService;

    public UserService(UserManagerImpl userManager){

        this.userManager = userManager;
        this.logService = new LogService();
    }
    public List<User> findAll(Connection con) {
        return null;
    }
/*
    public List<User> findAll() throws SQLException, ClassNotFoundException, JsonProcessingException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            logService.registerLog(
                    Log.builder().fecha(LocalDateTime.now())
                            .logStatus(LogStatus.OK).titulo("Buscando Todos las ciudades.")
                            .mensaje("Buscando todas las ciudades sin filtro.").build());
            List<User> users = userManager.findAll(con);
            logService.registerLog(
                    Log.builder().fecha(LocalDateTime.now())
                            .logStatus(LogStatus.OK).titulo("Busqueda de ciudades exitosa.")
                            .mensaje("Busqueda de ciudades sin filtro  exitosa. Encontradas "+users.size()+" ciudades.").build());
            return users;
        }
    }
*/
    public User findByUserName(String userName) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return userManager.findBy(con,"userName", userName);
        }
    }

    public boolean deleteUser(User user) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return userManager.delete(con, "userName",user.getUserId());
        }
    }

    public int createUser(User user) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return userManager.create(con, user);
        }
    }

    public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return userManager.update(con, user);
        }
    }
}

