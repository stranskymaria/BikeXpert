package Tests;

import Pages.MainPage;
import Pages.RegistrationPage;
import Utils.ExtentTestManager;
import Utils.SeleniumUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class MainPageTests extends BaseTest{

    @Test(groups = {"Regression"})
    public void wishlistNotLoggedTest(Method method){
        test = ExtentTestManager.startTest(method.getName(), "Wishlist from main page for not logged in test");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(driver.getTitle(), "BikeXpert");
        mp.wishlistNotLogged();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.verifyRegistrationPage();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void searchFieldTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Search field from maine page test");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.searchField("birdy rohloff");
        SeleniumUtils.pause(2000);
        Assert.assertEquals(driver.getTitle(), "Cauta produse: birdy rohloff");
    }

    @Test(groups = {"Smoke", "Regression"})
    public void bikesSubmenu (Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Bikes submenu test");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.selectFromBikesSubmenu();
        Assert.assertEquals(driver.getTitle(), "Pliabile BikeXpert.ro");
    }
}
