package edu.fpdual.webapplication.client;


import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.client.dto.Budget;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class BudgetClient extends Client<Budget> {
    private final WebTarget webTarget;
    private final String clientPath = "budget/";

    public BudgetClient() {
        jakarta.ws.rs.client.Client client = ClientBuilder.newClient();
        this.webTarget = client.target(GlobalInfo.URL_WEBTARGET);
    }

    @Override
    public String ping() {
        return webTarget.path(clientPath + "ping")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    @Override
    public Budget get(String budgetName) {
        return webTarget.path(clientPath + "get" + budgetName)
                .request(MediaType.APPLICATION_JSON)
                .get(Budget.class);
    }

    public List<Budget> get() {
        return webTarget.path(clientPath + "get/all")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<>() {
                });
    }

    @Override
    public boolean put(Budget budget) {
        return webTarget.path(clientPath + "put")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(budget, MediaType.APPLICATION_JSON), boolean.class);
    }

    @Override
    public boolean post(Budget budget) {
        return webTarget.path(clientPath + "post")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(budget, MediaType.APPLICATION_JSON), boolean.class);
    }

    @Override
    public boolean delete(Budget budget) {
        return webTarget.path(clientPath + "delete")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(budget, MediaType.APPLICATION_JSON), boolean.class);
    }
}

