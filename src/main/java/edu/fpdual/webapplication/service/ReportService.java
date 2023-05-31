package edu.fpdual.webapplication.service;

import edu.fpdual.webapplication.client.ReportClient;
import edu.fpdual.webapplication.dto.Report;

import java.util.List;

public class ReportService {
    private final ReportClient reportClient;

    public ReportService(ReportClient reportClient) {
        this.reportClient = reportClient;
    }

    public String ping() {
        return reportClient.ping();
    }

    public List<Report> getAllReports() {
        return reportClient.get();
    }

    public Report getReport(String reportName) {
        return reportClient.get(reportName);
    }

    public boolean updateReport(Report report) {
        return reportClient.put(report);
    }

    public boolean createReport(Report report) {
        return reportClient.post(report);
    }

    public boolean deleteReport(Report report) {
        return reportClient.delete(report);
    }
}
