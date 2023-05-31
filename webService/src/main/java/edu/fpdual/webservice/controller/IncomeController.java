package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.persistence.dao.Income;
import edu.fpdual.webservice.model.persistence.manager.impl.IncomeManagerImpl;
import edu.fpdual.webservice.service.IncomeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/income")
public class IncomeController {
    private final IncomeService incomeService;

    public IncomeController() {
        this.incomeService = new IncomeService(new IncomeManagerImpl());
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
            return Response.ok().entity(incomeService.findAllIncomes()).build();
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name/{incomeName}")
    public Response findByIncomeName(@PathParam("incomeName") String incomeName) {
        try {
            if (incomeName == null) {
                return Response.ok().entity(incomeService.findAllIncomes()).build();
            } else {
                if (incomeService.findByIncomeName(incomeName).getIncomeId() <= 0) {
                    return Response.status(400).entity("Income Not Found"). build();
                }
                return Response.ok().entity(incomeService.findByIncomeName(incomeName)).build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(400).entity("Internal Error During DB Interaction").build();
        }
    }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateIncome (Income income) {
        try {
            Income incomeToUpdate = incomeService.findByIncomeName(income.getIncomeName());
            if (incomeToUpdate != null) {
                if (incomeService.updateIncome(income)) {
                    return Response.status(200).entity(incomeService.findByIncomeName(income.getIncomeName())).build();
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
    public Response createIncome (Income income) {
        try {
            if (incomeService.findByIncomeName(income.getIncomeName()) != null) {
                //FALTARÍA PONER LA HORA SI LA AÑADIMOS
                if (incomeService.createIncome(income)) {
                    return Response.status(200).entity("Income created.").build();
                } else {
                    return Response.status(400).entity("Income not created.").build();
                }
            } else {
                return Response.status(400).entity("Income already exist.").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteIncome(Income income) {
        try {
            if (incomeService.findByIncomeName(income.getIncomeName()) != null) {
                if (incomeService.deleteIncome(income)) {
                    return Response.status(200).entity(income).build();
                } else {
                    return Response.status(400).entity("Income Was Not Deleted").build();
                }
            } else {
                return Response.status(400).entity("Income Not Found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

}
