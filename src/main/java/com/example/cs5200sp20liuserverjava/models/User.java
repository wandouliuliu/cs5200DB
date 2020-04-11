package com.example.cs5200sp20liuserverjava.models;

import java.util.ArrayList;
import java.sql.*;

public class User extends Person {

    private Boolean userAgreement= false;

    public User(Boolean userAgreement,int pId,String firstName, String lastName) {
        super(pId,firstName,lastName);
        this.userAgreement=userAgreement;

    }

    public User(int pId, String firstName, String lastName) {
        super(pId, firstName, lastName);
        userAgreement = false;
    }


    public Boolean getUserAgreement() { return this.userAgreement; }
    public void setUserAgreement(Boolean userAgreement) { this.userAgreement = userAgreement; }
}
