package ObjectModels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class RegistrationModel {
    private RegistrationAccountModel account;

    private String firstNameError;
    private String lastNameError;
    private String phoneError;
    private String emailError;
    private String passwordError;
    private String confirmPasswordError;
    private String termsError;

    public RegistrationModel(String firstName,
                             String lastName,
                             String phone,
                             String email,
                             String password,
                             String confirmPassword,
                             String firstNameError,
                             String lastNameError,
                             String phoneError,
                             String emailError,
                             String passwordError,
                             String confirmPasswordError,
                             String termsError) {
        RegistrationAccountModel arc = new RegistrationAccountModel();
        arc.setFirstName(firstName);
        arc.setLastName(lastName);
        arc.setPhone(phone);
        arc.setEmail(email);
        arc.setPassword(password);
        arc.setConfirmPassword(confirmPassword);

        this.account = arc;
        this.firstNameError = firstNameError;
        this.lastNameError = lastNameError;
        this.phoneError = phoneError;
        this.emailError = emailError;
        this.passwordError = passwordError;
        this.confirmPasswordError = confirmPasswordError;
        this.termsError = termsError;
    }

    @Override
    public String toString() {
        return "RegistrationData{" +
                "account={firstName:" + account.getFirstName() +
                ",lastName:" + account.getLastName() +
                ",phone:" + account.getPhone() +
                ",email:" + account.getEmail() +
                ",password:" + account.getPassword() +
                ",confirmPassword:" + account.getConfirmPassword() +
                "}, firstNameError='" + firstNameError + '\'' +
                ", lastNameError='" + lastNameError + '\'' +
                ", phoneError='" + phoneError + '\'' +
                ", emailError='" + emailError + '\'' +
                ", confirmPasswordError='" + confirmPasswordError + '\'' +
                ", passwordError='" + passwordError + '\'' +
                '}';
    }
}
