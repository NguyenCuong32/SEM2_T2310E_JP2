package com.example.entity;

public class National {
    private int nationalID;
    private String nationalName;
    public int getNationalID() {
        return nationalID;
    }
    public void setNationalID(int nationalID) {
        this.nationalID = nationalID;
    }
    public String getNationalName() {
        return nationalName;
    }
    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }
    public National(int nationalID, String nationalName) {
        this.nationalID = nationalID;
        this.nationalName = nationalName;
    }
    
}
