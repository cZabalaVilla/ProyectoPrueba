package edu.fpdual.webapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Profile {
    //que se pueda cambiar todo aqui
    private int userId;
    private String userName;
    private String userPassword;
    private String description;
    private String email;
    private String link;
    private String location;

    public Profile(int userId, String userName, String userPassword, String description, String email, String link, String location) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.description = description;
        this.email = email;
        this.link = link;
        this.location = location;
    }
}
