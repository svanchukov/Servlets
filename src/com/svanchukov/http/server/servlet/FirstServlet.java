package com.svanchukov.http.server.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var nigerValue = req.getParameter("nigger");
        var parameterMap = req.getParameterMap();
        System.out.println();

        resp.setContentType("text/html");
        try (var writer = resp.getWriter()) {
            writer.write("<h1>Hello from First Servlet</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (var reader = req.getReader();
            var lines = reader.lines()) {
            lines.forEach(System.out::println);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
