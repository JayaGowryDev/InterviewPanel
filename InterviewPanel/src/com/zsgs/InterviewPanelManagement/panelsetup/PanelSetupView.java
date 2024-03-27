package com.zsgs.InterviewPanelManagement.panelsetup;

import com.zsgs.InterviewPanelManagement.interviewScheduling.InterviewSchedulingView;
import com.zsgs.InterviewPanelManagement.model.Company;
import com.zsgs.InterviewPanelManagement.model.Hr;
import com.zsgs.InterviewPanelManagement.model.Receptionist;


import java.util.Map;
import java.util.Scanner;

public class PanelSetupView {
	private PanelSetupModel panelSetupModel;
	public PanelSetupView() {
		panelSetupModel=new PanelSetupModel(this);
	}
	public void init(){
		panelSetupModel.startSetup();

	}

	public void initialSetup(){
		System.out.println("Enter Company Details");
		Scanner scan=new Scanner(System.in);
		Company company=new Company();
		System.out.print("Enter Company Name              :");
		company.setName(scan.nextLine());
		System.out.print("Enter Email id                  :");
		company.setEmail(scan.nextLine());
		System.out.print("Enter Company Location          :");
		company.setLocation(scan.nextLine());
		System.out.print("Enter Company Type              :");
		company.setCompanyType(scan.nextLine());
		System.out.print("Enter Company Phone Number      :");
		company.setPhone(scan.nextLong());
		scan.nextLine();
		System.out.print("Enter Founder of the company    :");
		company.setFounder(scan.nextLine());
		panelSetupModel.createCompany(company);
	}
	public void onSetupComplete(Company company){
		System.out.println("Company setup complete successfully");

		panelSetupModel.startSetupHr();
		panelSetupModel.startSetupReceptionist();
		new InterviewSchedulingView().init();

	}
	public void onsetHr(Hr hr){
		System.out.println("\n---------HR Profile is Created Successfully------------");
	}
	public void onSetReception(Receptionist receptionist){
		System.out.println("---------Receptionist Profile is Created Successfully------------");
	}
	public void creatHr(){

		System.out.println("\n----------------Enter Hr Details -----------------");
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter name of the Hr        :");
		String name=scan.nextLine();
		System.out.print("Create username             :");
		String userName=scan.nextLine();
		System.out.print("Enter Password              :");
		String password=scan.nextLine();
		System.out.print("Enter Email id              :");
		String email=scan.nextLine();
		System.out.print("Enter Phone Number           :");
		long phoneNo=scan.nextLong();
		Hr hr=new Hr(userName,password,name,email,phoneNo);
		panelSetupModel.createHr(hr);


	}
	public void creatReception(){

		System.out.println("----------------Enter Receptionist Details -----------------");
		Scanner scan=new Scanner(System.in);

		System.out.print("Enter name of the Reception         :");
		String name=scan.nextLine();
		System.out.print("Create username                     :");
		String userName=scan.nextLine();
		System.out.print("Enter Password                      :");
		String password=scan.nextLine();
		System.out.print("Enter Email id                      :");
		String email=scan.nextLine();
		System.out.print("Enter Phone Number                  :");
		long phoneNo=scan.nextLong();
		Receptionist receptionist=new Receptionist(userName,password,name,email,phoneNo);
		panelSetupModel.createReceptionist(receptionist);

	}
	public void showAlert(String msg){
		System.out.println("-----------------"+msg+"-----------------");
	}

}
