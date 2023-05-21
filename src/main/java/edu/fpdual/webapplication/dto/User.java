package edu.fpdual.webapplication.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@XmlRootElement
public class User {
    private int userId;
    private String userName;
    private Password userPassword;
    private boolean admn;


    public User(String userName, String userPassword, boolean admn) {
        this.userName = userName;
        this.userPassword = new Password(userPassword);
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
