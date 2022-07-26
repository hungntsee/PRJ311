/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistrationServer;

import DTO.RegistrationDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface RegistrationInterface extends Remote{
    boolean createRegistration(RegistrationDTO dto) throws RemoteException;
    RegistrationDTO findByRegistrationID(String id) throws RemoteException;
    ArrayList<RegistrationDTO> readFile() throws RemoteException;
    ArrayList<RegistrationDTO> findAllRegistration() throws RemoteException;
    boolean removeRegistration(String id) throws RemoteException ;
    boolean updateRegistration(RegistrationDTO dto) throws RemoteException;
    
    
}
