package edu.fpdual.webapplication.client;

import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.dfo.Email;
import edu.fpdual.webapplication.dto.User;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class EmailClient extends Client<Email> {
    private final WebTarget webTarget;
    private final String clientPath = "email/";

    public EmailClient() {
        jakarta.ws.rs.client.Client client = ClientBuilder.newClient();
        this.webTarget = client.target(GlobalInfo.URL_WEBTARGET);
    }

    @Override
    public String ping() {
        return webTarget.path(clientPath + "ping")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public List<Email> get() {
        return webTarget.path(clientPath + "get/all")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<>() {
                });
    }

    public Email get(String email) {
        return webTarget.path(clientPath + "get/" + email)
                .request(MediaType.APPLICATION_JSON)
                .get(Email.class);
    }

    @Override
    public boolean put(Email email) {
        return webTarget.path(clientPath + "put")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(email, MediaType.APPLICATION_JSON), boolean.class);
    }

    @Override
    public boolean post(Email email) {
        return webTarget.path(clientPath + "post")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(email, MediaType.APPLICATION_JSON), boolean.class);
    }

    @Override
    public boolean delete(Email email) {
        return webTarget.path(clientPath + "delete")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(email, MediaType.APPLICATION_JSON), boolean.class);}
}