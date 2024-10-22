package ru.svanchukov.tomcat.myservletsproject.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.svanchukov.tomcat.myservletsproject.service.AdminService;

import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private final AdminService adminService = AdminService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Обработка GET-запроса
        System.out.println("doGet method called");
        resp.setContentType("text/html");
        resp.getWriter().write("<html><body><h1>Admin Page</h1>");
        resp.getWriter().write("<form action=\"/admin\" method=\"post\">");
        resp.getWriter().write("<input type=\"hidden\" name=\"action\" value=\"delete\">");
        resp.getWriter().write("<label for=\"userId\">User ID:</label>");
        resp.getWriter().write("<input type=\"text\" id=\"userId\" name=\"userId\">");
        resp.getWriter().write("<button type=\"submit\">Delete User</button>");
        resp.getWriter().write("</form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String userIdStr = req.getParameter("userId");

        if ("delete".equals(action) && userIdStr != null) {
            try {
                Integer userId = Integer.parseInt(userIdStr);
                boolean isDeleted = adminService.deleteUser(userId);

                if (isDeleted) {
                    resp.getWriter().write("User deleted successfully.");
                } else {
                    resp.getWriter().write("User not found.");
                }
            } catch (NumberFormatException e) {
                resp.getWriter().write("Invalid user ID.");
            }
        } else {
            resp.getWriter().write("Invalid action or user ID.");
        }
    }
}
