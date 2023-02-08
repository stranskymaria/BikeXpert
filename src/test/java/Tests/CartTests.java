package Tests;

import Pages.CartPage;
import Pages.MainPage;
import Utils.ExtentTestManager;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CartTests extends BaseTest{

    @Test
    public void emptyCartPage(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Negative login tests with JSON");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.cartButtonClick();
        CartPage cp = new CartPage(driver);
        cp.verifyEmptyCartPage();
    }
}
