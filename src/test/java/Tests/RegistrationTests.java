package Tests;

import Pages.MainPage;
import Pages.RegistrationConfirmationPage;
import Pages.RegistrationPage;
import Tests.ObjectModels.RegistrationModel;
import Utils.ExtentTestManager;
import Utils.Tools;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegistrationTests extends BaseTest{

    @Test
    public void verifyRegistrationPage(Method method){
        test = ExtentTestManager.startTest(method.getName(), "Negative login tests with JSON");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.registrationPage();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.verifyRegistrationPage();
    }

    @DataProvider(name = "RegistrationSQLdp")
    public Iterator<Object[]> SQLDpCollection(Method method) {
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
            String query;
            if (method.getName().equals("negativeRegistrationWithDBTest")) {
                query = "SELECT * FROM registration WHERE id = 1 OR id = 2 OR id = 3 OR id = 4";
            } else if (method.getName().equals("positiveRegistrationWithDBTest")) {
                query = "SELECT * FROM registration WHERE id = 5";
            }else {
                throw new IllegalArgumentException("Incorrect query");
            }
            ResultSet resultSet = statement.executeQuery(query);
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

    @Test(dataProvider = "RegistrationSQLdp")
    public void negativeRegistrationWithDBTest(RegistrationModel rm, Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Negative registration tests with SQL");
        driver.get(baseUrl);
//       open registration page
        MainPage mp = new MainPage(driver);
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


    @Test(dataProvider = "RegistrationSQLdp")
    public void positiveRegistrationWithDBTest(RegistrationModel rm, Method method) throws InterruptedException {
        test = ExtentTestManager.startTest(method.getName(), "positive registration test with SQL");
        driver.get(baseUrl);
//       open registration page
        MainPage mp = new MainPage(driver);
        mp.registrationPage();

//        print data set
        System.out.println(rm);

        RegistrationPage rp = new RegistrationPage(driver);

//        registration with random phone number and email with timestamp
        rp.registration(rm.getAccount().getFirstName(),
                rm.getAccount().getLastName(),
                rm.getAccount().getPhone() + randomNumber,
                rm.getAccount().getEmail() + timestampEmail,
                rm.getAccount().getPassword(),
                rm.getAccount().getConfirmPassword());
        System.out.println(timestampEmail);
        rp.termsCheckbox();
        Thread.sleep(5000);
//        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        rp.submitRegistration();
        System.out.println("submit pressed");
        RegistrationConfirmationPage rcp = new RegistrationConfirmationPage(driver);
        rcp.registrationConfirmation();
        Assert.assertEquals(rcp.getNameValue(), rm.getAccount().getLastName() + " " + rm.getAccount().getFirstName());
        Assert.assertEquals(rcp.getEmailValue(), rm.getAccount().getEmail() + timestampEmail);
        Assert.assertEquals(rcp.getPhoneValue(), rm.getAccount().getPhone() + randomNumber);

    }

    @Test
    public void termsCheckboxTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Testing terms checkbox from registration page");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.registrationPage();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.termsCheckbox();
    }

    @Test
    public void appellationRadioButtonsTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Testing appellation radio buttons from registration page");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.registrationPage();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.appellationRadioButtons();
    }

    @Test
    public void newsletterCheckboxTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Testing terms checkbox from registration page");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.registrationPage();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.newsletterCheckbox();
    }
}
