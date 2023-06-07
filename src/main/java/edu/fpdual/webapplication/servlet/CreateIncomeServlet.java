package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.client.CategoryClient;
import edu.fpdual.webapplication.dto.Category;
import edu.fpdual.webapplication.service.CategoryService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateIncomeServlet", urlPatterns = {"/create-income-servlet"})
public class CreateIncomeServlet extends HttpServlet {
    private CategoryService categoryService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        categoryService = new CategoryService(new CategoryClient());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> categoryList = categoryService.getAllCategories();
        request.getSession().setAttribute("categoryList", categoryList);
        response.sendRedirect("/ProyectoPrueba/jsp/common/addIncome.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    }
}
