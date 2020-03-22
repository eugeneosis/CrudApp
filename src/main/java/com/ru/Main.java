package com.ru;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/index")
public class Main extends HttpServlet {
    public static String test() {
        return "It's a test page.";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Integer userCount = (Integer) session.getAttribute("userCount");

        if (userCount == null) {
            session.setAttribute("userCount", 1);
            userCount = 1;
        } else {
            session.setAttribute("userCount", userCount + 1);
        }

        Cookie cookie = new Cookie("user_id", "user_1");
        cookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(cookie);

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);


    }
}
