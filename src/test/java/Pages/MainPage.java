package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage{
    private String agreeCookiesSelector = "body > section > div.container > header > div.smaller_right > input"; //CSS

    private String accountButtonSelector = "login-link"; //CSS

    private String loginButtonSelector = "#header > div.top-header-section.t-top-header-background > div > div.right-section.users-box-section.cf > div.box-user.left > div > div > div > div.buttons-login > a"; //CSS

    private String registerButtonSelector = "#header > div.top-header-section.t-top-header-background > div > div.right-section.users-box-section.cf > div.box-user.left > div > div > div > div.no-accont > a"; //CSS
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void agreeCookies() {
        WebElement agreeCookiesButton = driver.findElement(By.cssSelector(agreeCookiesSelector));
        if (agreeCookiesButton.isDisplayed()) {
            agreeCookiesButton.click();
        }
    }

    public void accountButton() {
        WebElement accountButton = driver.findElement(By.id(accountButtonSelector));
        accountButton.click();
    }

    public void loginPageLink() {
        WebElement loginButton = driver.findElement(By.cssSelector(loginButtonSelector));
        loginButton.click();
    }

    public void registrationPageLink() {
        WebElement registrationButton = driver.findElement(By.cssSelector(registerButtonSelector));
        registrationButton.click();
    }

//    public void goToAlerts()
//    {
//        driver.findElement(By.cssSelector(alertUrlSelector)).click();
//    }
//
//    public void goToHover(){
//        driver.findElement(By.cssSelector(hoverUrlSelector)).click();
//    }
//
//    public void goToInterceptor(){
//        driver.findElement(By.cssSelector(interceptorUrlSelector)).click();
//    }
//
//    public void goToModal(){
//        driver.findElement(By.cssSelector(modalUrlSelector)).click();
//    }
//
//    public String getWelcomeText() {
//        return driver.findElement(By.cssSelector(welcomeTextSelector)).getText();
//    }
//
//    public void goToCookie()
//    {
//        driver.findElement(By.cssSelector(cookieUrlSelector)).click();
//    }

}