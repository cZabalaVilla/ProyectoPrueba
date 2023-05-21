package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.persistence.dao.Notification;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/notification")
public class NotificationController {

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("id") int id) {
        return Response.ok().entity(new Notification(id, "john", "test notification")).build();
    }

    @PUT
    @Path("/put")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putNotification() {
        return Response.ok().entity(true).build();
    }

    @GET
    @Path("/get/{id}/name")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotificationWithParameters(@PathParam("id") int id, @QueryParam("name") String name) {
        if (name == null || name.trim().isEmpty()) {
            return Response.status(400).entity("Name not present in the request").build();
        } else {
            return Response.ok().entity(new Notification(id, name, "test notification")).build();
        }
    }

    @GET
    @Path("/getXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getNotificationXML(@PathParam("id") int id) {
        return Response.ok().entity(new Notification(id, "john", "test notification")).build();
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postNotification(Notification notification) {
        return Response.status(201).entity(true).build();
    }
}
