/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBWorks;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 *
 * @author MATT
 */
public class DBConnection {
    
    public boolean valid(HttpServletRequest request) throws ClassNotFoundException{
        
        if(connectDB()==false)
            return false;
        
        if(request.getParameter("name").isEmpty()){
            return false;
        }
        return true;
    }
    
    public boolean connectDB() throws ClassNotFoundException{
        
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/javabase";
        String username = "java";
        String password = "12345";
        boolean result = true;
    
        try (Connection connection = (Connection) DriverManager.getConnection(url, username, password)) {
        } 
        catch (SQLException e) {
            result = false;
        }

        return result;
    }
}
