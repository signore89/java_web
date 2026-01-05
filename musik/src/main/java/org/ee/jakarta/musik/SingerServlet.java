package org.ee.jakarta.musik;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.ee.jakarta.musik.dao.SingerDao;
import org.ee.jakarta.musik.db.DBConnect;
import org.ee.jakarta.musik.entity.Singer;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class SingerServlet extends HttpServlet {
    private SingerDao singerDao;

    public void init() {
        singerDao = new SingerDao(DBConnect.getConn());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        try {
            List<Singer> artists = singerDao.getAllSingers();
            request.setAttribute("artists", artists);
            request.getRequestDispatcher("/artists.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Ошибка получения данных", e);
        }
    }

    public void destroy() {
    }
}