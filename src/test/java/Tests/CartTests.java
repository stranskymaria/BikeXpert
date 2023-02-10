package Tests;

import Pages.CartPage;
import Pages.MainPage;
import Utils.ExtentTestManager;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CartTests extends BaseTest{

    @Test(groups = {"Regression"}, description = "Empty cart page test")
    public void emptyCartPage() {
        MainPage mp = new MainPage(driver);
        mp.cartButtonClick();
        CartPage cp = new CartPage(driver);
        cp.verifyEmptyCartPage();
    }
}
