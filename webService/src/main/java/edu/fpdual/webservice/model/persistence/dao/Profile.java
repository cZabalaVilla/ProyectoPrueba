package edu.fpdual.webservice.model.persistence.dao;

import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
public class Profile {

    private int userId;
    private String userName;
    private String userPassword;
    private String description;
    private String email;
    private String link;
    private String location;

    public Profile (ResultSet result) {
        try {
            this.userId = result.getInt("userId");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
