package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.client.BudgetClient;
import edu.fpdual.webapplication.dto.Budget;
import edu.fpdual.webapplication.service.BudgetService;
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

//        int budgetId = Integer.parseInt(request.getParameter("submitBtn"));
//        Budget budget = budgetService.getBudgetById(budgetId);
//        request.getSession().setAttribute("budget", budget);
//        response.sendRedirect("/ProyectoPrueba/jsp/common/budgetData.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
