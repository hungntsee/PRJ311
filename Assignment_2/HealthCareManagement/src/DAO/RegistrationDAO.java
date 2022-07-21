/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.RegistrationDTO;
import RegistrationServer.RegistrationInterface;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class RegistrationDAO extends UnicastRemoteObject implements RegistrationInterface {

    private RegistrationDTO dto;
    String filename;
    ArrayList<RegistrationDTO> listDTO = new ArrayList<>();

    public RegistrationDAO(String filename) throws RemoteException {
        super();
        this.filename = filename;
    }

    public boolean writeToFile(ArrayList<RegistrationDTO> list) {
        try {
            FileWriter f = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(f);
            String S = "";
            for (int i = 0; i < list.size(); i++) {
                String gender = "";
                if (list.get(i).isGender() == true) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                S = list.get(i).getRegistrationID() + ","
                        + list.get(i).getFullName() + ","
                        + String.valueOf(listDTO.get(i).getAge()) + ","
                        + gender + ","
                        + list.get(i).getEmail() + ","
                        + list.get(i).getPhone() + ","
                        + list.get(i).getAddress() + ","
                        + String.valueOf(list.get(i).getNumberOfPet()) + ","
                        + list.get(i).getSymptoms();
                pw.println(S);
            }
            pw.close();
            f.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createRegistration(RegistrationDTO dto) throws RemoteException {
        listDTO.add(dto);
        if(writeToFile(listDTO)) return true;
        return false;
    }

    @Override
    public RegistrationDTO findByRegistrationID(String id) throws RemoteException {
        RegistrationDTO dto = null;
        for (int i = 0; i < listDTO.size(); i++) {
            if (id.equals(listDTO.get(i).getRegistrationID())) {
                dto = listDTO.get(i);
            }
        }
        return dto;
    }

    public ArrayList<RegistrationDTO> readFile(){
        try {
            FileReader f = new FileReader(filename);
            BufferedReader br = new BufferedReader(f);
            String line;

            String registrationID;
            String fullName;
            int age;
            boolean gender;
            String email;
            String phone;
            String address;
            int numberOfPet;
            String symptoms;
            while ((line = br.readLine()) != null) {               
                StringTokenizer stk = new StringTokenizer(line, ",");
                while (stk.hasMoreElements()) {
                    registrationID = stk.nextToken();
                    fullName = stk.nextToken();
                    age = Integer.parseInt(stk.nextToken());
                    if (stk.nextToken().matches("Male")) {
                        gender = true;
                    } else {
                        gender = false;
                    }
                    email = stk.nextToken();
                    phone = stk.nextToken();
                    address = stk.nextToken();
                    numberOfPet = Integer.parseInt(stk.nextToken());
                    symptoms = stk.nextToken();
                    dto = new RegistrationDTO(registrationID, fullName, age, gender, email, phone, address, numberOfPet, symptoms);
                    listDTO.add(dto);
                }
            }
            br.close();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listDTO;
    }
    @Override
    public ArrayList<RegistrationDTO> findAllRegistration() throws RemoteException {
        return listDTO;
    }

    @Override
    public boolean removeRegistration(String id) throws RemoteException {
        for (int i = 0; i < listDTO.size(); i++) {
            if (id.equals(listDTO.get(i).getRegistrationID())) {
                listDTO.remove(i);
                writeToFile(listDTO);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateRegistration(RegistrationDTO dto) throws RemoteException {
        for (int i = 0; i < listDTO.size(); i++) {
            if (dto.getRegistrationID().toUpperCase().equals(listDTO.get(i).getRegistrationID())) {
                listDTO.remove(i);
                listDTO.add(dto);
                writeToFile(listDTO);
                return true;
            }
        }
        return false;
    }
}
