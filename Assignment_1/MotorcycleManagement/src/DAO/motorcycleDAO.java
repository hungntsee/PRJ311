/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.motorcycleModel;
import DBAccess.DBAccess;
import View.MainFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class motorcycleDAO {
    String sql= "";
    DBAccess dBAccess =new DBAccess();
    MainFrame view;
    public int AddNew(motorcycleModel cycle){
        sql = "insert into tblBike values('" 
                    + cycle.getMotorcycleID() + "','"
                    + cycle.getModel() + "','"
                    + cycle.getYear() + "','"
                    + cycle.getCondition() + "','"
                    + cycle.getPrice() + "','"
                    + cycle.getQuantity() + "','"
                    + cycle.getWarranty() + "','"
                    + cycle.getBrand().getBrandID() + "')";
        int n = dBAccess.executeUpdate(sql);
        JOptionPane.showConfirmDialog(view, sql);
        return n;
    }
    public int Update(motorcycleModel cycle){
        sql = "update tblBike set "
                    +"model='" + cycle.getModel() + "',"
                    +"year='" + cycle.getYear() + "',"
                    +"condition='" + cycle.getCondition() + "',"
                    +"price='" + cycle.getPrice() + "',"
                    +"quantity='" + cycle.getQuantity() + "',"
                    +"warranty='" + cycle.getWarranty() + "',"
                    +"brandID='" + cycle.getBrand().getBrandID() +"'"
                    + "where motorcycleID ='" + cycle.getMotorcycleID() +"'";
        int n = dBAccess.executeUpdate(sql);
        JOptionPane.showConfirmDialog(view, sql);
        return n;
    }
}
