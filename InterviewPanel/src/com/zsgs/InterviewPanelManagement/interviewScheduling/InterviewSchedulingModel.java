package com.zsgs.InterviewPanelManagement.interviewScheduling;

import com.zsgs.InterviewPanelManagement.datalayer.InterviewPanelDatabase;
import com.zsgs.InterviewPanelManagement.model.*;

import java.util.List;
import java.util.Map;
import java.util.Queue;

class InterviewSchedulingModel {
    private  InterviewSchedulingView interviewSchedulingView;
    InterviewSchedulingModel(InterviewSchedulingView interviewSchedulingView){
        this.interviewSchedulingView=interviewSchedulingView;

    }
    public boolean receptionistLogin(String username, String password){
        Receptionist value= InterviewPanelDatabase.getInstance().showReceptionist();
        if(value.getUserName().equals(username) && value.getPassword().equals(password)){
            return true;
        }
        return false;
    }
    public boolean hrLogin(String username, String password){
        Hr value= InterviewPanelDatabase.getInstance().showHr();
        if(value.getUserName().equals(username) && value.getPassword().equals(password)){
            return true;
        }
        return false;
    }
    public boolean checkTeam(String team){
        Map<String,Interviewer> value=InterviewPanelDatabase.getInstance().showInterviewer();
        if(value.containsKey(team)){
            return true;
        }
        else {
            return false;
        }
    }
    public void addCandidate(Candidate candidate){
        InterviewPanelDatabase.getInstance().addCandidate(candidate);
        InterviewPanelDatabase.getInstance().serialzeCanditateList(InterviewPanelDatabase.getInstance().showCandidate());
        interviewSchedulingView.showAlert("Candidate Successfully added");
    }
    public  Map<Integer,Candidate> showCandidate(){
        Map<Integer,Candidate> value=InterviewPanelDatabase.getInstance().showCandidate();
        return value;


    }
    public void addInterviewer(Interviewer interviewer){
        Map<String,Interviewer> value=InterviewPanelDatabase.getInstance().showInterviewer();
        if(value.containsKey(interviewer.getTeam())){
            interviewSchedulingView.showAlert("This Team already have an Interviewer");
        }
        else {
            InterviewPanelDatabase.getInstance().addInterviewer(interviewer);

            interviewSchedulingView.showAlert("Interviewer added successfully");
        }
        InterviewPanelDatabase.getInstance().serialzeInterviewerList(InterviewPanelDatabase.getInstance().showInterviewer());
    }
    public  Map<String ,Interviewer> showInterviewer(){
        Map<String ,Interviewer> value=InterviewPanelDatabase.getInstance().showInterviewer();
        return value;


    }
    //schedule interview
    public void scheduleInterview(){
        while(!InterviewPanelDatabase.getInstance().getCandidateQueue().isEmpty()){
            int canid=InterviewPanelDatabase.getInstance().getCandidateQueue().peek();
            Candidate candidate=InterviewPanelDatabase.getInstance().showCandidate().get(canid);
            Map<String ,Interviewer> value=InterviewPanelDatabase.getInstance().showInterviewer();
            if(value.containsKey(candidate.getTeam())){
                Interviewer in=value.get(candidate.getTeam());
                if(interviewSchedulingView.isSelected(candidate.getId())){
                    Schedule schedule=new Schedule(canid, candidate.getName(), in.getName(),in.getTeam(),candidate.getEmail(),"Selected");
                    InterviewPanelDatabase.getInstance().addSchedule(schedule);
                    InterviewPanelDatabase.getInstance().serialzeSchedule(InterviewPanelDatabase.getInstance().showSelected());
                }else{
                    Schedule schedule=new Schedule(canid, candidate.getName(), in.getName(),in.getTeam(),candidate.getEmail(),"Rejected");
                    InterviewPanelDatabase.getInstance().addSchedule(schedule);
                    InterviewPanelDatabase.getInstance().serialzeSchedule(InterviewPanelDatabase.getInstance().showSelected());
                }


            }
            else{
                interviewSchedulingView.showAlert("Sorry ,Your team is not exist ");
            }
            InterviewPanelDatabase.getInstance().getCandidateQueue().poll();
        }


    }
    public  Map<Integer,Schedule> selectedCandidate(){
        return InterviewPanelDatabase.getInstance().showSelected();

    }

}
