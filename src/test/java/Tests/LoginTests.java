package Tests;

import Pages.LoginPage;
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


    //
//    @Test
//    public void loginPositivePomTest() {
//        driver.get(baseUrl + "#/login");
//        Pages.DemoApp.LoginPage lp = new Pages.DemoApp.LoginPage(driver);
//        lp.verifyPage();
//        lp.login("abc", "password");
//    }

    @DataProvider(name = "jsonDp")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();

//      here is starting deserialization of json into LoginModel object
        ObjectMapper objectMapper = new ObjectMapper();

        File f = new File("src\\test\\resources\\data\\negativelogin.json");
        LoginModel[] lms = objectMapper.readValue(f, LoginModel[].class);

        for (LoginModel lm : lms)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }

    @Test(dataProvider = "jsonDp")
    public void loginWithJsonTest(LoginModel lm, Method method) {
        test = ExtentTestManager.startTest(method.getName(), "");
        printData(lm);
        loginActions(lm);
    }

    private void printData(LoginModel lm) {
        System.out.println(lm);
    }

    private void loginActions(LoginModel lm) {
        LoginPage loginPage = new LoginPage(driver);

//       open login page
        System.out.println("Open Login page");
        driver.get(baseUrl + "/?page=checkout");

//         login
        loginPage.login(lm.getAccount().getUsername(), lm.getAccount().getPassword());
        System.out.println("Login button was pressed");

        Assert.assertTrue(loginPage.checkErr(lm.getUserError(), "userErr"));
        System.out.println("Expected user error: " + lm.getUserError() + " \n");

        Assert.assertTrue(loginPage.checkErr(lm.getPasswordError(), "passErr"));
        System.out.println("Expected password error: " + lm.getPasswordError() + " \n");
    }


}
