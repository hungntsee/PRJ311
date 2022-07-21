/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ValidData {

    String readerID;
    String fullName;
    boolean gender;
    Date birthday;
    String address;
    String email;
    String phone;

    public ValidData(String readerID, String fullName, boolean gender, Date birthday, String address, String email, String phone) {
        this.readerID = readerID;
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
    
    MainFrame view;

    public boolean checkValid() {
        if (!readerID.matches("\\w{1,10}")) {
            JOptionPane.showMessageDialog(view, "Wrong input please refill ReaderID.");
            return false;
        } else if (fullName.length() > 50) {
            JOptionPane.showMessageDialog(view, "Max lenght of Full Name is 50.");
            return false;
        } else if (email.length() > 30) {
            JOptionPane.showMessageDialog(view, "Max length of email is 30.");
            return false;
        } else if (!email.matches("^\\w+\\@{1}\\w+\\.\\w+$")) {
            JOptionPane.showMessageDialog(view, "Wrong formatt: aaa@aaa.aaa");  
            return false;
        } else if (phone.length() > 15) {
            JOptionPane.showMessageDialog(view, "Max length of Phone is 15.");
            return false;
        } else if (!phone.matches("^\\d{10,15}$")) {
            JOptionPane.showMessageDialog(view, "Phone is number has length from 10 to 15");
            return false;
        } 

        return true;
    }
}
