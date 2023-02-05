package Pages;

import org.openqa.selenium.*;
import org.testng.Assert;

public class RegistrationPage extends BasePage {

    //Fields labels and fields conditions labels selectors
    private String titleTextSelector = "#svelte > div.container-fluid > div.main.row > div.content > h1";
    private String pageDescriptionSelector = "#svelte > div.container-fluid > div.main.row > div.content > p";
    private String formTitleSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > p";
    private String detailsTextSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(5) > p";
    private String usernameLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(2) > label";
    private String usernameConditionSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(2) > small";
    private String passwordLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(3) > label";
    private String passwordConditionSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(3) > small";
    private String confirmPasswordLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(4) > label";
    private String confirmPasswordConditionSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(4) > small";
    private String appellationLabelSelector = "#register > form > div:nth-child(4) > label"; //CSS
    private String mrLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(6) > div:nth-child(2) > label";
    private String msLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(6) > div:nth-child(3) > label";
    private String firstNameLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(7) > label";
    private String firstNameConditionSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(7) > small";
    private String lastNameLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(8) > label";
    private String lastNameConditionSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(8) > small";
    private String emailLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(9) > label";
    private String emailSpamSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(9) > small";
    private String birthdayLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(10) > label";
    private String nationalityLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(11) > label";
    private String termsLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(12) > div > label";

    //input selectors
    private String firstNameInputSelector = "#register > form > div:nth-child(5) > div > input"; //CSS

    private String lastNameInputSelector = "#register > form > div:nth-child(6) > div > input"; //CSS
    private String phoneInputSelector = "#register > form > div:nth-child(7) > div > input"; //CSS

    private String emailInputSelector = "#register > form > div:nth-child(8) > div > input"; //CSS
    private String passwordInputSelector = "#register > form > div:nth-child(9) > div > input"; //CSS

    private String confirmPasswordInputSelector = "#register > form > div:nth-child(10) > div > input"; //CSS
    private String submitButtonSelector = "#register > form > div.form-actions.col-8 > button"; //CSS

    private String termsCheckboxSelector = "terms"; //CSS

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

//    public void verifyPage() {
//        Assert.assertEquals(driver.findElement(By.cssSelector(titleTextSelector)).getText(), "Sign up");
//    }
//
//    public void verifyTextsOnPage() {
//        Assert.assertEquals(driver.findElement(By.cssSelector(pageDescriptionSelector)).getText(), "Create a new temporary account. A default session will be created with the successfully created account. The new account will not be saved, so when the session expires (in 2 minutes), the account will no longer exist.");
//        Assert.assertEquals(driver.findElement(By.cssSelector(formTitleSelector)).getText(), "Your login information");
//        Assert.assertEquals(driver.findElement(By.cssSelector(detailsTextSelector)).getText(), "Some details to get to know you better");
//    }
//
//    public void verifyLabels() {
//        Assert.assertEquals(driver.findElement(By.cssSelector(usernameLabelSelector)).getText(), "Username*");
//        Assert.assertEquals(driver.findElement(By.cssSelector(passwordLabelSelector)).getText(), "Password*");
//        Assert.assertEquals(driver.findElement(By.cssSelector(confirmPasswordLabelSelector)).getText(), "Confirm password*");
//        Assert.assertEquals(driver.findElement(By.cssSelector(titleLabelSelector)).getText(), "Title");
//        Assert.assertEquals(driver.findElement(By.cssSelector(mrLabelSelector)).getText(), "Mr");
//        Assert.assertEquals(driver.findElement(By.cssSelector(msLabelSelector)).getText(), "Ms");
//        Assert.assertEquals(driver.findElement(By.cssSelector(firstNameLabelSelector)).getText(), "First name");
//        Assert.assertEquals(driver.findElement(By.cssSelector(lastNameLabelSelector)).getText(), "Last name");
//        Assert.assertEquals(driver.findElement(By.cssSelector(emailLabelSelector)).getText(), "Email");
//        Assert.assertEquals(driver.findElement(By.cssSelector(birthdayLabelSelector)).getText(), "Date of birth");
//        Assert.assertEquals(driver.findElement(By.cssSelector(nationalityLabelSelector)).getText(), "Nationality");
//        Assert.assertEquals(driver.findElement(By.cssSelector(termsLabelSelector)).getText(), "I accept the terms and conditions*");
//    }
//
//    public void verifyFieldsConditions() {
//        Assert.assertEquals(driver.findElement(By.cssSelector(usernameConditionSelector)).getText(), "4 to 35 letters, numbers or underscore.");
//        Assert.assertEquals(driver.findElement(By.cssSelector(passwordConditionSelector)).getText(), "Minimum of 8 characters.");
//        Assert.assertEquals(driver.findElement(By.cssSelector(confirmPasswordConditionSelector)).getText(), "Must match the password.");
//        Assert.assertEquals(driver.findElement(By.cssSelector(firstNameConditionSelector)).getText(), "2 to 35 letters and '-' only.");
//        Assert.assertEquals(driver.findElement(By.cssSelector(lastNameConditionSelector)).getText(), "2 to 35 letters and '-' only.");
//        Assert.assertEquals(driver.findElement(By.cssSelector(emailSpamSelector)).getText(), "We promise we won't spam you.");
//
//    }
//
//    public void verifyFieldsIcons() {
//        Assert.assertTrue(driver.findElement(By.cssSelector(usernameIconSelector)).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector(passwordIconSelector)).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector(confirmPasswordIconSelector)).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector(firstNameIconSelector)).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector(lastNameIconSelector)).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector(emailIconSelector)).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector(birthdayIconSelector)).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector(nationalityIconSelector)).isDisplayed());
//    }

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

//    public String getCurrentUrl() {
//        String URL = driver.getCurrentUrl();
//        return URL;
//            }

}