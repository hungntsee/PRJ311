/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class ReaderFullModel extends AbstractTableModel{

    private ArrayList<Reader> list;
    private String[] col;

    public ReaderFullModel(ArrayList<Reader> list) {
        super();
        this.list = list;
        col = new String[]{"ID", "Full name", "Gender", "Birthday", "Email", "Phone", "Address"};
    }

    public ArrayList<Reader> getList() {
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
        Vector<Reader> v = new Vector<Reader>(list);
        Reader reader = v.get(row);
        Object obj = null;
        switch (col){
            case 0: obj = reader.getReaderID(); break;
            case 1: obj = reader.getReadername(); break;
            case 2: 
                if (reader.isGender() == true) {
                    obj = "Male";
                } else {
                    obj = "Female";
                }
                break;
            case 3: 
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String birth = sdf.format(reader.getBirthday());
                obj = birth; break;
            case 4: obj = reader.getEmail(); break;
            case 5: obj = reader.getPhone(); break;
            case 6: obj = reader.getAddress(); break;
        }
        return obj;
    }

    @Override
    public String getColumnName(int col) {
        return this.col[col];
    }
    
}
