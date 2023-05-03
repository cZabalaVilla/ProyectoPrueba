package edu.fpdual.persistence.manager;


import edu.fpdual.persistence.dao.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {
    List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> findAllUsers(Connection con) {

        try (Statement stm = con.createStatement()) {

            ResultSet result = stm.executeQuery("SELECT * FROM USUARIO");

            result.beforeFirst();

            List<Usuario> usuarios = new ArrayList<>();

            while (result.next()) {
                usuarios.add(new Usuario(result));
            }
            return usuarios;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Usuario findByUser(Connection con, String user) {

        try (PreparedStatement stm = con.prepareStatement("SELECT * FROM USUARIO WHERE USUARIO = ?")) {

            stm.setString(1, user);

            ResultSet result = stm.executeQuery();

            result.beforeFirst();

            Usuario usuario = null;

            while (result.next()) {
                usuario = new Usuario(result);
            }

            return usuario;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
