package com.zsgs.InterviewPanelManagement.panelsetup;

import com.zsgs.InterviewPanelManagement.datalayer.InterviewPanelDatabase;
import com.zsgs.InterviewPanelManagement.model.Company;
import com.zsgs.InterviewPanelManagement.model.Hr;
import com.zsgs.InterviewPanelManagement.model.Receptionist;

import java.util.Map;

class PanelSetupModel {
	private PanelSetupView panelSetupView;
	private  Company company;
	private Hr hr;
	private Receptionist receptionist;
	PanelSetupModel(PanelSetupView panelSetupView){
		this.panelSetupView=panelSetupView;
		company= InterviewPanelDatabase.getInstance().getCompany();
		hr=InterviewPanelDatabase.getInstance().showHr();
		receptionist=InterviewPanelDatabase.getInstance().showReceptionist();
	}

	public void startSetup(){
		if(company==null){
			panelSetupView.initialSetup();
		}
		else{
			panelSetupView.onSetupComplete(company);
		}
	}
	public void startSetupHr(){
		if(hr==null){
			panelSetupView.showAlert("------Create Account for HR------");
			panelSetupView.creatHr();
		}
		else{
			panelSetupView.onsetHr(hr);
		}
	}
	public void startSetupReceptionist(){
		if(receptionist==null){
			panelSetupView.showAlert("------Create Account for Receptionist------");
			panelSetupView.creatReception();
		}
		else{
			panelSetupView.onSetReception(receptionist);
		}
	}

	public void createCompany(Company company){
		this.company=InterviewPanelDatabase.getInstance().insertCompany(company);
		InterviewPanelDatabase.getInstance().serializeCompany(company);
		panelSetupView.onSetupComplete(company);
	}
	public void createHr(Hr hr){
		this.hr=InterviewPanelDatabase.getInstance().insertHr(hr);
		InterviewPanelDatabase.getInstance().serializeHr(hr);
		panelSetupView.onsetHr(hr);

//		panelSetupView.showAlert("HR Profile is Created Successfully");
		//Hr det=InterviewPanelDatabase.getInstance().showHr();
	}
	public void createReceptionist(Receptionist receptionist){
		this.receptionist=InterviewPanelDatabase.getInstance().insertReceptionist(receptionist);
		InterviewPanelDatabase.getInstance().serializeReceptionist(receptionist);
		panelSetupView.onSetReception(receptionist);
//		panelSetupView.showAlert("Receptionist Profile is Created Successfully");
//
	}



}
