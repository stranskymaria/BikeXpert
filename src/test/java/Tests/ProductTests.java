package Tests;

import Pages.MainPage;
import Pages.ProductPage;
import Pages.SearchResultsPage;
import Utils.ExtentTestManager;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ProductTests extends BaseTest{

    @Test(groups = {"Smoke", "Regression"}, description = "Wishlist from main page for not logged in test")
    public void verifyPage(){
        MainPage mp = new MainPage(driver);
        mp.searchField("riese muller birdy city");
        SearchResultsPage srp = new SearchResultsPage(driver);
        srp.openProductPage();
        ProductPage pp = new ProductPage(driver);
        pp.verifyPage();
    }

    @Test(groups = {"Smoke", "Regression"}, description = "Wishlist from main page for not logged in test")
    public void addToCart(){
        MainPage mp = new MainPage(driver);
        mp.searchField("riese muller birdy city");
        SearchResultsPage srp = new SearchResultsPage(driver);
        srp.openProductPage();
        ProductPage pp = new ProductPage(driver);
        pp.addToCart();
    }
}
