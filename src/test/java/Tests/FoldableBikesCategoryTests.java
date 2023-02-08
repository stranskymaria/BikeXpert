package Tests;

import Pages.FoldableBikesCategoryPage;
import Pages.MainPage;
import Utils.ExtentTestManager;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class FoldableBikesCategoryTests extends BaseTest{

    @Test
    public void sortingTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Verify page, default sorting option, change sorting option, open specific product page");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.selectFromBikesSubmenu();
        FoldableBikesCategoryPage fp = new FoldableBikesCategoryPage(driver);
        fp.verifyPage();
        fp.sorting();
    }

}
