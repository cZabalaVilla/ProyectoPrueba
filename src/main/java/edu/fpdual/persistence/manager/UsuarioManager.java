package edu.fpdual.persistence.manager;


import edu.fpdual.persistence.dao.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioManager implements Manager<Usuario> {
    List<Usuario> usuarios = new ArrayList<>();
    Usuario usuario;

    public List<Usuario> findAll(Connection con) {
        try (Statement stm = con.createStatement()) {
            ResultSet result = stm.executeQuery("SELECT * FROM USUARIO");
            result.beforeFirst();
            while (result.next()) {
                usuarios.add(new Usuario(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            usuarios = null;
        }
        return usuarios;
    }

    @Override
    public Usuario findBy(Connection con, String fieldName, Object value) {
        String sentence = "SELECT * FROM USUARIO WHERE " + fieldName + " =?";
        try (PreparedStatement stm = con.prepareStatement(sentence)) {
            stm.setObject(1, value);
            ResultSet result = stm.executeQuery();
            result.beforeFirst();
            while (result.next()) {
                usuario = new Usuario(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            usuario = null;
        }
        return usuario;
    }
}
