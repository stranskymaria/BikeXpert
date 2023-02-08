package Tests;

import Pages.MainPage;
import Pages.RegistrationPage;
import Utils.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class MainPageTests extends BaseTest{

    @Test
    public void wishlistNotLoggedTest(Method method){
        test = ExtentTestManager.startTest(method.getName(), "Positive login test with JSON");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(driver.getTitle(), "BikeXpert");
        mp.wishlistNotLogged();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.verifyRegistrationPage();
    }

    @Test
    public void searchFieldTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Positive login test with JSON");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.searchField("birdy rohloff");
//        Assert.assertEquals(driver.getTitle(), "Cauta produse: birdy rohloff");
    }

    @Test
    public void bikesSubmenu (Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Positive login test with JSON");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.selectFromBikesSubmenu();
        Assert.assertEquals(driver.getTitle(), "Pliabile BikeXpert.ro");
    }
}
