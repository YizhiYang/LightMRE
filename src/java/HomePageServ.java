
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.Recommendation;
import DBWorks.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author MATT
 */
public class HomePageServ extends HttpServlet {

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
            out.println("<title>Servlet HomePageServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>User Name: " + request.getParameter("name") + "</h1>");
            out.println("<h1>User Name: " + request.getParameter("var") + "</h1>");
            out.println("<h1>Password: " + request.getParameter("password") + "</h1>");
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
        //this.processRequest(request, response);
        try {
            DBConnection DBConnect = new DBConnection();
            DBConnect.connectDB();
            if (request.getParameter("MovieName") != null) {
                boolean result = DBConnect.deleteMovie(request.getParameter("MovieName"));
                request.setAttribute("deleteStatus", result);
            }
            ResultSet rs = null;
            String url = "ManagerHomePage.jsp";
            ArrayList list = new ArrayList();
            rs = DBConnect.queryAllMovie();

            while (rs.next()) {
                Recommendation movie = new Recommendation();
                movie.setName(rs.getString("Name"));
                movie.setType(rs.getString("Type"));
                movie.setRating(rs.getInt("Rating"));
                movie.setPrice(rs.getDouble("DistrFee"));
                list.add(movie);
            }
            request.setAttribute("allMovie", list);
            DBConnect.close();

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(HomePageServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomePageServ.class.getName()).log(Level.SEVERE, null, ex);
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
            // Store name and password into Session Object
            HttpSession session = request.getSession();
            session.setAttribute("UserName", request.getParameter("name"));
            session.setAttribute("Password", request.getParameter("password"));
            DBConnection DBConnect = new DBConnection();
            boolean result = false;
            try {
                result = DBConnect.valid(request);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HomePageServ.class.getName()).log(Level.SEVERE, null, ex);
            }
            String username = request.getParameter("name");
            String password = request.getParameter("password");
            Boolean isCustomer = DBConnect.existingCustomer(username, password);
            char accountType = ' ';

            if(isCustomer){
                accountType = 'c';
            }
            else{
                int type = DBConnect.existingEmployee(username, password);
                if(type == 1){
                    accountType = 'e';
                }
                else if(type == 2){
                    accountType = 'm';
                }
                
            }


            // Connect to the DB
            

            session.setAttribute("r", request);

            ResultSet rs = null;

            // if the login account is a customer 
            if (accountType == 'c') {
                String url = "HomePage.jsp";
                String falseUrl = "index.html";
                int accId = 1;
                //get recommendation list and store them into bean class.
                rs = DBConnect.queryUserSuggestedMovies(accId);
                //rs = DBConnect.queryAllMovie();
                //if result set from the SQL Query is not empty
                //store them into bean class, then store beans
                //class into session object. JSP can get these beans.
                ArrayList list = new ArrayList();

                while (rs.next()) {
                    Recommendation movie = new Recommendation();
                    movie.setName(rs.getString("Name"));
                    movie.setType(rs.getString("Type"));
                    movie.setRating(rs.getInt("Rating"));
                    movie.setPrice(rs.getDouble("DistrFee"));
                    list.add(movie);
                }
                request.setAttribute("recommendList", list);

                // if user name and password are valid, forward to the homepage.
                DBConnect.close();
                if (result) {
                    RequestDispatcher dispatcher
                            = request.getRequestDispatcher(url);
                    dispatcher.forward(request, response);
                } // if not, then forward back to the login page.
            } else if (accountType == 'm') {
                String url = "ManagerHomePage.jsp";
                String falseUrl = "index.html";
                ArrayList list = new ArrayList();
                rs = DBConnect.queryAllMovie();

                while (rs.next()) {
                    Recommendation movie = new Recommendation();
                    movie.setName(rs.getString("Name"));
                    movie.setType(rs.getString("Type"));
                    movie.setRating(rs.getInt("Rating"));
                    movie.setPrice(rs.getDouble("DistrFee"));
                    list.add(movie);
                }
                request.setAttribute("allMovie", list);
                DBConnect.close();

                if (result) {
                    RequestDispatcher dispatcher
                            = request.getRequestDispatcher(url);
                    dispatcher.forward(request, response);
                } // if not, then forward back to the login page.
                else {
                    RequestDispatcher dispatcher
                            = request.getRequestDispatcher(falseUrl);
                    dispatcher.forward(request, response);
                }
            } else {
                String falseUrl = "index.html";
                String url = "ManagerHomePage.jsp";
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher(falseUrl);
                dispatcher.forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HomePageServ.class.getName()).log(Level.SEVERE, null, ex);
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

