package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.persistence.dao.Profile;
import edu.fpdual.webservice.model.persistence.dao.User;
import edu.fpdual.webservice.model.persistence.manager.impl.UserManagerImpl;
import edu.fpdual.webservice.service.UserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/user")
public class UserController {
    private final UserService userService;

    //@TODO Añadir Javadoc
    public UserController() {
        this.userService = new UserService(new UserManagerImpl());
    }

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/all")
    public Response findAll() {
        try {
            return Response.ok().entity(userService.findAllUsers()).build();
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/byId/{userId}")
    public Response findByUserId(@PathParam("userId") int userId) {
        try {
            if (userId != 0) {
                return Response.status(400).entity("Incorrect Parameters").build();
            } else {
                if (userService.findByUserId(userId).getUserId() <= 0) {
                    return Response.status(400).entity("User Not Found").build();
                }
                return Response.ok().entity(userService.findByUserId(userId)).build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/byName/{userName}")
    public Response findByUserName(@PathParam("userName") String userName) {
        try {
            if (userName == null) {
                return Response.status(400).entity("Incorrect Parameters").build();
            } else {
                if (userService.findByUserName(userName).getUserId() <= 0) {
                    return Response.status(400).entity("User Not Found").build();
                }
                return Response.ok().entity(userService.findByUserName(userName)).build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }
    @PUT
    @Path("/put")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        try {
            User userToUpdate = userService.findByUserName(user.getUserName());
            if (userToUpdate != null) {
                return Response.status(200).entity(userService.updateUser(user)).build();
            } else {
                return Response.status(400).entity("User Not Found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        try {
            if (findByUserName(user.getUserName()) != null) {
                if (userService.createUser(user.getUserName().toLowerCase(), user.getUserPassword())) {
                    return Response.status(200).entity("User created.").build();
                } else {
                    return Response.status(400).entity("User not created.").build();
                }
            } else {
                return Response.status(400).entity("User already exists.").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction.").build();
        }
    }

    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(User user) {
        try {
            if (findByUserName(user.getUserName()) != null) {
                if (userService.deleteUser(user)) {
                    return Response.status(200).entity(user).build();
                } else {
                    return Response.status(400).entity("User Was Not Deleted.").build();
                }
            } else {
                return Response.status(404).entity("User Not Found.").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }
}