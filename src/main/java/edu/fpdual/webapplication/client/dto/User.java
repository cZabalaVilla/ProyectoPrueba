package edu.fpdual.webapplication.client.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Data
@NoArgsConstructor
@XmlRootElement
public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private boolean admn;


    public User(String userName, String userPassword, boolean admn) {
        this.userName = userName;
        this.userPassword = userPassword;
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
