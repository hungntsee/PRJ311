/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DBAccess.DBAccess;
import View.userView;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class userModel extends DBAccess{
    private String userID;
    private String fullname;
    private String password;
    private int status;
    final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    final String url = "jdbc:sqlserver://localhost:1433;"
            + "databasename=MotorcycleManagement;user=sa;password=Hung0708";
    DBAccess dbAccess = new DBAccess();

    public userModel() {
    }

    public userModel(String userID, String password) {
        super();
        connectDB(driver, url);
        this.userID = userID;
        this.password = password;
    }
    
    

    public userModel(String userID, String fullname, String password, int status) {
        this.userID = userID;
        this.fullname = fullname;
        this.password = password;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public userModel checkLogin(String userID, String password){
        String fullname;
        int status;
        userModel user = null;
        userView view = null;
        String sql = "SELECT userID,password,fullname,status FROM tblUser where userID= '"+ userID +"'AND password= '"+password+"'";       
        try{
            ResultSet rs = dbAccess.executeQuery(sql);
            while(rs.next()){
                fullname = rs.getString(3);
                status = rs.getInt(4);
                user= new userModel(userID, fullname, password, status);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
}
