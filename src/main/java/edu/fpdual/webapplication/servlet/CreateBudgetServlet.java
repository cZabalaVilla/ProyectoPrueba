package edu.fpdual.webapplication.servlet;


import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.client.BudgetClient;
import edu.fpdual.webapplication.client.CurrencyClient;
import edu.fpdual.webapplication.dto.Budget;
import edu.fpdual.webapplication.dto.Currency;
import edu.fpdual.webapplication.service.BudgetService;
import edu.fpdual.webapplication.service.CurrencyService;
import edu.fpdual.webapplication.servlet.dto.Session;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



@WebServlet(name = "CreateBudgetServlet", urlPatterns = {"/create-budget-servlet"})
public class CreateBudgetServlet extends HttpServlet {
    private CurrencyService currencyService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        currencyService = new CurrencyService(new CurrencyClient());
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Currency> currencyList = currencyService.getAllCurrency();
        request.getSession().setAttribute("currencyList", currencyList);
        response.sendRedirect("/ProyectoPrueba/jsp/common/addBudget.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ok = "Presupuesto Creado.";
        String error = "No se ha podido crear el presupuesto.";
        String dispatcherURLBudget = "jsp/common/success.jsp";

        Budget budget = (Budget) request.getSession().getAttribute("newBudget");
        try {
            Session session = (Session) request.getSession().getAttribute(GlobalInfo.session);
            int userIdSession = session.getUserId();
            String nombreIntroducido = request.getParameter("budgetNameInput");

            if (session != null && nombreIntroducido != null) {

                budget = budget.builder()
                        .userId(userIdSession)
                        .budgetName(request.getParameter("budgetNameInput"))
                        .description(request.getParameter("budgetDescInput"))
                        .currencyId(Integer.parseInt(request.getParameter("currencyInput"))).build();
                System.out.println(budget);

                if (new BudgetService(new BudgetClient()).createBudget(budget)) {
                    System.out.println("Se ha insertado en la bbdd");
                    request.setAttribute("ok", ok);
                    response.sendRedirect("/ProyectoPrueba/common/success.jsp");
                } else {
                    System.out.println("Else error");
                    request.setAttribute("error",error);
                    request.getRequestDispatcher("/ProyectoPrueba/common/addBudget.jsp").forward(request, response);
                    //request.setAttribute("error", error);
                    //request.getRequestDispatcher(dispatcherURLBudget).forward(request, response);
                }

                //request.getSession().setAttribute("newBudget", budget);
                //request.getRequestDispatcher(dispatcherURLBudget).forward(request, response);
            }

        } catch (ServletException e) {
            request.setAttribute("error", error);
            e.printStackTrace();
        }
    }
}
