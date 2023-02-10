package Tests;

import Pages.FoldableBikesCategoryPage;
import Pages.MainPage;
import Utils.ExtentTestManager;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class FoldableBikesCategoryTests extends BaseTest{

    @Test(groups = {"Smoke", "Regression"}, description = "Verify page and default sorting option test")
    public void verifyPage() {
        MainPage mp = new MainPage(driver);
        mp.selectFromBikesSubmenu();
        FoldableBikesCategoryPage fp = new FoldableBikesCategoryPage(driver);
        fp.verifyPage();
    }

    @Test(priority = 1, groups = {"Smoke", "Regression"}, description = "Verify change sorting option, open specific product page tests")
    public void changeSortingTest() {
        MainPage mp = new MainPage(driver);
        mp.selectFromBikesSubmenu();
        FoldableBikesCategoryPage fp = new FoldableBikesCategoryPage(driver);
        fp.changeSorting();
    }

}
