/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DBWorks.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author huang
 */
public class EditCustomerServlet extends HttpServlet {

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
            out.println("<title>Servlet EditCustomerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditCustomerServlet at " + request.getParameter("CustomerId") + "</h1>");
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
        try {

            DBConnection DBConnect = new DBConnection();
            if (DBConnect.connectDB() == false) {
                processRequest(request, response);
            }
            ResultSet rs = null;

            rs = DBConnect.getCustomerForEdit(request.getParameter("CustomerId"));
            //processRequest(request, response);
            ArrayList resultList = new ArrayList();
            while (rs.next()) {
                //processRequest(request, response);
                
                request.setAttribute(("SSN"), rs.getString("SSN"));
                
                request.setAttribute("lastname", rs.getString("lastname"));

                request.setAttribute("Firstname", rs.getString("Firstname"));

                request.setAttribute("address", rs.getString("Address"));

                request.setAttribute("city", rs.getString("City"));

                request.setAttribute("state", rs.getString("State"));

                request.setAttribute("zipcode", rs.getInt("Zipcode"));

                request.setAttribute("telephone", rs.getString("Telephone"));

                request.setAttribute("email", rs.getString("email"));

                request.setAttribute("Rating", rs.getInt("Rating"));

                request.setAttribute("CreditCardNumber", rs.getString("CreditCardNumber"));

                request.setAttribute("Type", rs.getString("Type"));
                
                request.setAttribute("username", rs.getString("username"));
                
                request.setAttribute("password", rs.getString("password"));

            }
            //request.setAttribute("employeeInfo", resultList);

            DBConnect.close();
            String url = "EditCustomer.jsp";
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
            //processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(SearchResult.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchResult.class.getName()).log(Level.SEVERE, null, ex);
        }
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
