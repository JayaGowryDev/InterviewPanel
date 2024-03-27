package com.zsgs.InterviewPanelManagement.model;

import com.zsgs.InterviewPanelManagement.datalayer.InterviewPanelDatabase;

public class Candidate {
    private int id;
    private  int count= InterviewPanelDatabase.getInstance().showCandidate().size()+1;
    private String name;
    private String qualification;
    private String email;
    private String team;
    private int age;

    public Candidate( String name, String qualification, String email, String team, int age) {
        this.id = count++;
        this.name = name;
        this.qualification = qualification;
        this.email = email;
        this.team = team;
        this.age = age;
    }

    public int getId() {
        return id;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
