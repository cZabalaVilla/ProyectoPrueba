package edu.fpdual.webapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Profile {
    //que se pueda cambiar todo aqui
    private int userId;
    private String description;
    private String email;
    private String link;
    private String location;
    private int phone;

    public Profile(String description, String email, String link, String location, int phone) {
        this.description = description;
        this.email = email;
        this.link = link;
        this.location = location;
        this.phone = phone;
    }

    public Profile(int userId, String email) {
        this.userId = userId;
        this.email = email;
    }
}
