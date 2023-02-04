package Tests;

import Pages.LoginPage;
import Pages.MainPage;
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
        test = ExtentTestManager.startTest(method.getName(), "");
//       open login page
        System.out.println("Open Login page");
        MainPage mp = new MainPage(driver);
        mp.agreeCookies();
        mp.loginPage();

//        print data set
        System.out.println(lm);

        LoginPage lp = new LoginPage(driver);

//      login
        lp.login(lm.getAccount().getEmail(), lm.getAccount().getPassword());
        System.out.println("Login button was pressed");
        System.out.println("Expected user error: " + lm.getEmailError() + " \n");
        Assert.assertTrue(lp.checkErr(lm.getEmailError(), "emailErr"));
        System.out.println("Expected user error: " + lm.getEmailError() + " \n");

        Assert.assertTrue(lp.checkErr(lm.getPasswordError(), "passErr"));
        System.out.println("Expected password error: " + lm.getPasswordError() + " \n");
    }

    @Test(dataProvider = "loginJsonDp")
    public void positiveLoginWithJsonTest(LoginModel lm, Method method) {
        test = ExtentTestManager.startTest(method.getName(), "");
//       open login page
        System.out.println("Open Login page");
        MainPage mp = new MainPage(driver);
        mp.agreeCookies();
        mp.loginPage();

//        print data set
        System.out.println(lm);

        LoginPage lp = new LoginPage(driver);

//      login
        lp.login(lm.getAccount().getEmail(), lm.getAccount().getPassword());
        System.out.println("Login button was pressed");
    }


}
