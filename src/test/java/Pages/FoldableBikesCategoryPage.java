package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

public class FoldableBikesCategoryPage extends BasePage{

    public FoldableBikesCategoryPage(WebDriver driver) {
        super(driver);
    }

    private String headerTextSelector = "#content > div.container.t-link-color > div > div.inner-container.clearfix > h1";
    private String sortingTextSelector = "#middle-column > div.category-options.clearfix > form.box-order-by.form > span";
    private String sortingSelector = "order"; //ID
    private String thirdItemNameSelector = "#middle-column > div.box-products.view-class.grid > div > div:nth-child(3) > div > div.card-section-mid > h2 > a";
    private String thirdItemPriceSelector = "#middle-column > div.box-products.view-class.grid > div > div:nth-child(3) > div > div.card-section-btm.offer.clearfix.product-offer-listing > div.price-product > div";
    private String thirdItemDetailsButtonSelector = "#middle-column > div.box-products.view-class.grid > div > div:nth-child(3) > div > div.card-section-btm.offer.clearfix.product-offer-listing > div.buttons > a";

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(By.cssSelector(headerTextSelector)).getText(), " Pliabile");
        Assert.assertEquals(driver.findElement(By.cssSelector(sortingTextSelector)).getText(), "Sorteaza dupa:");
        WebElement sorting = driver.findElement(By.id(sortingSelector));
        Select se = new Select(sorting);

//        verify default sorting
        WebElement option = se.getFirstSelectedOption();
        Assert.assertEquals(option.getText(), "Reducere");
    }
    public void changeSorting() {
        WebElement sorting = driver.findElement(By.id(sortingSelector));
        Select se = new Select(sorting);

//        select another sorting option
        sorting.click();
        se.selectByVisibleText("Pret descrescator");

//        verify selected sorting option is applied
        WebElement changedOption = se.getFirstSelectedOption();
        Assert.assertEquals(changedOption.getText(), "Pret descrescator");

//        verify products are reordered by the new sort option
        WebDriverWait wait=new WebDriverWait(driver,30);
        try{
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(thirdItemNameSelector))));
        }catch(TimeoutException e){
            System.out.println("Page is not refreshed in 30 seconds");
        }
        Assert.assertEquals(driver.findElement(By.cssSelector(thirdItemNameSelector)).getText(), "BICICLETA PLIABILA RIESE MULLER BIRDY CITY LIME Carry-Bag");
        Assert.assertEquals(driver.findElement(By.cssSelector(thirdItemPriceSelector)).getText(), "14.24135 Lei");
        WebElement thirdItemDetailsButton = driver.findElement(By.cssSelector(thirdItemDetailsButtonSelector));
        Assert.assertTrue(thirdItemDetailsButton.isDisplayed());
        Assert.assertEquals(thirdItemDetailsButton.getText(), "Vezi detalii");

//        open a specific product page
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", thirdItemDetailsButton);
    }

 }
