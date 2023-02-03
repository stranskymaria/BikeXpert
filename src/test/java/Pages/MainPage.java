package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage{

    private String alertUrlSelector = "#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(1)"; //CSS
    private String hoverUrlSelector = "#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(3)"; // CSS
    private String interceptorUrlSelector = "#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(4)"; //CSS
    private String modalUrlSelector = "#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(5)";// CSS
    private String welcomeTextSelector = "#svelte > div.container-fluid > div.main.row > div.content > h1"; //CSS

    private String cookieUrlSelector = "#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(2)";

    private String agreeCookiesSelector = "body > section > div.container > header > div.smaller_right > input"; //CSS

    private String accountSelector = "#login-link > i.t-config-usericon-color.fa-user.fa"; //CSS

    private String enterAccountSelector = "#header > div.top-header-section.t-top-header-background > div > div.right-section.users-box-section.cf > div.box-user.left > div > div > div > div.buttons-login > a"; //CSS

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void agreeCookies() {
        WebElement agreeCookies = driver.findElement(By.cssSelector(agreeCookiesSelector));
        agreeCookies.click();
    }

    public void account() {
        WebElement account = driver.findElement(By.cssSelector(accountSelector));
        account.click();
        WebElement enterAccount = driver.findElement(By.cssSelector(enterAccountSelector));
        enterAccount.click();
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