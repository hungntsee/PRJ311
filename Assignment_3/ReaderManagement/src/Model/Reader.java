/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class Reader extends Vector<Object> implements Comparable{
    private String readerID;
    private String readername;
    private boolean gender;
    private Date birthday;
    private String address;
    private String email;
    private String phone;

    public Reader() {
    }

    public Reader(String readerID, String readername, boolean gender, Date birthday, String address, String email, String phone) {
        this.readerID = readerID;
        this.readername = readername;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public String getReaderID() {
        return readerID;
    }

    public void setReaderID(String readerID) {
        this.readerID = readerID;
    }

    public String getReadername() {
        return readername;
    }

    public void setReadername(String readername) {
        this.readername = readername;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(Object t) {
        return this.getReadername().compareToIgnoreCase(((Reader) t).getReadername());
    }
    
    
    
}
