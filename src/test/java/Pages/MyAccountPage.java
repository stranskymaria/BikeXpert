package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MyAccountPage extends BasePage {

    private String myInfoLabelSelector = "#info > h2";
    private String nameLabelSelector = "#info > div > div.clearfix > div.left > div > div.right.info-section > div:nth-child(1) > strong";
    private String nameValueSelector = "#info > div > div.clearfix > div.left > div > div.right.info-section > div:nth-child(1) > span";
    private String emailLabelSelector = "#info > div > div.clearfix > div.left > div > div.right.info-section > div:nth-child(2) > strong";
    private String emailValueSelector = "#info > div > div.clearfix > div.left > div > div.right.info-section > div:nth-child(2) > span";
    private String phoneLabelSelector = "#info > div > div.clearfix > div.left > div > div.right.info-section > div:nth-child(3) > strong";
    private String phoneValueSelector = "#info > div > div.clearfix > div.left > div > div.right.info-section > div:nth-child(3) > span";
    private String changeButtonSelector = "#info > div > div.clearfix > div.right.edit-section > a";

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void myAccount() {
        WebElement changeButton = driver.findElement(By.cssSelector(changeButtonSelector));

        Assert.assertEquals(driver.findElement(By.cssSelector(myInfoLabelSelector)).getText(), "Datele mele");
        Assert.assertEquals(driver.findElement(By.cssSelector(nameLabelSelector)).getText(), "Nume:");
        Assert.assertEquals(driver.findElement(By.cssSelector(emailLabelSelector)).getText(), "Adresa e-mail:");
        Assert.assertEquals(driver.findElement(By.cssSelector(phoneLabelSelector)).getText(), "Telefon:");
        Assert.assertTrue(changeButton.isDisplayed());
        Assert.assertEquals(changeButton.getText(), "Modifica");
    }

    public String getNameValue() {
        return driver.findElement(By.cssSelector(nameValueSelector)).getText();
    }

    public String getEmailValue() {
        return driver.findElement(By.cssSelector(emailValueSelector)).getText();
    }

    public String getPhoneValue() {
        return driver.findElement(By.cssSelector(phoneValueSelector)).getText();
    }
}

