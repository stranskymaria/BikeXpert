package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

//    private String pageTextSelector = "//*[@id=\"svelte\"]/div[1]/div[2]/div[2]/h1";
//    private String pageTextCSSSelector = "#svelte > div.container-fluid > div.main.row > div.content > h1";
//    private String pageTextClassSelector = "content";
//    private String elementsSelector = "content";
//    private String elementsTagSelector = "small";
//    private String usernameLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(1) > label";
//    private String passwordLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(2) > label";

    private String emailInputSelector = "#login > form > div:nth-child(5) > div > input"; //CSS
    private String passwordInputSelector = "#login > form > div:nth-child(6) > div > input"; //CSS
    private String submitButtonSelector = "#login > form > div.form-actions > div > button"; //CSS
    private String emailErrorSelector = "cs_customer_email-error"; //ID
    private String passwordErrorSelector = "cs_customer_password-error"; //ID

    public LoginPage(WebDriver driver) {
        super(driver);
    }

//    public void verifyPage() {
//        Assert.assertEquals(driver.findElement(By.xpath(pageTextSelector)).getText(), "Sign in");
//    }

//    public void login(String email, String password, String emailError, String passError) {
//        login(email, password);
//        Assert.assertEquals(getEmailError(), emailError);
//        Assert.assertEquals(getPasswordError(), passError);
//    }

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