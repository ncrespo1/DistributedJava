package us.ncrespo.fruit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class AddToCartController extends HttpServlet {


    static int cookieCounter = 1;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Enumeration paramNames = request.getParameterNames();
        String paramName;
        String theOrder = "";
        while (paramNames.hasMoreElements()) {
            paramName = (String) paramNames.nextElement();
            if (paramName.equals("cartItem")) {
                String[] paramValues = request.getParameterValues(paramName);
                // Read single valued data
                if (paramValues.length == 1) {
                    String paramValue = paramValues[0];
                    if (paramValue.length() == 0)
                        theOrder += "Empty Cart";
                    else
                        theOrder += paramValue;
                } else {
                    for (int i = 0; i < paramValues.length; i++) {
                        theOrder += paramValues[i] + ",";
                    }
                    theOrder = theOrder.substring(0, theOrder.length() - 1);
                }
            }
        }
        Cookie items = new Cookie("cartItem" + cookieCounter++, theOrder);
        // Expiration Date
        items.setMaxAge(60 * 60 * 24);
        response.addCookie(items);

        String site = new String("fruit");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);

    }
}

