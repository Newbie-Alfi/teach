package com.example.teach;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import dao.ConnectionProperty;
import dao.EmpConnBuilder;
import domain.Subject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "subjectServlet", value = "/subjects")
public class SubjectServlet extends HttpServlet {
    ConnectionProperty prop;
    String select_all_subjects = "SELECT id, name, type FROM subject";
    ArrayList<Subject> subjects = new ArrayList<Subject>();
    String userPath;
    private String message;

    public void init() {
        message = "Subjects!";
    }

    public SubjectServlet()  throws FileNotFoundException, IOException {
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
                subjects.clear();
                while (rs.next()) {
                    subjects.add(new Subject(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("type")));
                }
                rs.close();

                request.setAttribute("subjects", subjects);
                RequestDispatcher view = getServletContext().getRequestDispatcher("/views/subject.jsp");
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