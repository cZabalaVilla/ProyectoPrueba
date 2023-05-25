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
    private String description;
    private String email;
    private String link;
    private String location;
    private int phone;

    public Profile(String description, String email, String link, String location,int phone) {
        this.description = description;
        this.email = email;
        this.link = link;
        this.location = location;
        this.phone = phone;
    }

    public Profile (ResultSet result) {
        try {
            this.userId = result.getInt("userId");
            this.description = result.getString("description");
            this.email = result.getString("email");
            this.link = result.getString("link");
            this.location = result.getString("location");
            this.phone = result.getInt("phone");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
