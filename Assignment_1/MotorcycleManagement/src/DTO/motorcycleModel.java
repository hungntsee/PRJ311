/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DTO.brandModel;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class motorcycleModel {
    private String motorcycleID;
    private String model;
    private Date year;
    private String condition;
    private double price;
    private int quantity;
    private String warranty;
    private brandModel brand;

    public motorcycleModel() {
    }

    public motorcycleModel(String motorcycleID, String model, Date year, String condition, double price, int quantity, String warranty, brandModel brand) {
        this.motorcycleID = motorcycleID;
        this.model = model;
        this.year = year;
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.warranty = warranty;
        this.brand = brand;
    }

    public String getMotorcycleID() {
        return motorcycleID;
    }

    public void setMotorcycleID(String motorcycleID) {
        this.motorcycleID = motorcycleID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public brandModel getBrand() {
        return brand;
    }

    public void setBrand(brandModel brand) {
        this.brand = brand;
    }
    
    
    
    
}
