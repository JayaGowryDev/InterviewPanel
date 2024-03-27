package com.zsgs.InterviewPanelManagement.interviewScheduling;

import com.zsgs.InterviewPanelManagement.model.Candidate;
import com.zsgs.InterviewPanelManagement.model.Interviewer;
import com.zsgs.InterviewPanelManagement.model.Schedule;

import java.util.Map;
import java.util.Scanner;

public class InterviewSchedulingView {
    private InterviewSchedulingModel interviewSchedulingModel;
    public InterviewSchedulingView(){
        interviewSchedulingModel=new InterviewSchedulingModel(this);
    }
    public void init(){
        System.out.print("\nMain menu \n1. Manage Candidate \n2. Manage Interview \n3. Exit \n Enter your choice  :");
        Scanner scan=new Scanner(System.in);
        int choice=scan.nextInt();

            switch (choice){
                case 1:
                    manageCandidate();
                    break;
                case 2:
                    manageInterview();
                    break;
                case 3:
                    System.out.print("-------------Thanks for using Interview panel application-----------");

            }


    }
    private void manageCandidate(){
        Scanner scan =new Scanner(System.in);
        System.out.print("\nTo Manage Candidate Details  \n Please proceed to login as a receptionist\n");
        System.out.print("Enter username             : ");
        String username=scan.nextLine();
        System.out.print("Enter Password             : ");
        String password=scan.nextLine();
        boolean isLogin=interviewSchedulingModel.receptionistLogin(username,password);
        if(isLogin){
            System.out.print("-----------------Login Successfully-------------");
            receptionistMenu();
        }
        else{
            System.out.print("Username or Password is incorrect");
            init();
        }


    }
    private void receptionistMenu(){
        System.out.print("\nCandidate Menu \n1. Add Canditate \n2. Show Candidate List \n3.Exit \n Enter your choice :");
        Scanner scan=new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                addCandidate();
                break;
            case 2:
                showCandidate();
                break;
            case 3:
                init();
                break;
        }
    }
    private void addCandidate(){
        Scanner scan=new Scanner(System.in);
        System.out.print("---------Enter Candidate Details -------");
        System.out.print("\nEnter Candidate name :");
        String name=scan.nextLine();
        System.out.print("Enter qualification   :");
        String quali=scan.nextLine();
        System.out.print("Enter Email           :");
        String email=scan.nextLine();
        System.out.print("Enter Team            :");
        String team=scan.nextLine();
        System.out.print("Enter age             :");
        int age=scan.nextInt();
        scan.nextLine();
        if(interviewSchedulingModel.checkTeam(team)){
            Candidate candi=new Candidate(name ,quali,email,team,age);
            interviewSchedulingModel.addCandidate(candi);

        }
        else{
            System.out.println("Sorry, Team not exist");
        }
        againAdded();
    }

    //manage interview

    private void againAdded(){
        System.out.print("Do you want added again ? ");
        Scanner scan =new Scanner(System.in);
        String val=scan.nextLine();
        if(val.equals("y")){
            addCandidate();
        }
        else{
            receptionistMenu();
        }
    }
       //// show candidate
    private void showCandidate(){
        Map<Integer,Candidate> value=interviewSchedulingModel.showCandidate();
                System.out.print(" -------------------List of Candidate-------------------------- ");

        for(Candidate item : value.values()){
            System.out.println("Candidate Id  :"+item.getId() +"\n"
                              +"Name          : "+item.getName()+"\n"+
                               "Qualification :"+item.getQualification()+"\n"+
                               "Email Id      :"+item.getEmail()+"\n"+
                               "Age           :"+item.getAge()+"\n" +
                               "Team          : "+item.getTeam()+"\n-------------------------------------------------------------------");
        }
        receptionistMenu();

    }
    ////---------------manageInterview----------------
    private void manageInterview(){
        Scanner scan =new Scanner(System.in);
        System.out.print("To Manage Interview Details  \n Please proceed to login as a Hr\n");
        System.out.print("Enter username             :");
        String username=scan.nextLine();
        System.out.print("Enter Password             :");
        String password=scan.nextLine();
        boolean isLogin=interviewSchedulingModel.hrLogin(username,password);
        if(isLogin){
            System.out.print("-----------------Login Successfully-------------");
            hrMenu();
        }
        else{
            System.out.print("Username or Password is incorrect");
            init();
        }
    }
    private void hrMenu(){
        System.out.print("\nInterview Menu \n1. Add Interviewer \n2. Show Interviewer List \n3.Schedule Interview \n4. Selected List\n5. Exit \n Enter your choice :");
        Scanner scan=new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                addInterviewer();
                break;
            case 2:
                showInterviewer();
                break;
            case 3:
                scheduleInterview();
                break;
            case 4:
                selectedCandidate();
                break;
            case 5:
                init();
                break;
        }
    }

    private void addInterviewer() {
        Scanner scan=new Scanner(System.in);
        System.out.print("---------Enter Interviewer Details -------");
        System.out.print("\nEnter Interviewer name   :  ");
        String name=scan.nextLine();
        System.out.print("Enter Team                 :  ");
        String team=scan.nextLine();
        System.out.print("Enter Email                :  ");
        String email=scan.nextLine();
        Interviewer in=new Interviewer(name ,email,team);
        interviewSchedulingModel.addInterviewer(in);
        againInterviewerAdded();
    }
    private void againInterviewerAdded(){
        System.out.print("Do you want added again ?");
        Scanner scan =new Scanner(System.in);
        String val=scan.nextLine();
        if(val.equals("y")){
            addInterviewer();
        }
        else{
            hrMenu();
        }
    }
    private void showInterviewer() {
        Map<String,Interviewer> value=interviewSchedulingModel.showInterviewer();
        System.out.println("------------------List Of Interviewer---------------------");
        for(Interviewer item : value.values()){
            System.out.println("Interviewer Id  :"+item.getInterviewerID() +"\n"
                    +"Name          : "+item.getName()+"\n"+
                    "Email Id      :"+item.getEmail()+"\n"+
                    "Team          : "+item.getTeam()+"\n-------------------------------------------------------------------");
        }
        hrMenu();
    }
    private void scheduleInterview() {
        interviewSchedulingModel.scheduleInterview();
        hrMenu();
    }
    private void selectedCandidate() {
        Map<Integer, Schedule> candi=interviewSchedulingModel.selectedCandidate();
        System.out.println("\n--------------------List of Selected Candidate ---------------------");
        for(Map.Entry<Integer, Schedule> entry : candi.entrySet()){
            if(entry.getValue().getFeedback().equals("Selected")){
                System.out.println("Candidate Name     :"+entry.getValue().getCandidateName() +"\n"
                        +"Team              : "+entry.getValue().getTeam()+"\n"+
                        "Interviewer  Name  :"+entry.getValue().getInterviewerName()+"\n"+
                        "Email Id           : "+entry.getValue().getEmail()+"\n-------------------------------------------------------------------");
            }
        }
        hrMenu();
    }
    public boolean isSelected(int id){
        System.out.println("-----Candidate id "+id +"  on process-------");
        System.out.print("Did the Candidate id "+id +"  got Selected ? \n Yes ---> y \n No --->n \n Is Selected :  ");
        Scanner scan =new Scanner(System.in);
        String result=scan.nextLine();
        if(result.equals("y")){
            return true;
        }
        else {
            return false;
        }

    }
    public void showAlert(String msg){
        System.out.println(msg);
    }


}
