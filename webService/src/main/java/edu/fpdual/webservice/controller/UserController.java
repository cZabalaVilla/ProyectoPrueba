package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.persistence.dao.User;
import edu.fpdual.webservice.model.persistence.manager.impl.UserManagerImpl;
import edu.fpdual.webservice.service.UserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.SQLException;

@Path("/user")
public class UserController {
    //Inicializado a null, cambiar
    private final Connection con = null;
    private final UserService userService;

    public UserController() {
        this.userService = new UserService(new UserManagerImpl());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws SQLException, ClassNotFoundException //JsonProcessingException
    {
        return Response.ok().entity(userService.findAll(con)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{findUserName}")
    public Response findByUserName(@PathParam("findUserName") String userName) {
        try {
            if (userName == null) {
                return Response.status(400).entity("Incorrect Parameters").build();
            } else {
                return Response.ok().entity(userService.findByUserName(userName)).build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @DELETE
    @Path("/{delUserName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("delUserName") String userName) {
        try {
            User userToDelete = userService.findByUserName(userName);
            if (userToDelete != null) {
                if (userService.deleteUser(userToDelete)) {
                    return Response.status(200).entity(userToDelete).build();
                } else {
                    return Response.status(304).entity("User Was Not Deleted").build();
                }
            } else {
                return Response.status(404).entity("User Not Found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        try {
            User userToUpdate = userService.findByUserName(user.getUserName());
            if (userToUpdate != null) {
                int createdId = userService.createUser(user);

                if (createdId == 3/* >0 en un principio pero como son tres campos == 3*/) {
                    return Response.status(201).entity(userService.findByUserName(user.getUserName())).build();
                } else {
                    return Response.status(500).entity("Internal Error During Creating The User").build();
                }
            } else {
                return Response.status(500).entity("Internal Error During Creating The User. User already exists.").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        try {
            User userToUpdate = userService.findByUserName(user.getUserName());
            if (userToUpdate != null) {
                if (userService.updateUser(user)) {
                    return Response.status(200).entity(userService.findByUserName(user.getUserName())).build();
                } else {
                    return Response.status(500).entity("Internal Error During City Update").build();
                }
            } else {
                return Response.status(404).entity("City Not Found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }
}

