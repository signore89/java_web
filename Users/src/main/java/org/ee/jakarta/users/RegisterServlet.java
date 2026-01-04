package org.ee.jakarta.users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final String query = "insert into users(name,surname) values(?,?)";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String userName = req.getParameter("name");
        String userSurname = req.getParameter("surname");

        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:*****/users_db", "****", "****");
            PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, userName);
            ps.setString(2, userSurname);

            int row = ps.executeUpdate();
            if(row == 1){
                out.println("<h2>Пользователь зарегистрирован</h2>");
            }else{
                out.println("<h2>Регистрация пользователя не удалась</h2>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h2>" + e.getMessage() + "</h2>");
        }
    }
}
