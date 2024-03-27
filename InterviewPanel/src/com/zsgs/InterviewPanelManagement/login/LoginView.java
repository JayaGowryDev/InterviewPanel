package com.zsgs.InterviewPanelManagement.login;

import com.zsgs.InterviewPanelManagement.InterviewPanelManagement;
import com.zsgs.InterviewPanelManagement.datalayer.InterviewPanelDatabase;
import com.zsgs.InterviewPanelManagement.panelsetup.PanelSetupView;

import java.util.Scanner;

public class LoginView {
    private LoginModel loginModel;

    public LoginView() {
        loginModel=new LoginModel(this);
    }
    public void init() {
        System.out.println("---" + InterviewPanelManagement.getInstance().getAppName() +"--- version"+ InterviewPanelManagement.getInstance().getVersion());
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------Login to proceed as a admin---------------------------");
        System.out.print("Enter default user name:");
        String userName = scanner.nextLine();
        System.out.print("Enter default password:");
        String password = scanner.nextLine();

        loginModel.validateUser(userName, password);
    }
    public void onSuccess() {
        System.out.flush();
        System.out.println("Login successful...");
        new PanelSetupView().init();



    }
    public void showAlert(String alertText) {
        System.out.println(alertText);
    }


}
