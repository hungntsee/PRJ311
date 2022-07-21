/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.userModel;
import View.userView;
import DBAccess.DBAccess;
import View.MainFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class userDAO  {

    private userModel model = new userModel();
    private userView view;

    public userDAO() {
        
    }
    
    public userModel Login(String userID, String password){       
        model = model.checkLogin(userID,password);
        return model;
    }
    
}
