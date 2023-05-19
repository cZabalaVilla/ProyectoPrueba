package edu.fpdual.webapplication.service.client;

import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.service.client.dto.User;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class UserClient extends Client<User> {
    private final WebTarget webTarget;
    private final String clientPath = "user/";

    public UserClient() {
        jakarta.ws.rs.client.Client client = ClientBuilder.newClient();
        this.webTarget = client.target(GlobalInfo.URL_WEBTARGET);
    }

    @Override
    public String ping() {
        return webTarget.path(clientPath + "ping")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public User get(String userName) {
        return webTarget.path(clientPath + "get/" + userName)
                .request(MediaType.APPLICATION_JSON)
                .get(User.class);
    }

    public List<User> getAll() {
        return webTarget.path(clientPath + "get/all")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<>() {
                });
    }
    @Override
    public boolean put(User user) {
        return false; /*webTarget.path(clientPath + "put/" + user)
                .request(MediaType.APPLICATION_JSON)
                .put(boolean(MediaType.APPLICATION_JSON), boolean.class);
    */}

    @Override
    public boolean post(User user) {
        return false;/*webTarget.path(clientPath + "post")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(user, MediaType.APPLICATION_JSON), User.class);
    */}

    @Override
    public boolean delete(User entity) {
        return false;
    }

    public boolean create(User user) {
        return webTarget.path(clientPath + "create/" + user.getUserName() + "/" + user.getUserPassword())
                .request(MediaType.APPLICATION_JSON)
                .get(Boolean.class);
    }


}
