package com.example.cs5200sp20liuserverjava.models;

import java.util.ArrayList;
import java.sql.*;

public class Person {
    private int pId;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private Date dob;
    private String phone=null;
    private String Address=null;



    public Person(int pId, String firstName, String lastName) {
        super();
        this.pId = pId;
        this.firstname = firstName;
        this.lastname = lastName;
    }


    public Person(int pId, String firstName, String lastName, String userName, String password, String email,
                  Date dob) {
        super();
        this.pId = pId;
        this.firstname = firstName;
        this.lastname = lastName;
        this.username = userName;
        this.password = password;
        this.email = email;
        this.dob = dob;
    }

    public Person(int pId, String firstName, String lastName, String userName, String password, String email,
                  Date dob, String phones) {
        super();
        this.pId = pId;
        this.firstname = firstName;
        this.lastname = lastName;
        this.username = userName;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.phone = phones;
    }

    public Person(int pId, String firstName, String lastName, String userName, String password, String email,
                  String address) {
        super();
        this.pId = pId;
        this.firstname = firstName;
        this.lastname = lastName;
        this.username = userName;
        this.password = password;
        this.email = email;
        this.Address = address;
    }

    public Person(int pId, String firstName, String lastName, String userName, String password, String email,
                  Date dob, String address, String phones) {
        super();
        this.pId = pId;
        this.firstname = firstName;
        this.lastname = lastName;
        this.username = userName;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.Address = address;
        this.phone = phones;
    }

    public Person() {

    }


    public Person(int pId, String userName, String password, String firstName, String lastName, String email) {
        super();
        this.pId = pId;
        this.firstname = firstName;
        this.lastname = lastName;
        this.username = userName;
        this.password = password;
        this.email = email;
    }

    public Person(int pId, String email) {
    }


    public int getpId() {
        return pId;
    }
    public void setpId(int pId) {
        this.pId = pId;
    }
    public String getFirstName() {
        return firstname;
    }
    public void setFirstNAme(String firstNAme) {
        this.firstname = firstNAme;
    }
    public String getLastName() {
        return lastname;
    }
    public void setLastName(String lastName) {
        this.lastname = lastName;
    }
    public String getUserName() {
        return username;
    }
    public void setUserName(String userName) {
        this.username = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getAddress() { return Address; }
    public String setAddress() { return Address; }
    public String getPhone() { return Address; }
    public String setPhone() { return Address; }


}
