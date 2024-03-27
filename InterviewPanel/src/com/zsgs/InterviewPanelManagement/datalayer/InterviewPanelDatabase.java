package com.zsgs.InterviewPanelManagement.datalayer;

import com.google.gson.reflect.TypeToken;
import com.zsgs.InterviewPanelManagement.jsonconversion.ConvertJson;
import com.zsgs.InterviewPanelManagement.model.*;

import java.util.*;

public class InterviewPanelDatabase {
    private static InterviewPanelDatabase interviewPanelDatabase;
    private Company company;
    private Map<Integer, Candidate> candidateMap=new LinkedHashMap();
    private Queue<Integer> candidateQueue = new LinkedList();
    private Map<String, Interviewer> interviewerMap=new LinkedHashMap();
    private Map<Integer,Schedule> scheduleMap=new LinkedHashMap();
    private Hr hr;
    private Receptionist receptionist;
    public static InterviewPanelDatabase getInstance(){
        if(interviewPanelDatabase==null){
            interviewPanelDatabase=new InterviewPanelDatabase();
        }
        return interviewPanelDatabase;
    }
    public Company getCompany(){
        return company;
    }
    public Company insertCompany(Company val){
        this.company=val;
        return company;
    }

    public Hr insertHr(Hr val){
        this.hr=val;
        return hr;
    }
    public Hr showHr(){
        return hr;
    }

    public Receptionist insertReceptionist(Receptionist val){
        this.receptionist=val;
        return receptionist;
    }
    public Receptionist showReceptionist(){
        return receptionist;
    }

    //canditate
    public void addCandidate(Candidate candi){
        int id=candi.getId();
        candidateMap.put(id,candi);
        candidateQueue.add(id);

    }
    public Map<Integer,Candidate> showCandidate(){
        return candidateMap;
    }
    //Interviewer
    public void addInterviewer(Interviewer in){
        String team=in.getTeam();
        interviewerMap.put(team,in);
    }
    public Map<String,Interviewer> showInterviewer(){
        return interviewerMap;
    }
    public  Queue<Integer> getCandidateQueue(){
        return candidateQueue;
    }
    //schedule
    public void addSchedule(Schedule sh){
        scheduleMap.put(sh.getCandidateId(),sh);
    }
    public  Map<Integer,Schedule> showSelected(){
        return scheduleMap;
    }



    //serialization
    public void serialzeCanditateList(Map<Integer, Candidate> candidatelist){
        ConvertJson.getConvertJson().serialize(candidatelist,"E:\\InterviewPanel\\src\\com\\zsgs\\InterviewPanelManagement\\data\\candidateJson.json");
    }
    public void serialzeInterviewerList(Map<String, Interviewer> interviewerList){
        ConvertJson.getConvertJson().serialize(interviewerList,"E:\\InterviewPanel\\src\\com\\zsgs\\InterviewPanelManagement\\data\\interviewer.json");
    }
    public void serialzeSchedule(Map<Integer,Schedule> schedulelist){
        ConvertJson.getConvertJson().serialize(schedulelist,"E:\\InterviewPanel\\src\\com\\zsgs\\InterviewPanelManagement\\data\\schedule.json");
    }
    public void serializeCompany(Company company1){
        ConvertJson.getConvertJson().serialize(company1,"E:\\InterviewPanel\\src\\com\\zsgs\\InterviewPanelManagement\\data\\company.json");
    }
    public void serializeHr(Hr hr1){
        ConvertJson.getConvertJson().serialize(hr1,"E:\\InterviewPanel\\src\\com\\zsgs\\InterviewPanelManagement\\data\\hr.json");
    }
    public void serializeReceptionist(Receptionist receptionist1){
        ConvertJson.getConvertJson().serialize(receptionist1,"E:\\InterviewPanel\\src\\com\\zsgs\\InterviewPanelManagement\\data\\receptionist.json");
    }



    //deserialization
    private void deserializeCandidateList(){
        Map<Integer, Candidate> candidatelist1=ConvertJson.getConvertJson().deserialize(new TypeToken<Map<Integer, Candidate>>(){},"E:\\InterviewPanel\\src\\com\\zsgs\\InterviewPanelManagement\\data\\candidateJson.json");
        if(!candidatelist1.isEmpty()){
            this.candidateMap=candidatelist1;
        }
    }
    private void deserialzeInterviewerList(){
        Map<String, Interviewer> interviewer1=ConvertJson.getConvertJson().deserialize(new TypeToken<Map<String, Interviewer> >(){},"E:\\InterviewPanel\\src\\com\\zsgs\\InterviewPanelManagement\\data\\interviewer.json");
        if(!interviewer1.isEmpty()){
            this.interviewerMap=interviewer1;
        }
    }
    private void deserialzeSchedule(){
        Map<Integer,Schedule> schedule1=ConvertJson.getConvertJson().deserialize(new TypeToken<Map<Integer, Schedule> >(){},"E:\\InterviewPanel\\src\\com\\zsgs\\InterviewPanelManagement\\data\\schedule.json");
        if(!schedule1.isEmpty()){
            this.scheduleMap=schedule1;
        }
    }
    private void deserializecompany(){
        this.company=ConvertJson.getConvertJson().deserialize(Company.class,"E:\\InterviewPanel\\src\\com\\zsgs\\InterviewPanelManagement\\data\\company.json");
    }
    private void deserializeHr(){
        this.hr=ConvertJson.getConvertJson().deserialize(Hr.class,"E:\\InterviewPanel\\src\\com\\zsgs\\InterviewPanelManagement\\data\\hr.json");
    }
    private void deserializeReceptionist(){
        this.receptionist=ConvertJson.getConvertJson().deserialize(Receptionist.class,"E:\\InterviewPanel\\src\\com\\zsgs\\InterviewPanelManagement\\data\\receptionist.json");
    }



    public void deserialize(){
        deserializeCandidateList();
       deserialzeInterviewerList();
       deserialzeSchedule();
       deserializeHr();
       deserializecompany();
       deserializeReceptionist();
    }


}
