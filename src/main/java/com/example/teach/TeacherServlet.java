package com.example.teach;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.ConnectionProperty;
import dao.EmpConnBuilder;
import domain.Teacher;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", value = "/teachers")
public class TeacherServlet extends HttpServlet {
    ConnectionProperty prop;
    String select_all_subjects = "SELECT id, full_name, academic_title, academic_degree FROM teacher";
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public TeacherServlet()  throws FileNotFoundException, IOException {
        super();
        prop = new ConnectionProperty();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        EmpConnBuilder builder = new EmpConnBuilder();

        try (Connection conn = builder.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(select_all_subjects);
            if (rs != null) {
                teachers.clear();
                while (rs.next()) {
                    teachers.add(new Teacher(
                            rs.getString("id"),
                            rs.getString("full_name"),
                            rs.getString("academic_title"),
                            rs.getString("academic_degree")));
                }
                rs.close();

                request.setAttribute("teachers", teachers);
                RequestDispatcher view = getServletContext().getRequestDispatcher("/views/teacher.jsp");
                view.forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    public void destroy() {
    }
}