package com.example.cs5200sp20liuserverjava.models;

public enum Privilege {
    creat(1),
    read(2),
    update(3),
    delete(4);

    public final int fId;
    private Privilege(int id){
        this.fId=id;
    }
    public static Privilege getValue(int id){
        return values()[id-1];
    }



}
