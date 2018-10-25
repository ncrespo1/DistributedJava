package us.ncrespo.fruit.controller;

import us.ncrespo.fruit.model.FruitCatalog;
import us.ncrespo.fruit.model.FruitItems;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


public class CartController extends HttpServlet {
    private static final String RESULT_PAGE = "cart.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        //String cookieVal = "";
        Cookie[] cookies = null;


        cookies = request.getCookies();
        ArrayList<String> cookieStringValues = new ArrayList<>();
        for (Cookie c : cookies) {

            if (c.getName().equals("JSESSIONID")) {
                System.out.println("SESSION ID: " + c.getValue());
            }
            else if (c.getName().substring(0, 8).equals("cartItem")) {
                cookieStringValues.add(c.getValue());
            } else {
                System.out.println("I SUCK AT THIS");
            }
        }
        System.out.println(cookieStringValues.toString());

        FruitItems fruit = new FruitItems(0, "", 0.0, "","");



        List<FruitItems> orderedFruit = new ArrayList();
        //int testCount = 0;
        for (String s : cookieStringValues) {

            System.out.println(s);
            orderedFruit.add(getOrderedItems(s));

        }


        System.out.println(orderedFruit);
        request.setAttribute("cartItems", orderedFruit);
        RequestDispatcher view = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }

    private FruitItems getOrderedItems(String itemNumber) {
        FruitCatalog cart = new FruitCatalog();
        return cart.getSingleItem(Integer.parseInt(itemNumber));
    }

}

