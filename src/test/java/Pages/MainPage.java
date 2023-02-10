package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MainPage extends BasePage{

    private String agreeCookiesSelector = "body > section > div.container > header > div.smaller_right > input"; //CSS
    private String searchInputSelector = "#header > div.top-header-section.t-top-header-background > div > div.left.search-section.hide-on-mob > div > form > div > input"; //CSS
    private String searchButtonSelector = "#header > div.top-header-section.t-top-header-background > div > div.left.search-section.hide-on-mob > div > form > div > div > button > i";
    private String accountButtonSelector = "login-link"; //CSS
    private String loginButtonSelector = "#header > div.top-header-section.t-top-header-background > div > div.right-section.users-box-section.cf > div.box-user.left > div > div > div > div.buttons-login > a"; //CSS

    private String registerButtonSelector = "#header > div.top-header-section.t-top-header-background > div > div.right-section.users-box-section.cf > div.box-user.left > div > div > div > div.no-accont > a"; //CSS
    private String wishlistButtonSelector = "#header > div.top-header-section.t-top-header-background > div > div.right-section.users-box-section.cf > div.wishlist-products-section.left > a > i.t-config-carticon-color.fa-heart.fa";
    private String cartButtonSelector = "#header > div.top-header-section.t-top-header-background > div > div.right-section.users-box-section.cf > div.box-cart.left.boxcartdefault > a > i";
    private String cartTextSelector = "#header > div.top-header-section.t-top-header-background > div > div.right-section.users-box-section.cf > div.box-cart.left.boxcartdefault > a > span";
    private String bikesMenuButtonSelector = "#header > div.bottom-header-section.t-menu-background.menu-for-sticky > div > div > nav > ul > li:nth-child(1) > a";
    private String partsMenuButtonSelector = "#header > div.bottom-header-section.t-menu-background.menu-for-sticky > div > div > nav > ul > li:nth-child(2) > a";
    private String accessoriesMenuButtonSelector = "#header > div.bottom-header-section.t-menu-background.menu-for-sticky > div > div > nav > ul > li:nth-child(3) > a";
    private String equipmentMenuButtonSelector = "#header > div.bottom-header-section.t-menu-background.menu-for-sticky > div > div > nav > ul > li:nth-child(4) > a";
    private String nutritionButtonSelector = "#header > div.bottom-header-section.t-menu-background.menu-for-sticky > div > div > nav > ul > li.nav-item.no-children.level-1 > a";
    private String contactButtonSelector = "#header > div.bottom-header-section.t-menu-background.menu-for-sticky > div > div > div.box-top-links.t-navigation-link > ul > li > a";
    private String bikesSubmenuMountainButtonSelector = "#header > div.bottom-header-section.t-menu-background.menu-for-sticky > div > div > nav > ul > li:nth-child(1) > div > div:nth-child(1) > div > h3:nth-child(1) > a";
    private String bikesSubmenuCiclocrossButtonSelector = "#header > div.bottom-header-section.t-menu-background.menu-for-sticky > div > div > nav > ul > li:nth-child(1) > div > div:nth-child(2) > div > h3:nth-child(1) > a";
    private String bikesSubmenuTrekkingButtonSelector = "#header > div.bottom-header-section.t-menu-background.menu-for-sticky > div > div > nav > ul > li:nth-child(1) > div > div:nth-child(3) > div > h3:nth-child(1) > a";
    private String bikesSubmenuKidsButtonSelector = "#header > div.bottom-header-section.t-menu-background.menu-for-sticky > div > div > nav > ul > li:nth-child(1) > div > div:nth-child(4) > div > h3:nth-child(1) > a";
    private String bikesSubmenuElectricButtonSelector = "#header > div.bottom-header-section.t-menu-background.menu-for-sticky > div > div > nav > ul > li:nth-child(1) > div > div:nth-child(5) > div > h3:nth-child(1) > a";
    private String bikesSubmenuFoldableButtonSelector = "#header > div.bottom-header-section.t-menu-background.menu-for-sticky > div > div > nav > ul > li:nth-child(1) > div > div:nth-child(6) > div > h3:nth-child(1) > a";
    private String bikesSubmenuBmxButtonSelector = "#header > div.bottom-header-section.t-menu-background.menu-for-sticky > div > div > nav > ul > li:nth-child(1) > div > div:nth-child(7) > div > h3:nth-child(1) > a";
    private String wishlistNotLoggedTextSelector = "#header > div.top-header-section.t-top-header-background > div > div.right-section.users-box-section.cf > div.wishlist-products-section.left > div > div > div";
    private String wishlistNotLoggedButtonSelector = "#header > div.top-header-section.t-top-header-background > div > div.right-section.users-box-section.cf > div.wishlist-products-section.left > div > div > a";
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void selectFromBikesSubmenu() {
        WebElement bikesMenuButton = driver.findElement(By.cssSelector(bikesMenuButtonSelector));
        Actions actions = new Actions(driver);
        actions.moveToElement(bikesMenuButton).build().perform();
        driver.findElement(By.cssSelector(bikesSubmenuFoldableButtonSelector)).click();
    }

    public void searchField(String keyword) {
        WebElement searchInput = driver.findElement(By.cssSelector(searchInputSelector));
        WebElement searchButton = driver.findElement(By.cssSelector(searchButtonSelector));
        searchInput.clear();
        searchInput.sendKeys(keyword);
        searchButton.submit();
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

    public void registrationPage() {
        agreeCookies();
        accountButton();
        WebElement registrationButton = driver.findElement(By.cssSelector(registerButtonSelector));
        registrationButton.click();
    }

    public void loginPage() {
        agreeCookies();
        accountButton();
        WebElement loginButton = driver.findElement(By.cssSelector(loginButtonSelector));
        loginButton.click();
    }

    public void wishlistNotLogged () {
        WebElement wishlistButton = driver.findElement(By.cssSelector(wishlistButtonSelector));
        wishlistButton.click();
        SeleniumUtils.waitForGenericElement(driver, By.cssSelector(wishlistNotLoggedTextSelector), 10);
        Assert.assertEquals(driver.findElement(By.cssSelector(wishlistNotLoggedTextSelector)).getText(), "Trebuie sa fiti logat pentru a vedea produsele favorite.");
        WebElement wishlistNotLoggedButton = driver.findElement(By.cssSelector(wishlistNotLoggedButtonSelector));
        Assert.assertTrue(wishlistNotLoggedButton.isDisplayed());
        Assert.assertEquals(wishlistNotLoggedButton.getText(), "Inregistrare");
        wishlistNotLoggedButton.click();
    }

    public void cartButtonClick () {
        WebElement cartButton = driver.findElement(By.cssSelector(cartButtonSelector));
        Assert.assertEquals(driver.findElement(By.cssSelector(cartTextSelector)).getText(), "Cosul meu");
        cartButton.click();

    }


}