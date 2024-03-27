package com.zsgs.InterviewPanelManagement.model;

public class Receptionist {
    private String userName;
    private String password;
    private String name;
    private String email;
    private long Phone;

    public Receptionist(String userName, String password, String name, String email, long phone) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        Phone = phone;
    }

    public String getUserName() {
        return userName;
    }



    public String getPassword() {
        return password;
    }



    public String getName() {
        return name;
    }



    public String getEmail() {
        return email;
    }



    public long getPhone() {
        return Phone;
    }


}
