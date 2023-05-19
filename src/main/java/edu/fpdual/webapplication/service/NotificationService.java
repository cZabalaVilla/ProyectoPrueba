package edu.fpdual.webapplication.service;

import edu.fpdual.webapplication.client.Client;
import edu.fpdual.webapplication.client.NotificationClient;

public class NotificationService {
    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient){
        this.notificationClient = notificationClient;
    }


}
