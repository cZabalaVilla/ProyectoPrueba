package edu.fpdual.webapplication.service.client.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement
public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private boolean admn;

    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashedBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
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
