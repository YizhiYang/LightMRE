/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DBWorks.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MATT
 */
public class AddEmployee extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddEmployee</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddEmployee at " + request.getParameter("lastName") + "</h1>");
            out.println("<h1>Servlet AddEmployee at " + request.getParameter("firstName") + "</h1>");
            out.println("<h1>Servlet AddEmployee at " + request.getParameter("SSN") + "</h1>");
            out.println("<h1>Servlet AddEmployee at " + request.getParameter("phoneNumber") + "</h1>");
            out.println("<h1>Servlet AddEmployee at " + request.getParameter("address") + "</h1>");
            out.println("<h1>Servlet AddEmployee at " + request.getParameter("city") + "</h1>");
            out.println("<h1>Servlet AddEmployee at " + request.getParameter("state") + "</h1>");
            out.println("<h1>Servlet AddEmployee at " + request.getParameter("zip") + "</h1>");
            out.println("<h1>Servlet AddEmployee at " + request.getParameter("date") + "</h1>");
            out.println("<h1>Servlet AddEmployee at " + request.getParameter("rate") + "</h1>");       
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//            DBConnection DBConnect = new DBConnection();
//            
//            String lastName = (String)request.getParameter("lastName");
//            String firstName = (String)request.getParameter("firstName");
//            String SSN = (String)request.getParameter("SSN");
//            String phoneNumber = (String)request.getParameter("phoneNumber");
//            String address = (String)request.getParameter("address");
//            String city = (String)request.getParameter("city");
//            String state = (String)request.getParameter("state");
//            String zip = (String)request.getParameter("zip");
//            String date = (String)request.getParameter("date");
//            String rate = (String)request.getParameter("rate");
//            
//            DBConnect.addEmployee(SSN, lastName, firstName, address, city, state, zip, phoneNumber, "2017-10-01", "15", "fakeEmployee", "123", "1");
            

            processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
