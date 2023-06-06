package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.client.BudgetClient;
import edu.fpdual.webapplication.client.ProfileClient;
import edu.fpdual.webapplication.dto.Budget;
import edu.fpdual.webapplication.dto.Profile;
import edu.fpdual.webapplication.service.BudgetService;
import edu.fpdual.webapplication.service.ProfileService;
import edu.fpdual.webapplication.servlet.dto.Session;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BudgetDataServlet", urlPatterns = {"/see-budget"})
public class BudgetDataServlet extends HttpServlet {
    private BudgetService budgetService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        budgetService = new BudgetService(new BudgetClient());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String budgetName = request.getParameter("budgetName");
        Budget budget = budgetService.getBudget(budgetName);
        request.getSession().setAttribute("budget", budget);
        response.sendRedirect("/ProyectoPrueba/jsp/common/budgetData.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
