package com.example.cs5200sp20liuserverjava.models;


import java.util.ArrayList;
import java.sql.*;
public class Developer extends Person {

    private String developerKey;
    private ArrayList<Website> websites;
    public Developer(int pId, String userName, String password, String firstName, String lastName, String email, String developerKey) {
        super(pId,userName,password,firstName,lastName,email);
        this.developerKey=developerKey;

    }

    public Developer(String developerKey, int pId, String firstName, String lastName, String userName, String password, String email,
                     Date dob) {
        super(pId,firstName,lastName,userName,password,email,dob);
        this.developerKey=developerKey;
        System.out.println(this.developerKey);
    }


    public Developer(String developerKey,int pId, String firstName, String lastName, String userName, String password, String email, Date dob,
                     String address, String phones) {
        super(pId,firstName,userName,password,email,address,dob,phones);
        this.developerKey=developerKey;
        System.out.println(this.developerKey);
    }


    public Developer(int pId, String userName, String password, String firstName, String lastName, String email, String developerKey, String phone) {
        super(pId,userName,password,firstName,lastName,email,phone);
        this.developerKey=developerKey;

    }

    public Developer(int id, int page_id, String name, String width, String height, String css_class, String css_style, String text, int order) {
    }


    public String getDeveloperKey() { return this.developerKey; }
    public void setDeveloperKey(String developerKey) {
        this.developerKey = developerKey;
    }
    public ArrayList<Website> getWebsites() {
        return this.websites;
    }
    public void setWebsites(ArrayList<Website> websites) {
        this.websites = websites;
    }

}
