package edu.wctc.simple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "SimpleServlet")
public class SimpleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<html><head></head><body><h1>Simple Web Page</h1><p>");
//        out.println(request.getParameter("message"));
        Students theStudents = new Students();

        ArrayList<Individual> result;

            switch(request.getParameter("column")) {
                case "ACCTNUM":
                    result = theStudents.findStudents(FindColumns.ACCTNUM, request.getParameter("search"));
                    for (Individual i: result) {
                        out.println(i.getAccountNumber() + " " + i.getFname() + " " + i.getLname() + "<br>");
                    }
                    break;
                case "LNAME":
                    result = theStudents.findStudents(FindColumns.LNAME, request.getParameter("search"));
                    for (Individual i: result) {
                        out.println(i.getAccountNumber() + " " + i.getLname() + "<br>");
                    }
                    break;
                case "FNAME":
                    result = theStudents.findStudents(FindColumns.FNAME, request.getParameter("search"));
                    for (Individual i: result) {
                        out.println(i.getAccountNumber() + " " + i.getFname() + "<br>");
                    }
                    break;
                case "EMAIL":
                    result = theStudents.findStudents(FindColumns.EMAIL, request.getParameter("search"));
                    for (Individual i: result) {
                        out.println(i.getAccountNumber() + " " + i.getEmail() + "<br>");
                    }
                    break;
                case "IPADDR":
                    result = theStudents.findStudents(FindColumns.IPADDR, request.getParameter("search"));
                    for (Individual i: result) {
                        out.println(i.getAccountNumber() + " " + i.getIpAddress() + "<br>");
                    }
                    break;
                default: out.println("This broke"); break;
            }


        out.println("</p></body></html>");
    }


}