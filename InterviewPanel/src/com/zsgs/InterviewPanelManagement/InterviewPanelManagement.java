package com.zsgs.InterviewPanelManagement;

import com.zsgs.InterviewPanelManagement.datalayer.InterviewPanelDatabase;
import com.zsgs.InterviewPanelManagement.login.LoginView;

public class InterviewPanelManagement {
	private static InterviewPanelManagement interviewPanel;
	private String appName="Interview Panel System";
	private String appVersion="0.1.0";
	private InterviewPanelManagement() {
		
	}
	public static InterviewPanelManagement getInstance() {
		if(interviewPanel==null) {
			interviewPanel=new InterviewPanelManagement();
		}
		return interviewPanel;
	}
	private void create() {
		LoginView loginView=new LoginView();
		loginView.init();
	}
	public String getAppName() {
		return appName;
	}
	public String getVersion() {
		return appVersion;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterviewPanelDatabase.getInstance().deserialize();
		InterviewPanelManagement.getInstance().create();
		
	}

}
