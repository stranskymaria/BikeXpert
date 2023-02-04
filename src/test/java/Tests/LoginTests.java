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

    @DataProvider(name = "negativeLoginJsonDp")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();

//      here is starting deserialization of json into LoginModel object
        ObjectMapper objectMapper = new ObjectMapper();

        File f = new File("src\\test\\resources\\data\\negative_login.json");
        LoginModel[] lms = objectMapper.readValue(f, LoginModel[].class);

        for (LoginModel lm : lms)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }

    @Test(dataProvider = "negativeLoginJsonDp")
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

    @DataProvider(name = "positiveLoginJsonDp")
    public Iterator<Object[]> positiveJsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();

//      here is starting deserialization of json into LoginModel object
        ObjectMapper objectMapper = new ObjectMapper();

        File f = new File("src\\test\\resources\\data\\positive_login.json");
        LoginModel[] lms = objectMapper.readValue(f, LoginModel[].class);

        for (LoginModel lm : lms)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }

    @Test(dataProvider = "positiveLoginJsonDp")
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
