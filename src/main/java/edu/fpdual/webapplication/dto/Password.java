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
        String hashedPassword;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            hashedPassword = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            hashedPassword = null;
        }
        return hashedPassword;
    }

    public boolean checkPassword(String storedHash) {
        boolean passwordMatches;
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
    @Override
    public String toString() {
        return password;
    }
}



