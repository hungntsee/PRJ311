/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.brands;
import DTO.brandModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class brandFullModel extends  AbstractTableModel{

    brands brands;

    public brandFullModel(brands brands) {
        this.brands = brands;
    }        

    public brands getBrands() {
        return brands;
    }
    
    @Override
    public int getRowCount() {
        return brands.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int   col) {
        brandModel brand = brands.get(row);
        Object obj =null;
        switch(col){
            case 0 :
                obj = brand.getBrandID();
                break;
            case 1 :
                obj = brand.getBrandName();
                break;
            case 2 :
                obj = brand.getCountry();
                break;
            case 3 :
                obj = brand.getDescription();
                break;
                
        }
        return obj;
    }

    @Override
    public String getColumnName(int col) {
        String columnName = "";
        switch(col){
            case 0 :
                columnName = "Brand ID";
                break;
            case 1 :
                columnName = "Brand Name";
                break;
            case 2 :  
                columnName = "Country";
                break;
            case 3 :
                columnName = "Description";
                break;
        }
        return columnName;
    }
    
    
}



