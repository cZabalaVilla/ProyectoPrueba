package edu.fpdual.webapplication.dto;

import lombok.Data;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Data
public class Password {
    private String password;

    public Password(String password){
        this.password = hashPassword(password);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }


    //Hasher
    /*
    public static void main2(String[] args) {
        // Supongamos que "hashFromDatabase" contiene el hash almacenado en la base de datos
        String hashFromDatabase = "e8e156..."; // Ejemplo de hash almacenado

        String passwordToCheck = "miContrasena123";
        boolean passwordMatches = checkPassword(passwordToCheck, hashFromDatabase);

        if (passwordMatches) {
            System.out.println("Contraseña correcta");
        } else {
            System.out.println("Contraseña incorrecta");
        }
    }
     */

    public boolean checkPassword(String storedHash) {
        boolean passwordMatches ;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            String calculatedHash = hexString.toString();
            passwordMatches = calculatedHash.equals(storedHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            passwordMatches = false;
        }
        return passwordMatches;
    }
}



