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

@WebServlet("/delete")
public class DeletedServlet extends HttpServlet {
    private static final String query = "delete from users where user_id=?";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:*****/users_db", "*****", "*****");
            PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            int row = ps.executeUpdate();
            out.println("<html><head><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB\" crossorigin=\"anonymous\"></head><body>");
            if(row == 1) {
                out.println("<h2>Удаление прошло успешно!</h2>");
            } else {
                out.println("<h2>Удаление не удалось</h2>");
            }
        } catch (SQLException e){
            e.printStackTrace();
            out.println("<h2>" + e.getMessage() + "</h2>");
        }
        out.println("<br><a href='home.html'>Главая</a>");
        out.println("<br><a href='look-all'>Список пользователей</a>");
        out.println("</body></html>");
    }
}
