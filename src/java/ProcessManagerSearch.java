/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.Recommendation;
import Beans.SearchByNameForManagerBean;
import Beans.SearchByTypeForManagerBean;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author MATT
 */
public class ProcessManagerSearch extends HttpServlet {

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
            out.println("<title>Servlet ProcessManagerSearch</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessManagerSearch at " + request.getParameter("search") + "</h1>");
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
        try {

            HttpSession session = request.getSession();
            session.setAttribute("KeyWord", request.getParameter("search"));
            DBConnection DBConnect = new DBConnection();
            if (DBConnect.connectDB() == false) {
                processRequest(request, response);
            }
            ResultSet rs = null;

            if (request.getParameter("searchType").equals("name")) {

                rs = DBConnect.queryMovieRentalbyName(request.getParameter("search"));
                //processRequest(request, response);
                SearchByNameForManagerBean bean = new SearchByNameForManagerBean();

                bean.setName(rs.getString("Name"));
                bean.setLastName(rs.getString("LastName"));
                bean.setFirstName(rs.getString("FirstName"));
                DBConnect.close();

                ArrayList list = new ArrayList();
                list.add(bean);
                request.setAttribute("resultBean", list);
                String url = "SearchResultByNameForManager.jsp";

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);

            } else if (request.getParameter("searchType").equals("type")) {

                SearchByTypeForManagerBean bean = new SearchByTypeForManagerBean();
                rs = DBConnect.queryMovieRentalbyType(request.getParameter("search"));

                bean.setName(rs.getString("Name"));
//                processRequest(request, response);
                bean.setType(rs.getString("Type"));
                bean.setLastName(rs.getString("LastName"));
                bean.setFirstName(rs.getString("FirstName"));
                DBConnect.close();

                ArrayList list = new ArrayList();
                list.add(bean);
                request.setAttribute("resultBean", list);
                String url = "SearchResultByTypeForManager.jsp";

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            } else {
                rs = DBConnect.queryMovieRentalbyCustomer(request.getParameter("search"));
                //processRequest(request, response);
                SearchByNameForManagerBean bean = new SearchByNameForManagerBean();

                bean.setName(rs.getString("Name"));
                bean.setLastName(rs.getString("LastName"));
                bean.setFirstName(rs.getString("FirstName"));
                DBConnect.close();

                ArrayList list = new ArrayList();
                list.add(bean);
                request.setAttribute("resultBean", list);
                String url = "SearchResultByNameForManager.jsp";

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }

            ArrayList resultList = new ArrayList();
            while (rs.next()) {
                Recommendation movie = new Recommendation();
                movie.setName(rs.getString("Name"));
                movie.setType(rs.getString("Type"));
                movie.setRating(rs.getInt("Rating"));
                movie.setPrice(rs.getDouble("DistrFee"));
                resultList.add(movie);
            }
            request.setAttribute("searchList", resultList);

            DBConnect.close();
            String url = "SearchResult.jsp";
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);

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
