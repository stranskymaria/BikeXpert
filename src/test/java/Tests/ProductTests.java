package Tests;

import Pages.MainPage;
import Pages.ProductPage;
import Pages.SearchResultsPage;
import Utils.ExtentTestManager;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ProductTests extends BaseTest{

    @Test(groups = {"Smoke", "Regression"})
    public void verifyPage(Method method){
        test = ExtentTestManager.startTest(method.getName(), "Wishlist from main page for not logged in test");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.searchField("riese muller birdy city");
        SearchResultsPage srp = new SearchResultsPage(driver);
        srp.openProductPage();
        ProductPage pp = new ProductPage(driver);
        pp.verifyPage();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void addToCart(Method method){
        test = ExtentTestManager.startTest(method.getName(), "Wishlist from main page for not logged in test");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        mp.searchField("riese muller birdy city");
        SearchResultsPage srp = new SearchResultsPage(driver);
        srp.openProductPage();
        ProductPage pp = new ProductPage(driver);
        pp.addToCart();
    }
}
