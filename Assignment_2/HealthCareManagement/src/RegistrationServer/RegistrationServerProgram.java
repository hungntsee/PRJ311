/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistrationServer;

import DAO.RegistrationDAO;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Admin
 */
public class RegistrationServerProgram extends Thread{

    public RegistrationServerProgram() {
        super();
    }
    
    public static void main(String[] args) throws RemoteException {
        String serviceName = "rmi://127.0.0.1:1098/HealthCareService";
        String filename= "Assignment2.txt";
        RegistrationDAO serverDAO = null;
         
        try{
            serverDAO = new RegistrationDAO(filename);
            
            Registry r = LocateRegistry.createRegistry(1098);
            Naming.rebind(serviceName, serverDAO);
            System.out.println("Service" + serviceName + " is running.");
        }catch(MalformedURLException e){
            System.out.println(e.getMessage());
        }
    }   
}
