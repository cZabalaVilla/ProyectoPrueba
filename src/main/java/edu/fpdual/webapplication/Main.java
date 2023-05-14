package edu.fpdual.webapplication;

import edu.fpdual.webapplication.service.client.NotificationClient;
import edu.fpdual.webapplication.service.client.dto.Notification;

public class Main {

    public static void main(String[] args) {
        System.out.println(new NotificationClient().ping());
        System.out.println(new NotificationClient().getNotification("8"));
        System.out.println(new NotificationClient().getNotification("82", ":D"));
        System.out.println(new NotificationClient().putNotification("82", ":D"));
        System.out.println(new NotificationClient().postNotification(
                Notification.builder().id(9).body("Prueba de consumo de servicio").title("Prueba").build()));
    }

}
