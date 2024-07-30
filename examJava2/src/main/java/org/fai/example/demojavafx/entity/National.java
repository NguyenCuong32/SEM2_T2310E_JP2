package org.fai.example.demojavafx.entity;

public class National {
    private Integer NationalId;
    private String NationalName;

    public National(Integer nationalId, String nationalName) {
        NationalId = nationalId;
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
