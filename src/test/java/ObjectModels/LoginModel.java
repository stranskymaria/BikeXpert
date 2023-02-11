package ObjectModels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class LoginModel {
    private LoginAccountModel account;
    private String emailError;
    private String passwordError;

    public LoginModel(String email, String password, String emailError, String passwordError) {
        LoginAccountModel ac = new LoginAccountModel();
        ac.setEmail(email);
        ac.setPassword(password);

        this.account = ac;
        this.emailError = emailError;
        this.passwordError = passwordError;
    }

    @Override

    public String toString() {
        return "LoginData{" +
                "account={email:" + account.getEmail() + ",password:" + account.getPassword() +
                "}, emailError='" + emailError + '\'' +
                ", passwordError='" + passwordError + '\'' +
                '}';
    }
}
