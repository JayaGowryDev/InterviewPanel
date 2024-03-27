package com.zsgs.InterviewPanelManagement.model;

import com.zsgs.InterviewPanelManagement.datalayer.InterviewPanelDatabase;

public class Interviewer {
    private int interviewerID;
    private static int count= InterviewPanelDatabase.getInstance().showInterviewer().size()+1;
    private String name;
    private String email;
    private String team;

    public Interviewer( String name, String email, String team) {
        this.interviewerID = count++;
        this.name = name;
        this.email = email;
        this.team = team;
    }

    public int getInterviewerID() {
        return interviewerID;
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
