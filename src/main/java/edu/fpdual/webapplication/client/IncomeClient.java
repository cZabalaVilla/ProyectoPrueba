package edu.fpdual.webapplication.client;

import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.dto.Income;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class IncomeClient extends Client<Income> {
    private final WebTarget webTarget;
    private final String clientPath = "budget/income/";

    public IncomeClient() {
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
    public Income get(String incomeName) {
        return webTarget.path(clientPath + "get" + incomeName)
                .request(MediaType.APPLICATION_JSON)
                .get(Income.class);
    }

    public List<Income> get() {
        return webTarget.path(clientPath + "get/all")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<>() {
                });
    }

    @Override
    public boolean put(Income income) {
        return webTarget.path(clientPath + "put")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(income, MediaType.APPLICATION_JSON), boolean.class);
    }

    @Override
    public boolean post(Income income) {
        return webTarget.path(clientPath + "post")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(income, MediaType.APPLICATION_JSON), boolean.class);
    }

    @Override
    public boolean delete(Income income) {
        return webTarget.path(clientPath + "delete")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(income, MediaType.APPLICATION_JSON), boolean.class);
    }
}
