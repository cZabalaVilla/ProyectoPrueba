package edu.fpdual.webapplication.servlet;


import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.client.BudgetClient;
import edu.fpdual.webapplication.client.IncomeClient;
import edu.fpdual.webapplication.dto.Budget;
import edu.fpdual.webapplication.dto.Income;
import edu.fpdual.webapplication.service.BudgetService;
import edu.fpdual.webapplication.service.IncomeService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name= "DeleteIncomeServlet", urlPatterns = {"/delete-income-servlet"})
public class DeleteIncomeServlet extends HttpServlet {
    private IncomeService incomeService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        incomeService = new IncomeService(new IncomeClient());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ok = "Presupuesto Borrado.";
        String error = "No se ha podido borrar el presupuesto.";

        int incomeId = Integer.parseInt(request.getParameter("deleteBtn"));
        Income income = incomeService.getIncomeById(incomeId);

        if (new IncomeService(new IncomeClient()).deleteIncome(income)) {
            request.setAttribute("ok", ok);
            response.sendRedirect(GlobalInfo.URL_JSP_SUCCESS2);
        } else {
            System.out.println("Else error");
            request.setAttribute("error",error);
            request.getRequestDispatcher(GlobalInfo.URL_JSP_BUDGETDATA).forward(request, response);
        }
    }
}
