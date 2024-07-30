package com.example.final_exam.model;

public class NationalModel {
    private Integer NationalId;
    private String NationalName;

    public NationalModel() {
    }

    public NationalModel(String nationalName) {
        NationalName = nationalName;
    }

    public Integer getNationalId() {
        return NationalId;
    }

    public void setNationalId(Integer nationalId) {
        NationalId = nationalId;
    }

    public String getNationalName() {
        return NationalName;
    }

    public void setNationalName(String nationalName) {
        NationalName = nationalName;
    }
}
