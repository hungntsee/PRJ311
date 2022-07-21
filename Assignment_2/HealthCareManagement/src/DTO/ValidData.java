/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import View.ClientFrame;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ValidData {

    String registrationID;
    String fullName;
    int age;
    boolean gender;
    String email;
    String phone;
    String address;
    int numberOfPet;
    String symptoms;

    public ValidData(String registrationID, String fullName, int age, boolean gender, String email, String phone, String address, int numberOfPet, String symptoms) {
        this.registrationID = registrationID;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.numberOfPet = numberOfPet;
        this.symptoms = symptoms;
    }

    ClientFrame view;

    public boolean checkValid() {
        if (!registrationID.matches("\\w{1,10}")) {
            JOptionPane.showMessageDialog(view, "Wrong input please refill RegistrationID.");
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
        } else if (!(numberOfPet > 0)) {
            JOptionPane.showMessageDialog(view, "Number of Pet must be > 0");
            return false;
        }

        return true;
    }
}
