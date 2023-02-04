package Tests;

import Pages.MainPage;
import Pages.RegistrationPage;
import Tests.ObjectModels.LoginModel;
import Tests.ObjectModels.RegistrationModel;
import Utils.ExtentTestManager;
import Utils.Tools;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegistrationTests extends BaseTest{
//    @Test
//    public void checkTextsOnPage() {
//        driver.get(baseUrl + "/signup/");
//        RegistrationPOMPage rp = new RegistrationPOMPage(driver);
//        rp.verifyTextsOnPage();
//    }
//
//    @Test
//    public void checkLabels() {
//        driver.get(baseUrl + "/signup/");
//        RegistrationPOMPage rp = new RegistrationPOMPage(driver);
//        rp.verifyLabels();
//    }
//
//    @Test
//    public void checkFieldsConditionsAndIcons() {
//        driver.get(baseUrl + "/signup/");
//        RegistrationPOMPage rp = new RegistrationPOMPage(driver);
//        rp.verifyFieldsConditions();
//        rp.verifyFieldsIcons();
//    }
//

//
//    @Test
//    public void titleRadioButtonsTest() {
//        driver.get(baseUrl + "/signup/");
//        RegistrationPOMPage rp = new RegistrationPOMPage(driver);
//        rp.titleRadioButtons();
//    }
    @Test
    public void termsCheckboxTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.agreeCookies();
        mp.registrationPage();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.termsCheckbox();
    }

    @DataProvider(name = "negativeRegistrationSQLdp")
    public Iterator<Object[]> NegativeSQLDpCollection() {
        //        get DB connection settings
        System.out.println("Use dbHostname:" + dbHostname);
        System.out.println("Use dbUser:" + dbUser);
        System.out.println("Use dbPort:" + dbPort);
        System.out.println("Use dbPassword:" + dbPassword);
        System.out.println("Use dbSchema:" + dbSchema);

        Collection<Object[]> dp = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + dbHostname + ":" + dbPort
                    + "/" + dbSchema, dbUser, new String(base64.decode(dbPassword.getBytes())));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM negative_registration");
            while (resultSet.next()) {
                RegistrationModel rm = new RegistrationModel(getEscapedElement(resultSet, "firstName"),
                        getEscapedElement(resultSet, "lastName"),
                        getEscapedElement(resultSet, "phone"),
                        getEscapedElement(resultSet, "email"),
                        getEscapedElement(resultSet, "password"),
                        getEscapedElement(resultSet, "confirmPassword"),
                        getEscapedElement(resultSet, "firstNameErr"),
                        getEscapedElement(resultSet, "lastNameErr"),
                        getEscapedElement(resultSet, "phoneErr"),
                        getEscapedElement(resultSet, "emailErr"),
                        getEscapedElement(resultSet, "passwordErr"),
                        getEscapedElement(resultSet, "confirmPasswordErr"),
                        getEscapedElement(resultSet, "termsErr"));
                dp.add(new Object[]{rm});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dp.iterator();
    }

    private String getEscapedElement(ResultSet resultSet, String element) throws SQLException {
        return Tools.replaceElements(resultSet.getString(element), "''", "");
    }

    @Test(dataProvider = "negativeRegistrationSQLdp")
    public void negativeRegistrationWithDBTest(RegistrationModel rm, Method method) {
        test = ExtentTestManager.startTest(method.getName(), "");
//       open registration page
        System.out.println("Open Login page");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.agreeCookies();
        mp.registrationPage();

//        print data set
        System.out.println(rm);

        RegistrationPage rp = new RegistrationPage(driver);

//        registration
        rp.registration(rm.getAccount().getFirstName(),
                rm.getAccount().getLastName(),
                rm.getAccount().getPhone(),
                rm.getAccount().getEmail(),
                rm.getAccount().getPassword(),
                rm.getAccount().getConfirmPassword());
        rp.submitRegistration();
        System.out.println("Register button was pressed");

        Assert.assertTrue(rp.checkRegErr(rm.getFirstNameError(), "firstNameErr"));
        System.out.println("Expected first name error: " + rm.getFirstNameError() + " \n");

        Assert.assertTrue(rp.checkRegErr(rm.getLastNameError(), "lastNameErr"));
        System.out.println("Expected last name error: " + rm.getLastNameError() + " \n");

        Assert.assertTrue(rp.checkRegErr(rm.getPhoneError(), "phoneErr"));
        System.out.println("Expected phone error: " + rm.getPhoneError() + " \n");

        Assert.assertTrue(rp.checkRegErr(rm.getEmailError(), "emailErr"));
        System.out.println("Expected email error: " + rm.getEmailError() + " \n");

        Assert.assertTrue(rp.checkRegErr(rm.getPasswordError(), "passwordErr"));
        System.out.println("Expected password error: " + rm.getPasswordError() + " \n");

        Assert.assertTrue(rp.checkRegErr(rm.getConfirmPasswordError(), "confirmPasswordErr"));
        System.out.println("Expected confirm password error: " + rm.getConfirmPasswordError() + " \n");

        Assert.assertTrue(rp.checkRegErr(rm.getTermsError(), "termsErr"));
        System.out.println("Expected terms error: " + rm.getTermsError() + " \n");

    }

    @DataProvider(name = "positiveRegistrationSQLdp")
    public Iterator<Object[]> SQLDpCollection() {
        //        get DB connection settings
        System.out.println("Use dbHostname:" + dbHostname);
        System.out.println("Use dbUser:" + dbUser);
        System.out.println("Use dbPort:" + dbPort);
        System.out.println("Use dbPassword:" + dbPassword);
        System.out.println("Use dbSchema:" + dbSchema);

        Collection<Object[]> dp = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + dbHostname + ":" + dbPort
                    + "/" + dbSchema, dbUser, new String(base64.decode(dbPassword.getBytes())));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM positive_registration");
            while (resultSet.next()) {
                RegistrationModel rm = new RegistrationModel(getEscapedElement(resultSet, "firstName"),
                        getEscapedElement(resultSet, "lastName"),
                        getEscapedElement(resultSet, "phone"),
                        getEscapedElement(resultSet, "email"),
                        getEscapedElement(resultSet, "password"),
                        getEscapedElement(resultSet, "confirmPassword"),
                        getEscapedElement(resultSet, "firstNameErr"),
                        getEscapedElement(resultSet, "lastNameErr"),
                        getEscapedElement(resultSet, "phoneErr"),
                        getEscapedElement(resultSet, "emailErr"),
                        getEscapedElement(resultSet, "passwordErr"),
                        getEscapedElement(resultSet, "confirmPasswordErr"),
                        getEscapedElement(resultSet, "termsErr"));
                dp.add(new Object[]{rm});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dp.iterator();
    }
    @Test(dataProvider = "positiveRegistrationSQLdp")
    public void positiveRegistrationWithDBTest(RegistrationModel rm, Method method) {
        test = ExtentTestManager.startTest(method.getName(), "");
//       open registration page
        System.out.println("Open Login page");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.agreeCookies();
        mp.registrationPage();

//        print data set
        System.out.println(rm);

        RegistrationPage rp = new RegistrationPage(driver);

//        registration
        rp.registration(rm.getAccount().getFirstName(),
                rm.getAccount().getLastName(),
                rm.getAccount().getPhone(),
                rm.getAccount().getEmail(),
                rm.getAccount().getPassword(),
                rm.getAccount().getConfirmPassword());
        rp.termsCheckbox();
        rp.submitRegistration();
        System.out.println("Register button was pressed");

    }


}
