package Tests;

import Pages.MainPage;
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
        mp.account();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.termsCheckbox();
    }
//
//    @Test
//    public void registrationPositivePomTest() {
//        driver.get(baseUrl + "/signup/");
//        RegistrationPOMPage rp = new RegistrationPOMPage(driver);
//        rp.verifyPage();
//        rp.registration("abcd", "password", "password", "first", "last", "a@b.com");
//        rp.termsCheckbox();
//        rp.submitRegistration();
//        Assert.assertEquals(rp.getCurrentUrl(), "http://86.121.249.151:4999/" );
//        }

    @DataProvider(name = "SQLdp")
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

    @Test(dataProvider = "SQLdp")
    public void registrationWithDBTest(RegistrationModel rm, Method method) {
        test = ExtentTestManager.startTest(method.getName(), "");
        printData(rm);
        registrationActions(rm);

    }

//    @DataProvider(name = "SQLdp1")
//    public Iterator<Object[]> SQLDpCollectionPositive() {
//        //        get DB connection settings
//        System.out.println("Use dbHostname:" + dbHostname);
//        System.out.println("Use dbUser:" + dbUser);
//        System.out.println("Use dbPort:" + dbPort);
//        System.out.println("Use dbPassword:" + dbPassword);
//        System.out.println("Use dbSchema:" + dbSchema);
//
//        Collection<Object[]> dp = new ArrayList<>();
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://" + dbHostname + ":" + dbPort
//                    + "/" + dbSchema, dbUser, new String(base64.decode(dbPassword.getBytes())));
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM positive_registration");
//            while (resultSet.next()) {
//                RegistrationModel rm = new RegistrationModel(getEscapedElement(resultSet, "firstName"),
//                        getEscapedElement(resultSet, "lastName"),
//                        getEscapedElement(resultSet, "phone"),
//                        getEscapedElement(resultSet, "email"),
//                        getEscapedElement(resultSet, "password"),
//                        getEscapedElement(resultSet, "confirmPassword"),
//                        getEscapedElement(resultSet, "firstNameErr"),
//                        getEscapedElement(resultSet, "lastNameErr"),
//                        getEscapedElement(resultSet, "phoneErr"),
//                        getEscapedElement(resultSet, "emailErr"),
//                        getEscapedElement(resultSet, "passwordErr"),
//                        getEscapedElement(resultSet, "confirmPasswordErr"),
//                        getEscapedElement(resultSet, "termsErr"));
//                dp.add(new Object[]{rm});
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return dp.iterator();
//    }
//
//    @Test(dataProvider = "SQLdp1")
//    public void registrationWithDBTestPositive(RegistrationModel rm, Method method) {
//        test = ExtentTestManager.startTest(method.getName(), "");
//        printData(rm);
//        registrationActions(rm);
//        RegistrationPage rp = new RegistrationPage(driver);
//        rp.termsCheckbox();
//        rp.submitRegistration();
//
//    }
    private void printData(RegistrationModel rm) {
        System.out.println(rm);
    }

    private void registrationActions(RegistrationModel rm) {
        RegistrationPage registrationPage = new RegistrationPage(driver);

//       open registration page
        System.out.println("Open Registration page");
        driver.get(baseUrl + "/?page=checkout");

//         login
        registrationPage.registration(rm.getAccount().getFirstName(),
                rm.getAccount().getLastName(),
                rm.getAccount().getPhone(),
                rm.getAccount().getEmail(),
                rm.getAccount().getPassword(),
                rm.getAccount().getConfirmPassword());

        System.out.println("Submit button was pressed");

        Assert.assertTrue(registrationPage.checkRegErr(rm.getFirstNameError(), "firstNameErr"));
        System.out.println("Expected first name error: " + rm.getFirstNameError() + " \n");
        Assert.assertTrue(registrationPage.checkRegErr(rm.getLastNameError(), "lastNameErr"));
        System.out.println("Expected last name error: " + rm.getLastNameError() + " \n");
        Assert.assertTrue(registrationPage.checkRegErr(rm.getPhoneError(), "phoneErr"));
        System.out.println("Expected phone error: " + rm.getPhoneError() + " \n");
        Assert.assertTrue(registrationPage.checkRegErr(rm.getEmailError(), "emailErr"));
        System.out.println("Expected email error: " + rm.getEmailError() + " \n");
        Assert.assertTrue(registrationPage.checkRegErr(rm.getPasswordError(), "passwordErr"));
        System.out.println("Expected password error: " + rm.getPasswordError() + " \n");
        Assert.assertTrue(registrationPage.checkRegErr(rm.getConfirmPasswordError(), "confirmPasswordErr"));
        System.out.println("Expected confirm password error: " + rm.getConfirmPasswordError() + " \n");
        Assert.assertTrue(registrationPage.checkRegErr(rm.getTermsError(), "termsErr"));
        System.out.println("Expected terms error: " + rm.getTermsError() + " \n");
    }

}
