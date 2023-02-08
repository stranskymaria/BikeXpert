package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private String emptyCartSectionTitleTextSelector = "#middle-column > h1";
    private String emptyCartHeaderTextSelector = "#middle-column > div > h1";

    public void verifyEmptyCartPage () {
        Assert.assertEquals(driver.findElement(By.cssSelector(emptyCartSectionTitleTextSelector)).getText(), "Cosul de cumparaturi este gol.");
        Assert.assertEquals(driver.findElement(By.cssSelector(emptyCartHeaderTextSelector)).getText(), "Cum comand");
    }
}
