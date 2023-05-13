package com.example.teach;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    String insert_subject = "INSERT INTO subject (name, type) VALUES(?, ?)";
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            EmpConnBuilder builder = new EmpConnBuilder();

            try (Connection conn = builder.getConnection()) {
                String name = request.getParameter("name");
                String type = request.getParameter("type");

                Subject newSubject = new Subject(name, type);
                try (PreparedStatement preparedStatement = conn.prepareStatement(insert_subject)) {
                    preparedStatement.setString(
                            1, newSubject.getName());
                    preparedStatement.setString(
                            2, newSubject.getType());
                    preparedStatement.executeUpdate();
                } catch (Exception e) {
                    System.out.println(e);
                }
            } catch (Exception e) {
                System.out.println(e);
                RequestDispatcher view = getServletContext().getRequestDispatcher("/views/subject.jsp");
                view.forward(request, response);
            }
            doGet(request, response);
    }
    public void destroy() {
    }
}