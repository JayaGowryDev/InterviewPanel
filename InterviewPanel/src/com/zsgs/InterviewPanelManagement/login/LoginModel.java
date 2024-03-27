package com.zsgs.InterviewPanelManagement.login;

class LoginModel {
    private LoginView loginView;

    LoginModel(LoginView loginView){
        this.loginView=loginView;
    }
    public void validateUser(String userName, String password) {
        if(isValidUserName(userName)) {
            if(isVaildPassword(password)) {
                loginView.onSuccess();
            }
            else {
                loginView.showAlert("Password is incorrect");
            }
        }
        else {
            loginView.showAlert("Invalid User Name");
        }
    }

    private boolean isVaildPassword(String password) {

        return password.equals("9943");
    }

    private boolean isValidUserName(String userName) {
        return userName.equals("Gowry");
    }
}
