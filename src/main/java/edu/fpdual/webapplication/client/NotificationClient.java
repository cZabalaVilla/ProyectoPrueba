package edu.fpdual.webapplication.client;

import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.dto.Notification;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class NotificationClient extends Client<Notification> {
    private final String clientPath = "notification/";
    private final WebTarget webTarget;

    public NotificationClient() {
        jakarta.ws.rs.client.Client client = ClientBuilder.newClient();
        this.webTarget = client.target(GlobalInfo.webPath);
    }

    public String ping() {
        return webTarget.path(clientPath + "ping")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public Notification get(String id) {
        return webTarget.path(clientPath + "get/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get(Notification.class);
    }

    public Notification get(String id, String name) {
        return webTarget.path(clientPath + "get/" + id + "/name")
                .queryParam("name", name)
                .request(MediaType.APPLICATION_JSON)
                .get(Notification.class);
    }

    public boolean put(Notification notification) {
        return webTarget.path(clientPath + "put")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(notification, MediaType.APPLICATION_JSON), boolean.class);
    }

    public boolean post(Notification notification) {
        return webTarget.path(clientPath + "post")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(notification, MediaType.APPLICATION_JSON), boolean.class);
    }

    @Override
    public boolean delete(Notification entity) {
        return false;
    }
}
