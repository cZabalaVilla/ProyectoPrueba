package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.client.BudgetClient;
import edu.fpdual.webapplication.service.BudgetService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteBudgetServlet", urlPatterns = {"/delete-budget-servlet"})
public class DeleteBudgetServlet extends HttpServlet {
    private BudgetService budgetService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        budgetService = new BudgetService(new BudgetClient());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Budget budget = (Budget) request.getSession().getAttribute("newBudget");
//        budget = budget.builder()
//                .userId()
//                .budgetName(request.getParameter("budgetNameInput"))
//                .description(request.getParameter("budgetDescInput"))
//                .currencyId(Integer.parseInt(request.getParameter("currencyInput"))).build();
        //Cómo cojo los datos del budget para borrarlo ?
        // new BudgetService(new BudgetClient()).deleteBudget(budget);
    }
}
