package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.persistence.dao.Expense;
import edu.fpdual.webservice.model.persistence.manager.impl.ExpenseManagerImpl;
import edu.fpdual.webservice.service.ExpenseService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController() {
        this.expenseService = new ExpenseService(new ExpenseManagerImpl());
    }

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response findAll() {
        try {
            return Response.ok().entity(expenseService.findAllExpenses()).build();
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name/{expenseName}")
    public Response findByExpenseName(@PathParam("expenseName") String expenseName) {
        try {
            if (expenseName == null) {
                return Response.ok().entity(expenseService.findAllExpenses()).build();
            } else {
                if (expenseService.findByExpenseName(expenseName).getExpenseId() <= 0) {
                    return Response.status(400).entity("Expense Not Found").build();
                }
                return Response.ok().entity(expenseService.findByExpenseName(expenseName)).build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(400).entity("Internal Error During DB Interaction").build();
        }
    }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateIncome(Expense expense) {
        try {
            Expense expenseToUpdate = expenseService.findByExpenseName(expense.getExpenseName());
            if (expenseToUpdate != null) {
                if (expenseService.updateExpense(expense)) {
                    return Response.status(200).entity(expenseService.findByExpenseName(expense.getExpenseName())).build();
                } else {
                    return Response.status(400).entity("Internal Error During Budget Update").build();
                }
            } else {
                return Response.status(400).entity("Income Not Found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(400).entity("Internal Error During DB Interaction").build();
        }
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createExpense(Expense expense) {
        try {
            if (expenseService.findByExpenseName(expense.getExpenseName()) != null) {
                //FALTARÍA PONER LA HORA SI LA AÑADIMOS
                if (expenseService.createExpense(expense)) {
                    return Response.status(200).entity("Expense created.").build();
                } else {
                    return Response.status(400).entity("Expense not created.").build();
                }
            } else {
                return Response.status(400).entity("Expense already exist.").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteExpense(Expense expense) {
        try {
            if (expenseService.findByExpenseName(expense.getExpenseName()) != null) {
                if (expenseService.deleteExpense(expense)) {
                    return Response.status(200).entity(expense).build();
                } else {
                    return Response.status(400).entity("Expense Was Not Deleted").build();
                }
            } else {
                return Response.status(400).entity("Expense Not Found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }
}
