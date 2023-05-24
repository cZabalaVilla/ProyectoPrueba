package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.persistence.dao.Budget;
import edu.fpdual.webservice.model.persistence.manager.impl.BudgetManagerImpl;
import edu.fpdual.webservice.service.BudgetService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/budget")
public class BudgetController {
    private final BudgetService budgetService;

    public BudgetController() {
        this.budgetService = new BudgetService(new BudgetManagerImpl());
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
        try  {
            return Response.ok().entity(budgetService.findAll()).build();
        }catch (SQLException | ClassNotFoundException e) {
            return Response.status(400).entity("Internal Error During DB Interaction").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{budgetName}")
    public Response findByBudgetName(@PathParam("budgetName") String budgetName) {
        try {
            if (budgetName == null) {
                return Response.status(400).entity("Incorrect Parameters").build();
            } else {
                if (budgetService.findByBudgetName(budgetName).getBudgetId() <= 0) {
                    return Response.status(400).entity("Budget Not Found").build();
                }
                return Response.ok().entity(budgetService.findByBudgetName(budgetName)).build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(400).entity("Internal Error During DB Interaction").build();
        }
    }

    @PUT
    @Path("/put")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBudget(Budget budget) {
        try {
            Budget budgetToUpdate = budgetService.findByBudgetName(budget.getBudgetName());
            if (budgetToUpdate != null) {
                if (budgetService.updateBudget(budget)) {
                    return Response.status(200).entity(budgetService.findByBudgetName(budget.getBudgetName())).build();
                } else {
                    return Response.status(400).entity("Internal Error During Budget Update").build();
                }
            } else {
                return Response.status(400).entity("Budget Not Found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(400).entity("Internal Error During DB Interaction").build();
        }
    }
    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBudget (Budget budget) {
        try {
            if (findByBudgetName(budget.getBudgetName()) != null) {
                //AÑADIR ESTO CUANDO DEJE DE DAR PROBLEMA EN EL OTRO SITIO
                // budget.getIncomeList(), budget.getExpenseList(), budget.getCreationDate())
                if (budgetService.createBudget(budget.getBudgetName().toLowerCase(), budget.getDescription())) {
                    return Response.status(200).entity("Budget created.").build();
                } else {
                    return Response.status(400).entity("Budget not created.").build();
                }
            } else {
                return Response.status(400).entity("Budget already exist.").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteBudget(Budget budget) {
        try {
            if (findByBudgetName(budget.getBudgetName()) != null) {
                if (budgetService.deleteBudget(budget)) {
                    return Response.status(200).entity(budget).build();
                } else {
                    return Response.status(400).entity("Budget Was Not Deleted").build();
                }
            } else {
                return Response.status(400).entity("Budget Not Found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    /*@POST
    @Path("/create/{budgetName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBudget(@PathParam("budgetName") String budgetName) {
        try {
            Budget budgetToUpdate = budgetService.findByBudgetName(budgetName);
            //int nCampos = ;
            if (budgetToUpdate != null) {
                boolean createdId = true; //budgetService.createBudget(budgetName.toLowerCase());
                if (createdId) {
                    return Response.status(200).entity(budgetService.findByBudgetName(budgetName)).build();
                } else {
                    return Response.status(400).entity("Internal Error During Creating The Budget").build();
                }
            } else {
                return Response.status(400).entity("Internal Error During Creating The Budget. Budget already exists.").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }*/



}
