package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SearchResultsPage extends BasePage{

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    private String headerTextSelector = "#lb-search-element > div.lb-search > div > div.lb-container.lb-search__container > main > h1 > span";
    private String subHeaderTextSelector = "#lb-results > div > h3";
    private String firstItemTitleSelector = "#lb-results > div > div > div > div:nth-child(1) > div > div.card-section-mid > h2 > a";
    private String firstItemPriceSelector = "#lb-results > div > div > div > div:nth-child(1) > div > div.card-section-btm.offer.clearfix.product-offer-listing > div.price-product > div";
    private String firstItemDetailsButtonSelector = "#lb-results > div > div > div > div:nth-child(1) > div > div.card-section-btm.offer.clearfix.product-offer-listing > div.buttons > a";

    public void verifyPage() {
        SeleniumUtils.pause(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector(headerTextSelector)).getText(), "Rezultate pentru riese muller birdy city (323)");
        Assert.assertEquals(driver.findElement(By.cssSelector(subHeaderTextSelector)).getText(), "Produse");
        Assert.assertEquals(driver.findElement(By.cssSelector(firstItemTitleSelector)).getText(), "BICICLETA PLIABILA RIESE MULLER BIRDY CITY LIME Carry-Bag");
        Assert.assertEquals(driver.findElement(By.cssSelector(firstItemPriceSelector)).getText(), "14.24135 Lei");
        Assert.assertEquals(driver.findElement(By.cssSelector(firstItemDetailsButtonSelector)).getText(), "Vezi detalii");
    }

    public void openProductPage() {
        WebElement firstItemDetailsButton = driver.findElement(By.cssSelector(firstItemDetailsButtonSelector));
        firstItemDetailsButton.click();
    }
}
