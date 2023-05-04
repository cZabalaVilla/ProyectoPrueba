package edu.fpdual.service;

import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.dao.Usuario;
import edu.fpdual.persistence.manager.UsuarioManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UsuarioService {
    private final MySQLConnector connector;
    private final UsuarioManager manager;

    public UsuarioService(MySQLConnector connector, UsuarioManager manager) {
        this.connector = connector;
        this.manager = manager;
    }

    public List<Usuario> findAllUsers()
            throws
            SQLException,
            ClassNotFoundException {
        try (Connection con = connector.getMySQLConnection()) {
            return manager.findAll(con);
        }
    }

    public Usuario findByUserId(Integer userId)
            throws
            SQLException,
            ClassNotFoundException {
        try (Connection con = connector.getMySQLConnection()) {
            return manager.findBy(con, "userId", userId);
        }
    }

    public Usuario findByUserName(String userName)
            throws
            SQLException,
            ClassNotFoundException {
        try (Connection con = connector.getMySQLConnection()) {
            return manager.findBy(con, "userName", userName);
        }
    }
}
