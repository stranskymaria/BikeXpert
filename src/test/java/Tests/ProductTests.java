package Tests;

import Pages.MainPage;
import Pages.ProductPage;
import Pages.SearchResultsPage;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

    @Test(priority = 1, groups = {"Smoke", "Regression"}, description = "Verify product page test")
    public void verifyPage() {
        MainPage mp = new MainPage(driver);
        mp.searchField("riese muller birdy city");
        SearchResultsPage srp = new SearchResultsPage(driver);
        srp.openProductPage();
        ProductPage pp = new ProductPage(driver);
        pp.verifyPage();
    }

    @Test(priority = 2, groups = {"Smoke", "Regression"}, description = "Add to cart from product page for not logged in test")
    public void addToCart() {
        MainPage mp = new MainPage(driver);
        mp.searchField("riese muller birdy city");
        SearchResultsPage srp = new SearchResultsPage(driver);
        srp.openProductPage();
        ProductPage pp = new ProductPage(driver);
        pp.addToCart();
    }

    @Test(dependsOnMethods = {"addToCart"}, priority = 3, groups = {"Smoke", "Regression"}, description = "Verify add to cart popup test")
    public void verifyAddToCartPopup() {
        ProductPage pp = new ProductPage(driver);
        pp.verifyAddToCartPopup();
    }

}