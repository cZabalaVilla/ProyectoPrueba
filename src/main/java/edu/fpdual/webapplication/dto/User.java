package edu.fpdual.webapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private boolean admn;


    public User(String userName, String userPassword, boolean admn) {
        this.userName = userName;
        this.userPassword = new Password(userPassword).toString();
        this.admn = admn;
    }

    @Override
    public String toString() {
        String esAdmin = "NO";
        if (admn) esAdmin = "SI";
        return "Usuario: " + userName
                + " | Id de usuario: " + userId
                + " | Password: " + userPassword
                + " | Administrador?: " + esAdmin;
    }

}
