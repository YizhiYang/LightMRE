/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBWorks;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 *
 * @author MATT
 */
public class DBConnection {

    private Connection conn;

    public DBConnection() {

        conn = null;
    }

    public boolean valid(HttpServletRequest request) throws ClassNotFoundException, SQLException {

        if (connectDB() == false) {
            return false;
        }

        //if (request.getParameter("name").isEmpty()) {
        //return false;
        //}
        return true;
    }

    public boolean connectDB() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/moviedb";
        String username = "java";
        String password = "12345";
        boolean result = true;
            
        try {
            conn = (Connection) DriverManager.getConnection(url, username, password);
            result = true;
        } catch (SQLException ex) {
            result = false;
        }
        return result;
    }

    //Get recommendation result based on movie and actor
    //Type and Actor should based on the current user's favor
    public ResultSet getRecommendation(String type, String actor) throws SQLException {

        Statement stmt = null;
        stmt = conn.createStatement();
        String sql = "SELECT Name, Type, Rating, DistrFee FROM Movie";
        ResultSet rs = stmt.executeQuery(sql);

        return rs;
    }

    // query based on the name of the movie
    public ResultSet queryMovie(String name) {

        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT Name, Type, Rating, DistrFee FROM Movie WHERE Name LIKE ?");
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    // query based on the type of movie.
    public ResultSet queryMovieByType(String name) {

        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT Name, Type, Rating, DistrFee FROM Movie WHERE Type LIKE ?");
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet queryMovieByActor(String name) {

        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT Movie.Name, Movie.Type, Movie.Rating, Movie.DistrFee FROM Movie, Actor, AppearedIn"
                    + " WHERE AppearedIn.MovieId = Movie.Id"
                    + " AND AppearedIn.ActorId = Actor.Id"
                    + " AND Actor.Name LIKE ?");
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet queryAllMovie() throws SQLException {

        Statement stmt = null;
        stmt = conn.createStatement();
        String sql = "SELECT Name, Type, Rating, DistrFee FROM Movie";
        ResultSet rs = stmt.executeQuery(sql);

        return rs;

    }
    public ResultSet queryUserSuggestedMovies(int accId) throws SQLException{
        try{
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT DISTINCT " +
                "    moviedb.movie.Name, moviedb.movie.Type, moviedb.movie.Rating, moviedb.movie.DistrFee " +
                "FROM " +
                "    moviedb.movie " +
                "WHERE " +
                "    movie.Type IN (SELECT  " +
                "            MAX(moviedb.movie.Type) " +
                "        FROM " +
                "            moviedb.rental, " +
                "            moviedb.order, " +
                "            moviedb.movie " +
                "        WHERE " +
                "            moviedb.rental.AccountId = ? " +
                "                AND moviedb.rental.OrderId = moviedb.order.Id " +
                "                AND rental.MovieId = moviedb.movie.Id) " +
                "        AND moviedb.movie.Id NOT IN (SELECT  " +
                "            moviedb.movie.Id " +
                "        FROM " +
                "            moviedb.movie, " +
                "            moviedb.rental " +
                "        WHERE " +
                "            moviedb.movie.Id = rental.MovieId " +
                "                AND rental.AccountId = ?)");
            stmt.setInt(1, accId);
            stmt.setInt(2, accId);
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch(SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    // close the connection to the DB
    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // return the list of all employee
    public ResultSet queryAllEmployees() throws SQLException {

        Statement stmt = null;
        stmt = conn.createStatement();
        String sql = "SELECT Id, SSN, StartDate, HourlyRate FROM Employee";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }
    
    public boolean deleteMovie(String moiveName){
        
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("DELETE FROM Movie WHERE Name = ?");
            stmt.setString(1, moiveName);
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deleteEmployee(String id){
        
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("DELETE FROM Employee WHERE Id = ?");
            stmt.setString(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean addCustomer(int zipCode, String city, String state, String ssn, String lastName, String firstName,
            String address, String telephone, int id, String email, int rating, String creditCardNumber,
            Date dateOpened, String accountType){
        try{
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT IGNORE INTO Location(ZipCode, City, State) VALUES (?, ?, ?)");
            stmt.setInt(1, zipCode);
            stmt.setString(2, city);
            stmt.setString(3, state);
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("INSERT INTO Person(SSN, LastName, FirstName, Address, ZipCode, Telephone)"
                    + " VALUES(?, ?, ?, ?, ?, ?)");
            stmt.setString(1, ssn);
            stmt.setString(2, lastName);
            stmt.setString(3, firstName);
            stmt.setString(4, address);
            stmt.setInt(5, zipCode);
            stmt.setString(6, telephone);
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("INSERT INTO Customer(Id, Email, Rating, CreditCardNumber) VALUES(?, ?, ?, ?)");
            stmt.setString(1, ssn);
            stmt.setString(2, email);
            stmt.setInt(3, rating);
            stmt.setString(4, creditCardNumber);
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("INSERT INTO Account(Id, DateOpened, Type, Customer) VALUES (?, ?, ?, ?");
            stmt.setInt(1, id);
            stmt.setDate(2, dateOpened);
            stmt.setString(3, accountType);
            stmt.setString(4, ssn);
            stmt.executeUpdate();

            return true;
        } catch(SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    /*
        Add movie
    */
    public boolean addMovie(int Id, String Name, String Type, int Rating, double DistrFee, int NumCopies, int[] ActorId, String[] ActorName, int[] ActorAge, char[] ActorGender){
        try{
            PreparedStatement stmt = null;
            
            //add information of movie
            stmt= conn.prepareStatement("INSERT INTO Movie(Id, Name, Type, Rating, DistrFee, NumCopies) VALUES (?,?,?,?,?,?)");
            stmt.setInt(1,Id);
            stmt.setString(2, Name);
            stmt.setString(3, Type);
            stmt.setInt(4,Rating);
            
            BigDecimal fee = new BigDecimal(DistrFee);
            stmt.setBigDecimal(5,fee);
            
            stmt.setInt(6,NumCopies);
            
            stmt.executeUpdate();
            
            //add information of Actor in movie and AppearedIn
            int numOfActor = ActorId.length;
            if(ActorId != null && ActorName != null && ActorAge != null && ActorGender != null){
                for(int i = 0; i < numOfActor; i++){
                    //update actor
                    stmt = conn.prepareStatement("INSERT INTO Actor(Id, Name, Age, M/F) VALUES (?,?,?,?)");
                    stmt.setInt(1,ActorId[i]);
                    stmt.setString(2,ActorName[i]);
                    stmt.setInt(3,ActorAge[i]);
                    stmt.setString(4, String.valueOf(ActorGender[i]));

                    stmt.executeUpdate();
                    //update appearedIn
                    stmt = conn.prepareStatement("INSERT INTO AppearedIn(ActorId, MovieId, Rating) VALUES (?,?,?)");
                    stmt.setInt(1, ActorId[i]);
                    stmt.setInt(2, Id);
                    stmt.setInt(3, 0);

                    stmt.executeUpdate();
                }
            }
            return true;
        }
        catch(SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    /* 
     * Add an employee with all information
    */
    public boolean addEmployee(String SSN, String LastName, String FirstName, String Address, String city, String state, int Zipcode, String Telephone, 
            Date StartDate, int HourlyRate){
        try{
            PreparedStatement stmt = null;
            //update person
            stmt= conn.prepareStatement("INSERT INTO Person(SSN, LastName, FirstName, Address, Zipcode, Telephone) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, SSN);
            stmt.setString(2, LastName);
            stmt.setString(3, FirstName);
            stmt.setString(4, Address);
            stmt.setInt(5, Zipcode);
            stmt.setString(6, Telephone);
            stmt.executeUpdate();
            
            //update address
            stmt = conn.prepareStatement("INSERT IGNORE INTO Location(ZipCode, City, State) VALUES (?, ?, ?)");
            stmt.setInt(1, Zipcode);
            stmt.setString(2, city);
            stmt.setString(3, state);
            stmt.executeUpdate();
            
            //get the newest ID in employee
            stmt = conn.prepareStatement("SELECT MAX(Id) FROM Employee");
            ResultSet rs = stmt.executeQuery();
            int Id = ((Number) rs.getObject(1)).intValue() + 1;
            
            //update employee
            stmt = conn.prepareStatement("INSERT INTO Employee(Id, SSN, StartDate, HourlyRate) VALUES (?,?,?,?)");
            stmt.setInt(1, Id);
            stmt.setString(2,SSN);
            stmt.setDate(3,StartDate);
            stmt.setInt(4,HourlyRate);
            stmt.executeUpdate();
            
            return true;
        }
        catch(SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean updateMovie(int Id, String name, String Type, int Rating, double distrFee, int NumOfCopies){
        try{
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("UPDATE Movie SET Name = ?, Type = ?, distrFee = ?, NumOfCopies = ? WHERE Id = ?");
            stmt.setString(1, name);
            stmt.setString(2, Type);
            BigDecimal fee = new BigDecimal(distrFee);
            stmt.setBigDecimal(3,fee);
            stmt.setInt(4, NumOfCopies);
            stmt.setInt(5,Id);
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
//    public boolean editEmployee(int Id, int SSN, String LastName, String FirstName, String Address, String city, String state, int Zipcode, String Telephone, 
//            Date StartDate, double HourlyRate){
//        try{
//            PreparedStatement stmt = null;
//            stmt = conn.prepareStatement("SELECT Id FROM moviedb.employee WHERE ? = Id");
//            stmt.setInt(1,Id);
//            ResultSet rs = stmt.executeQuery();
//            if(rs != null){
//                //id exist
//                
//                return true;
//            }
//            else{
//                //id not exist
//                return false;
//            }
//        }catch(SQLException ex)
//        {
//            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null ,ex);
//            return false;
//        }
//    }
//    public boolean editCustomer(){
//        return true;
//    }
}
