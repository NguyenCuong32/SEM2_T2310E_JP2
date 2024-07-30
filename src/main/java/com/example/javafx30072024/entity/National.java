package com.example.javafx30072024.entity;

public class National {
    private Long nationalId;
    private String nationalName;

    public National(Long nationalId, String nationalName) {
        this.nationalId = nationalId;
        this.nationalName = nationalName;
    }

    public National() {
    }

    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }
}
