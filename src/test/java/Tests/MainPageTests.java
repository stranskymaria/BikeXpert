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

    @Test(groups = {"Regression"}, description = "Wishlist from main page for not logged in test")
    public void wishlistNotLoggedTest(){
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(driver.getTitle(), "BikeXpert");
        mp.wishlistNotLogged();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.verifyRegistrationPage();
    }

    @Test(groups = {"Smoke", "Regression"}, description = "Search field from maine page test")
    public void searchFieldTest() {
        MainPage mp = new MainPage(driver);
        mp.searchField("birdy rohloff");
        SeleniumUtils.pause(2000);
        Assert.assertEquals(driver.getTitle(), "Cauta produse: birdy rohloff");
    }

    @Test(groups = {"Smoke", "Regression"}, description = "Bikes submenu test")
    public void bikesSubmenu () {
        MainPage mp = new MainPage(driver);
        mp.selectFromBikesSubmenu();
        Assert.assertEquals(driver.getTitle(), "Pliabile BikeXpert.ro");
    }
}
