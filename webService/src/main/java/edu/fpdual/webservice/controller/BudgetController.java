package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.persistence.dao.Budget;
import edu.fpdual.webservice.model.persistence.dao.User;
import edu.fpdual.webservice.model.persistence.manager.impl.BudgetManagerImpl;
import edu.fpdual.webservice.service.BudgetService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.SQLException;

@Path("/budget")
public class BudgetController {



    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }
    /*
    //Inicializado a null, CAMBIAR.
    private final Connection con = null;
    private final BudgetService budgetService;

    public BudgetController() {
        this.budgetService = new BudgetService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws SQLException, ClassNotFoundException //JsonProcessingException
    {
        return Response.ok().entity(budgetService.findAll(con)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{findBudgetName}")
    public Response findByBudgetName(@PathParam("findBudgetName") String budgetName) {
        try {
            if (budgetName == null) {
                return Response.status(400).entity("Incorrect Parameters").build();
            } else {
                return Response.ok().entity(budgetService.findByBudgetName(budgetName)).build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @DELETE
    @Path("/{delBudgetName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBudget(@PathParam("delBudgetName") String budgetName) {
        try {
            Budget budgetToDelete = budgetService.findByBudgetName(budgetName);
            if (budgetToDelete != null) {
                if (budgetService.deleteBudget(budgetToDelete)) {
                    return Response.status(200).entity(budgetToDelete).build();
                } else {
                    return Response.status(304).entity("Budget Was Not Deleted").build();
                }
            } else {
                return Response.status(404).entity("Budget Not Found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBudget(Budget budget) {
        try {
            Budget budgetToUpdate = budgetService.findByBudgetName(budget.getBudgetName());
            if (budgetToUpdate != null) {
                int createdId = budgetService.createBudget(budget);
                //?????????? Tiene que igualar al número de atributos??
                if (createdId == 3// >0 en un principio pero como son tres campos == 3
                ) {

                    return Response.status(201).entity(budgetService.findByBudgetName(budget.getBudgetName())).build();
                } else {
                    return Response.status(500).entity("Internal Error During Creating The Budget").build();
                }
            } else {
                return Response.status(500).entity("Internal Error During Creating The Budget. Budget already exists.").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBudget(Budget budget) {
        try {
            Budget budgetToUpdate = budgetService.findByBudgetName(budget.getBudgetName());
            if (budgetToUpdate != null) {
                if (budgetService.updateBudget(budget)) {
                    return Response.status(200).entity(budgetService.findByBudgetName(budget.getBudgetName())).build();
                } else {
                    return Response.status(500).entity("Internal Error During Budget Update").build();
                }
            } else {
                return Response.status(404).entity("Budget Not Found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }
    */
}
