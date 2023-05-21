package edu.fpdual.webapplication.service;

import edu.fpdual.webapplication.client.NotificationClient;
import edu.fpdual.webapplication.dto.Notification;

public class NotificationService {
    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public String ping() {
        return notificationClient.ping();
    }

    public Notification getNotification(String id) {
        return notificationClient.get(id);
    }

    public Notification getNotification(String id, String name) {
        return notificationClient.get(id, name);
    }

    public boolean putNotification(Notification notification) {
        return notificationClient.put(notification);
    }

    public boolean postNotification(Notification notification) {
        return notificationClient.post(notification);
    }

}
