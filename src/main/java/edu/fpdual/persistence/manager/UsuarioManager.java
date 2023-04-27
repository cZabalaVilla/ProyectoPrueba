package edu.fpdual.persistence.manager;


import edu.fpdual.persistence.dao.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {
    List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> findAll(Connection con) {
        try (PreparedStatement stm = con.prepareStatement("SELECT * FROM usuario")) {
            ResultSet result = stm.executeQuery();

            result.beforeFirst();

            while (result.next()) {
                usuarios.add(new Usuario(result.getString("usuario"), result.getString("userpassword")));
            }

            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }

    public List<Usuario> findByUser(Connection con, String user) {

        try (PreparedStatement stm = con.prepareStatement("SELECT * FROM usuario WHERE usuario = ?")) {

            stm.setString(1, user);

            ResultSet result = stm.executeQuery();

            result.beforeFirst();

            while (result.next()) {
                usuarios.add(new Usuario(result.getString("usuario"), result.getString("userpassword")));
            }

            return usuarios;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
