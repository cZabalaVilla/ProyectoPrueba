package edu.fpdual.webapplication.service.client;

import edu.fpdual.webapplication.service.client.dto.Notification;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class NotificationClient {

    private final WebTarget webTarget;

    public NotificationClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8081/webService/webapi/");
    }

    public Notification getNotification(String id) {
        return webTarget.path("notification/get/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get(Notification.class);
    }

    public String ping() {
        return webTarget.path("notification/ping")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public Notification getNotification(String id, String name) {
        return webTarget.path("notification/get/" + id + "/name")
                .queryParam("name", name)
                .request(MediaType.APPLICATION_JSON)
                .get(Notification.class);
    }

    public Notification putNotification(String id, String name) {
        return webTarget.path("notification/get/" + id + "/" + name)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity("", MediaType.APPLICATION_JSON), Notification.class);
    }

    public Notification postNotification(Notification notification) {
        return webTarget.path("notification/post")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(notification, MediaType.APPLICATION_JSON), Notification.class);
    }
}
