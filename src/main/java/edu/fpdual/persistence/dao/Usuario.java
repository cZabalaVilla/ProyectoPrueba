package edu.fpdual.persistence.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Usuario {
    int userId;
    String userName;
    String userPassword;

    public Usuario(ResultSet result) {
        try {
            this.userId = Integer.parseInt(result.getString("usuario"));
            this.userPassword = result.getString("userPassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}