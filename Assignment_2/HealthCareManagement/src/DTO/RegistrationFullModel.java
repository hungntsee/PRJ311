/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class RegistrationFullModel extends AbstractTableModel {

    private ArrayList<RegistrationDTO> list;
    private String[] col;

    public RegistrationFullModel(ArrayList<RegistrationDTO> listDTO) {
        super();
        list = listDTO;
        col = new String[]{"ID", "Full name", "Age", "Gender", "Email", "Phone", "Address", "Number of Pet", "Symptoms"};
    }

    public ArrayList<RegistrationDTO> getList() {
        return list;
    }

    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return col.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Vector<RegistrationDTO> v = new Vector<RegistrationDTO>(list);
        RegistrationDTO dto = v.get(row);
        Object obj = null;
        switch (col) {
            case 0:
                obj = dto.getRegistrationID();
                break;
            case 1:
                obj = dto.getFullName();
                break;
            case 2:
                obj = dto.getAge();
                break;
            case 3:
                if (dto.isGender() == true) {
                    obj = "Male";
                } else {
                    obj = "Female";
                }
                break;
            case 4:
                obj = dto.getEmail();
                break;
            case 5:
                obj = dto.getPhone();
                break;
            case 6:
                obj = dto.getAddress();
                break;
            case 7:
                obj = dto.getNumberOfPet();
                break;
            case 8:
                obj = dto.getSymptoms();
                break;
        }
        return obj;
    }

    @Override
    public String getColumnName(int col) {
        return this.col[col];
    }

}
