package edu.fpdual.webapplication.servlet;


import edu.fpdual.webapplication.client.CategoryClient;
import edu.fpdual.webapplication.dto.Category;
import edu.fpdual.webapplication.dto.Expense;
import edu.fpdual.webapplication.service.CategoryService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateExpenseServlet", urlPatterns = {"/create-expense-servlet"})
public class CreateExpenseServlet extends HttpServlet {
    private CategoryService categoryService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        categoryService = new CategoryService(new CategoryClient());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> categoryList = categoryService.getAllCategories();
        request.getSession().setAttribute("categoryList", categoryList);
        response.sendRedirect("/ProyectoPrueba/jsp/common/addExpense.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Expense expense = (Expense) request.getSession().getAttribute("newExpense");
        //Cómo cojo el budgetId??


    }

}
