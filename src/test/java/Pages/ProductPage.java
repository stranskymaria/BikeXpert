package Pages;

import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private String productTitleSelector = "#middle-column > div.product-container.default-product-container.custom_product_container_header_bx > div.heading-section > div > h1";
    private String productPriceSelector = "product_price"; //ID

}
