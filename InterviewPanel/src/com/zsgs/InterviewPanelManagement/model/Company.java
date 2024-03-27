package com.zsgs.InterviewPanelManagement.model;

public class Company {
    private String name;
    private String email;
    private String location;
    private String companyType;
    private long phone;
    private String founder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String company) {
        this.companyType = company;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }
}
