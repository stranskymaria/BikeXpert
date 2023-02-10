package Tests;

import Pages.FoldableBikesCategoryPage;
import Pages.MainPage;
import Utils.ExtentTestManager;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class FoldableBikesCategoryTests extends BaseTest{

    @Test(groups = {"Smoke", "Regression"})
    public void verifyPage(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Verify page and default sorting option test");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.selectFromBikesSubmenu();
        FoldableBikesCategoryPage fp = new FoldableBikesCategoryPage(driver);
        fp.verifyPage();
    }

    @Test(priority = 1, groups = {"Smoke", "Regression"})
    public void changeSortingTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Verify change sorting option, open specific product page tests");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.selectFromBikesSubmenu();
        FoldableBikesCategoryPage fp = new FoldableBikesCategoryPage(driver);
        fp.changeSorting();
    }

}
