package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.MyAccountPage;
import Utils.ExtentTestManager;
import Tests.ObjectModels.LoginModel;
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

    @Test
    public void verifyLoginPage(Method method){
        test = ExtentTestManager.startTest(method.getName(), "Negative login tests with JSON");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.loginPage();
        LoginPage lp = new LoginPage(driver);
        lp.verifyLoginPage();
    }

    @Test
    public void forgotPassword(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Negative login tests with JSON");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
//        mp.agreeCookies();
//        mp.accountButton();
//        mp.loginPageLink();
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

    @Test(dataProvider = "loginJsonDp")
    public void negativeLoginWithJsonTest(LoginModel lm, Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Negative login tests with JSON");
        driver.get(baseUrl);
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


    @Test(dataProvider = "loginJsonDp")
    public void positiveLoginWithJsonTest(LoginModel lm, Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Positive login test with JSON");
        driver.get(baseUrl);
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
        map.myAccount();
        Assert.assertEquals(map.getNameValue(), "Popa Maria");
        Assert.assertEquals(map.getEmailValue(), lm.getAccount().getEmail());
        Assert.assertEquals(map.getPhoneValue(), "0722000000");
        map.leftBoxMenuButtonsText();
    }

    @Test(dependsOnMethods = {"positiveLoginWithJsonTest"} )
    public void logout(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Negative login tests with JSON");
        MyAccountPage map = new MyAccountPage(driver);
        map.logout();
    }

}
