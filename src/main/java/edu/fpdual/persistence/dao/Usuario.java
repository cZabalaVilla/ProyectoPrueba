package edu.fpdual.persistence.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    String usuario;
    String userPassword;

    public Usuario(ResultSet result) {
        try {
            this.usuario = result.getString("usuario");
            this.userPassword = result.getString("useropassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}