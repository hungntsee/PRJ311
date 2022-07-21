/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.motorcycles;
import DTO.motorcycleModel;
import java.text.SimpleDateFormat;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class motorcycleFullModel extends AbstractTableModel {

    motorcycles cycles;

    public motorcycleFullModel(motorcycles cycles) {
        this.cycles = cycles;
    }

    public motorcycles getCycles() {
        return cycles;
    }

    @Override
    public int getRowCount() {
        return cycles.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int row, int col) {
        motorcycleModel cycle = cycles.get(row);
        Object obj = null;
        switch (col) {
            case 0:
                obj = cycle.getMotorcycleID();
                break;
            case 1:
                obj = cycle.getModel();
                break;
            case 2:
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                obj = sdf.format(cycle.getYear());
                break;
            case 3:
                obj = cycle.getCondition();
                break;
            case 4:
                obj = cycle.getPrice();
                break;
            case 5:
                obj = cycle.getQuantity();
                break;
            case 6:
                obj = cycle.getWarranty();
                break;
            case 7:
                obj = cycle.getBrand().getBrandName();
                break;
        }
        return obj;
    }

    @Override
    public String getColumnName(int col) {
        String columnName = "";
        switch (col) {
            case 0:
                columnName = "ID";
                break;
            case 1:
                columnName = "Model";
                break;
            case 2:
                columnName = "Year";
                break;
            case 3:
                columnName = "Condition";
                break;
            case 4:
                columnName = "Price";
                break;
            case 5:
                columnName = "Quantity";
                break;
            case 6:
                columnName = "Warranty";
                break;
            case 7:
                columnName = "Brand Name";
                break;
        }
        return columnName;
    }

}
