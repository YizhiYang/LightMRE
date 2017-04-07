/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DBWorks.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
        
    String url = "HomePage.jsp";
    String falseUrl = "index.html";
    
    
    HttpSession session =request.getSession();
    session.setAttribute("UserName", request.getParameter("name"));
    session.setAttribute("Password", request.getParameter("password"));
    
    response.setContentType("text/html");
    PrintWriter out =response.getWriter();
    
    
    DBConnection connection = new DBConnection();
    boolean result = connection.valid(request);
    
//    String docType ="<!DOCTYPE html> \n";
//    out.println(docType);
//    out.println("<html>");
//    out.println("<head><title> Hello World</title></head>");
//    out.println("<body>");
//    out.println("<h1>" + session.getAttribute("UserName")+ "</h1>");
//    out.println("<h1>" + session.getAttribute("Password")+ "</h1>");
//    out.println("</body></html>");
    
    if(result == true){
        RequestDispatcher dispatcher =
        request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
        processRequest(request, response);
    }
    else{
        RequestDispatcher dispatcher =
        request.getRequestDispatcher(falseUrl);
        dispatcher.forward(request, response);
        processRequest(request, response);
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
