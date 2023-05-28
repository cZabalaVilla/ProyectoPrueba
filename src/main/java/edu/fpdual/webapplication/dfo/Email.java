package edu.fpdual.webapplication.dfo;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class Email {
    private static final List<String> commonDomains = Arrays.asList(
            "gmail.com", "yahoo.com", "outlook.com", "hotmail.com",
            "aol.com", "icloud.com", "mail.com", "protonmail.com",
            "yandex.com", "gmx.com"
    );
    private String email;

    public Email(String email) throws InvalidEmailException {
        try {
            checkEmail(email);
            this.email = email;
        } catch (InvalidEmailException e) {
            throw new InvalidEmailException(e.getMessage());
        }
    }

    public void checkEmail(String email) throws InvalidEmailException {
        if (email == null || !email.contains("@")) {
            throw new InvalidEmailException("El correo electrónico no es válido.");
        }

        String[] parts = email.split("@");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            throw new InvalidEmailException("El correo electrónico no es válido.");
        }

        String dominio = parts[1].toLowerCase();
        if (!commonDomains.contains(dominio)) {
            throw new InvalidEmailException("El dominio del correo electrónico no es válido.");
        }
    }

    @Override
    public String toString() {
        return email;
    }
}

