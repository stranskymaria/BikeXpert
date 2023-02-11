package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

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
    private String popupSelector = "#popup-root > div.box-cart-popup.popup-box.t-link-color > div";
    private String addToCartPopupTitleSelector = "#popup-root > div.box-cart-popup.popup-box.t-link-color > div > h2";
    private String addToCartPopupProductNameSelector = "#popup-root > div.box-cart-popup.popup-box.t-link-color > div > div.product-added > h2";
    private String addToCartPopupProductPriceSelector = "#popup-root > div.box-cart-popup.popup-box.t-link-color > div > div.product-added > div.price.t-call-to-action-background-to-text";
    private String addToCartPopupTextSelector = "#popup-root > div.box-cart-popup.popup-box.t-link-color > div > div.align-center";
    private String addToCartPopupContinueButtonSelector = "#popup-root > div.box-cart-popup.popup-box.t-link-color > div > a.close-button.btn.nice-btn.gray-btn > span";
    private String addToCartPopupFinalizeButtonSelector = "go-to-cart"; //ID


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
        SeleniumUtils.waitForTextOnSite(driver, By.cssSelector(addToCartPopupTitleSelector), 10, "Va multumim, Produsul a fost adaugat");
        Assert.assertTrue(driver.findElement(By.cssSelector(popupSelector)).isDisplayed());
    }

    public void verifyAddToCartPopup() {
        Assert.assertEquals(driver.findElement(By.cssSelector(addToCartPopupTitleSelector)).getText(), "Va multumim, Produsul a fost adaugat in cos.");
        Assert.assertEquals(driver.findElement(By.cssSelector(addToCartPopupProductNameSelector)).getText(), "BICICLETA PLIABILA RIESE MULLER BIRDY CITY LIME Carry-Bag");
        Assert.assertEquals(driver.findElement(By.cssSelector(addToCartPopupProductPriceSelector)).getText(), "14.24135 Lei");
        Assert.assertEquals(driver.findElement(By.cssSelector(addToCartPopupTextSelector)).getText(), "Aveti in cos 1 produs ce valoreaza 14241.35 Lei");
        WebElement addToCartPopupContinueButton = driver.findElement(By.cssSelector(addToCartPopupContinueButtonSelector));
        WebElement addToCartPopupFinalizeButton = driver.findElement(By.id(addToCartPopupFinalizeButtonSelector));
        Assert.assertTrue(addToCartPopupContinueButton.isDisplayed());
        Assert.assertTrue(addToCartPopupFinalizeButton.isDisplayed());
        Assert.assertEquals(addToCartPopupContinueButton.getText(), "Continua cumparaturile");
        Assert.assertEquals(addToCartPopupFinalizeButton.getText(), "Finalizeaza comanda");
    }

    public void verifyFinalizeFromAddToCartPopup() {
        driver.findElement(By.id(addToCartButtonSelector)).click();
        driver.findElement(By.cssSelector(addToCartPopupFinalizeButtonSelector)).click();
    }
}
