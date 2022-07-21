/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.motorcycleModel;
import DTO.brandModel;
import DBAccess.DBAccess;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class motorcycles extends Vector<motorcycleModel> {

    DBAccess dBAccess = new DBAccess();

    public  int find(String motorcycleID){
        for (int i = 0; i < this.size(); i++) {
            if(motorcycleID.equals(this.get(i).getMotorcycleID())) return i;
        }
        return -1;
    }
    

    public boolean isDuplicated(String motorcycleID){
        int n = find(motorcycleID);
        if (n>0) return true;
        return false;
    }
    public void loadFromDB(DBAccess dBAccess, brands brands) {
        String motorcycleID;
        String model;
        Date year;
        String condition;
        double price;
        int quantity;
        String warranty;
        String brandID;
        String sql = "Select * From tblBike";
        try {
            ResultSet rs = dBAccess.executeQuery(sql);
            while(rs.next()){
                motorcycleID=rs.getString(1);
                model = rs.getString(2);
                year = rs.getDate(3);
                condition = rs.getString(4);
                price = rs.getFloat(5);
                quantity = rs.getInt(6);
                warranty = rs.getString(7);
                brandID = rs.getString(8);
                brandModel brand = brands.findBrand(brandID);
                motorcycleModel cycle = new motorcycleModel(motorcycleID, model, year, condition, price, quantity, warranty, brand);
                this.add(cycle);
            }
            rs.close();
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }

}
