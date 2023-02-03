package Tests.ObjectModels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class LoginModel {
    private LoginAccountModel account;
    private String userError;
    private String passwordError;

//    public LoginModel() {
//    }

    public LoginModel(String username, String password, String userError, String passwordError) {
        LoginAccountModel ac = new LoginAccountModel();
        ac.setUsername(username);
        ac.setPassword(password);

        this.account = ac;
        this.userError = userError;
        this.passwordError = passwordError;
    }

//    public AccountModel getAccount() {
//        return account;
//    }
//
//    public void setAccount(AccountModel account) {
//        this.account = account;
//    }
//
//    public String getUserError() {
//        return userError;
//    }
//
//    public void setUserError(String userError) {
//        this.userError = userError;
//    }
//
//    public String getPasswordError() {
//        return passwordError;
//    }
//
//    public void setPasswordError(String passwordError) {
//        this.passwordError = passwordError;
//    }

    @Override
    public String toString() {
        return "LoginData{" +
                "account={username:" + account.getUsername() + ",password:" + account.getPassword() +
                "}, userError='" + userError + '\'' +
                ", passwordError='" + passwordError + '\'' +
                '}';
    }
}
