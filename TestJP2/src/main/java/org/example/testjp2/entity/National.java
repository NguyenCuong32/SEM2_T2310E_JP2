package org.example.testjp2.entity;

public class National {

    private Integer NationalID;
    private String NationNames;

    public  National(Integer NationalID, String NationNames) {
        this.NationalID = NationalID;
        this.NationNames = NationNames;
    }

    public National() {

    }

    public Integer getNationalID() {
        return NationalID;
    }

    public void setNationalID(Integer nationalID) {
        NationalID = nationalID;
    }

    public String getNationNames() {
        return NationNames;
    }

    public void setNationNames(String nationNames) {
        NationNames = nationNames;
    }


}
