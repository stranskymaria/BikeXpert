package Tests.ObjectModels;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegistrationAccountModel {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String confirmPassword;
}
