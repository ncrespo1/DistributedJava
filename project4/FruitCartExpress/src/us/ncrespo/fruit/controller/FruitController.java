package us.ncrespo.fruit.controller;

import us.ncrespo.fruit.model.FruitCatalog;
import us.ncrespo.fruit.model.FruitItems;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FruitController extends HttpServlet {
    private static final String RESULT_PAGE = "products.jsp";

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method. Not currently used.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        FruitCatalog testModel = new FruitCatalog();
        List<FruitItems> testList = testModel.getFruitItems();
        request.setAttribute("fruitSomething", testList);

        RequestDispatcher view = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }
}
