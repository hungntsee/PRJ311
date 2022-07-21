/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.brandModel;
import DAO.brands;
import DBAccess.DBAccess;
import View.MainFrame;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author Admin
 */
public class brandDAO {

    public int deleteBrand(String brandID) {
        String sql = "delete from tblBrand where brandID = '" + brandID + "'";
        JOptionPane.showMessageDialog(view, "Do you want to delete this Brand "+brandID+"?");
        int n = dBAccess.executeUpdate(sql);
        return n;
    }
    
    DBAccess dBAccess = new DBAccess();
    MainFrame view;

    
    
    public int addNew(brandModel brandModel) {
        String brandID = brandModel.getBrandID();
        String brandName = brandModel.getBrandName();
        String country = brandModel.getCountry();
        String description = brandModel.getDescription();
        
        String sql = "insert into tblBrand values('"+ brandID + "','" 
                + brandName + "','" + country + "','" + description + "')";
        int n = dBAccess.executeUpdate(sql);
        
        return n;
    }

    public int update(brandModel brandModel) {
        int m;
            String brandID= brandModel.getBrandID();
            String brandName = brandModel.getBrandName();
            String country = brandModel.getCountry();
            String description = brandModel.getDescription();
            
            String sql = "update tblBrand set "
                    + "brandName = '" + brandName + "',"
                    + "country = '" + country + "'," 
                    + "description = '"+ description + "'" 
                    + "where brandID = '" + brandID +"'";
            m = dBAccess.executeUpdate(sql);
            
        return m;
    }
    
}
