package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private String productTitleSelector = "#middle-column > div.product-container.default-product-container.custom_product_container_header_bx > div.heading-section > div > h1";
    private String productPriceSelector = "product_price"; //ID
    private String productCodeLabelSelector = "#middle-column > div.product-container.default-product-container.custom_product_container_header_bx > div.clearfix > div.product-info-right.col-md-5.col-12 > div.product-details.t-text-color > div > div > div.under-variants-section > div.code-stock-section > div.product-code.t-text-color > span";
    private String addToCartButtonSelector = "product_addToCart"; //ID
    private String addToWishListButtonSelector = "#add-to-favorite > i";
    private String descriptionSectionTitleSelector = "#tab-description > h2";
    private String addToCartPopupTitleSelector = "#popup-root > div.box-cart-popup.popup-box.t-link-color > div > h2";

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(By.cssSelector(productTitleSelector)).getText(), "BICICLETA PLIABILA RIESE MULLER BIRDY CITY LIME Carry-Bag");
        Assert.assertEquals(driver.findElement(By.id(productPriceSelector)).getText(), "14.24135 Lei");
        Assert.assertEquals(driver.findElement(By.cssSelector(productCodeLabelSelector)).getText(), "Cod produs:");
        Assert.assertEquals(driver.findElement(By.id(addToCartButtonSelector)).getText(), "Adauga in cos");
        Assert.assertEquals(driver.findElement(By.cssSelector(descriptionSectionTitleSelector)).getText(), "Descriere");
    }

    public void addToCart() {
        WebElement addToCartButton = driver.findElement(By.id(addToCartButtonSelector));
        addToCartButton.click();
        Assert.assertEquals(driver.findElement(By.cssSelector(addToCartPopupTitleSelector)).getText(), "Va multumim, Produsul a fost adaugat in cos.");

    }
}
