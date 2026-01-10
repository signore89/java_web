package org.ee.jakarta.musik;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.ee.jakarta.musik.dao.UserDao;
import org.ee.jakarta.musik.db.DBConnect;
import org.ee.jakarta.musik.entity.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        UserDao userDao = new UserDao(DBConnect.getConn());
        User user = userDao.login(name, password);
        if (user != null) {
            session.setAttribute("userObj", user);
            resp.sendRedirect("/home");
        } else {
            session.setAttribute("errorMsg", "Некорректный имя или пароль");
            resp.sendRedirect("user_login.jsp");
        }
    }
}
