package us.ncrespo.fruit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BillController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookieList = request.getCookies();
        for (Cookie c : cookieList) {
            c.setValue("");
            c.setPath("/");
            c.setMaxAge(0);
            response.addCookie(c);
        }
        response.sendRedirect("fruit");

    }
}
