package com.example.teach;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "subjectServlet", value = "/subjects")
public class SubjectServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Subjects!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher view = getServletContext().getRequestDispatcher("/views/subject.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    public void destroy() {
    }
}