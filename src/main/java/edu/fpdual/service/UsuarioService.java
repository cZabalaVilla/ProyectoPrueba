package edu.fpdual.service;

import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.dao.Usuario;
import edu.fpdual.persistence.manager.UsuarioManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UsuarioService {

    private MySQLConnector connector;

    private UsuarioManager manager;

    public UsuarioService(MySQLConnector connector, UsuarioManager manager) {
        this.connector = connector;
        this.manager = manager;
    }

    public List<Usuario> findAllUsers()
            throws
            SQLException,
            ClassNotFoundException {

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.findAllUsers(con);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public Usuario findUserByUsuario(String user)
            throws
            SQLException,
            ClassNotFoundException {

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.findByUser(con, user);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}
