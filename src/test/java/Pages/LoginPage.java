package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {

    private String loginFormTitleSelector = "#login > form > h2"; //CSS
    private String loginFormSubtitleSelector = "#login > form > p";//CSS
    private String emailLabelSelector = "#login > form > div:nth-child(5) > label";//CSS
    private String passwordLabelSelector = "#login > form > div:nth-child(6) > label";//CSS
    private String policyTextSelector = "#login > form > div:nth-child(7) > div > p";//CSS
    private String forgotPasswordSelector = "#login > form > div.form-actions > div > a";//CSS

    private String emailResetPasswordTextSelector = "#forgotpassword > form > p";

    private String emailResetPasswordInputSelector = "#forgotpassword > form > div:nth-child(4) > input[type=email]";

    private String submitSendPasswordButtonSelector = "#forgotpassword > form > div:nth-child(5) > button";

    private String emailSentMessageSelector = "#forgotpassword > div";
    private String emailInputSelector = "#login > form > div:nth-child(5) > div > input"; //CSS
    private String passwordInputSelector = "#login > form > div:nth-child(6) > div > input"; //CSS
    private String submitButtonSelector = "#login > form > div.form-actions > div > button"; //CSS
    private String emailErrorSelector = "cs_customer_email-error"; //ID
    private String passwordErrorSelector = "cs_customer_password-error"; //ID

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void verifyLoginPage() {
        Assert.assertEquals(driver.findElement(By.cssSelector(loginFormTitleSelector)).getText(), "Autentificare");
        Assert.assertEquals(driver.findElement(By.cssSelector(loginFormSubtitleSelector)).getText(), "Pentru a accesa contul dumneavoastra, va rugam introduceti adresa de e-mail si parola.");
        Assert.assertEquals(driver.findElement(By.cssSelector(emailLabelSelector)).getText(), "Adresa e-mail");
        Assert.assertEquals(driver.findElement(By.cssSelector(passwordLabelSelector)).getText(), "Parola");
        Assert.assertEquals(driver.findElement(By.cssSelector(policyTextSelector)).getText(), "Inainte de a trimite solicitarea dumneavoastra, va rugam sa consultati Politica de confidentialitate  privind prelucrarea datelor personale.");
        Assert.assertEquals(driver.findElement(By.cssSelector(forgotPasswordSelector)).getText(), "Ai uitat parola?");
        Assert.assertEquals(driver.findElement(By.cssSelector(submitButtonSelector)).getText(), "Autentificare");
    }

    public void forgotPasswordClick() {
        WebElement forgotPasswordButton = driver.findElement(By.cssSelector(forgotPasswordSelector));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", forgotPasswordButton);
    }

    public void emailResetPasswordInput(String email) {
        WebElement emailResetPasswordText = driver.findElement(By.cssSelector(emailResetPasswordTextSelector));
        WebElement emailResetPasswordInput = driver.findElement(By.cssSelector(emailResetPasswordInputSelector));
        WebElement submitSendPasswordButton = driver.findElement(By.cssSelector(submitSendPasswordButtonSelector));
        Assert.assertEquals(emailResetPasswordText.getText(), "Introdu mai jos adresa de e-mail pentru care doresti sa resetam parola:");
        Assert.assertEquals(submitSendPasswordButton.getText(), "Trimite parola");
        emailResetPasswordInput.clear();
        emailResetPasswordInput.sendKeys(email);
        submitSendPasswordButton.submit();
    }

    public String emailSentMessage() {
        return driver.findElement(By.cssSelector(emailSentMessageSelector)).getText();
    }

    public void login(String email, String password) {
        WebElement emailInput = driver.findElement(By.cssSelector(emailInputSelector));
        WebElement passwordInput = driver.findElement(By.cssSelector(passwordInputSelector));
        WebElement submitButton = driver.findElement(By.cssSelector(submitButtonSelector));

        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        submitButton.submit();

    }

    public String getEmailError() {
        return driver.findElement(By.id(emailErrorSelector)).getText();
    }

    public String getPasswordError() {
        return driver.findElement(By.id(passwordErrorSelector)).getText();
    }

    public boolean checkErr(String expectedErr, String errorType) {
        if (errorType.equalsIgnoreCase("emailErr")) {
            if (expectedErr.length() > 0) {
                System.out.println("Actual email error: " + getEmailError());
                return expectedErr.equals(getEmailError());
            } else return true;
        } else if (errorType.equalsIgnoreCase("passErr")) {
            if (expectedErr.length() > 0) {
                System.out.println("Actual pass error: " + getPasswordError());
                return expectedErr.equalsIgnoreCase(getPasswordError());
            } else return true;
        }
        return false;
    }

}