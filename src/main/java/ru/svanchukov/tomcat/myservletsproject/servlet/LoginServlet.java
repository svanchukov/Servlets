package ru.svanchukov.tomcat.myservletsproject.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.svanchukov.tomcat.myservletsproject.service.UserService;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Обработка GET-запроса
        System.out.println("doGet method called");
        resp.setContentType("text/html");
        resp.getWriter().write("<html><body><h2>Login</h2>");
        resp.getWriter().write("<form action=\"/login\" method=\"post\">");
        resp.getWriter().write("<label for=\"username\">Username:</label>");
        resp.getWriter().write("<input type=\"text\" id=\"username\" name=\"username\" required><br><br>");
        resp.getWriter().write("<label for=\"password\">Password:</label>");
        resp.getWriter().write("<input type=\"password\" id=\"password\" name=\"password\" required><br><br>");
        resp.getWriter().write("<button type=\"submit\">Login</button>");
        resp.getWriter().write("</form>");
        resp.getWriter().write("<p>Don't have an account? <a href=\"/registration\">Register here</a></p>");
        resp.getWriter().write("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userService.authenticate(username, password)) {
            resp.sendRedirect("/hello"); // Перенаправление на страницу после успешного входа
        } else {
            req.setAttribute("errorMessage", "Такого пользователя нет, попробуйте ещё раз зарегистрироваться");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp); // Перенаправление на страницу с ошибкой
        }
    }

}

