package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.client.CategoryClient;
import edu.fpdual.webapplication.client.UserClient;
import edu.fpdual.webapplication.dto.Category;
import edu.fpdual.webapplication.dto.User;
import edu.fpdual.webapplication.service.CategoryService;
import edu.fpdual.webapplication.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListsServlet", urlPatterns = {"/lists-servlet"})
public class ListsServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> objectList = switch (request.getParameter("classType")) {
            case "user" -> getUserList();
            case "category" -> getCategoryList();
            default -> null;
        };
        request.setAttribute("error", "No hay nada en esta lista.");
        request.setAttribute("objectList", objectList);
        request.getRequestDispatcher("jsp/admin/database/lists.jsp").forward(request, response);
    }

    private List<String> getUserList() {
        UserService userService = new UserService(new UserClient());
        List<User> users = userService.getAllUsers();
        List<String> userList = new ArrayList<>();
        for (User user : users) {
            userList.add(user.toString());
        }
        return userList;
    }

    private List<String> getCategoryList() {
        CategoryService categoryService = new CategoryService(new CategoryClient());
        List<Category> categories = categoryService.getAllCategories();
        List<String> categoryList = new ArrayList<String>();
        for (Category category : categories) {
            categoryList.add(category.toString());
        }
        return categoryList;
    }


/*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        List<User> users = new UserClient().get();
        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("<table style=\"border: 1px solid black;" +
                "  border-collapse: collapse;\">");
        for (User user : users) {
            writer.println("<tr><td>");
            writer.println(user.toString());
            writer.println("</td></tr>");
        }
        writer.println("</table>");
        writer.println("</br></br>");
        writer.println("<button onclick=\"location.href='\\index.jsp'\">Volver al inicio</button>");
        writer.println("</body>");
        writer.println("</html>");
    }*/
}
