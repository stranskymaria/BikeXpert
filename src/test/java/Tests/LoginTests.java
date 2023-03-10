package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.MyAccountPage;
import ObjectModels.LoginModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginTests extends BaseTest{

    @Test(priority = 1, groups = {"Smoke", "Regression"}, description = "Verify login page test")
    public void verifyLoginPage(){
        MainPage mp = new MainPage(driver);
        mp.loginPage();
        LoginPage lp = new LoginPage(driver);
        lp.verifyLoginPage();
    }

    @Test(priority = 2, groups = {"Regression"}, description = "Forgot password flow test")
    public void forgotPassword() {
        MainPage mp = new MainPage(driver);
        mp.loginPage();
        LoginPage lp = new LoginPage(driver);
        lp.forgotPasswordClick();
        lp.emailResetPasswordInput("maditest2@gmail.com");
        Assert.assertEquals(lp.emailSentMessage(), "BikeXpert.ro v-a trimis acum un email pentru confirmare resetare parola. Va rugam sa asteptati cateva minute pentru a-l primi. Va multumim.");
    }

    @DataProvider(name = "loginJsonDp")
    public Iterator<Object[]> JsonDpCollection(Method method) throws IOException {
        Collection<Object[]> dp = new ArrayList<>();

//      here is starting deserialization of json into LoginModel object
        ObjectMapper objectMapper = new ObjectMapper();

        String pathName;
        if (method.getName().equals("negativeLoginWithJsonTest")) {
            pathName = "src\\test\\resources\\data\\negative_login.json";
        } else if (method.getName().equals("positiveLoginWithJsonTest")) {
            pathName = "src\\test\\resources\\data\\positive_login.json";
        } else {
            throw new IllegalArgumentException("Method name not recognized. Please check the test method name.");
        }

        File f = new File(pathName);
        LoginModel[] lms = objectMapper.readValue(f, LoginModel[].class);

        for (LoginModel lm : lms)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }

    @Test(dataProvider = "loginJsonDp", priority = 3, groups = {"Regression"}, description = "Negative login tests with JSON")
    public void negativeLoginWithJsonTest(LoginModel lm) {
//       open login page
        MainPage mp = new MainPage(driver);
        mp.loginPage();
//        print data set
        System.out.println(lm);
        LoginPage lp = new LoginPage(driver);
//      login
        lp.login(lm.getAccount().getEmail(), lm.getAccount().getPassword());
        System.out.println("Expected user error: " + lm.getEmailError() + " \n");
        Assert.assertTrue(lp.checkErr(lm.getEmailError(), "emailErr"));
        System.out.println("Expected user error: " + lm.getEmailError() + " \n");

        Assert.assertTrue(lp.checkErr(lm.getPasswordError(), "passErr"));
        System.out.println("Expected password error: " + lm.getPasswordError() + " \n");
    }


    @Test(dataProvider = "loginJsonDp", priority = 4, groups = {"Smoke", "Regression"}, description = "Positive login test with JSON")
    public void positiveLoginWithJsonTest(LoginModel lm) {
//       open login page
        System.out.println("Open Login page");
        MainPage mp = new MainPage(driver);
        mp.loginPage();

//        print data set
        System.out.println(lm);

        LoginPage lp = new LoginPage(driver);

//      login
        lp.login(lm.getAccount().getEmail(), lm.getAccount().getPassword());
        MyAccountPage map = new MyAccountPage(driver);
        Assert.assertEquals(map.getNameValue(), "Popa Maria");
        Assert.assertEquals(map.getEmailValue(), lm.getAccount().getEmail());
        Assert.assertEquals(map.getPhoneValue(), "0722000000");
        map.leftBoxMenuButtonsText();
    }

    @Test(dependsOnMethods = {"positiveLoginWithJsonTest"}, priority = 5, groups = {"Smoke", "Regression"},
            description = "Positive login test with JSON")
    public void verifyMyAccountPage(){
        MyAccountPage map = new MyAccountPage(driver);
        map.myAccount();
        map.leftBoxMenuButtonsText();
    }


    @Test(dependsOnMethods = {"positiveLoginWithJsonTest"}, priority = 6, groups = {"Smoke", "Regression"},
            description = "Negative login tests with JSON")
    public void logout() {
        MyAccountPage map = new MyAccountPage(driver);
        map.logout();
    }

}
