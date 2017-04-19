/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;

/**
 *
 * @author MATT
 * 
 */

// Stpre info about the "you might like..."
// BEAN class
public class Recommendation implements Serializable{
    
    private String name;
    private String type;
    private String actor;
    private double price;
    private int rating;
    
    
    // PLEASE refer to the bean naming principle,
    // and follow them to ensure that beans
    // can be successfully load in JSP
    public Recommendation(){
        
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getActor() {
        return actor;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }
    
    
}
