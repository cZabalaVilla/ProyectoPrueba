package edu.fpdual.webapplication.client;

import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.dto.Report;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class ReportClient extends Client<Report> {

    private final WebTarget webTarget;
    private final String clientPath = "report/";

    public ReportClient() {
        jakarta.ws.rs.client.Client client = ClientBuilder.newClient();
        this.webTarget = client.target(GlobalInfo.URL_WEBTARGET);
    }

    @Override
    public String ping() {
        return webTarget.path(clientPath + "ping")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public List<Report> get() {
        return webTarget.path(clientPath + "get/all")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<>() {
                });
    }

    public Report get(String userId) {
        return webTarget.path(clientPath + "get/" + userId)
                .request(MediaType.APPLICATION_JSON)
                .get(Report.class);
    }

    @Override
    public boolean put(Report profile) {
        return webTarget.path(clientPath + "put")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(profile, MediaType.APPLICATION_JSON), boolean.class);
    }

    @Override
    public boolean post(Report report) {
        return webTarget.path(clientPath + "post")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(report, MediaType.APPLICATION_JSON), boolean.class);
    }

    @Override
    public boolean delete(Report report) {
        return webTarget.path(clientPath + "delete")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(report, MediaType.APPLICATION_JSON), boolean.class);
    }
}
