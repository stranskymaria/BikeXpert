package Tests;

import Pages.MainPage;
import Pages.SearchResultsPage;
import Utils.ExtentTestManager;
import Utils.SeleniumUtils;
import org.testng.annotations.Test;

import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class SearchResultsTests extends BaseTest{

    @Test(groups = {"Smoke", "Regression"}, description = "Wishlist from main page for not logged in test")
    public void verifyPage(){
        MainPage mp = new MainPage(driver);
        mp.searchField("riese muller birdy city");
        SearchResultsPage srp = new SearchResultsPage(driver);
        srp.verifyPage();
    }
}
