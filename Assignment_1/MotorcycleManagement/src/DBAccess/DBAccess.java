/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class DBAccess {
    Connection con = null;
    Statement stmt = null;
    final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    final String url = "jdbc:sqlserver://localhost:1433;"
            + "databasename=MotorcycleManagement;user=sa;password=Hung0708";
    
    public DBAccess(){
        
        connectDB(driver, url);
    }
    
    public void connectDB(String driver, String url){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
        }catch (Exception e ){
            JOptionPane.showMessageDialog(null, "Connection is error: " +e);
        }
    }
    public void connectDB(String driver, String url, String uid, String pwd){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,uid,pwd);
            stmt = con.createStatement();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Connection 2 is error: "+e);
        }
    }
    
    public ResultSet executeQuery(String selectSql){
       if( con == null) return null;
       try{
           return (stmt.executeQuery(selectSql));
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
       return null;
    }
    
    public int executeUpdate(String updateSql){
        if(con == null)return 0;
        try{
            return (stmt.executeUpdate(updateSql));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return 0;
    }
}
