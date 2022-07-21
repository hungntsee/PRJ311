/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.brandModel;
import DBAccess.DBAccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class brands extends Vector<brandModel>{

    public brands() {
        super();
    }
    
    public int find(String brandID){
        for (int i = 0;i<this.size();i++){
            if(brandID.equals(this.get(i).getBrandID())) return i;
        }
        return -1;
    }
    public boolean isDuplicated(String brandID){
        int n = find(brandID);
        if(n>-1)
            return true;
        return false;
    }
    public brandModel findBrand(String brandID){
        int i = find(brandID);
        return i < 0 ? null : this.get(i);
    }
    
    public  void loadFromDB(DBAccess dbAccess){
        
        String brandID,brandName,country,description;
        String sql="Select brandID,brandName,country,description from tblBrand";
        try {
            ResultSet rs = dbAccess.executeQuery(sql);
            while(rs.next())
            {
                brandID=rs.getString(1);
                brandName=rs.getString(2);
                country=rs.getString(3);
                description=rs.getString(4);
                brandModel brand = new brandModel(brandID, brandName, country, description);
                this.add(brand);
            }
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }
}
