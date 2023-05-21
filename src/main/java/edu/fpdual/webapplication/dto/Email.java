package edu.fpdual.webapplication.dto;

import lombok.Data;

@Data
public class Email {
    private String email;

    public Email(String email) {
        setEmail(email);
    }

    public void setEmail(String email) {
        //Comprobacion del email.
    }

    public boolean sendEmail() {
        return false;
    }

}
