package com.zsgs.InterviewPanelManagement.model;

import com.zsgs.InterviewPanelManagement.datalayer.InterviewPanelDatabase;

public class Schedule {
    private int scheduleId;
    private static int count= InterviewPanelDatabase.getInstance().showSelected().size()+1;
    private int candidateId;
    private String candidateName;
    private String interviewerName;
    private String team;
    private String feedback;
    private String email;

    public Schedule( int candidateId, String candidateName, String interviewerName, String team,String email,String feedback) {
        this.scheduleId = count++;
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.interviewerName = interviewerName;
        this.team = team;
        this.email=email;
        this.feedback=feedback;
    }

    public int getScheduleId() {
        return scheduleId;
    }



    public int getCandidateId() {
        return candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getInterviewerName() {
        return interviewerName;
    }
    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
