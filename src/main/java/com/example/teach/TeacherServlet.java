package com.example.teach;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.ConnectionProperty;
import dao.EmpConnBuilder;
import domain.Subject;
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
    String select_all_teachers = "SELECT id, full_name, academic_title, academic_degree FROM teacher";
    String insert_teachers = "INSERT INTO teacher (full_name, academic_title, academic_degree) VALUES(?, ?, ?)";
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
            ResultSet rs = stmt.executeQuery(select_all_teachers);
            if (rs != null) {
                teachers.clear();
                while (rs.next()) {
                    teachers.add(new Teacher(
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

        EmpConnBuilder builder = new EmpConnBuilder();

        try (Connection conn = builder.getConnection()) {
            String fullName = request.getParameter("fullName");
            String academicDegree = request.getParameter("academicDegree");
            String academicTitle = request.getParameter("academicTitle");

            Teacher newTeacher = new Teacher(fullName, academicTitle, academicDegree);
            try (PreparedStatement preparedStatement = conn.prepareStatement(insert_teachers)) {
                preparedStatement.setString(1, newTeacher.getFullName());
                preparedStatement.setString(2, newTeacher.getAcademicTitle());
                preparedStatement.setString(3, newTeacher.getAcademicDegree());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
            RequestDispatcher view = getServletContext().getRequestDispatcher("/views/teacher.jsp");
            view.forward(request, response);
        }
        doGet(request, response);
    }

    public void destroy() {
    }
}