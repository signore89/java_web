package org.ee.jakarta.users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/look-all")
public class LookAllServlet extends HttpServlet {
    private static final String query = "select * from users";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:****/users_db", "*****", "*****");
            PreparedStatement ps = connection.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            out.println("<html><head><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB\" crossorigin=\"anonymous\"></head><body><table class='table'>");
            out.println("<thead>\n" +
                    "    <tr>\n" +
                    "      <th scope=\"col\">id</th>\n" +
                    "      <th scope=\"col\">Имя</th>\n" +
                    "      <th scope=\"col\">Фамилия</th>\n" +
                    "      <th scope=\"col\">Выполнить операцию</th>\n" +
                    "    </tr>\n" +
                    "  </thead>");
            out.println("<tbody>");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<th scope = \"row\">" + rs.getInt(1) + "</th>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("<td><a href='delete?id=" + rs.getInt(1) + "'>Удалить</a></td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h2>" + e.getMessage() + "</h2>");
        }
        out.println("<br><a href='home.html'>Главая</a>");
        out.println("</table></body></html>");
    }
}
