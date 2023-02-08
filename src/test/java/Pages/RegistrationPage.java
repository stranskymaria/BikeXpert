package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegistrationPage extends BasePage {

    //Fields labels, texts
    private String registrationFormTitleSelector = "#register > form > h2"; //CSS
    private String appellationDnaLabelSelector = "#register > form > div:nth-child(4) > div > label:nth-child(2)";//CSS
    private String appellationDraLabelSelector = "#register > form > div:nth-child(4) > div > label:nth-child(4)";//CSS
    private String appellationDlLabelSelector = "#register > form > div:nth-child(4) > div > label:nth-child(6)";//CSS
    private String firstNameLabelSelector = "#register > form > div:nth-child(5) > label";//CSS
    private String lastNameLabelSelector = "#register > form > div:nth-child(6) > label";//CSS
    private String phoneLabelSelector = "#register > form > div:nth-child(7) > label";//CSS
    private String emailLabelSelector = "#register > form > div:nth-child(8) > label";//CSS
    private String passwordLabelSelector = "#register > form > div:nth-child(9) > label";//CSS
    private String confirmPasswordLabelSelector = "#register > form > div:nth-child(10) > label";//CSS
    private String newsletterTextLabelSelector = "#register > form > div.form-group.margin-top-10.margin-bottom-10 > div > label";//CSS
    private String policyTextLabelSelector = "#register > form > div.form-group.margin-top-10.margin-bottom-10 > label";//CSS



    //input selectors
    private String firstNameInputSelector = "#register > form > div:nth-child(5) > div > input"; //CSS

    private String lastNameInputSelector = "#register > form > div:nth-child(6) > div > input"; //CSS
    private String phoneInputSelector = "#register > form > div:nth-child(7) > div > input"; //CSS

    private String emailInputSelector = "#register > form > div:nth-child(8) > div > input"; //CSS
    private String passwordInputSelector = "#register > form > div:nth-child(9) > div > input"; //CSS

    private String confirmPasswordInputSelector = "#register > form > div:nth-child(10) > div > input"; //CSS
    private String submitButtonSelector = "#register > form > div.form-actions.col-8 > button"; //CSS
    
    private String termsCheckboxSelector = "terms"; //ID

    private String dnaRadioButtonSelector = "salutation_1"; //ID

    private String draRadioButtonSelector = "salutation_2"; //ID

    private String dlRadioButtonSelector = "salutation_3"; //ID

    //errors selectors
    private String firstNameErrorSelector = "#register > form > div:nth-child(5) > div > span"; //CSS

    private String lastNameErrorSelector = "#register > form > div:nth-child(6) > div > span"; //CSS
    private String phoneErrorSelector = "#register > form > div:nth-child(7) > div > span"; //CSS
    private String emailErrorSelector = "#register > form > div:nth-child(8) > div > span"; //CSS
    private String passwordErrorSelector = "#register > form > div:nth-child(9) > div > span"; //CSS

    private String confirmPasswordErrorSelector = "#register > form > div:nth-child(10) > div > span"; //CSS
    private String termsErrorSelector = "#register > form > div.form-group.margin-top-10.margin-bottom-10.has-error > span"; //CSS


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void verifyRegistrationPage() {
        Assert.assertEquals(driver.findElement(By.cssSelector(registrationFormTitleSelector)).getText(), "Inregistrare");
        Assert.assertEquals(driver.findElement(By.cssSelector(appellationDnaLabelSelector)).getText(), "Dna.");
        Assert.assertEquals(driver.findElement(By.cssSelector(appellationDraLabelSelector)).getText(), "Dra.");
        Assert.assertEquals(driver.findElement(By.cssSelector(appellationDlLabelSelector)).getText(), "Dl.");
        Assert.assertEquals(driver.findElement(By.cssSelector(firstNameLabelSelector)).getText(), "Prenume");
        Assert.assertEquals(driver.findElement(By.cssSelector(lastNameLabelSelector)).getText(), "Nume");
        Assert.assertEquals(driver.findElement(By.cssSelector(phoneLabelSelector)).getText(), "Telefon");
        Assert.assertEquals(driver.findElement(By.cssSelector(emailLabelSelector)).getText(), "Adresa e-mail");
        Assert.assertEquals(driver.findElement(By.cssSelector(passwordLabelSelector)).getText(), "Parola");
        Assert.assertEquals(driver.findElement(By.cssSelector(confirmPasswordLabelSelector)).getText(), "Confirmare parola");
        Assert.assertEquals(driver.findElement(By.cssSelector(newsletterTextLabelSelector)).getText(), "Doresc sa ma abonez la newsletter.");
        Assert.assertEquals(driver.findElement(By.cssSelector(policyTextLabelSelector)).getText(), "Am citit si sunt de acord cu termenii si conditiile si cu politica de confidentialitate");
        Assert.assertEquals(driver.findElement(By.cssSelector(submitButtonSelector)).getText(), "Inregistrare");
    }
    public void registration(String firstName,
                             String lastName,
                             String phone,
                             String email,
                             String password,
                             String confirmPassword
    ) {
        WebElement firstNameInput = driver.findElement(By.cssSelector(firstNameInputSelector));
        WebElement lastNameInput = driver.findElement(By.cssSelector(lastNameInputSelector));
        WebElement phoneInput = driver.findElement(By.cssSelector(phoneInputSelector));
        WebElement emailInput = driver.findElement(By.cssSelector(emailInputSelector));
        WebElement passwordInput = driver.findElement(By.cssSelector(passwordInputSelector));
        WebElement confirmPasswordInput = driver.findElement(By.cssSelector(confirmPasswordInputSelector));

        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void submitRegistration() {
        WebElement submitButton = driver.findElement(By.cssSelector(submitButtonSelector));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//
//        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver)
//                .executeScript("return document.readyState").toString().equals("complete");
//
//        wait.until(jsLoad);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", submitButton);
    }

    public String getFirstNameError() {
        return driver.findElement(By.cssSelector(firstNameErrorSelector)).getText();
    }

    public String getLastNameError() {
        return driver.findElement(By.cssSelector(lastNameErrorSelector)).getText();
    }

    public String getPhoneError() {
        return driver.findElement(By.cssSelector(phoneErrorSelector)).getText();
    }

    public String getEmailError() {
        return driver.findElement(By.cssSelector(emailErrorSelector)).getText();
    }

    public String getPasswordError() {
        return driver.findElement(By.cssSelector(passwordErrorSelector)).getText();
    }

    public String getConfirmPasswordError() {
        return driver.findElement(By.cssSelector(confirmPasswordErrorSelector)).getText();
    }

    public String getTermsError() {
        return driver.findElement(By.cssSelector(termsErrorSelector)).getText();
    }


    public boolean checkRegErr(String expectedErrFromDb, String errorTypeFromSite) {
        switch (errorTypeFromSite) {
            case "firstNameErr":
                    if (expectedErrFromDb.length() > 0) {
                        System.out.println("Actual first name error: " + getFirstNameError());
                        return expectedErrFromDb.equals(getFirstNameError());
                    } else return true;
            case "lastNameErr":
                    if (expectedErrFromDb.length() > 0) {
                        System.out.println("Actual last name error: " + getLastNameError());
                        return expectedErrFromDb.equals(getLastNameError());
                    } else return true;
            case "phoneErr":
                    if (expectedErrFromDb.length() > 0) {
                        System.out.println("Actual phone error: " + getPhoneError());
                        return expectedErrFromDb.equals(getPhoneError());
                    } else return true;
            case "emailErr":
                    if (expectedErrFromDb.length() > 0) {
                        System.out.println("Actual email error: " + getEmailError());
                        return expectedErrFromDb.equals(getEmailError());
                    } else return true;
            case "passwordErr":
                    if (expectedErrFromDb.length() > 0) {
                        System.out.println("Actual password error: " + getPasswordError());
                        return expectedErrFromDb.equals(getPasswordError());
                    } else return true;
            case "confirmPasswordErr":
                    if (expectedErrFromDb.length() > 0) {
                        System.out.println("Actual confirm password error: " + getConfirmPasswordError());
                        return expectedErrFromDb.equals(getConfirmPasswordError());
                    } else return true;
            case "termsErr":
                    if (expectedErrFromDb.length() > 0) {
                        System.out.println("Actual terms error: " + getTermsError());
                        return expectedErrFromDb.equals(getTermsError());
                    } else return true;
        }
    return false;
    }


    public void termsCheckbox() {
        WebElement terms = driver.findElement(By.id(termsCheckboxSelector));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", terms);
        Assert.assertTrue(terms.isSelected());
    }

    public void appellationRadioButtons() {
        //test number of radio buttons
        Assert.assertEquals(driver.findElements(By.name("salutation")).size(), 3);

        WebElement radio1 = driver.findElement(By.id(dnaRadioButtonSelector));
        WebElement radio2 = driver.findElement(By.id(draRadioButtonSelector));
        WebElement radio3 = driver.findElement(By.id(dlRadioButtonSelector));

        Assert.assertTrue(radio1.isDisplayed());
        Assert.assertTrue(radio2.isDisplayed());
        Assert.assertTrue(radio3.isDisplayed());

        //test all three radios are unselected by default
        Assert.assertFalse(radio1.isSelected());
        Assert.assertFalse(radio2.isSelected());
        Assert.assertFalse(radio3.isSelected());

        //test radio1 select, radio2, 3 remains unselected
        JavascriptExecutor jse1 = (JavascriptExecutor)driver;
        jse1.executeScript("arguments[0].click();", radio1);
        Assert.assertTrue(radio1.isSelected());
        Assert.assertFalse(radio2.isSelected());
        Assert.assertFalse(radio3.isSelected());


        //test radio2 select, radio1,3 becomes unselected
        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
        jse2.executeScript("arguments[0].click();", radio2);
        Assert.assertFalse(radio1.isSelected());
        Assert.assertTrue(radio2.isSelected());
        Assert.assertFalse(radio3.isSelected());

        //test radio3 select, radio2,3 becomes unselected
        JavascriptExecutor jse3 = (JavascriptExecutor)driver;
        jse3.executeScript("arguments[0].click();", radio3);
        Assert.assertFalse(radio1.isSelected());
        Assert.assertFalse(radio2.isSelected());
        Assert.assertTrue(radio3.isSelected());
    }

    public void newsletterCheckbox() {
        WebElement newsletterCheckbox = driver.findElement(By.cssSelector("[id^='newsletter_accept']"));
        Assert.assertFalse(newsletterCheckbox.isSelected());
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", newsletterCheckbox);
        Assert.assertTrue(newsletterCheckbox.isSelected());
    }

}