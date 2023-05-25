package edu.fpdual.webapplication.dfo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Data
@NoArgsConstructor
public class Password {
    private String password;

    public Password(String password, String userName) {
        try {
            checkPassword(password, userName);
            this.password = hashPassword(password);
        } catch (InvalidPasswordException e) {
            e.getMessage();
            e.printStackTrace();
        }
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

    public void checkPassword(String password, String userName) throws InvalidPasswordException {
        if (password.length() < 6) {
            throw new InvalidPasswordException("La contraseña debe tener al menos 6 caracteres.");
        }

        if (password.contains(userName)) {
            throw new InvalidPasswordException("La contraseña no puede contener el nombre de usuario.");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("La contraseña debe contener al menos una letra mayúscula.");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new InvalidPasswordException("La contraseña debe contener al menos una letra minúscula.");
        }

        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("La contraseña debe contener al menos un número.");
        }

        if (!password.matches(".*[!@#$%^&*()].*")) {
            throw new InvalidPasswordException("La contraseña debe contener al menos un carácter especial.");
        }
    }

    public boolean comparePassword(String storedHash) {
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

    public boolean resetPassword(String userName) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final int LENGTH = 8;
        SecureRandom random = new SecureRandom();
        StringBuilder newCodePassword = new StringBuilder(LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            newCodePassword.append(randomChar);
        }

        return false;
    }

    @Override
    public String toString() {
        return password;
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}


