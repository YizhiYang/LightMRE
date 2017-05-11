/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author MATT
 * 
 */

// Stpre info about the "you might like..."
// BEAN class
public class Employee implements Serializable{
    
    private int ID;
    private String SSN;
    private Date date;
    private int hourlyRate;
    
    
    // PLEASE refer to the bean naming principle,
    // and follow them to ensure that beans
    // can be successfully load in JSP
    public Employee(){
        
    }

    public int getID() {
        return ID;
    }

    public String getSSN() {
        return SSN;
    }

    public Date getDate() {
        return date;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
