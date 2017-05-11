/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.Customer;
import Beans.Employee;
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
 * @author MATT
 */
public class QueryAllCustomers extends HttpServlet {

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
            out.println("<title>Servlet QueryAllCustomers</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QueryAllCustomers at " + request.getSession().getAttribute("userName") + request.getSession().getAttribute("password")+ "</h1>");
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
            
              if (request.getParameter("CustomerId") != null) {
                boolean result = DBConnect.deleteCustomer(request.getParameter("CustomerId"));
                request.setAttribute("deleteStatus", result);
            }
            ResultSet rs = null;

            rs = DBConnect.queryAllCustomers();

            ArrayList resultList = new ArrayList();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getString("Id"));
                customer.setEmail(rs.getString("Email"));
                customer.setRating(rs.getInt("Rating"));
                customer.setCreditCardNumber(rs.getString("CreditCardNumber"));
                resultList.add(customer);
            }
            request.setAttribute("customersList", resultList);

            
            
            String url = "DisplayAllCustomers.jsp";

            String employeeName = (String) request.getSession().getAttribute("userName");
            String employeePassword = (String) request.getSession().getAttribute("password");
            //processRequest(request, response);
            if ((DBConnect.existingEmployee(employeeName, employeePassword)) == 1) {
                url = "EmployeeHomePage.jsp";
                
            }
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
            DBConnect.close();
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
        try {
            DBConnection DBConnect = new DBConnection();
            if (DBConnect.connectDB() == false) {
                processRequest(request, response);
            }
            ResultSet rs = null;

            rs = DBConnect.queryAllCustomers();

            ArrayList resultList = new ArrayList();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getString("Id"));
                customer.setEmail(rs.getString("Email"));
                customer.setRating(rs.getInt("Rating"));
                customer.setCreditCardNumber(rs.getString("CreditCardNumber"));
                resultList.add(customer);
            }
            request.setAttribute("customersList", resultList);

            DBConnect.close();

            String url = "EmployeeHomePage.jsp";

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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
